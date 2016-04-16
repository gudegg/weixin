package club.gude.entity.msg.out;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @Author Gude
 * @Date 2016/4/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsArticles {
    @XmlElement(name = "item")
    private  List<NewsItem> newsItems;

    public List<NewsItem> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }
}
