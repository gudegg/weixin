package club.gude.api.msg;

import club.gude.entity.BaseRes;
import club.gude.entity.kfcustomer.KF;
import club.gude.entity.kfcustomer.KFBaseMsg;
import club.gude.entity.kfcustomer.KFHead;
import club.gude.utils.http.OkHttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static club.gude.utils.http.OkHttpUtil.syncPostByJson;
import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * @Author Gude
 * @Date 2016/4/16.
 * 客服消息
 */
public class KFCustomServiceApi {
    /**
     * 添加客服帐号
     *
     * @param access_token
     * @param KF           客服
     * @return
     * @throws IOException
     */
    public static BaseRes addCustomerService(String access_token, KF KF) {
        String url = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=" + access_token;
        return syncPostByJson(url, toJSONString(KF), BaseRes.class);
    }

    /**
     * 修改客服账号
     *
     * @param access_token
     * @param KF           客服
     * @return
     * @throws IOException
     */
    public static BaseRes updateCustomerService(String access_token, KF KF) {
        String url = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=" + access_token;
        return syncPostByJson(url, toJSONString(KF), BaseRes.class);

    }

    /**
     * 删除客服账号
     *
     * @param access_token
     * @param KF           客服
     * @return
     * @throws IOException
     */
    public static BaseRes delCustomerService(String access_token, KF KF) {
        String url = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=" + access_token;
        return syncPostByJson(url, toJSONString(KF), BaseRes.class);

    }

    /**
     * 设置客服帐号的头像
     *
     * @param access_token
     * @param kf_account   客服账号
     * @param file         头像文件 只支持jpg格式
     * @return
     * @throws IOException
     */
    public static BaseRes uploadHead(String access_token, String kf_account, File file) {
        String url = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=" + access_token + "&kf_account=" + access_token;
        return OkHttpUtil.syncPostByFile(url, file, BaseRes.class);

    }

    /**
     * 获取所有客服账号
     *
     * @param access_token
     * @return
     * @throws IOException
     */
    public static List<KFHead> getKFList(String access_token) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        String res = responseBody.string();
        JSONObject kf_list_res = JSON.parseObject(res);
        String kf_list = kf_list_res.getString("kf_list");
        List<KFHead> kfList = JSON.parseArray(kf_list, KFHead.class);
        return kfList;
    }

    /**
     * 客服接口-发消息
     * @param msg json格式数据 如:{@linkplain club.gude.entity.kfcustomer.KFTextMsg}
     * @return
     */
    public static String sendMsg(String access_token, String msg) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, msg);
        return responseBody.string();
    }

    /**
     *客服接口-发消息
     * @param access_token
     * @param t
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T extends KFBaseMsg> BaseRes sendMsg(String access_token,T t) throws IOException {
        String msg= JSON.toJSONString(t);
        String result= sendMsg(access_token,msg);
        return JSON.parseObject(result,BaseRes.class);
    }
}
