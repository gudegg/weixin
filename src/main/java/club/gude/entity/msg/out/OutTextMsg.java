package club.gude.entity.msg.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author Gude
 * @Date 2016/4/8.
 */
@XmlRootElement(name = "xml")
public class OutTextMsg extends OutBaseMsg {
    @XmlElement
    private String MsgType = "text";
    @XmlElement
    private String Content;

    public String getMsgType() {
        return MsgType;
    }

    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }
}
