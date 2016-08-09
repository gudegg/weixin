package club.gude.entity.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Gude.
 * @Date 2016/8/9.
 * 二级菜单
 */
public class SubButton {
    /**
     * 菜单的响应动作类型
     */
    private String type;
    /**
     * 菜单标题，不超过16个字节，子菜单不超过60个字节
     */
    private String name;
    /**
     * 菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;
    /**
     * 网页链接，用户点击菜单可打开链接，不超过1024字节
     */
    private String url;
    /**
     * 调用新增永久素材接口返回的合法media_id
     */
    private String media_id;
    /**
     * 二级菜单
     */
    private List<SubButton> sub_button=new ArrayList<SubButton>(5);


    public SubButton() {
    }

    public SubButton(String type, String name, String key, String url, String media_id, List<SubButton> sub_button) {
        this.type = type;
        this.name = name;
        this.key = key;
        this.url = url;
        this.media_id = media_id;
        this.sub_button = sub_button;
    }

    public SubButton(MenuType type, String name, String key, String url, String media_id, List<SubButton> sub_button) {
        this.type = type.getType();
        this.name = name;
        this.key = key;
        this.url = url;
        this.media_id = media_id;
        this.sub_button = sub_button;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setType(MenuType type) {
        this.type = type.getType();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public List<SubButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<SubButton> sub_button) {
        if (sub_button.size() > 5) {
            throw new RuntimeException("每个一级菜单最多包含5个二级菜单");
        }
        this.sub_button = sub_button;
    }

    public synchronized SubButton add(SubButton btn) {
        sub_button.add(btn);
        return this;
    }
}
