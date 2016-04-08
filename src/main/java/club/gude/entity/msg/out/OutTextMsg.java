package club.gude.entity.msg.out;

/**
 * @Author Gude
 * @Date 2016/4/8.
 */
public class OutTextMsg extends OutBaseMsg {
    private String MsgType = "text";
    private String Content;

    public String getMsgType() {
        return MsgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
