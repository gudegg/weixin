package club.gude.entity.datacube;

import club.gude.entity.BaseRes;

/**
 * Created by Gude on 2016/4/29.
 */
public class UserCumulate extends BaseRes{
    private String ref_date;
    private int cumulate_user;

    public String getRef_date() {
        return ref_date;
    }

    public void setRef_date(String ref_date) {
        this.ref_date = ref_date;
    }

    public int getCumulate_user() {
        return cumulate_user;
    }

    public void setCumulate_user(int cumulate_user) {
        this.cumulate_user = cumulate_user;
    }

    @Override
    public String toString() {
        return "UserCumulate{" +
                "ref_date='" + ref_date + '\'' +
                ", cumulate_user=" + cumulate_user +
                '}'+";"+super.toString();
    }
}
