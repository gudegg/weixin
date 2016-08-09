package club.gude.entity.ip;

import club.gude.entity.BaseRes;

import java.util.List;

/**
 * @Author Gude.
 * @Date 2016/8/9.
 */
public class Ip extends BaseRes{
    private List<String> ip_list;

    public List<String> getIp_list() {
        return ip_list;
    }

    public void setIp_list(List<String> ip_list) {
        this.ip_list = ip_list;
    }
}
