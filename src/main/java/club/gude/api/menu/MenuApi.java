package club.gude.api.menu;

import club.gude.entity.BaseRes;
import club.gude.entity.menu.Menu;
import club.gude.entity.menu.MenuResult;
import club.gude.entity.menu.condition.ConditionMenu;
import club.gude.entity.menu.condition.ConditionMenuResult;
import club.gude.utils.http.OkHttpUtil;
import com.alibaba.fastjson.JSON;
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
     * 自定义菜单创建接口
     *
     * @param access_token
     * @param menu
     * @return
     * @throws IOException
     */
    public static BaseRes createMenu(String access_token, Menu menu) throws IOException {
        StringBuilder sb = new StringBuilder("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=");
        sb.append(access_token);
        String param = JSON.toJSONString(menu);
        return OkHttpUtil.syncPostByJson(sb.toString(), param, BaseRes.class);
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
     * 自定义菜单查询接口
     *
     * @param access_token
     * @return
     * @throws IOException
     */
    public static MenuResult getMenuRes(String access_token) throws IOException {
        String result = getMenu(access_token);
        return JSON.parseObject(result, MenuResult.class);
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
     * 自定义菜单删除接口
     *
     * @param acccess_token
     * @return
     * @throws IOException
     */
    public static BaseRes delMenuRes(String acccess_token) throws IOException {
        String result = delMenu(acccess_token);
        return JSON.parseObject(result, BaseRes.class);
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
     * 创建个性化菜单
     *
     * @param access_token
     * @param conditionMenu
     * @return
     * @throws IOException
     */
    public static ConditionMenuResult addConditionalMenuRes(String access_token, ConditionMenu conditionMenu) throws IOException {
        String param = JSON.toJSONString(conditionMenu);
        String result = addConditionalMenu(access_token, param);
        return JSON.parseObject(result, ConditionMenuResult.class);
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
     * 删除个性化菜单
     *
     * @param access_token
     * @param conditionMenuResult
     * @return
     * @throws IOException
     */
    public static BaseRes delConditionalMenuRes(String access_token, ConditionMenuResult conditionMenuResult) throws IOException {
        StringBuilder sb = new StringBuilder("https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=");
        sb.append(access_token);
        return OkHttpUtil.syncPostByJson(sb.toString(), conditionMenuResult, BaseRes.class);
    }

    /**
     * 测试个性化菜单匹配结果
     *
     * @param access_token
     * @param user_id 可以是粉丝的OpenID，也可以是粉丝的微信号。
     * @return
     * @throws IOException
     */
    public static String tryMatchMenu(String access_token, String user_id) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=" + access_token;
        String json="{\"user_id\":\""+user_id+"\"}";
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
