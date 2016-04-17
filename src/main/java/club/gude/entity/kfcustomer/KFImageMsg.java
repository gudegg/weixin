package club.gude.entity.kfcustomer;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Author Gude
 * @Date 2016/4/17.
 */
public class KFImageMsg extends KFBaseMsg {
    private static class SingletonHolder {
        private static final KFImage KF_IMAGE = new KFImage();
    }
    @JSONField(name = "image")
    public KFImage getInstance() {
        return SingletonHolder.KF_IMAGE;
    }

    private String media_id;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        getInstance().setMedia_id(media_id);
    }

    private static class KFImage {
        private String media_id;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }
}
