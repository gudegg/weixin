package club.gude.entity.user;

/**
 * Created by Gude on 2016/5/1.
 */
public class Groups extends Group{
    private int count;

    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "count=" + count +
                '}'+";"+super.toString();
    }
}
