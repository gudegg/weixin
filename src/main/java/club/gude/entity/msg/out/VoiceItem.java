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
public class VoiceItem {
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String MediaId;

    public String getMedia_id() {
        return MediaId;
    }

    public void setMedia_id(String media_id) {
        this.MediaId = media_id;
    }
}
