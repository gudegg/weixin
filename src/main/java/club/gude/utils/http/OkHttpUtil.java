package club.gude.utils.http;

import com.alibaba.fastjson.JSON;
import com.google.common.io.ByteStreams;
import com.squareup.okhttp.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author Gude
 * @Date 2016/4/7.
 */
public class OkHttpUtil {
    public static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/x-markdown; charset=utf-8");

    static {
        OK_HTTP_CLIENT.setConnectTimeout(10, TimeUnit.SECONDS);
        OK_HTTP_CLIENT.setWriteTimeout(30, TimeUnit.SECONDS);
        OK_HTTP_CLIENT.setReadTimeout(30, TimeUnit.SECONDS);
    }

    /**
     * 同步get
     */
    public static ResponseBody syncGet(String url) {
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T syncGet(String url, Class<T> clz) {
        ResponseBody body = syncGet(url);
        try {
            String result = body.string();
            return JSON.parseObject(result, clz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 同步get
     */
    public static Response syncGetResResponse(String url) {
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            if (response.isSuccessful()) {
                return response;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 同步get
     */
    public static ResponseBody syncGet(String url, Map<String, String> param) {
        for (String s : param.keySet()) {
            url += "?" + s + "=" + param.get(s);
        }
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 异步Get
     *
     * @param url      请求链接
     * @param callback 回调
     */
    public static void asynGet(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();
        OK_HTTP_CLIENT.newCall(request).enqueue(callback);
    }

    public static void asynGet(String url, Map<String, String> param, Callback callback) {
        StringBuilder sb = new StringBuilder(url);
        for (String s : param.keySet()) {
            sb.append("?").append(s).append("=").append(param.get(s));
        }
        Request request = new Request.Builder().url(sb.toString()).build();
        OK_HTTP_CLIENT.newCall(request).enqueue(callback);
    }


    /**
     * 同步 post 发送键值对
     */
    public static ResponseBody syncPostByForm(String url, Map<String, String> map) {
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        for (String s : map.keySet()) {
            formEncodingBuilder.add(s, map.get(s));
        }
        RequestBody requestBody = formEncodingBuilder.build();

        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = null;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseBody syncPostByJson(String url, String json) {
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_JSON, json);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = null;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T syncPostByJson(String url, String json, Class<T> clz) {
        ResponseBody body = syncPostByJson(url, json);

        try {
            String result = body.string();
            return JSON.parseObject(result, clz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T syncPostByJson(String url, Object param, Class<T> clz) {
        String json = JSON.toJSONString(param);
        ResponseBody body = syncPostByJson(url, json);
        try {
            String result = body.string();
            return JSON.parseObject(result, clz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseBody syncPostByString(String url, String str) {
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_TEXT, str);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = null;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseBody syncPostByStream(String url, InputStream is) throws IOException {
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_TEXT, ByteStreams.toByteArray(is));
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = null;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseBody syncPostByFile(String url, File file) {
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_TEXT, file);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = null;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * example:
     * <p>
     * private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
     * RequestBody requestBody = new MultipartBody.Builder()
     * .setType(MultipartBody.FORM)
     * .addFormDataPart("title", "Square Logo")
     * .addFormDataPart("image", "logo-square.png",
     * RequestBody.create(MEDIA_TYPE_PNG, new File("website/static/logo-square.png")))
     * .build();
     * <p>
     * 自定义请求
     *
     * @param url         链接
     * @param requestBody 请求体
     * @return
     * @see <a href="https://github.com/square/okhttp/wiki/Recipes">https://github.com/square/okhttp/wiki/Recipes</a>
     */
    public static ResponseBody syncPost(String url, RequestBody requestBody) {
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = null;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
