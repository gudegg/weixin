package club.gude.entity.msg.in;

import java.io.Serializable;

/**
 * @Author Gude
 * @Date 2016/4/5.
 */
public class InBaseMsg implements Serializable {

    private static final long serialVersionUID = 530650570515468050L;
    //开发者微信(接收)
    private String ToUserName;
    //发送方帐号（一个OpenID）
    private String FromUserName;
    //消息创建时间
    private Integer CreateTime;
    //消息类型 text voice image vedio shortvideo location link
    private String MsgType;
    private Long MsgId;

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }

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


}
