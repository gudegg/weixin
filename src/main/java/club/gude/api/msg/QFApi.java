package club.gude.api.msg;

import club.gude.api.media.MediaApi;
import club.gude.entity.media.Article;
import club.gude.utils.http.OkHttpUtil;
import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Gude
 * @Date 2016/4/17.
 * 群发接口
 */
public class QFApi {
    /**
     * 上传图文消息内的图片获取URL【订阅号与服务号认证后均可用】
     *
     * @param access_token
     * @param file
     * @return
     * @throws IOException
     */
    public static String uploadNewsImg(String access_token, File file) throws IOException {
        return MediaApi.addForeverNew_Img(access_token, file);
    }

    /**
     * 上传图文消息素材【订阅号与服务号认证后均可用】
     *
     * @param access_token
     * @param articles
     * @return
     * @throws IOException
     */

    public static String uploadNews(String access_token, List<Article> articles) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=" + access_token;
        Map<String, List<Article>> map = new HashMap();
        map.put("articles", articles);
        String json = JSON.toJSONString(map);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 根据分组进行群发【订阅号与服务号认证后均可用】
     *
     * @param access_token
     * @param map          按照官方需要的格式封装成map
     * @return
     */
    public static String massSendAllGroupMap(String access_token, Map<String, Object> map) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=" + access_token;
        String json = JSON.toJSONString(map);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 根据分组进行群发【订阅号与服务号认证后均可用】
     *
     * @param access_token
     * @param json         详看微信官方json格式
     * @return
     */
    public static String massSendAllGroupJson(String access_token, String json) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 根据OpenID列表群发【订阅号不可用，服务号认证后可用】
     *
     * @param access_token
     * @param map          按照官方json的格式封装成map
     * @return
     */
    public static String massSendOpenIdMap(String access_token, Map<String, Object> map) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=" + access_token;
        String json = JSON.toJSONString(map);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 根据OpenID列表群发【订阅号不可用，服务号认证后可用】
     *
     * @param access_token
     * @param json         详看微信官方json格式
     * @return
     */
    public static String massSendOpenIdJson(String access_token, String json) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 删除群发【订阅号与服务号认证后均可用】
     * 请注意：
     * 1、只有已经发送成功的消息才能删除
     * 2、删除消息是将消息的图文详情页失效，已经收到的用户，还是能在其本地看到消息卡片。
     * 3、删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除。
     * 4、如果多次群发发送的是一个图文消息，那么删除其中一次群发，就会删除掉这个图文消息也，导致所有群发都失效
     *
     * @param access_token
     * @param msg_id       群发消息后返回的消息id
     * @return
     */
    public static String delMassSend(String access_token, long msg_id) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=" + access_token;
        String json = "{\"msg_id\":" + msg_id + "}";
        System.out.println(json);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();

    }

    /**
     * 开发者可通过该接口发送消息给指定用户，在手机端查看消息的样式和排版。为了满足第三方平台开发者的需求，在保留对openID预览能力的同时，增加了对指定微信号发送预览的能力，该能力每日调用次数有限制（100次），请勿滥用。
     * <p>
     * 预览接口【订阅号与服务号认证后均可用】
     *
     * @param access_token
     * @param map          按照官方json的格式封装成map
     * @return
     */
    public static String previewMassSendMap(String access_token, Map map) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=" + access_token;
        String json = JSON.toJSONString(map);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 预览接口【订阅号与服务号认证后均可用】
     *
     * @param access_token
     * @param json
     * @return
     */
    public static String previewMassSendJson(String access_token, String json) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 查询群发消息发送状态【订阅号与服务号认证后均可用】
     *
     * @param access_token
     * @param msg_id       群发消息后返回的消息id
     * @return
     * @throws IOException
     */
    public static String getMassStatus(String access_token, long msg_id) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=" + access_token;
        String json = "{\"msg_id\":" + msg_id + "}";
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();

    }
}
