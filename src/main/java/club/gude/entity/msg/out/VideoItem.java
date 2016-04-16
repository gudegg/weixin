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
public class VideoItem {
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String MediaId;
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String Title;
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String Description;

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
