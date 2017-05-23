package com.team.common.util.gencode;

public class GeneratorProperty {

	private String columnName;
	private String propertyName;//PROPERTY_NAME
	private String propertyType; //PROPERTY_TYPE
	private String propertyTitle; //PROPERTY_TITLE
	private String isprimary; //ISPRIMARY
	private String isselect; //ISSELECT
	private String islike;//ISLIKE
	private String nulls; //NULLS
    private String isadd;
    private String isupdate;
    private String isdisplay;
	private Short propertyLength; //PROPERTY_LENGTH
    private Short width;
    private String component;
    private String sortable;
    private String formatter;
    private String dataOptions;
    private String comboid;
	
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getPropertyTitle() {
		return propertyTitle;
	}
	public void setPropertyTitle(String propertyTitle) {
		this.propertyTitle = propertyTitle;
	}
	public String getIsprimary() {
		return isprimary;
	}
	public void setIsprimary(String isprimary) {
		this.isprimary = isprimary;
	}
	public String getIsselect() {
		return isselect;
	}
	public void setIsselect(String isselect) {
		this.isselect = isselect;
	}
	public String getIslike() {
		return islike;
	}
	public void setIslike(String islike) {
		this.islike = islike;
	}
	public String getNulls() {
		return nulls;
	}
	public void setNulls(String nulls) {
		this.nulls = nulls;
	}
	public Short getPropertyLength() {
		return propertyLength;
	}
	public void setPropertyLength(Short propertyLength) {
		this.propertyLength = propertyLength;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getIsadd() {
		return isadd;
	}
	public void setIsadd(String isadd) {
		this.isadd = isadd;
	}
	public String getIsupdate() {
		return isupdate;
	}
	public void setIsupdate(String isupdate) {
		this.isupdate = isupdate;
	}
	public String getIsdisplay() {
		return isdisplay;
	}
	public void setIsdisplay(String isdisplay) {
		this.isdisplay = isdisplay;
	}
	public Short getWidth() {
		return width;
	}
	public void setWidth(Short width) {
		this.width = width;
	}
	public String getSortable() {
		return sortable;
	}
	public void setSortable(String sortable) {
		this.sortable = sortable;
	}
	public String getFormatter() {
		return formatter;
	}
	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}
	public String getDataOptions() {
		return dataOptions;
	}
	public void setDataOptions(String dataOptions) {
		this.dataOptions = dataOptions;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getComboid() {
		return comboid;
	}
	public void setComboid(String comboid) {
		this.comboid = comboid;
	}
	
}