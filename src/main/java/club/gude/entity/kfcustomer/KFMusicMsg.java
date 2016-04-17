package club.gude.entity.kfcustomer;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * @Author Gude
 * @Date 2016/4/17.
 */
public class KFMusicMsg extends KFBaseMsg {

    private static class SingletonHolder {
        private static final KFMusic KF_MUSIC = new KFMusic();
    }

    @JSONField(name = "music")
    public KFMusic getInstance() {
        return SingletonHolder.KF_MUSIC;
    }

    private String hqmusicurl;
    private String musicurl;
    private String title;
    private String description;
    private String thumb_media_id;

    public String getHqmusicurl() {
        return hqmusicurl;
    }

    public void setHqmusicurl(String hqmusicurl) {
        getInstance().setHqmusicurl(hqmusicurl);
    }

    public String getMusicurl() {
        return musicurl;
    }

    public void setMusicurl(String musicurl) {
       getInstance().setMusicurl(musicurl);
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

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        getInstance().setThumb_media_id(thumb_media_id);
    }

    public static class KFMusic {

        private String hqmusicurl;
        private String musicurl;
        private String title;
        private String description;
        private String thumb_media_id;

        public String getHqmusicurl() {
            return hqmusicurl;
        }

        public void setHqmusicurl(String hqmusicurl) {
            this.hqmusicurl = hqmusicurl;
        }

        public String getMusicurl() {
            return musicurl;
        }

        public void setMusicurl(String musicurl) {
            this.musicurl = musicurl;
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

        public String getThumb_media_id() {
            return thumb_media_id;
        }

        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
        }
    }
}
