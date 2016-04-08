package club.gude.entity.msg.out;

import java.io.Serializable;

/**
 * @Author Gude
 * @Date 2016/4/8.
 */
public class OutBaseMsg implements Serializable {
    private static final long serialVersionUID = 6194723611566771819L;
    //接收方帐号（收到的OpenID）
    private String ToUserName;
    //开发者微信号
    private String FromUserName;
    private Integer CreateTime = (int) System.currentTimeMillis()/1000;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public Integer getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Integer createTime) {
        CreateTime = createTime;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }
}
