package club.gude.entity.user;

import club.gude.entity.BaseRes;

import java.util.Arrays;

/**
 * @Author Gude
 * @Date 2016/5/2.
 */
public class TagIdList extends BaseRes{
    String []tagid_list;

    public String[] getTagid_list() {
        return tagid_list;
    }

    public void setTagid_list(String[] tagid_list) {
        this.tagid_list = tagid_list;
    }

    @Override
    public String toString() {
        return "TagIdList{" +
                "tagid_list=" + Arrays.toString(tagid_list) +
                '}';
    }
}
