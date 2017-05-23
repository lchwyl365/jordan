package com.team.platform.pojo;

public class SysComboBox {
    /**
     * �ֵ���
     */
    private String comboid;

    /**
     * �ֵ�����
     */
    private String name;

    /**
     * ��ѯ��
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
     * ��ѯ����(key:value)
     */
    private String whereCondition;

    /**
     * parentField
     */
    private String parentField;

    /**
     * ���ڵ�ֵ
     */
    private String rootValue;

    /**
     * �ֵ���
     * @return COMBOID �ֵ���
     */
    public String getComboid() {
        return comboid;
    }

    /**
     * �ֵ���
     * @param comboid �ֵ���
     */
    public void setComboid(String comboid) {
        this.comboid = comboid == null ? null : comboid.trim();
    }

    /**
     * �ֵ�����
     * @return NAME �ֵ�����
     */
    public String getName() {
        return name;
    }

    /**
     * �ֵ�����
     * @param name �ֵ�����
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * ��ѯ��
     * @return TABLE_NAME ��ѯ��
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * ��ѯ��
     * @param tableName ��ѯ��
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
     * ��ѯ����(key:value)
     * @return WHERE_CONDITION ��ѯ����(key:value)
     */
    public String getWhereCondition() {
        return whereCondition;
    }

    /**
     * ��ѯ����(key:value)
     * @param whereCondition ��ѯ����(key:value)
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
     * ���ڵ�ֵ
     * @return ROOT_VALUE ���ڵ�ֵ
     */
    public String getRootValue() {
        return rootValue;
    }

    /**
     * ���ڵ�ֵ
     * @param rootValue ���ڵ�ֵ
     */
    public void setRootValue(String rootValue) {
        this.rootValue = rootValue == null ? null : rootValue.trim();
    }
}