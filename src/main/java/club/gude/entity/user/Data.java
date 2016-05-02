package club.gude.entity.user;

import java.util.Arrays;

public class Data {
    private String []openid;

    public String[] getOpenid() {
        return openid;
    }

    public void setOpenid(String[] openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "Data{" +
                "openid=" + Arrays.toString(openid) +
                '}';
    }
}