package club.gude.entity.msg.in;

/**
 * @Author Gude
 * @Date 2016/4/5.
 */
public class InImageMsg extends InBaseMsg {
    //图片链接
    private String PicUrl;
    //	图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;


    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
