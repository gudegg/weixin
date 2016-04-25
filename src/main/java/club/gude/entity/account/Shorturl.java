package club.gude.entity.account;

/**
 * @Author Gude
 * @Date 2016/4/25.
 */
public class Shorturl {
    private int errcode;
    private String errmsg;
    private String short_url;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    @Override
    public String toString() {
        return "Shorturl{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", short_url='" + short_url + '\'' +
                '}';
    }
}
