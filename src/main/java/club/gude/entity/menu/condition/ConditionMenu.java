package club.gude.entity.menu.condition;

import club.gude.entity.menu.Menu;

/**
 * @Author Gude.
 * @Date 2016/8/10.
 * 个性化菜单
 */
public class ConditionMenu extends Menu{
    /**
     * 菜单匹配规则
     */
    private Matchrule matchrule;

    public Matchrule getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(Matchrule matchrule) {
        this.matchrule = matchrule;
    }
}
