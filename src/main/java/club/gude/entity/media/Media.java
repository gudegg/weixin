package club.gude.entity.media;

import club.gude.entity.BaseRes;

/**
 * @Author Gude
 * @Date 2016/5/5.
 */
public class Media extends BaseRes{
    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     */
    private String type;
    /**
     * 媒体文件上传后，获取时的唯一标识
     */
    private String media_id;
    private String thumb_media_id;
    /**
     * 媒体文件上传时间戳
     */
    private int created_at;
    /**
     * 新增的图片素材的图片URL（仅新增图片素材时会返回该字段）
     */
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
