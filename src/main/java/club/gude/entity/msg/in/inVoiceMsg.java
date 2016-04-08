package club.gude.entity.msg.in;

/**
 * @Author Gude
 * @Date 2016/4/5.
 */
public class InVoiceMsg extends InBaseMsg {
    //	语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;
    //语音格式，如amr，speex等
    private String Format;
    private String Recongnition;

    public String getRecongnition() {
        return Recongnition;
    }

    public void setRecongnition(String recongnition) {
        Recongnition = recongnition;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
