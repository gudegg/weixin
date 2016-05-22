package club.gude.config;


import java.io.IOException;
import java.util.Properties;

/**
 * @Author Gude
 * @Date 2016/4/5.
 */
public class WechatConfig {
    public final static String Token;
    public final static String Appid;
    public final static String AppSecret;
    public final static String EncodingAESKey;
    public final static boolean EncryptMessage;

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
        EncryptMessage= Boolean.parseBoolean(properties.getProperty("wechat.EncryptMessage"));
    }

}
