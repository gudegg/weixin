package club.gude.api.token;

import club.gude.config.WechatConfig;
import club.gude.entity.token.Token;
import club.gude.utils.http.OkHttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.ResponseBody;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author Gude
 * @Date 2016/4/6.
 */
public class TokenTask {
    private static final ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
    private static ScheduledFuture<?> scheduledFuture;
    private final static String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + WechatConfig.Appid + "&secret=" + WechatConfig.AppSecret;

    public static synchronized void createTask(long expired_time) {
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        scheduledFuture = service.scheduleWithFixedDelay(new tokenRunnable(), 0, expired_time, TimeUnit.SECONDS);
    }

    public static class tokenRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Token token = freshToken();
                TokenApi.getInstance().setToken(token);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static Token freshToken() throws IOException {
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        JSONObject jsonObject = JSON.parseObject(responseBody.string());
        Token token = new Token(jsonObject.getString("access_token"), jsonObject.getLong("expires_in"));
        return token;
    }
}
