package com.team.platform.pojo;

public class AuthRole {
    /**
     * 角色编号
     */
    private String roleid;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色类型
     */
    private String type;

    /**
     * 角色编号
     * @return ROLEID 角色编号
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * 角色编号
     * @param roleid 角色编号
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    /**
     * 角色名称
     * @return NAME 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 角色类型
     * @return TYPE 角色类型
     */
    public String getType() {
        return type;
    }

    /**
     * 角色类型
     * @param type 角色类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}