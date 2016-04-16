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
public class OutVedioMsg extends OutBaseMsg {
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String MsgType = "vedio";
    @XmlElement(name = "Video")
    private VideoItem videoItem;

    public String getMsgType() {
        return MsgType;
    }


    public VideoItem getVideoItem() {
        return videoItem;
    }

    public void setVideoItem(VideoItem videoItem) {
        this.videoItem = videoItem;
    }
}
