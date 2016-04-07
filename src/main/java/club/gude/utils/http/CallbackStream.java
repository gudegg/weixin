package club.gude.utils.http;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Gude
 * @Date 2016/4/7.
 */
public abstract class CallbackStream extends OkHttpCallback {
    @Override
    public void ResBody(ResponseBody body) throws IOException {
        resStream(body.byteStream());
    }

    public abstract void resStream(InputStream resStream);
}
