package club.gude.entity.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Gude.
 * @Date 2016/8/9.
 */
public class Menu {
    private List<Button> button = new ArrayList<Button>(3);

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        if (button.size() > 3) {
            throw new RuntimeException("自定义菜单最多包括3个一级菜单");
        }
        this.button = button;
    }

    public synchronized Menu add(Button btn) {
        button.add(btn);
        return this;
    }
}
