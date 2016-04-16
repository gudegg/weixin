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
public class OutMusicMsg extends OutBaseMsg {
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String MsgType = "music";
    @XmlElement(name = "Music")
    private MusicItem musicItem;

    public String getMsgType() {
        return MsgType;
    }
    public MusicItem getMusicItem() {
        return musicItem;
    }

    public void setMusicItem(MusicItem musicItem) {
        this.musicItem = musicItem;
    }
}
