package club.gude.api.msg;

import club.gude.entity.kfcustomer.KF;
import club.gude.entity.kfcustomer.KFHead;
import club.gude.utils.http.OkHttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static club.gude.utils.http.OkHttpUtil.syncPostByJson;

/**
 * @Author Gude
 * @Date 2016/4/16.
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
    public static String addCustomerService(String access_token, KF KF) throws IOException {
        String url = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=" + access_token;
        ResponseBody responseBody = syncPostByJson(url, JSON.toJSONString(KF));
        return responseBody.string();
    }

    /**
     * 修改客服账号
     *
     * @param access_token
     * @param KF           客服
     * @return
     * @throws IOException
     */
    public static String updateCustomerService(String access_token, KF KF) throws IOException {
        String url = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=" + access_token;
        ResponseBody responseBody = syncPostByJson(url, JSON.toJSONString(KF));
        return responseBody.string();

    }

    /**
     * 删除客服账号
     *
     * @param access_token
     * @param KF           客服
     * @return
     * @throws IOException
     */
    public static String delCustomerService(String access_token, KF KF) throws IOException {
        String url = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=" + access_token;
        ResponseBody responseBody = syncPostByJson(url, JSON.toJSONString(KF));
        return responseBody.string();

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
    public static String uploadHead(String access_token, String kf_account, File file) throws IOException {
        String url = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=" + access_token + "&kf_account=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncPostByFile(url, file);
        return responseBody.string();

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
        //                String res = "{\n" +
        //                        "    \"kf_list\": [\n" +
        //                        "        {\n" +
        //                        "            \"kf_account\": \"test1@test\", \n" +
        //                        "            \"kf_nick\": \"ntest1\", \n" +
        //                        "            \"kf_id\": \"1001\"\n," +
        //                        "            \"kf_headimgurl\": \" http://mmbiz.qpic.cn/mmbiz/4whpV1VZl2iccsvYbHvnphkyGtnvjfUS8Ym0GSaLic0FD3vN0V8PILcibEGb2fPfEOmw/0\"\n" +
        //                        "        }, \n" +
        //                        "        {\n" +
        //                        "            \"kf_account\": \"test2@test\", \n" +
        //                        "            \"kf_nick\": \"ntest2\", \n" +
        //                        "            \"kf_id\": \"1002\"\n," +
        //                        "            " +
        //                        "        }, \n" +
        //                        "        {\n" +
        //                        "            \"kf_account\": \"test3@test\", \n" +
        //                        "            \"kf_nick\": \"ntest3\", \n" +
        //                        "            \"kf_id\": \"1003\"\n," +
        //                        "            \"kf_headimgurl\": \" http://mmbiz.qpic.cn/mmbiz/4whpV1VZl2iccsvYbHvnphkyGtnvjfUS8Ym0GSaLic0FD3vN0V8PILcibEGb2fPfEOmw /0\"\n" +
        //                        "        }\n" +
        //                        "    ]\n" +
        //                        "}";
        JSONObject kf_list_res = JSON.parseObject(res);
        String kf_list = kf_list_res.getString("kf_list");
        List<KFHead> kfList = JSON.parseArray(kf_list, KFHead.class);
        return kfList;
    }

    /**
     *
     * @param msg json格式数据 如:{@linkplain club.gude.entity.kfcustomer.KFTextMsg}
     * @return
     */
    public static String sendMsg(String access_token, String msg) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + access_token;
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, msg);
        return responseBody.string();
    }
}
