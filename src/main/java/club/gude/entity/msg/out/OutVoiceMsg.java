package club.gude.entity.msg.out;

import club.gude.utils.xml.AdapterStringCDATA;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @Author Gude
 * @Date 2016/4/8.
 */
@XmlRootElement(name = "xml")
public class OutVoiceMsg extends OutBaseMsg {
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String MsgType = "voice";
    @XmlElement(name = "Voice")
    private VoiceItem VoiceItem;

    public String getMsgType() {
        return MsgType;
    }

    public VoiceItem getVoiceItem() {
        return VoiceItem;
    }

    public void setVoiceItem(VoiceItem voiceItem) {
        VoiceItem = voiceItem;
    }
}
