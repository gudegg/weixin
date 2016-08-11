package club.gude.entity.msg;

/**
 * @Author Gude.
 * @Date 2016/8/11.
 */
public class ReceiveParam {
    /**
     * 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     */
    private String signature;
    /**
     * 时间戳
     */
    private String timestamp;
    /**
     * 随机串
     */
    private String nonce;
    /**
     * 加密后的微信号，每个用户对每个公众号的OpenID是唯一的
     */
    private String openid;
    /**
     * 加密方式 aes
     */
    private String encrypt_type;
    /**
     * 签名串
     */
    private String msg_signature;
    /**
     * 随机字符串
     */
    private String echostr;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getEncrypt_type() {
        return encrypt_type;
    }

    public void setEncrypt_type(String encrypt_type) {
        this.encrypt_type = encrypt_type;
    }

    public String getMsg_signature() {
        return msg_signature;
    }

    public void setMsg_signature(String msg_signature) {
        this.msg_signature = msg_signature;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
}
