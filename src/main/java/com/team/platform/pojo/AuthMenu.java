package com.team.platform.pojo;

public class AuthMenu {
    /**
     * 菜单编号
     */
    private String menuid;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单位置
     */
    private String menuPos;

    /**
     * 链接地址
     */
    private String href;

    /**
     * 菜单图标
     */
    private String iconCls;

    /**
     * 是否显示
     */
    private String display;

    /**
     * 序号
     */
    private String orderNum;

    /**
     * 父菜单编号
     */
    private String pid;

    /**
     * null
     */
    private String levelType;

    /**
     * 菜单编号
     * @return MENUID 菜单编号
     */
    public String getMenuid() {
        return menuid;
    }

    /**
     * 菜单编号
     * @param menuid 菜单编号
     */
    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }

    /**
     * 菜单名称
     * @return NAME 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 菜单名称
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 菜单位置
     * @return MENU_POS 菜单位置
     */
    public String getMenuPos() {
        return menuPos;
    }

    /**
     * 菜单位置
     * @param menuPos 菜单位置
     */
    public void setMenuPos(String menuPos) {
        this.menuPos = menuPos == null ? null : menuPos.trim();
    }

    /**
     * 链接地址
     * @return HREF 链接地址
     */
    public String getHref() {
        return href;
    }

    /**
     * 链接地址
     * @param href 链接地址
     */
    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    /**
     * 菜单图标
     * @return ICON_CLS 菜单图标
     */
    public String getIconCls() {
        return iconCls;
    }

    /**
     * 菜单图标
     * @param iconCls 菜单图标
     */
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls == null ? null : iconCls.trim();
    }

    /**
     * 是否显示
     * @return DISPLAY 是否显示
     */
    public String getDisplay() {
        return display;
    }

    /**
     * 是否显示
     * @param display 是否显示
     */
    public void setDisplay(String display) {
        this.display = display == null ? null : display.trim();
    }

    /**
     * 序号
     * @return ORDER_NUM 序号
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 序号
     * @param orderNum 序号
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    /**
     * 父菜单编号
     * @return PID 父菜单编号
     */
    public String getPid() {
        return pid;
    }

    /**
     * 父菜单编号
     * @param pid 父菜单编号
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * null
     * @return LEVEL_TYPE null
     */
    public String getLevelType() {
        return levelType;
    }

    /**
     * null
     * @param levelType null
     */
    public void setLevelType(String levelType) {
        this.levelType = levelType == null ? null : levelType.trim();
    }
}