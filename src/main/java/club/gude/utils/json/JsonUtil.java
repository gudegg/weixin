package club.gude.utils.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;


/**
 * @Author Gude
 * @Date 2016/4/24.
 */
public class JsonUtil {
    /**
     * @param res
     * @param para
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T strToObj(String res, String para, Class<T> clz) {
        JSONObject jsonObject = JSON.parseObject(res);
        String json = jsonObject.getString(para);
        return JSON.parseObject(json, clz);
    }

    /**
     *
     * @param res
     * @param para
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> List<T> strToListObj(String res, String para, Class<T> clz) {
        JSONObject jsonObject = JSON.parseObject(res);
        String json = jsonObject.getString(para);
        return JSON.parseArray(json,clz);
    }
}
