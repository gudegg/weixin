package club.gude.entity.msg.in;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author Gude
 * @Date 2016/4/5.
 */
@XmlRootElement(name = "xml")
public class InImageMsg extends InBaseMsg {
    //图片链接
    @XmlElement
    private String PicUrl;
    //	图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
    @XmlElement
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
