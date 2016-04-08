package club.gude.entity.msg.out;

/**
 * @Author Gude
 * @Date 2016/4/8.
 */
public class OutVedioMsg extends OutBaseMsg {
    private String MsgType = "vedio";
    private String MediaId;
    private String Title;
    private String Description;

    public String getMsgType() {
        return MsgType;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
