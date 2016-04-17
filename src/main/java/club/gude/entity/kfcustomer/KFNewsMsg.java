package club.gude.entity.kfcustomer;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Author Gude
 * @Date 2016/4/17.
 * 发送图文消息（点击跳转到图文消息页面）
 */
public class KFNewsMsg extends KFBaseMsg {
    private static class SingletonHolder {
        private static final KFNews KF_NEWS = new KFNews();
    }

    @JSONField(name = "mpnews")
    public KFNews getInstance() {
        return SingletonHolder.KF_NEWS;
    }

    private String media_id;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
       getInstance().setMedia_id(media_id);
    }

    private static class KFNews {
        private String media_id;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }
}
