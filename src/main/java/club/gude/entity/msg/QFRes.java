package club.gude.entity.msg;

import club.gude.entity.BaseRes;

/**
 * @Author Gude
 * @Date 2016/5/6.
 */
public class QFRes extends BaseRes{
    private int msg_id;
    private int msg_data_id;
    private String msg_status;

    public String getMsg_status() {
        return msg_status;
    }

    public void setMsg_status(String msg_status) {
        this.msg_status = msg_status;
    }

    public int getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(int msg_id) {
        this.msg_id = msg_id;
    }

    public int getMsg_data_id() {
        return msg_data_id;
    }

    public void setMsg_data_id(int msg_data_id) {
        this.msg_data_id = msg_data_id;
    }
}
