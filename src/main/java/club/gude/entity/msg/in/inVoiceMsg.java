package club.gude.entity.msg.in;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author Gude
 * @Date 2016/4/5.
 */
@XmlRootElement(name = "xml")
public class InVoiceMsg extends InBaseMsg {
    //语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    @XmlElement
    private String MediaId;
    //语音格式，如amr，speex等
    @XmlElement
    private String Format;
    @XmlElement
    private String Recognition;

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
