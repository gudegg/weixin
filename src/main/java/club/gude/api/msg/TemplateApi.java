package club.gude.api.msg;

import club.gude.utils.http.OkHttpUtil;
import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Gude
 * @Date 2016/4/17.
 * 模板接口
 */
public class TemplateApi {
    /**
     * 设置所属行业
     *
     * @param access_token
     * @param industry_id1
     * @param industry_id2
     * @return
     */
    public static String setIndustry(String access_token, int industry_id1, int industry_id2) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=" + access_token;
        Map map = new HashMap();
        map.put("industry_id1", industry_id1);
        map.put("industry_id2", industry_id2);
        String json = JSON.toJSONString(map);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();

    }

    /**
     * 获取设置的行业信息
     *
     * @param access_token
     * @return
     * @throws IOException
     */
    public static String getIndustry(String access_token) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        return responseBody.string();

    }


    /**
     * 获取模板列表
     *
     * @param access_token
     * @return
     * @throws IOException
     */
    public static String getAllPrivateTemplate(String access_token) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        return responseBody.string();
    }

    /**
     * 获得模板ID
     *
     * @param access_token
     * @param template_id_short 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     * @return
     * @throws IOException
     */
    public static String apiAddTemplate(String access_token, String template_id_short) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=" + access_token;
        String json = "{\"template_id_short\":\"" + template_id_short + "\"}";
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 删除模板
     *
     * @param access_token
     * @param template_id  公众帐号下模板消息ID
     * @return
     * @throws IOException
     */
    public static String delPrivateTemplate(String access_token, String template_id) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=" + access_token;
        String json = "{\"template_id\":\"" + template_id + "\"}";
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();

    }

    /**
     * 发送模板消息
     *
     * @param access_token
     * @param map          按照官方格式封装成map
     * @return
     * @throws IOException
     */
    public static String sendTemplateMsg(String access_token, Map<String, Object> map) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + access_token;
        String json = JSON.toJSONString(map);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

}
