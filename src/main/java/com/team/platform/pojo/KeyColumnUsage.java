package com.team.platform.pojo;

public class KeyColumnUsage {
    /**
     * 
     */
    private String constraintCatalog;

    /**
     * 
     */
    private String constraintSchema;

    /**
     * 
     */
    private String constraintName;

    /**
     * 
     */
    private String tableCatalog;

    /**
     * 
     */
    private String tableSchema;

    /**
     * 
     */
    private String tableName;

    /**
     * 
     */
    private String columnName;

    /**
     * 
     */
    private Long ordinalPosition;

    /**
     * 
     */
    private Long positionInUniqueConstraint;

    /**
     * 
     */
    private String referencedTableSchema;

    /**
     * 
     */
    private String referencedTableName;

    /**
     * 
     */
    private String referencedColumnName;

    /**
     * 
     * @return CONSTRAINT_CATALOG 
     */
    public String getConstraintCatalog() {
        return constraintCatalog;
    }

    /**
     * 
     * @param constraintCatalog 
     */
    public void setConstraintCatalog(String constraintCatalog) {
        this.constraintCatalog = constraintCatalog == null ? null : constraintCatalog.trim();
    }

    /**
     * 
     * @return CONSTRAINT_SCHEMA 
     */
    public String getConstraintSchema() {
        return constraintSchema;
    }

    /**
     * 
     * @param constraintSchema 
     */
    public void setConstraintSchema(String constraintSchema) {
        this.constraintSchema = constraintSchema == null ? null : constraintSchema.trim();
    }

    /**
     * 
     * @return CONSTRAINT_NAME 
     */
    public String getConstraintName() {
        return constraintName;
    }

    /**
     * 
     * @param constraintName 
     */
    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName == null ? null : constraintName.trim();
    }

    /**
     * 
     * @return TABLE_CATALOG 
     */
    public String getTableCatalog() {
        return tableCatalog;
    }

    /**
     * 
     * @param tableCatalog 
     */
    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog == null ? null : tableCatalog.trim();
    }

    /**
     * 
     * @return TABLE_SCHEMA 
     */
    public String getTableSchema() {
        return tableSchema;
    }

    /**
     * 
     * @param tableSchema 
     */
    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema == null ? null : tableSchema.trim();
    }

    /**
     * 
     * @return TABLE_NAME 
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 
     * @param tableName 
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * 
     * @return COLUMN_NAME 
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 
     * @param columnName 
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * 
     * @return ORDINAL_POSITION 
     */
    public Long getOrdinalPosition() {
        return ordinalPosition;
    }

    /**
     * 
     * @param ordinalPosition 
     */
    public void setOrdinalPosition(Long ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    /**
     * 
     * @return POSITION_IN_UNIQUE_CONSTRAINT 
     */
    public Long getPositionInUniqueConstraint() {
        return positionInUniqueConstraint;
    }

    /**
     * 
     * @param positionInUniqueConstraint 
     */
    public void setPositionInUniqueConstraint(Long positionInUniqueConstraint) {
        this.positionInUniqueConstraint = positionInUniqueConstraint;
    }

    /**
     * 
     * @return REFERENCED_TABLE_SCHEMA 
     */
    public String getReferencedTableSchema() {
        return referencedTableSchema;
    }

    /**
     * 
     * @param referencedTableSchema 
     */
    public void setReferencedTableSchema(String referencedTableSchema) {
        this.referencedTableSchema = referencedTableSchema == null ? null : referencedTableSchema.trim();
    }

    /**
     * 
     * @return REFERENCED_TABLE_NAME 
     */
    public String getReferencedTableName() {
        return referencedTableName;
    }

    /**
     * 
     * @param referencedTableName 
     */
    public void setReferencedTableName(String referencedTableName) {
        this.referencedTableName = referencedTableName == null ? null : referencedTableName.trim();
    }

    /**
     * 
     * @return REFERENCED_COLUMN_NAME 
     */
    public String getReferencedColumnName() {
        return referencedColumnName;
    }

    /**
     * 
     * @param referencedColumnName 
     */
    public void setReferencedColumnName(String referencedColumnName) {
        this.referencedColumnName = referencedColumnName == null ? null : referencedColumnName.trim();
    }
}