package club.gude.entity.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author Gude.
 * @Date 2016/8/12.
 * 扫描带参数二维码事件
 */
@XmlRootElement(name = "xml")
public class QrsceneEvent extends BaseEvent{
    /**
     * 用户未关注:事件KEY值，qrscene_为前缀，后面为二维码的参数值
     * 用户已关注:事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    @XmlElement
    private String EventKey;
    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    @XmlElement
    private String Ticket;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }
}
