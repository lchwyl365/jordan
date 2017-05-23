package com.team.platform.pojo;

public class SysColumnsKey {
    /**
     * 字段名称
     */
    private String columnName;

    /**
     * 表名称
     */
    private String tbname;

    /**
     * 创建用户
     */
    private String tbcreator;

    /**
     * 字段名称
     * @return COLUMN_NAME 字段名称
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 字段名称
     * @param columnName 字段名称
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * 表名称
     * @return TBNAME 表名称
     */
    public String getTbname() {
        return tbname;
    }

    /**
     * 表名称
     * @param tbname 表名称
     */
    public void setTbname(String tbname) {
        this.tbname = tbname == null ? null : tbname.trim();
    }

    /**
     * 创建用户
     * @return TBCREATOR 创建用户
     */
    public String getTbcreator() {
        return tbcreator;
    }

    /**
     * 创建用户
     * @param tbcreator 创建用户
     */
    public void setTbcreator(String tbcreator) {
        this.tbcreator = tbcreator == null ? null : tbcreator.trim();
    }
}