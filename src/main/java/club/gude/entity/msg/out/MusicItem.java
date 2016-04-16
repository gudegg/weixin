package club.gude.entity.msg.out;

import club.gude.utils.xml.AdapterStringCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @Author Gude
 * @Date 2016/4/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicItem {
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String Title;
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String Description;
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String MusicURL;
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String HQMusicUrl;
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
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
