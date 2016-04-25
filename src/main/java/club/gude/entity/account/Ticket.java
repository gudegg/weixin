package club.gude.entity.account;

/**
 * @Author Gude
 * @Date 2016/4/25.
 */
public class Ticket {
    //获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
    private String ticket;
    private int expire_seconds;
    private String url;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(int expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
