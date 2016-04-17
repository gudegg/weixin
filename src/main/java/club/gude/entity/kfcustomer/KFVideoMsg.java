package club.gude.entity.kfcustomer;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * @Author Gude
 * @Date 2016/4/17.
 */
public class KFVideoMsg extends KFBaseMsg {

    private static class SingletonHolder {
        private static final KFVideo KF_VIDEO = new KFVideo();
    }

    @JSONField(name = "video")
    public KFVideo getInstance() {
        return SingletonHolder.KF_VIDEO;
    }

    private String media_id;
    private String thumb_media_id;
    private String title;
    private String description;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
       getInstance().setMedia_id(media_id);
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
       getInstance().setThumb_media_id(thumb_media_id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
       getInstance().setTitle(title);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
       getInstance().setDescription(description);
    }

    public static class KFVideo {

        private String media_id;
        private String thumb_media_id;
        private String title;
        private String description;

        public String getThumb_media_id() {
            return thumb_media_id;
        }

        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }
}
