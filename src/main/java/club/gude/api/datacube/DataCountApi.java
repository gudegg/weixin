package club.gude.api.datacube;

import club.gude.entity.datacube.UserCumulate;
import club.gude.entity.datacube.UserSummary;
import club.gude.utils.http.OkHttpUtil;
import club.gude.utils.json.JsonUtil;
import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Gude
 * @Date 2016/4/25.
 * 数据统计
 */
public class DataCountApi {
    public static final SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd");

    /**
     * 获取用户增减数据
     *
     * @param access_token 调用接口凭证
     * @param begin_date   获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param end_date     获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String getUserSummary(String access_token, Date begin_date, Date end_date) throws ParseException, IOException {
        String url = "https://api.weixin.qq.com/datacube/getusersummary?access_token=" + access_token;
        String paraJson = dateExChange(begin_date, end_date);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, paraJson);
        return responseBody.string();
    }

    /**
     * 获取用户增减数据
     *
     * @param access_token 调用接口凭证
     * @param begin_date   获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param end_date     获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static List<UserSummary> getUserSummaryResObj(String access_token, Date begin_date, Date end_date) throws IOException, ParseException {
        String res = getUserSummary(access_token, begin_date, end_date);
        return JsonUtil.strToListObj(res, "list", UserSummary.class);

    }

    /**
     * 获取累计用户数据
     * @param access_token 调用接口凭证
     * @param begin_date 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param end_date 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String getUserCumulate(String access_token, Date begin_date, Date end_date) throws ParseException, IOException {
        String url = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=" + access_token;
        String paraJson = dateExChange(begin_date, end_date);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, paraJson);
        return responseBody.string();
    }
    /**
     * 获取累计用户数据
     * @param access_token 调用接口凭证
     * @param begin_date 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param end_date 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static List<UserCumulate> getUserCumulateResObj(String access_token, Date begin_date, Date end_date) throws ParseException, IOException {
        String res= getUserCumulate(access_token,begin_date,end_date);
        return  JsonUtil.strToListObj(res,"list", UserCumulate.class);
    }

    private static String dateExChange(Date begin_date, Date end_date) throws ParseException {
        String str_b_date = df.format(begin_date);
        String str_e_date = df.format(end_date);
        Date b_date = df.parse(str_b_date);
        Date e_date = df.parse(str_e_date);
        long day = (e_date.getTime() - b_date.getTime()) / (24 * 60 * 60 * 1000);
        if (day > 7) {
            throw new RuntimeException("最大时间跨度不能超过7天");
        }
        Map map = new LinkedHashMap();
        map.put("begin_date", str_b_date);
        map.put("end_date", str_e_date);
        return JSON.toJSONString(map);
    }
}
