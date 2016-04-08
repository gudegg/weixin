package club.gude.entity.msg.out;

import java.util.List;

/**
 * @Author Gude
 * @Date 2016/4/8.
 * <p>
 * <?xml version="1.0" encoding="utf-8"?>
 * <p>
 * <xml>
 * <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>12345678</CreateTime>
 * <MsgType><![CDATA[news]]></MsgType>
 * <ArticleCount>2</ArticleCount>
 * <Articles>
 * <item>
 * <Title><![CDATA[title1]]></Title>
 * <Description><![CDATA[description1]]></Description>
 * <PicUrl><![CDATA[picurl]]></PicUrl>
 * <Url><![CDATA[url]]></Url>
 * </item>
 * <item>
 * <Title><![CDATA[title]]></Title>
 * <Description><![CDATA[description]]></Description>
 * <PicUrl><![CDATA[picurl]]></PicUrl>
 * <Url><![CDATA[url]]></Url>
 * </item>
 * </Articles>
 * </xml>
 */
public class OutNewsMsg extends OutBaseMsg {
    private String MsgType = "news";
    private Integer ArticleCount;
    //多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
    private List<NewsItem> Articles;

    public String getMsgType() {
        return MsgType;
    }

    public Integer getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(Integer articleCount) {
        ArticleCount = articleCount;
    }

    public List<NewsItem> getArticles() {
        return Articles;
    }

    public void setArticles(List<NewsItem> articles) {
        Articles = articles;
    }
}
