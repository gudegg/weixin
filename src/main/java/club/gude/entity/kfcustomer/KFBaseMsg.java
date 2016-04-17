package club.gude.entity.kfcustomer;

/**
 * @Author Gude
 * @Date 2016/4/17.
 */
public class KFBaseMsg {
    private String touser;
    private String msgtype;
    private Customservice customservice;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Customservice getCustomservice() {
        return customservice;
    }

    public void setCustomservice(Customservice customservice) {
        this.customservice = customservice;
    }
}
