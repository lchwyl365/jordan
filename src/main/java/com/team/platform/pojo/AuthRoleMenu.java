package com.team.platform.pojo;

public class AuthRoleMenu {
    /**
     * null
     */
    private String roleMenuId;

    /**
     * null
     */
    private String roleId;

    /**
     * null
     */
    private String menuId;

    /**
     * null
     * @return ROLE_MENU_ID null
     */
    public String getRoleMenuId() {
        return roleMenuId;
    }

    /**
     * null
     * @param roleMenuId null
     */
    public void setRoleMenuId(String roleMenuId) {
        this.roleMenuId = roleMenuId == null ? null : roleMenuId.trim();
    }

    /**
     * null
     * @return ROLE_ID null
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * null
     * @param roleId null
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * null
     * @return MENU_ID null
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * null
     * @param menuId null
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }
}