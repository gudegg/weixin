package club.gude.utils;

import club.gude.config.WechatConfig;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

/**
 * @Author Gude
 * @Date 2016/4/6.
 */
public class MsgUtil {
    private WXBizMsgCrypt wxBizMsgCrypt;

    {
        try {
            wxBizMsgCrypt = new WXBizMsgCrypt(WechatConfig.Token, WechatConfig.EncodingAESKey, WechatConfig.Appid);
        } catch (AesException e) {
            e.printStackTrace();
        }
    }

    public static String sendMsg() {
        return null;

    }
}
