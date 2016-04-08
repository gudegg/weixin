package club.gude.entity.msg.out;

/**
 * @Author Gude
 * @Date 2016/4/8.
 */
public class OutMusicMsg extends OutBaseMsg{
    private String MsgType="music";
    private String Title;
    private String Description;
    private String MusicURL;
    private String HQMusicUrl;
    private String ThumbMediaId;
    public String getMsgType() {
        return MsgType;
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

    public String getMusicURL() {
        return MusicURL;
    }

    public void setMusicURL(String musicURL) {
        MusicURL = musicURL;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
