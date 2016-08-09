package club.gude.entity;

/**
 * Created by Gude on 2016/5/1.
 */
public class BaseRes {
    private static final Integer SUCCESS_CODE = 0;
    private Integer errcode;
    private String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public boolean isSuccess() {
        return errcode == null || errcode == SUCCESS_CODE;
    }

    @Override
    public String toString() {
        return "BaseRes{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
