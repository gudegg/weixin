package club.gude.entity.msg.out;

/**
 * @Author Gude
 * @Date 2016/4/8.
 */
public class OutVoiceMsg extends OutBaseMsg {
    private String MsgType = "voice";
    //通过素材管理接口上传多媒体文件，得到的id。
    private String MediaId;

    public String getMsgType() {
        return MsgType;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
