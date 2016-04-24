package club.gude.api.user;

import club.gude.entity.user.Group;
import club.gude.entity.user.UserInfo;
import club.gude.utils.http.OkHttpUtil;
import club.gude.utils.json.JsonUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Gude
 * @Date 2016/4/21.
 * 用户管理
 */
public class UserApi {
    /**
     * 创建分组
     *
     * @param access_token
     * @param groupName    分组名字（30个字符以内）
     * @return
     * @throws IOException
     */
    public static String createGroup(String access_token, String groupName) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=" + access_token;
        String json = "{\"group\":{\"name\":\"" + groupName + "\"}}";
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();


    }

    /**
     * 创建分组
     *
     * @param access_token
     * @param groupName    分组名字（30个字符以内）
     * @return
     * @throws IOException
     */
    public static Group createGroupResObj(String access_token, String groupName) throws IOException {
        String res = createGroup(access_token, groupName);
        return JsonUtil.strToObj(res,"group",Group.class);
    }

    /**
     * 查询所有分组
     *
     * @param access_token
     * @return
     * @throws IOException
     */
    public static String getGroups(String access_token) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        return responseBody.string();

    }
    /**
     * 查询所有分组
     *
     * @param access_token
     * @return
     * @throws IOException
     */
    public static List<Group> getGroupsResObj(String access_token) throws IOException {
        String res=getGroups(access_token);
        return JsonUtil.strToListObj(res,"groups",Group.class);

    }
    /**
     * 查询用户所在分组
     *
     * @param access_token
     * @param openId       用户的OpenID
     * @return
     * @throws IOException
     */
    public static String getGroupByOpenId(String access_token, String openId) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=" + access_token;
        String json = "{\"openid\":\"" + openId + "\"}";
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 修改分组名
     *
     * @param access_token
     * @param groupId      分组id，由微信分配
     * @param groupName    分组名字（30个字符以内）
     * @return
     */
    public static String updateGroup(String access_token, int groupId, String groupName) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=" + access_token;
        String json = "{\"group\":{\"id\":" + groupId + ",\"name\":\"" + groupName + "\"}}";
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();

    }

    /**
     * 移动用户分组
     *
     * @param access_token
     * @param openId       用户唯一标识符
     * @param to_groupid   分组id
     * @return
     * @throws IOException
     */
    public static String moveGroup(String access_token, String openId, int to_groupid) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=" + access_token;
        String json = "{\"openid\":\"" + openId + "\",\"to_groupid\":" + to_groupid + "}";
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * @param access_token
     * @param openid_list  用户唯一标识符openid的列表（size不能超过50）
     * @param to_groupid   分组id
     * @return
     * @throws IOException
     */
    public static String batchMoveGroup(String access_token, List<String> openid_list, int to_groupid) throws IOException {
        if (openid_list.size() > 50) {
            throw new RuntimeException("size不能超过50");
        }
        String url = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=" + access_token;
        Map map = new HashMap();
        map.put("to_groupid", to_groupid);
        map.put("openid_list", openid_list);
        String json = JSON.toJSONString(map);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();

    }

    /**
     * 删除分组
     *
     * @param access_token
     * @param groupId      分组的id
     * @return
     * @throws IOException
     */
    public static String delGroup(String access_token, int groupId) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=" + access_token;
        String json = "{\"group\":{\"id\":" + groupId + "}}";
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();

    }

    /**
     * 设置用户备注名
     *
     * @param access_token
     * @param openId       用户标识
     * @param remark       新的备注名，长度必须小于30字符
     * @return
     * @throws IOException
     */
    public static String updateUserRemark(String access_token, String openId, String remark) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=" + access_token;
        Map map = new HashMap();
        map.put("openid", openId);
        map.put("remark", remark);
        String json = JSON.toJSONString(map);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 获取用户基本信息（包括UnionID机制）
     *
     * @param access_token
     * @param openId       普通用户的标识，对当前公众号唯一
     * @return
     * @throws IOException
     */
    public static String getUserInfo(String access_token, String openId) throws IOException {
        return getUserInfo(access_token, openId, null);
    }

    /**
     * 获取用户基本信息（包括UnionID机制）
     *
     * @param access_token
     * @param openId       普通用户的标识，对当前公众号唯一
     * @param lang         返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return
     * @throws IOException
     */
    public static String getUserInfo(String access_token, String openId, String lang) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("https://api.weixin.qq.com/cgi-bin/user/info").append("?access_token=").append(access_token).append("&openid=").append(openId);

        if (lang == null) {
            sb.append("&lang=zh_CN ");
        } else {
            sb.append("&lang=").append(lang);
        }
        ResponseBody responseBody = OkHttpUtil.syncGet(sb.toString());
        return responseBody.string();
    }

    /**
     * 批量获取用户基本信息
     *
     * @param access_token
     * @param openIds
     * @param lang         国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
     * @return
     */
    public static String batchUserInfo(String access_token, List<String> openIds, String lang) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=" + access_token;
        List<Map> opens = new ArrayList<>();
        for (String openid : openIds) {
            Map map = new HashMap();
            map.put("openid", openid);
            map.put("lang", lang);
            opens.add(map);
        }
        Map mapJson = new HashMap();
        mapJson.put("user_list", opens);
        String json = JSON.toJSONString(mapJson);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, json);
        return responseBody.string();
    }

    /**
     * 批量获取用户基本信息
     *
     * @param access_token
     * @param openIds
     * @param lang         国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
     * @return
     */
    public static List<UserInfo> batchUserInfoResObj(String access_token, List<String> openIds, String lang) throws IOException {
        String res = batchUserInfo(access_token, openIds, lang);
       return JsonUtil.strToListObj(res,"user_info_list",UserInfo.class);
    }

    /**
     * 一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
     *
     * @param access_token
     * @param next_openid  第一个拉取的OPENID，不填默认从头开始拉取
     * @return
     * @throws IOException
     */
    public static String getAllUser(String access_token, String next_openid) throws IOException {
        StringBuilder url = new StringBuilder();
        url.append("https://api.weixin.qq.com/cgi-bin/user/get?access_token=").append(access_token);
        if (next_openid != null) {
            url.append("&next_openid=").append(next_openid);
        }
        ResponseBody responseBody = OkHttpUtil.syncGet(url.toString());
        return responseBody.string();

    }

    /**
     * 获取用户列表,默认从头开始拉取.一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
     *
     * @param access_token
     * @return
     * @throws IOException
     */
    public static String getAllUser(String access_token) throws IOException {
        return getAllUser(access_token, null);
    }

}
