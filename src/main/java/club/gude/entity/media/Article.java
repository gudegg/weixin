package club.gude.entity.media;

/**
 * @Author Gude
 * @Date 2016/4/15.
 * title	是	标题
 * thumb_media_id	是	图文消息的封面图片素材id（必须是永久mediaID）
 * author	是	作者
 * digest	是	图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
 * show_cover_pic	是	是否显示封面，0为false，即不显示，1为true，即显示
 * content	是	图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
 * content_source_url	是	图文消息的原文地址，即点击“阅读原文”后的URL
 */
public class Article {

    private String title;
    private String thumb_media_id;
    private String author;
    private String digest;
    private String show_cover_pic;
    private String content;
    private String content_source_url;

    public Article() {
    }

    public Article(String title, String thumb_media_id, String author, String digest, String show_cover_pic, String content, String content_source_url) {
        this.title = title;
        this.thumb_media_id = thumb_media_id;
        this.author = author;
        this.digest = digest;
        this.show_cover_pic = show_cover_pic;
        this.content = content;
        this.content_source_url = content_source_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getShow_cover_pic() {
        return show_cover_pic;
    }

    public void setShow_cover_pic(String show_cover_pic) {
        this.show_cover_pic = show_cover_pic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_source_url() {
        return content_source_url;
    }

    public void setContent_source_url(String content_source_url) {
        this.content_source_url = content_source_url;
    }
}
