package club.gude.entity.msg;

import java.io.Serializable;

/**
 * @Author Gude
 * @Date 2016/4/5.
 */
public class BaseMsg implements Serializable{

    private static final long serialVersionUID = 530650570515468050L;
    //开发者微信(接收)  发送方账号(回复)
    private String ToUserName;
    //发送方帐号（一个OpenID）(接收)  开发者(回复)
    private String FromUserName;
    //消息创建时间
    private  long CreateTime;
    //消息类型 text voice image vedio shortvideo location link
    private String MsgType;
    //消息id，64位整型
    private String MsgId;

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

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
