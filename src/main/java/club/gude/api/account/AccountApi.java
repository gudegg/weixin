package club.gude.api.account;

import club.gude.entity.account.Shorturl;
import club.gude.entity.account.Ticket;
import club.gude.utils.http.OkHttpUtil;
import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/**
 * @Author Gude
 * @Date 2016/4/25.
 * 账号管理
 */
public class AccountApi {
    //https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN

    /**
     * 创建二维码ticket
     *
     * @param access_token
     * @param expire_seconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果为null，则默认有效期为30秒。
     * @param action_name    二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值
     * @param scene_id       场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     */
    public static Ticket qrcodeCreate(String access_token, Integer expire_seconds, String action_name, int scene_id) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + access_token;
        Map map = new HashMap();
        if (expire_seconds != null) {
            map.put("expire_seconds", expire_seconds);
        }
        map.put("action_name", action_name);
        Map actionInfoMap = new HashMap();
        actionInfoMap.put("scene", "{\"scene_id\":" + scene_id + "}");
        map.put("action_info", actionInfoMap);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, JSON.toJSONString(map));
        return JSON.parseObject(responseBody.string(), Ticket.class);
    }

    /**
     * 创建二维码ticket
     *
     * @param access_token
     * @param expire_seconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果为null，则默认有效期为30秒。
     * @param action_name    二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值
     * @param scene_str      场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
     */
    public static Ticket qrcodeCreate(String access_token, Integer expire_seconds, String action_name, String scene_str) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + access_token;
        Map map = new HashMap();
        if (expire_seconds != null) {
            map.put("expire_seconds", expire_seconds);
        }
        map.put("action_name", action_name);
        Map actionInfoMap = new HashMap();
        actionInfoMap.put("scene", "{\"scene_id\":\"" + scene_str + "\"}");
        map.put("action_info", actionInfoMap);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, JSON.toJSONString(map));
        return JSON.parseObject(responseBody.string(), Ticket.class);
    }

    /**
     * 通过ticket换取二维码
     *
     * @param ticket
     * @return
     * @throws IOException
     */
    public static InputStream showQrcode(String ticket) throws IOException {
        String tk = URLEncoder.encode(ticket, "UTF-8");
        String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + tk;
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        return responseBody.byteStream();
    }

    /**
     * 通过ticket换取二维码
     *
     * @param ticket
     * @return
     * @throws IOException
     */
    public static Response showQrcodeResResponse(String ticket) throws IOException {
        String tk = URLEncoder.encode(ticket, "UTF-8");
        String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + tk;
        return OkHttpUtil.syncGetResResponse(url);
    }

    /**
     * 长链接转短链接接口
     *
     * @param access_token
     * @param long_url     需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
     * @param action       此处填long2short，代表长链接转短链接
     * @return
     * @throws IOException
     */
    public static Shorturl shortUrl(String access_token, String long_url, String action) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=" + access_token;
        Map map = new HashMap();
        if (action != null) {
            map.put("action", access_token);
        } else {
            map.put("action", "long2short");
        }
        map.put("long_url", long_url);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, JSON.toJSONString(map));
        return JSON.parseObject(responseBody.string(), Shorturl.class);

    }

    /**
     * 长链接转短链接接口
     *
     * @param access_token
     * @param long_url     需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
     * @return
     * @throws IOException
     */
    public static Shorturl shortUrl(String access_token, String long_url) throws IOException {
        return shortUrl(access_token, long_url, null);
    }
}
