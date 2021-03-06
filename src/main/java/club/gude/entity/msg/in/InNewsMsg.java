package club.gude.entity.msg.in;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author Gude
 * @Date 2016/4/5.
 * 图文
 * <p>
 * ArticleCount	是	图文消息个数，限制为10条以内
 * Articles	是	多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
 * Title	否	图文消息标题
 * Description	否	图文消息描述
 * PicUrl	否	图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
 * Url	否	点击图文消息跳转链接
 */
@XmlRootElement(name = "xml")
public class InNewsMsg extends InBaseMsg {
    @XmlElement
    private String ArticleCount;
    @XmlElement
    private String Articles;
    @XmlElement
    private String Title;
    @XmlElement
    private String Description;
    @XmlElement
    private String PicUrl;
    @XmlElement
    private String Url;






    public String getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(String articleCount) {
        ArticleCount = articleCount;
    }

    public String getArticles() {
        return Articles;
    }

    public void setArticles(String articles) {
        Articles = articles;
    }

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
