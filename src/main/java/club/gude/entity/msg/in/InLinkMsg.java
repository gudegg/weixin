package club.gude.entity.msg.in;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author Gude
 * @Date 2016/4/5.
 */
@XmlRootElement(name = "xml")
public class InLinkMsg extends InBaseMsg {
    //消息标题
    @XmlElement
    private String Title;
    //消息描述
    @XmlElement
    private String Description;
    //消息链接
    @XmlElement
    private String Url;


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
