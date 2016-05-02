package club.gude.entity.user;

import club.gude.entity.BaseRes;

import java.util.List;

/**
 * @Author Gude
 * @Date 2016/5/2.
 */
public class Fans extends BaseRes {
    private int count;
    private Data data;
    private String next_openid;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    @Override
    public String toString() {
        return "Fans{" +
                "count=" + count +
                ", data=" + data +
                ", next_openid='" + next_openid + '\'' +
                '}';
    }
}




