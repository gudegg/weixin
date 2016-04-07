package club.gude.utils.http;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

/**
 * @Author Gude
 * @Date 2016/4/7.
 */
public abstract class CallbackString extends OkHttpCallback {

    @Override
    public void ResBody(ResponseBody body) throws IOException {
        resData(body.string());
    }


    public abstract void resData(String resData);
}
