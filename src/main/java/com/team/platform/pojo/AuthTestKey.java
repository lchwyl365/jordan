package com.team.platform.pojo;

public class AuthTestKey {
    /**
     * 测试编号3
     */
    private String testid;

    /**
     * 组编号
     */
    private String groupId;

    /**
     * 测试编号3
     * @return TESTID 测试编号3
     */
    public String getTestid() {
        return testid;
    }

    /**
     * 测试编号3
     * @param testid 测试编号3
     */
    public void setTestid(String testid) {
        this.testid = testid == null ? null : testid.trim();
    }

    /**
     * 组编号
     * @return GROUP_ID 组编号
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 组编号
     * @param groupId 组编号
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }
}