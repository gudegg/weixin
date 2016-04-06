package club.gude.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author Gude
 * @Date 2016/4/5.
 */
@ConfigurationProperties(prefix = "wechat",locations = "classpath:wechat.properties")
public class WechatConfig {
    private String Token;
    private String Appid;
    private String AppSecret;
    private String EncodingAESKey;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getAppid() {
        return Appid;
    }

    public void setAppid(String appid) {
        this.Appid = appid;
    }

    public String getAppSecret() {
        return AppSecret;
    }

    public void setAppSecret(String appSecret) {
        AppSecret = appSecret;
    }

    public String getEncodingAESKey() {
        return EncodingAESKey;
    }

    public void setEncodingAESKey(String encodingAESKey) {
        EncodingAESKey = encodingAESKey;
    }
}
