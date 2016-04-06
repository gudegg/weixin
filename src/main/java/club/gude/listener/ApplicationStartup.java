package club.gude.listener;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author Gude
 * @Date 2016/4/4.
 */
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent>{
    private Logger logger= LoggerFactory.getLogger(ApplicationStartup.class);
//    @Value("${wechat.Appid}" )
//    private String appid;
//    @Value("${wechat.AppSecret}" )
//    private String secret;
//    @Value("${wechat.Token}" )
//    private String token;
//    @Value("${wechat.EncodingAESKey}" )
//    private String aeskey;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
//        config.setAppId(appid); // 设置微信公众号的appid
//        config.setSecret(secret); // 设置微信公众号的app corpSecret
//        config.setToken(token); // 设置微信公众号的token
//        config.setAesKey(aeskey); // 设置微信公众号的EncodingAESKey
//
//        WxMpService wxService = new WxMpServiceImpl();
//        wxService.setWxMpConfigStorage(config);

    }
}
