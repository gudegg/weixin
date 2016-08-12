package club.gude.entity.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author Gude.
 * @Date 2016/8/12.
 * 自定义菜单事件
 */
@XmlRootElement(name = "xml")
public class MenuEvent extends BaseEvent{
    /**
     * 点击菜单拉取消息时的事件推送:事件KEY值，与自定义菜单接口中KEY值对应
     * 点击菜单跳转链接时的事件推送:事件KEY值，设置的跳转URL
     */
    @XmlElement
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
