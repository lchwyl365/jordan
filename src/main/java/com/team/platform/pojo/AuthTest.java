package com.team.platform.pojo;

public class AuthTest extends AuthTestKey {
    /**
     * 测试名称
     */
    private String testname;

    /**
     * 测试名称
     * @return TESTNAME 测试名称
     */
    public String getTestname() {
        return testname;
    }

    /**
     * 测试名称
     * @param testname 测试名称
     */
    public void setTestname(String testname) {
        this.testname = testname == null ? null : testname.trim();
    }
}