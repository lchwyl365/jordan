package com.team.platform.pojo;

public class SysTablesKey {
    /**
     * 表名
     */
    private String tableName;

    /**
     * SCHEMA
     */
    private String schemaName;

    /**
     * 类型
     */
    private String type;

    /**
     * 表名
     * @return TABLE_NAME 表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 表名
     * @param tableName 表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * SCHEMA
     * @return SCHEMA_NAME SCHEMA
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * SCHEMA
     * @param schemaName SCHEMA
     */
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName == null ? null : schemaName.trim();
    }

    /**
     * 类型
     * @return TYPE 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 类型
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}