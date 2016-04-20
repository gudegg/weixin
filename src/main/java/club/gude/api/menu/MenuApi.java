package club.gude.api.menu;

import club.gude.utils.http.OkHttpUtil;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

/**
 * @Author Gude
 * @Date 2016/4/19.
 */
public class MenuApi {
    /**
     * 自定义菜单创建接口
     *
     * @param access_token
     * @param json
     * @return
     * @throws IOException
     */
    public static String createMenu(String access_token, String json) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();

    }

    /**
     * 自定义菜单查询接口
     *
     * @param access_token
     * @return
     * @throws IOException
     */
    public static String getMenu(String access_token) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        return responseBody.string();

    }

    /**
     * 自定义菜单删除接口
     *
     * @param access_token
     * @return
     * @throws IOException
     */
    public static String delMenu(String access_token) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        return responseBody.string();
    }

    /**
     * 创建个性化菜单
     *
     * @param access_token
     * @param json
     * @return
     * @throws IOException
     */
    public static String addConditionalMenu(String access_token, String json) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();

    }

    /**
     * 删除个性化菜单
     *
     * @param access_token
     * @param menuid
     * @return
     * @throws IOException
     */
    public static String delConditionalMenu(String access_token, String menuid) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=" + access_token;
        String json = "{\"menuid\":\"" + menuid + "\"}";

        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 测试个性化菜单匹配结果
     *
     * @param access_token
     * @param json
     * @return
     * @throws IOException
     */
    public static String tryMatchMenu(String access_token, String json) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);

        return responseBody.string();

    }

    /**
     * 获取自定义菜单配置接口
     *
     * @param access_token
     * @return
     * @throws IOException
     */
    public static String getCurrentSelfmenuInfo(String access_token) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        return responseBody.string();

    }
}
