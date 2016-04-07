package club.gude.utils.http;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

/**
 * @Author Gude
 * @Date 2016/4/7.
 */
public abstract class OkHttpCallback implements Callback {
    private ResponseBody body;

    @Override
    public void onFailure(Request request, IOException e) {
        e.printStackTrace();
    }

    @Override
    public void onResponse(Response response) throws IOException {
        if (response.isSuccessful()) {
            body = response.body();

        } else {
            body = null;
        }
        ResBody(body);
    }


    /**
     * 传入返回body
     *
     * @return
     */
    public abstract void ResBody(ResponseBody body) throws IOException;
}
