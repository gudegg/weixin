package club.gude.api.token;

/**
 * @Author Gude
 * @Date 2016/4/6.
 */
public class TokenApi {
    //
    private long expired_time = 7000;

    private  String token;

    TokenApi() {

    }
    private TokenApi(Builder builder) {
        this.expired_time = builder.expired_time;
    }

    /**
     * 刷新token
     */
    private  void freshAccessToken(){



    }

    public String getToken() {

        return token;
    }

    public static class Builder {
        private long expired_time= 7000 ;

        /**
         *
         * @param expired_time 自定义token过期时间 默认为7000s  单位:s  即定时器刷新时间
         * @return
         */
        public Builder expiredTime(long expired_time) {
            this.expired_time = expired_time;
            return this;
        }

        public TokenApi build() {
            return new TokenApi(this);
        }

    }

}
