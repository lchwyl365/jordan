package com.team.platform.pojo;

import java.util.Date;

public class Tables {
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
    private String tableType;

    /**
     * null
     */
    private Date createTime;

    /**
     * null
     */
    private String tableComment;

    /**
     * null
     */
    private Short fid;

    /**
     * null
     */
    private Short keycolumns;

    /**
     * null
     * @return NAME null
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
     * @return CREATOR null
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
     * @return TYPE null
     */
    public String getTableType() {
        return tableType;
    }

    /**
     * null
     * @param tableType null
     */
    public void setTableType(String tableType) {
        this.tableType = tableType == null ? null : tableType.trim();
    }

    /**
     * null
     * @return CTIME null
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * null
     * @param createTime null
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * null
     * @return REMARKS null
     */
    public String getTableComment() {
        return tableComment;
    }

    /**
     * null
     * @param tableComment null
     */
    public void setTableComment(String tableComment) {
        this.tableComment = tableComment == null ? null : tableComment.trim();
    }

    /**
     * null
     * @return FID null
     */
    public Short getFid() {
        return fid;
    }

    /**
     * null
     * @param fid null
     */
    public void setFid(Short fid) {
        this.fid = fid;
    }

    /**
     * null
     * @return KEYCOLUMNS null
     */
    public Short getKeycolumns() {
        return keycolumns;
    }

    /**
     * null
     * @param keycolumns null
     */
    public void setKeycolumns(Short keycolumns) {
        this.keycolumns = keycolumns;
    }
}