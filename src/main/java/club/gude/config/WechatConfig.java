package club.gude.config;


import java.io.IOException;
import java.util.Properties;

/**
 * @Author Gude
 * @Date 2016/4/5.
 */
public class WechatConfig {
    /**
     * Token(令牌)
     */
    public final static String Token;
    /**
     * AppID(应用ID)
     */
    public final static String Appid;
    /**
     * AppSecret(应用密钥)
     */
    public final static String AppSecret;
    /**
     * EncodingAESKey(消息加解密密钥)
     */
    public final static String EncodingAESKey;
    /**
     * 消息加解密方式,默认使用加密
     */
    public final static boolean IsEncryptMessage;

    static {
        Properties properties=new Properties();
        try {
            properties.load(WechatConfig.class.getClassLoader().getResourceAsStream("wechat.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Token=properties.getProperty("wechat.Token");
        Appid=properties.getProperty("wechat.Appid");
        AppSecret=properties.getProperty("wechat.AppSecret");
        EncodingAESKey=properties.getProperty("wechat.EncodingAESKey");
        IsEncryptMessage= Boolean.parseBoolean(properties.getProperty("wechat.EncryptMessage","true"));
    }

}
