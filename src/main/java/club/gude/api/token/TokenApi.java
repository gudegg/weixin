package club.gude.api.token;

import club.gude.entity.token.Token;

import java.io.IOException;

/**
 * @Author Gude
 * @Date 2016/4/6.
 */
public class TokenApi {
    private long expired_time = 7000;
    private Token token=null;

    private static TokenApi tokenApi = new TokenApi();

    public static TokenApi getInstance() {
        return tokenApi;
    }

    private TokenApi() {

    }

    public synchronized Token getToken() throws IOException {
        if (token == null) {
            setToken(TokenTask.freshToken());
            TokenTask.createTask(expired_time);

        }
        return token;
    }

    public synchronized void setToken(Token token) {
        this.token = token;
    }

    /**
     *  会重新创建定时器
     *
     * @param expired_time 自定义定时器间隔时间
     */
    public void setExpired_time(long expired_time) {
        this.expired_time = expired_time;
        if (token != null) {
            TokenTask.createTask(expired_time);
        }
    }
}
