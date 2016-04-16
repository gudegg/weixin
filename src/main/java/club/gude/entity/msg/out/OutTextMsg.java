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
public class OutTextMsg extends OutBaseMsg {
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String MsgType = "text";
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
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
