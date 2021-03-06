package club.gude.entity.msg.out;

import club.gude.utils.xml.AdapterStringCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @Author Gude
 * @Date 2016/4/8.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsItem {
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String Title;
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String Description;
    //图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String PicUrl;
    //点击图文消息跳转链接
    @XmlJavaTypeAdapter(AdapterStringCDATA.class)
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
