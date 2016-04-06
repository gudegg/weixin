package club.gude.controller;

import club.gude.config.WechatConfig;
import club.gude.utils.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    /**
     * 接入微信
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping(value = "/access",method = RequestMethod.GET)
    public String accessWechat(String signature, String timestamp, String nonce, String echostr) {
        logger.info(wechatConfig.getToken());
        String sha1_signature = SignUtil.getSHA1(wechatConfig.getToken(), timestamp, nonce);
        logger.info(sha1_signature + "  " + signature);
        if (sha1_signature.equals(signature)) {
            return echostr;
        }
        return sha1_signature;
    }
    @RequestMapping(value = "/access",method = RequestMethod.POST)
    public Object sendMsg(){
        return "Hello";
    }
}
