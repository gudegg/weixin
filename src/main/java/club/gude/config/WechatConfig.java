package club.gude.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author Gude
 * @Date 2016/4/5.
 */
@ConfigurationProperties(prefix = "wechat", locations = "classpath:wechat.properties")
public class WechatConfig {
    public static String Token;
    public static String Appid;
    public static String AppSecret;
    public static String EncodingAESKey;
    public static boolean EncryptMessage;

    public static String getToken() {
        return Token;
    }

    public static void setToken(String token) {
        Token = token;
    }

    public static boolean isEncryptMessage() {
        return EncryptMessage;
    }

    public static void setEncryptMessage(boolean encryptMessage) {
        EncryptMessage = encryptMessage;
    }

    public static String getEncodingAESKey() {
        return EncodingAESKey;
    }

    public static void setEncodingAESKey(String encodingAESKey) {
        EncodingAESKey = encodingAESKey;
    }

    public static String getAppSecret() {
        return AppSecret;
    }

    public static void setAppSecret(String appSecret) {
        AppSecret = appSecret;
    }

    public static String getAppid() {
        return Appid;
    }

    public static void setAppid(String appid) {
        Appid = appid;
    }
}
