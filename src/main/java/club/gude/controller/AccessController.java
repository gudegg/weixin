package club.gude.controller;

import club.gude.config.WechatConfig;
import club.gude.utils.SignUtil;
import club.gude.utils.XmlUtil;
import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.CharStreams;
import com.google.common.io.Resources;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;

import static club.gude.utils.SignUtil.getSHA1;

/**
 * @Author Gude
 * @Date 2016/4/5.
 * 微信服务器验证 接入微信
 */
@RestController
public class AccessController {
    private Logger logger = LoggerFactory.getLogger(AccessController.class);
    @Resource
    WechatConfig wechatConfig;

    public WXBizMsgCrypt wxBizMsgCrypt;


    /**
     * 接入微信
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping(value = "/access", method = RequestMethod.GET)
    public String accessWechat(String signature, String timestamp, String nonce, String echostr) {
        logger.info(wechatConfig.getToken());
        String sha1_signature = SignUtil.getSHA1(wechatConfig.getToken(), timestamp, nonce);
        logger.info(sha1_signature + "  " + signature);
        if (sha1_signature.equals(signature)) {
            return echostr;
        }
        return sha1_signature;
    }

    /**
     * 接收用户消息 处理
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/access", method = RequestMethod.POST)
    public Object sendMsg(HttpServletRequest request, String signature, String timestamp, String nonce) {
        String sha1_signature = SignUtil.getSHA1(wechatConfig.getToken(), timestamp, nonce);
        if (sha1_signature.equals(signature)) {
            try {
                InputStream is = request.getInputStream();
                String receive_msg = CharStreams.toString(new InputStreamReader(is, Charsets.UTF_8));
                Map<String, String> receive_map = null;
                //判断使用明文模式 还是加密模式
                if (wechatConfig.getEncryptMessage()) {
                    if (wxBizMsgCrypt == null) {
                        wxBizMsgCrypt = new WXBizMsgCrypt(wechatConfig.getToken(), wechatConfig.getEncodingAESKey(), wechatConfig.getAppid());
                    }
                    String encrypt_type = request.getParameter("encrypt_type");
                    String msg_signature = request.getParameter("msg_signature");
                    //加密消息解密
                    String decrypt_Msg = wxBizMsgCrypt.decryptMsg(msg_signature, timestamp, nonce, receive_msg);
                    receive_map=XmlUtil.xmlResolve(decrypt_Msg);


                } else {
                    //明文无需解密
                    receive_map = XmlUtil.xmlResolve(receive_msg);
                }


                logger.info("\n" + receive_msg + "\n" + receive_map + "\n" + signature + "---" + timestamp + "---" + nonce);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return "Hello";

        }

        return null;
    }
}
