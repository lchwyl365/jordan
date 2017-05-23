package com.team.platform.pojo;

public class AuthUserRole {
    /**
     * null
     */
    private String userRoleId;

    /**
     * null
     */
    private String userId;

    /**
     * null
     */
    private String roleId;

    /**
     * null
     * @return USER_ROLE_ID null
     */
    public String getUserRoleId() {
        return userRoleId;
    }

    /**
     * null
     * @param userRoleId null
     */
    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId == null ? null : userRoleId.trim();
    }

    /**
     * null
     * @return USER_ID null
     */
    public String getUserId() {
        return userId;
    }

    /**
     * null
     * @param userId null
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
}