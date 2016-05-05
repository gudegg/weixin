package club.gude.entity.media;

import club.gude.entity.BaseRes;

/**
 * @Author Gude
 * @Date 2016/5/5.
 */
public class Media extends BaseRes{
    private String type;
    private String media_id;
    private String thumb_media_id;
    private int created_at;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Media{" +
                "type='" + type + '\'' +
                ", media_id='" + media_id + '\'' +
                ", thumb_media_id='" + thumb_media_id + '\'' +
                ", created_at=" + created_at +
                ", url='" + url + '\'' +
                '}'+";"+super.toString();
    }
}
