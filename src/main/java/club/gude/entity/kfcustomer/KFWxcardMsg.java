package club.gude.entity.kfcustomer;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Author Gude
 * @Date 2016/4/17.
 * 发送卡券
 */
public class KFWxcardMsg extends KFBaseMsg {
    private static class SingletonHolder {
        private static final KFWxcard KF_WXCARD = new KFWxcard();
    }

    @JSONField(name = "wxcard")
    public KFWxcard getInstance() {
        return SingletonHolder.KF_WXCARD;
    }

    private String card_id;
    private String card_ext;

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        getInstance().setCard_id(card_id);
    }

    public String getCard_ext() {
        return card_ext;
    }

    public void setCard_ext(String card_ext) {
        getInstance().setCard_ext(card_ext);
    }

    private static class KFWxcard {
        private String card_id;
        private String card_ext;

        public String getCard_id() {
            return card_id;
        }

        public void setCard_id(String card_id) {
            this.card_id = card_id;
        }

        public String getCard_ext() {
            return card_ext;
        }

        public void setCard_ext(String card_ext) {
            this.card_ext = card_ext;
        }
    }
}
