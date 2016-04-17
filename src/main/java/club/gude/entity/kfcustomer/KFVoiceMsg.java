package club.gude.entity.kfcustomer;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * @Author Gude
 * @Date 2016/4/17.
 */
public class KFVoiceMsg extends KFBaseMsg {

    private static class SingletonHolder {
        private static final KFVoice KF_VOICE = new KFVoice();
    }

    @JSONField(name = "voice")
    public KFVoice getInstance() {
        return SingletonHolder.KF_VOICE;
    }

    private String media_id;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        getInstance().setMedia_id(media_id);
    }

    public static class KFVoice {

        private String media_id;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }
}
