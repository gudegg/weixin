package club.gude.controller;

import club.gude.config.WechatConfig;
import club.gude.entity.msg.in.*;
import club.gude.entity.msg.out.OutTextMsg;
import club.gude.utils.SignUtil;
import club.gude.utils.XmlJaxbUtil;
import club.gude.utils.XmlUtil;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author Gude
 * @Date 2016/4/5.
 * 微信服务器验证 接入微信
 */
@RestController
public class AccessController {
    private Logger logger = LoggerFactory.getLogger(AccessController.class);

    private WXBizMsgCrypt wxBizMsgCrypt;


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
        logger.info(WechatConfig.Token);
        String sha1_signature = SignUtil.getSHA1(WechatConfig.Token, timestamp, nonce);
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
        String sha1_signature = SignUtil.getSHA1(WechatConfig.Token, timestamp, nonce);
        if (sha1_signature.equals(signature)) {
            try {
                InputStream is = request.getInputStream();
                String receive_msg = CharStreams.toString(new InputStreamReader(is, Charsets.UTF_8));
                Map<String, String> receive_map = null;
                //判断使用明文模式 还是加密模式
                if (WechatConfig.EncryptMessage) {
                    if (wxBizMsgCrypt == null) {
                        wxBizMsgCrypt = new WXBizMsgCrypt(WechatConfig.Token, WechatConfig.EncodingAESKey, WechatConfig.Appid);
                    }
                    String encrypt_type = request.getParameter("encrypt_type");
                    String msg_signature = request.getParameter("msg_signature");
                    //加密消息解密
                    String decrypt_Msg = wxBizMsgCrypt.decryptMsg(msg_signature, timestamp, nonce, receive_msg);
                    receive_map = XmlUtil.xmlResolve(decrypt_Msg);


                    if (XmlUtil.inMsgType(decrypt_Msg).equals("shortvideo") || XmlUtil.inMsgType(decrypt_Msg).equals("vedio")) {
                        // InVedioMsg inLocationMsg = (InVedioMsg) XmlUtil.xmlResolve_MsgIn(decrypt_Msg);
                        InVedioMsg inLocationMsg = (InVedioMsg) XmlJaxbUtil.xmlResolve_MsgIn(decrypt_Msg);
                        logger.info("对象:" + inLocationMsg.toString() + "视频");
                    } else if (XmlUtil.inMsgType(decrypt_Msg).equals("image")) {
                        //InImageMsg inLocationMsg = (InImageMsg) XmlUtil.xmlResolve_MsgIn(decrypt_Msg);
                        InImageMsg inLocationMsg = (InImageMsg) XmlJaxbUtil.xmlResolve_MsgIn(decrypt_Msg);
                        logger.info("对象:" + inLocationMsg.toString() + "图片");
                    } else if (XmlUtil.inMsgType(decrypt_Msg).equals("voice")) {
                        //InVoiceMsg inLocationMsg = (InVoiceMsg) XmlUtil.xmlResolve_MsgIn(decrypt_Msg);
                        InVoiceMsg inVoiceMsg = (InVoiceMsg) XmlJaxbUtil.xmlResolve_MsgIn(decrypt_Msg);
                        logger.info("对象:" + inVoiceMsg.toString() + "语音" + " " + inVoiceMsg.getRecognition());
                    } else if (XmlUtil.inMsgType(decrypt_Msg).equals("text")) {
                        //InTextMsg inLocationMsg = (InTextMsg) XmlUtil.xmlResolve_MsgIn(decrypt_Msg);
                        InTextMsg inTexitMsg = (InTextMsg) XmlJaxbUtil.xmlResolve_MsgIn(decrypt_Msg);
                        logger.info("对象:" + inTexitMsg.toString() + "  " + inTexitMsg.getContent() + "文本");
                        OutTextMsg outTextMsg = new OutTextMsg();
                        outTextMsg.setContent("你发送的是文本");
                        outTextMsg.setFromUserName(inTexitMsg.getToUserName());
                        outTextMsg.setToUserName(inTexitMsg.getFromUserName());


                        String replyMsg = XmlJaxbUtil.xmlCreate_MsgOut(outTextMsg);
                        return replyMsg;

                    } else if (XmlUtil.inMsgType(decrypt_Msg).equals("location")) {
                        // InLocationMsg inLocationMsg = (InLocationMsg) XmlUtil.xmlResolve_MsgIn(decrypt_Msg);
                        InLocationMsg inLocationMsg = (InLocationMsg) XmlJaxbUtil.xmlResolve_MsgIn(decrypt_Msg);
                        logger.info("对象:" + inLocationMsg.toString() + "位置" + inLocationMsg.getLocation_X() + "  " + inLocationMsg.getLocation_Y());
                    } else if (XmlUtil.inMsgType(decrypt_Msg).equals("link")) {
                        //InLinkMsg inLocationMsg = (InLinkMsg) XmlUtil.xmlResolve_MsgIn(decrypt_Msg);
                        InLinkMsg inLocationMsg = (InLinkMsg) XmlJaxbUtil.xmlResolve_MsgIn(decrypt_Msg);
                        logger.info("对象:" + inLocationMsg.toString() + "链接");
                    }


                    logger.info("\n" + receive_msg + "\n" + receive_map + "\n" + signature + "---" + timestamp + "---" + nonce);

                    String MsgTyp = receive_map.get("MsgType");
                    Map map = new HashMap();
                    map.put("ToUserName", receive_map.get("FromUserName"));
                    map.put("FromUserName", receive_map.get("ToUserName"));
                    map.put("CreateTime", System.currentTimeMillis() + "");
                    map.put("MsgType", "text");
                    map.put("Content", "欢迎你");
                    String replyMsg = XmlUtil.xmlCreate(map);


                    logger.info("回复消息:" + replyMsg);
                    replyMsg = wxBizMsgCrypt.encryptMsg(replyMsg, timestamp, nonce);
                    logger.info("加密后回复消息:" + replyMsg);
                    return replyMsg;
                } else {
                    //明文无需解密
                    receive_map = XmlUtil.xmlResolve(receive_msg);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            return "Hello";

        }

        return null;
    }
}
