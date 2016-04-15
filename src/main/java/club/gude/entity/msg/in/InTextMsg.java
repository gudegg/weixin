package club.gude.entity.msg.in;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author Gude
 * @Date 2016/4/5.
 */
@XmlRootElement(name = "xml")
public class InTextMsg extends InBaseMsg {
    //文本
    @XmlElement
    private String Content;


    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }


}
