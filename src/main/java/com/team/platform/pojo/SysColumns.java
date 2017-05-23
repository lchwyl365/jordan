package com.team.platform.pojo;

public class SysColumns extends SysColumnsKey {
    /**
     * 字段序号
     */
    private Short colno;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 字段类型
     */
    private String coltype;

    /**
     * 字段长度
     */
    private Short propertyLength;

    /**
     * 是否为空
     */
    private String nulls;

    /**
     * 属性名
     */
    private String propertyName;

    /**
     * 属性类型
     */
    private String propertyType;

    /**
     * 属性标题
     */
    private String propertyTitle;

    /**
     * 是否为主键
     */
    private String isprimary;

    /**
     * 精确查询
     */
    private String isselect;

    /**
     * 模糊查询
     */
    private String islike;

    /**
     * 表格中显示
     */
    private String isdisplay;

    /**
     * 添加时显示
     */
    private String isadd;

    /**
     * 修改时显示
     */
    private String isupdate;

    /**
     * 宽度
     */
    private Short width;

    /**
     * 允许排序
     */
    private String sortable;

    /**
     * easyui控件
     */
    private String component;

    /**
     * data-options
     */
    private String dataOptions;

    /**
     * 格式化
     */
    private String formatter;

    /**
     * 字典编号
     */
    private String comboid;

    /**
     * 字段序号
     * @return COLNO 字段序号
     */
    public Short getColno() {
        return colno;
    }

    /**
     * 字段序号
     * @param colno 字段序号
     */
    public void setColno(Short colno) {
        this.colno = colno;
    }

    /**
     * 备注
     * @return REMARKS 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 字段类型
     * @return COLTYPE 字段类型
     */
    public String getColtype() {
        return coltype;
    }

    /**
     * 字段类型
     * @param coltype 字段类型
     */
    public void setColtype(String coltype) {
        this.coltype = coltype == null ? null : coltype.trim();
    }

    /**
     * 字段长度
     * @return PROPERTY_LENGTH 字段长度
     */
    public Short getPropertyLength() {
        return propertyLength;
    }

    /**
     * 字段长度
     * @param propertyLength 字段长度
     */
    public void setPropertyLength(Short propertyLength) {
        this.propertyLength = propertyLength;
    }

    /**
     * 是否为空
     * @return NULLS 是否为空
     */
    public String getNulls() {
        return nulls;
    }

    /**
     * 是否为空
     * @param nulls 是否为空
     */
    public void setNulls(String nulls) {
        this.nulls = nulls == null ? null : nulls.trim();
    }

    /**
     * 属性名
     * @return PROPERTY_NAME 属性名
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * 属性名
     * @param propertyName 属性名
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName == null ? null : propertyName.trim();
    }

    /**
     * 属性类型
     * @return PROPERTY_TYPE 属性类型
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * 属性类型
     * @param propertyType 属性类型
     */
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType == null ? null : propertyType.trim();
    }

    /**
     * 属性标题
     * @return PROPERTY_TITLE 属性标题
     */
    public String getPropertyTitle() {
        return propertyTitle;
    }

    /**
     * 属性标题
     * @param propertyTitle 属性标题
     */
    public void setPropertyTitle(String propertyTitle) {
        this.propertyTitle = propertyTitle == null ? null : propertyTitle.trim();
    }

    /**
     * 是否为主键
     * @return ISPRIMARY 是否为主键
     */
    public String getIsprimary() {
        return isprimary;
    }

    /**
     * 是否为主键
     * @param isprimary 是否为主键
     */
    public void setIsprimary(String isprimary) {
        this.isprimary = isprimary == null ? null : isprimary.trim();
    }

    /**
     * 精确查询
     * @return ISSELECT 精确查询
     */
    public String getIsselect() {
        return isselect;
    }

    /**
     * 精确查询
     * @param isselect 精确查询
     */
    public void setIsselect(String isselect) {
        this.isselect = isselect == null ? null : isselect.trim();
    }

    /**
     * 模糊查询
     * @return ISLIKE 模糊查询
     */
    public String getIslike() {
        return islike;
    }

    /**
     * 模糊查询
     * @param islike 模糊查询
     */
    public void setIslike(String islike) {
        this.islike = islike == null ? null : islike.trim();
    }

    /**
     * 表格中显示
     * @return ISDISPLAY 表格中显示
     */
    public String getIsdisplay() {
        return isdisplay;
    }

    /**
     * 表格中显示
     * @param isdisplay 表格中显示
     */
    public void setIsdisplay(String isdisplay) {
        this.isdisplay = isdisplay == null ? null : isdisplay.trim();
    }

    /**
     * 添加时显示
     * @return ISADD 添加时显示
     */
    public String getIsadd() {
        return isadd;
    }

    /**
     * 添加时显示
     * @param isadd 添加时显示
     */
    public void setIsadd(String isadd) {
        this.isadd = isadd == null ? null : isadd.trim();
    }

    /**
     * 修改时显示
     * @return ISUPDATE 修改时显示
     */
    public String getIsupdate() {
        return isupdate;
    }

    /**
     * 修改时显示
     * @param isupdate 修改时显示
     */
    public void setIsupdate(String isupdate) {
        this.isupdate = isupdate == null ? null : isupdate.trim();
    }

    /**
     * 宽度
     * @return WIDTH 宽度
     */
    public Short getWidth() {
        return width;
    }

    /**
     * 宽度
     * @param width 宽度
     */
    public void setWidth(Short width) {
        this.width = width;
    }

    /**
     * 允许排序
     * @return SORTABLE 允许排序
     */
    public String getSortable() {
        return sortable;
    }

    /**
     * 允许排序
     * @param sortable 允许排序
     */
    public void setSortable(String sortable) {
        this.sortable = sortable == null ? null : sortable.trim();
    }

    /**
     * easyui控件
     * @return COMPONENT easyui控件
     */
    public String getComponent() {
        return component;
    }

    /**
     * easyui控件
     * @param component easyui控件
     */
    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    /**
     * data-options
     * @return DATA_OPTIONS data-options
     */
    public String getDataOptions() {
        return dataOptions;
    }

    /**
     * data-options
     * @param dataOptions data-options
     */
    public void setDataOptions(String dataOptions) {
        this.dataOptions = dataOptions == null ? null : dataOptions.trim();
    }

    /**
     * 格式化
     * @return FORMATTER 格式化
     */
    public String getFormatter() {
        return formatter;
    }

    /**
     * 格式化
     * @param formatter 格式化
     */
    public void setFormatter(String formatter) {
        this.formatter = formatter == null ? null : formatter.trim();
    }

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
}