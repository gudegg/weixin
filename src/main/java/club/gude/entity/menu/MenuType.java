package club.gude.entity.menu;

/**
 * @Author Gude.
 * @Date 2016/8/9.
 */
public enum MenuType {
    Click("click"),
    View("view"),
    Scancode_Push("scancode_push"),
    Scancode_Waitmsg("scancode_waitmsg"),
    Pic_Sysphoto("pic_sysphoto"),
    Pic_Photo_or_album("pic_photo_or_album"),
    Pic_Weixin("pic_weixin"),
    Location_Select("location_select"),
    Media_Id("media_id"),
    View_Limited("view_limited");


    private String type;

    MenuType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
