package club.gude.entity.kfcustomer;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @Author Gude
 * @Date 2016/4/17.
 * 发送图文消息（点击跳转到外链）
 */
public class KFNewsJumpMsg extends KFBaseMsg {
    private static class SingletonHolder {
        private static final KFNews KF_NEWS = new KFNews();
    }

    @JSONField(name = "news")
    public KFNews getInstance() {
        return SingletonHolder.KF_NEWS;
    }

    private List<KFNewsArticle> articles;

    public List<KFNewsArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<KFNewsArticle> articles) {
        getInstance().setArticles(articles);
    }

    private static class KFNews {

        private List<KFNewsArticle> articles;

        public List<KFNewsArticle> getArticles() {
            return articles;
        }

        public void setArticles(List<KFNewsArticle> articles) {
            this.articles = articles;
        }
    }



}
