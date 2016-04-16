package club.gude.entity.msg.out;

import club.gude.utils.xml.AdapterIntegerCDATA;
import club.gude.utils.xml.AdapterStringCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

/**
 * @Author Gude
 * @Date 2016/4/8.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class OutBaseMsg implements Serializable {
    private static final long serialVersionUID = 6194723611566771819L;
    //接收方帐号（收到的OpenID）
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String ToUserName;
    //开发者微信号
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String FromUserName;
    @XmlJavaTypeAdapter(AdapterIntegerCDATA.class)
    private Integer CreateTime = (int) (System.currentTimeMillis() / 1000);

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
