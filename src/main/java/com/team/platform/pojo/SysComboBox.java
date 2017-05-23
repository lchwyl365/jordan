package com.team.platform.pojo;

public class SysComboBox {
    /**
     * 字典编号
     */
    private String comboid;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 查询表
     */
    private String tableName;

    /**
     * valueField
     */
    private String valueField;

    /**
     * textField
     */
    private String textField;

    /**
     * 查询条件(key:value)
     */
    private String whereCondition;

    /**
     * parentField
     */
    private String parentField;

    /**
     * 根节点值
     */
    private String rootValue;

    /**
     * 字典编号
     * @return COMBOID 字典编号
     */
    public String getComboid() {
        return comboid;
    }

    /**
     * 字典编号
     * @param comboid 字典编号
     */
    public void setComboid(String comboid) {
        this.comboid = comboid == null ? null : comboid.trim();
    }

    /**
     * 字典名称
     * @return NAME 字典名称
     */
    public String getName() {
        return name;
    }

    /**
     * 字典名称
     * @param name 字典名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 查询表
     * @return TABLE_NAME 查询表
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 查询表
     * @param tableName 查询表
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * valueField
     * @return VALUE_FIELD valueField
     */
    public String getValueField() {
        return valueField;
    }

    /**
     * valueField
     * @param valueField valueField
     */
    public void setValueField(String valueField) {
        this.valueField = valueField == null ? null : valueField.trim();
    }

    /**
     * textField
     * @return TEXT_FIELD textField
     */
    public String getTextField() {
        return textField;
    }

    /**
     * textField
     * @param textField textField
     */
    public void setTextField(String textField) {
        this.textField = textField == null ? null : textField.trim();
    }

    /**
     * 查询条件(key:value)
     * @return WHERE_CONDITION 查询条件(key:value)
     */
    public String getWhereCondition() {
        return whereCondition;
    }

    /**
     * 查询条件(key:value)
     * @param whereCondition 查询条件(key:value)
     */
    public void setWhereCondition(String whereCondition) {
        this.whereCondition = whereCondition == null ? null : whereCondition.trim();
    }

    /**
     * parentField
     * @return PARENT_FIELD parentField
     */
    public String getParentField() {
        return parentField;
    }

    /**
     * parentField
     * @param parentField parentField
     */
    public void setParentField(String parentField) {
        this.parentField = parentField == null ? null : parentField.trim();
    }

    /**
     * 根节点值
     * @return ROOT_VALUE 根节点值
     */
    public String getRootValue() {
        return rootValue;
    }

    /**
     * 根节点值
     * @param rootValue 根节点值
     */
    public void setRootValue(String rootValue) {
        this.rootValue = rootValue == null ? null : rootValue.trim();
    }
}