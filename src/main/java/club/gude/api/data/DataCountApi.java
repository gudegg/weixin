package club.gude.api.data;

import club.gude.utils.http.OkHttpUtil;
import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Gude
 * @Date 2016/4/25.
 * 数据统计
 */
public class DataCountApi {
    public static final SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd");

    /**
     * TODO 返回对象 UserSummary
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
        String str_b_date = df.format(begin_date);
        String str_e_date = df.format(end_date);
        System.out.println(str_b_date + "  " + str_e_date);

        Date b_date = df.parse(str_b_date);
        Date e_date = df.parse(str_e_date);
        long day = (e_date.getTime() - b_date.getTime()) / (24 * 60 * 60 * 1000);
        if (day > 7) {
            throw new RuntimeException("最大时间跨度不能超过7天");
        }
        Map map = new LinkedHashMap();
        map.put("begin_date", str_b_date);
        map.put("end_date", str_e_date);
        ResponseBody responseBody = OkHttpUtil.syncPostByJson(url, JSON.toJSONString(map));
        return responseBody.string();
    }
}
