package club.gude.entity.kfcustomer;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * @Author Gude
 * @Date 2016/4/17.
 */
public class KFTextMsg extends KFBaseMsg {

    private static class SingletonHolder {
        private static final KFText KF_TEXT = new KFText();
    }

    @JSONField(name = "text")
    public   KFText getInstance() {
        return SingletonHolder.KF_TEXT;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        getInstance().setContent(content);
    }

    public static class KFText {

        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
