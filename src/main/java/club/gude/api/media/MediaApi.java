package club.gude.api.media;

import club.gude.entity.media.Article;
import club.gude.utils.http.OkHttpUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.io.ByteStreams;
import com.squareup.okhttp.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static club.gude.utils.http.OkHttpUtil.syncPostByJson;
import static org.apache.coyote.http11.Constants.a;

/**
 * @Author Gude
 * @Date 2016/4/12.
 */
public class MediaApi {
    /**
     * 添加临时素材
     * <p>
     * 注意事项<br/>
     * 上传的临时多媒体文件有格式和大小限制，如下：<br/>
     * 图片（image）: 1M，支持JPG格式<br/>
     * 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式<br/>
     * 视频（video）：10MB，支持MP4格式<br/>
     * 缩略图（thumb）：64KB，支持JPG格式<br/>
     * <p/>
     *
     * @param access_token
     * @param type         媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param file         上传文件
     * @return
     */
    public static String addTemporaryMedia(String access_token, String type, File file) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/media/upload";
        RequestBody filebody = RequestBody.create(null, file);
        RequestBody requestBody = new MultipartBuilder().type(MultipartBuilder.FORM).addFormDataPart("media", file.getName(), filebody).addFormDataPart("type", type).addFormDataPart("access_token", access_token).build();
        ResponseBody responseBody = OkHttpUtil.syncPost(url, requestBody);
        return responseBody.string();

    }

    /**
     * 获取临时素材
     *
     * @param access_token
     * @param media_id
     * @return
     * @throws IOException
     */
    public static InputStream getTemporaryMediaResIS(String access_token, String media_id) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=" + access_token + "&media_id=" + media_id;
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        return responseBody.byteStream();
    }

    public static Response getTemporaryMediaResResponse(String access_token, String media_id) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=" + access_token + "&media_id=" + media_id;
        Response response = OkHttpUtil.syncGetResResponse(url);
        return response;
    }

    /**
     * TODO 新增永久图文素材
     *
     * @param access_token
     * @return
     */

    public static String addForeverNews(String access_token, List<Article> articles) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_news";
        Map<String, List<Article>> map = new HashMap();
        map.put("articles", articles);
        String json = JSON.toJSONString(map);
        RequestBody r = RequestBody.create(null, json);
        RequestBody requestBody = new MultipartBuilder().type(MultipartBuilder.FORM).addPart(r).addFormDataPart("access_token", access_token).build();
        ResponseBody responseBody = OkHttpUtil.syncPost(url, requestBody);
        return responseBody.string();
    }

    /**
     * 图文素材中的图片 不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
     *
     * @param access_token
     * @param file
     * @return
     */
    public static String addForeverNew_Img(String access_token, File file) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/media/uploadimg";
        RequestBody filebody = RequestBody.create(null, file);
        RequestBody requestBody = new MultipartBuilder().type(MultipartBuilder.FORM).addFormDataPart("access_token", access_token).addFormDataPart("media", file.getName(), filebody).build();
        ResponseBody responseBody = OkHttpUtil.syncPost(url, requestBody);
        return responseBody.string();
    }

    /**
     * 新增视频永久素材
     *
     * @param access_token
     * @param title        视频素材的标题
     * @param introduction 视频素材的描述
     * @param file
     * @return
     * @throws IOException
     */
    public static String addForeverVideo(String access_token, String title, String introduction, File file) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_material";
        String description = "{\"title\":" + title + ",\"introduction\":" + introduction + "}";
        //System.out.println(description);
        RequestBody filebody = RequestBody.create(null, file);
        RequestBody requestBody = new MultipartBuilder().type(MultipartBuilder.FORM).addFormDataPart("media", file.getName(), filebody).addFormDataPart("description", description).addFormDataPart("type", "video").addFormDataPart("access_token", access_token).build();
        ResponseBody responseBody = OkHttpUtil.syncPost(url, requestBody);
        return responseBody.string();
    }

    /**
     * 新增其他永久素材
     *
     * @param type 媒体文件类型，分别有图片（image）、语音（voice）、和缩略图（thumb）
     * @return
     */
    public static String addForeverOther(String access_token, String type, File file) throws IOException {
        if (type.equals("video")) {
            throw new RuntimeException("请调用视频方法");
        }

        String url = "https://api.weixin.qq.com/cgi-bin/material/add_material";
        RequestBody filebody = RequestBody.create(null, file);
        RequestBody requestBody = new MultipartBuilder().type(MultipartBuilder.FORM).addFormDataPart("media", file.getName(), filebody).addFormDataPart("type", type).addFormDataPart("access_token", access_token).build();
        ResponseBody responseBody = OkHttpUtil.syncPost(url, requestBody);
        return responseBody.string();
    }

    /**
     * 获取永久素材
     *
     * @param access_token
     * @param media_id
     * @return
     * @throws IOException
     */

    public static InputStream getForeverMedia(String access_token, String media_id) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=" + access_token;
        String json = "{\"media_id\":\"" + media_id + "\"}";
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.byteStream();
    }

    /**
     * 删除永久素材
     *
     * @param access_token
     * @param media_id
     * @return
     */
    public static String delForeverMedia(String access_token, String media_id) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=" + access_token;
        String json = "{\"media_id\":\"" + media_id + "\"}";
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 修改永久图文素材
     *
     * @param media_id
     * @param index    要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
     * @param article
     * @return
     */
    public static String updateForeverNews(String access_token, String media_id, int index, Article article) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=" + access_token;
        Map map = new HashMap();
        map.put("media_id", media_id);
        map.put("index", index);
        map.put("articles", article);
        String json = JSON.toJSONString(map);

        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 获取素材总数
     *
     * @param access_token
     * @return
     */
    public static String getMediaCount(String access_token) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=" + access_token;
        return OkHttpUtil.syncGet(url).string();
    }

    /**
     * 获取素材列表
     *
     * @param access_token
     * @param type         素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     * @param offset       从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     * @param count        返回素材的数量，取值在1到20之间
     * @return
     */
    public static String getMediaList(String access_token, String type, int offset, int count) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=" + access_token;
        String json = "{\"type\":\"" + type + "\",\"offset\":" + offset + ",\"count\":" + count + "}";
        return OkHttpUtil.syncPostByJson(url, json).string();
    }
}
