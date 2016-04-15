package club.gude.entity.msg.in;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author Gude
 * @Date 2016/4/5.
 * Title	否	音乐标题
 * Description	否	音乐描述
 * MusicURL	否	音乐链接
 * HQMusicUrl	否	高质量音乐链接，WIFI环境优先使用该链接播放音乐
 * ThumbMediaId	否	缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id
 */
@XmlRootElement(name = "xml")
public class InMusicMsg extends InBaseMsg {
    @XmlElement
    private String Title;
    @XmlElement
    private String Description;
    @XmlElement
    private String MusicURL;
    @XmlElement
    private String HQMusicUrl;
    @XmlElement
    private String ThumbMediaId;


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
