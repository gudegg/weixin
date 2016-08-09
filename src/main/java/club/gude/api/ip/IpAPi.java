package club.gude.api.ip;

import club.gude.entity.ip.Ip;
import club.gude.utils.http.OkHttpUtil;

import java.io.IOException;

/**
 * @Author Gude.
 * @Date 2016/8/9.
 * 获取微信服务器IP地址
 */
public class IpAPi {
    public static final String url="https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=";

    /**
     * 获取微信服务器IP地址
     * @param access_token
     * @return
     * @throws IOException
     */
    public static Ip getCallBackIp(String access_token) throws IOException {
        StringBuilder sb=new StringBuilder(url);
        sb.append(access_token);
        return OkHttpUtil.syncGet(sb.toString(),Ip.class);
    }
}
