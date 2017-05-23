package com.team.platform.pojo;

public class Columns {
    /**
     * null
     */
    private String columnName;

    /**
     * null
     */
    private String tableName;

    /**
     * null
     */
    private String tableSchema;

    /**
     * null
     */
    private String columnComment;

    /**
     * null
     */
    private String dataType;

    /**
     * null
     */
    private String isNullable;

    /**
     * null
     */
    private Short length;

    /**
     * null
     */
    private Short colno;

    /**
     * null
     * @return NAME null
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * null
     * @param columnName null
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * null
     * @return TBNAME null
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * null
     * @param tableName null
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * null
     * @return TBCREATOR null
     */
    public String getTableSchema() {
        return tableSchema;
    }

    /**
     * null
     * @param tableSchema null
     */
    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema == null ? null : tableSchema.trim();
    }

    /**
     * null
     * @return REMARKS null
     */
    public String getColumnComment() {
        return columnComment;
    }

    /**
     * null
     * @param columnComment null
     */
    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment == null ? null : columnComment.trim();
    }

    /**
     * null
     * @return COLTYPE null
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * null
     * @param dataType null
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /**
     * null
     * @return NULLS null
     */
    public String getIsNullable() {
        return isNullable;
    }

    /**
     * null
     * @param isNullable null
     */
    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable == null ? null : isNullable.trim();
    }

    /**
     * null
     * @return LENGTH null
     */
    public Short getLength() {
        return length;
    }

    /**
     * null
     * @param length null
     */
    public void setLength(Short length) {
        this.length = length;
    }

    /**
     * null
     * @return COLNO null
     */
    public Short getColno() {
        return colno;
    }

    /**
     * null
     * @param colno null
     */
    public void setColno(Short colno) {
        this.colno = colno;
    }
}