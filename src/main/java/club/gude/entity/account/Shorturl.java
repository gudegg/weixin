package club.gude.entity.account;

import club.gude.entity.BaseRes;

/**
 * @Author Gude
 * @Date 2016/4/25.
 */
public class Shorturl extends BaseRes{
    private String short_url;


    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    @Override
    public String toString() {
        return "Shorturl{" +
                "short_url='" + short_url + '\'' +
                '}'+";"+super.toString();
    }
}
