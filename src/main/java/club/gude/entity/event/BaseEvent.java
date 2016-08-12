package club.gude.entity.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * @Author Gude.
 * @Date 2016/8/12.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class BaseEvent implements Serializable {
    private static final long serialVersionUID = -7595364937709524186L;
    //开发者微信(接收)
    @XmlElement
    private String ToUserName;
    //发送方帐号（一个OpenID）
    @XmlElement
    private String FromUserName;
    //消息创建时间
    @XmlElement
    private Integer CreateTime;
    //消息类型
    @XmlElement
    private String MsgType;
    //事件类型，subscribe(订阅)、unsubscribe(取消订阅)
    @XmlElement
    private String Event;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Integer getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Integer createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }
}
