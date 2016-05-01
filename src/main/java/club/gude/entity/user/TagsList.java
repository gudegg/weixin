package club.gude.entity.user;

import club.gude.entity.BaseRes;

import java.util.List;

/**
 * Created by Gude on 2016/5/1.
 */
public class TagsList extends BaseRes{
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
