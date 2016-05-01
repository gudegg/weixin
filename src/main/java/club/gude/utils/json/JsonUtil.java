package club.gude.utils.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.List;

import static com.alibaba.fastjson.JSON.parseObject;


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
        JSONObject jsonObject = parseObject(res);
        String json = jsonObject.getString(para);
        if(Strings.isNullOrEmpty(json)){
            return parseObject(res,clz);
        }
        return parseObject(json, clz);
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
        JSONObject jsonObject = parseObject(res);
        String json = jsonObject.getString(para);
        if(Strings.isNullOrEmpty(json)){
            T t= JSON.parseObject(res,clz);
            List list=new ArrayList();
            list.add(t);
            return list;
        }
        return JSON.parseArray(json,clz);
    }
}
