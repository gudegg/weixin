package club.gude.utils.msg;

import club.gude.config.WechatConfig;
import club.gude.entity.msg.ReceiveParam;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Enumeration;

/**
 * @Author Gude
 * @Date 2016/4/6.
 */
public class MsgUtil {
    private static Logger logger= LoggerFactory.getLogger(MsgUtil.class);

    private static WXBizMsgCrypt wxBizMsgCrypt;

    static {
        try {
            wxBizMsgCrypt = new WXBizMsgCrypt(WechatConfig.Token, WechatConfig.EncodingAESKey, WechatConfig.Appid);
        } catch (AesException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取从公众号接收到的真实(加密的已经解密)消息
     * @param request
     * @return
     */
    public static String getReceiveMsg(HttpServletRequest request) {
        try {
            String receive_msg = CharStreams.toString(new InputStreamReader(request.getInputStream(), Charsets.UTF_8));
            logger.info("接收到的原始消息{}",receive_msg);
            if (WechatConfig.IsEncryptMessage) {//消息加密方式
                String encrypt_type = request.getParameter("encrypt_type");
                String msg_signature = request.getParameter("msg_signature");
                String timestamp = request.getParameter("timestamp");
                String nonce = request.getParameter("nonce");
                //加密消息解密
                String decrypt_Msg = wxBizMsgCrypt.decryptMsg(msg_signature, timestamp, nonce, receive_msg);
                return decrypt_Msg;
            } else {
                return receive_msg;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 请求接收到的参数和值
     * @param request
     * @return
     */
    public static ReceiveParam getReceiveParam(HttpServletRequest request){
        Enumeration enumeration= request.getParameterNames();

        ReceiveParam receiveParam=new ReceiveParam();
        Field field=null;
        while ((enumeration.hasMoreElements())){
            String name= (String) enumeration.nextElement();
            String value= request.getParameter(name.toString());
            try {
                field=receiveParam.getClass().getDeclaredField(name);
                if(!field.isAccessible()){
                    field.setAccessible(true);
                }
                field.set(receiveParam,value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return receiveParam;
    }
}
