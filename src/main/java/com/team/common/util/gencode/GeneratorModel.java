package com.team.common.util.gencode;

import java.util.ArrayList;
import java.util.List;

public class GeneratorModel {

	private String tableName;
	private String menuName;
	private String domainObjectName; // DOMAIN_OBJECT_NAME
	private String path; // PATH
	private String businessName;
	private String variableName; // VARIABLE_NAME
	private String pojoTargetPackage;// POJO_TARGET_PACKAGE;
	private String mapperTargetPackage;// MAPPER_TARGET_PACKAGE;
	private String serviceTargetPackage;// SERVICE_TARGET_PACKAGE;
	private String controllerTargetPackage;// CONTROLLER_TARGET_PACKAGE;
	private List<GeneratorProperty> propertys;// 前台赋值属性
	
	private List<GeneratorProperty> addPropertys;// 需要添加的属性
	private List<GeneratorProperty> updatePropertys;// 需要修改的属性
	private List<GeneratorProperty> selectPropertys;// 需要查询的属性
	private List<GeneratorProperty> displayPropertys;// 需要在表格中显示的属性
	
	private String batchServiceParam;//Service 接口中定义 主键参数数组
	private String primaryKey;
	
	private String pathPrimaryKeyURL;// URL： /{主键参数} 的字符串
	
	private String pathVariable;//Controller 中 主键 @PathVariable 的参数
	private String callPathVariable;//Controller 中调用Service的传参
	
	private String requestParam;//Controller 中 主键 @RequestParam 的参数 参数为执行批量操作时的数组
	private String callRequestParam;//Controller 中调用Service的传参 数组
	
	private String idField; //第一个主键列
	
	private Short keycolumns;//主键列
	
    private String isadd;

    private String isupdate;

    private String isdelete;
    
    private String gentype;
    
    private String parentField;
    
    private String treeField;
    
    private Boolean useCombo;
    
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getDomainObjectName() {
		return domainObjectName;
	}

	public void setDomainObjectName(String domainObjectName) {
		this.domainObjectName = domainObjectName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getPojoTargetPackage() {
		return pojoTargetPackage;
	}

	public void setPojoTargetPackage(String pojoTargetPackage) {
		this.pojoTargetPackage = pojoTargetPackage;
	}

	public String getMapperTargetPackage() {
		return mapperTargetPackage;
	}

	public void setMapperTargetPackage(String mapperTargetPackage) {
		this.mapperTargetPackage = mapperTargetPackage;
	}

	public String getServiceTargetPackage() {
		return serviceTargetPackage;
	}

	public void setServiceTargetPackage(String serviceTargetPackage) {
		this.serviceTargetPackage = serviceTargetPackage;
	}

	public String getControllerTargetPackage() {
		return controllerTargetPackage;
	}

	public void setControllerTargetPackage(String controllerTargetPackage) {
		this.controllerTargetPackage = controllerTargetPackage;
	}

	public List<GeneratorProperty> getPropertys() {
		return propertys;
	}

	public void setPropertys(List<GeneratorProperty> propertys) {
		this.propertys = propertys;
	}

	public String getBatchServiceParam() {
		StringBuffer primaryKeyList = new StringBuffer();
		for (GeneratorProperty property : propertys) {
			if ("T".equals(property.getIsprimary())) {
				primaryKeyList.append("List<").append(property.getPropertyType()).append("> ")
						  .append(property.getPropertyName()).append("s,");
			}
		}
		int lastIndex = primaryKeyList.lastIndexOf(",");
		if (lastIndex != -1) {
			this.batchServiceParam = primaryKeyList.substring(0, lastIndex);
		} else {
			this.batchServiceParam = primaryKeyList.toString();
		}
		return batchServiceParam;
	}

	public void setBatchServiceParam(String batchServiceParam) {
		this.batchServiceParam = batchServiceParam;
	}

	public String getPrimaryKey() {
		StringBuffer primaryKey = new StringBuffer();
		for (GeneratorProperty property : propertys) {
			if ("T".equals(property.getIsprimary())) {
				primaryKey.append(property.getPropertyType()).append(" ")
						  .append(property.getPropertyName()).append(",");
			}
		}
		int lastIndex = primaryKey.lastIndexOf(",");
		if (lastIndex != -1) {
			this.primaryKey = primaryKey.substring(0, lastIndex);
		} else {
			this.primaryKey = primaryKey.toString();
		}
		return this.primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	

	public String getPathVariable() {
		StringBuffer primaryKey = new StringBuffer();
		for (GeneratorProperty property : propertys) {
			if ("T".equals(property.getIsprimary())) {
				primaryKey.append("@PathVariable ").append(property.getPropertyType()).append(" ")
						  .append(property.getPropertyName()).append(",");
			}
		}
		int lastIndex = primaryKey.lastIndexOf(",");
		if (lastIndex != -1) {
			this.pathVariable = primaryKey.substring(0, lastIndex);
		} else {
			this.pathVariable = primaryKey.toString();
		}
		return this.pathVariable;
	}

	public void setPathVariable(String pathVariable) {
		this.pathVariable = pathVariable;
	}

	public String getRequestParam() {
		
		StringBuffer primaryKey = new StringBuffer();
		for (GeneratorProperty property : propertys) {
			if ("T".equals(property.getIsprimary())) {
				primaryKey.append("@RequestParam List<").append(property.getPropertyType()).append("> ")
						  .append(property.getPropertyName()).append("s,");
			}
		}
		int lastIndex = primaryKey.lastIndexOf(",");
		if (lastIndex != -1) {
			this.requestParam = primaryKey.substring(0, lastIndex);
		} else {
			this.requestParam = primaryKey.toString();
		}
		return this.requestParam;
	}

	public void setRequestParam(String requestParam) {
		this.requestParam = requestParam;
	}

	public String getPathPrimaryKeyURL() {
		StringBuffer primaryKey = new StringBuffer();
		for (GeneratorProperty property : propertys) {
			if ("T".equals(property.getIsprimary())) {
				primaryKey.append("/{").append(property.getPropertyName()).append("}");
			}
		}
		this.pathPrimaryKeyURL = primaryKey.toString();
		return pathPrimaryKeyURL;
	}

	public void setPathPrimaryKeyURL(String pathPrimaryKeyURL) {
		this.pathPrimaryKeyURL = pathPrimaryKeyURL;
	}

	public String getCallPathVariable() {
		StringBuffer primaryKey = new StringBuffer();
		for (GeneratorProperty property : propertys) {
			if ("T".equals(property.getIsprimary())) {
				primaryKey.append(property.getPropertyName()).append(",");
			}
		}
		int lastIndex = primaryKey.lastIndexOf(",");
		if (lastIndex != -1) {
			this.callPathVariable = primaryKey.substring(0, lastIndex);
		} else {
			this.callPathVariable = primaryKey.toString();
		}
		return callPathVariable;
	}

	public void setCallPathVariable(String callPathVariable) {
		this.callPathVariable = callPathVariable;
	}

	public String getCallRequestParam() {
		StringBuffer primaryKey = new StringBuffer();
		for (GeneratorProperty property : propertys) {
			if ("T".equals(property.getIsprimary())) {
				primaryKey.append(property.getPropertyName()).append("s,");
			}
		}
		int lastIndex = primaryKey.lastIndexOf(",");
		if (lastIndex != -1) {
			this.callRequestParam = primaryKey.substring(0, lastIndex);
		} else {
			this.callRequestParam = primaryKey.toString();
		}
		return this.callRequestParam;
	}

	public void setCallRequestParam(String callRequestParam) {
		this.callRequestParam = callRequestParam;
	}

	public List<GeneratorProperty> getAddPropertys() {
		addPropertys = new ArrayList<GeneratorProperty>();
		for (GeneratorProperty property : propertys) {
			if("T".equals(property.getIsadd())){
				addPropertys.add(property);
			}
		}
		return addPropertys;
	}

	public void setAddPropertys(List<GeneratorProperty> addPropertys) {
		this.addPropertys = addPropertys;
	}

	public List<GeneratorProperty> getUpdatePropertys() {
		updatePropertys = new ArrayList<GeneratorProperty>();
		for (GeneratorProperty property : propertys) {
			if("T".equals(property.getIsupdate()) && "F".equals(property.getIsprimary())){
				updatePropertys.add(property);
			}
		}
		return updatePropertys;
	}

	public void setUpdatePropertys(List<GeneratorProperty> updatePropertys) {
		this.updatePropertys = updatePropertys;
	}

	public List<GeneratorProperty> getSelectPropertys() {
		selectPropertys = new ArrayList<GeneratorProperty>();
		for (GeneratorProperty property : propertys) {
			if("T".equals(property.getIsselect()) || "T".equals(property.getIslike())){
				selectPropertys.add(property);
			}
		}
		return selectPropertys;
	}

	public void setSelectPropertys(List<GeneratorProperty> selectPropertys) {
		this.selectPropertys = selectPropertys;
	}

	public Short getKeycolumns() {
		return keycolumns;
	}

	public void setKeycolumns(Short keycolumns) {
		this.keycolumns = keycolumns;
	}

	public String getIdField() {
		/*for (GeneratorProperty property : propertys) {
			if ("T".equals(property.getIsprimary())) {
				return property.getPropertyName();
			}
		}*/
		return idField;
	}

	public void setIdField(String idField) {
		this.idField = idField;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<GeneratorProperty> getDisplayPropertys() {
		displayPropertys = new ArrayList<GeneratorProperty>();
		for (GeneratorProperty property : propertys) {
			if("T".equals(property.getIsdisplay())){
				displayPropertys.add(property);
			}
		}
		return displayPropertys;
	}

	public void setDisplayPropertys(List<GeneratorProperty> displayPropertys) {
		this.displayPropertys = displayPropertys;
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

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public String getGentype() {
		return gentype;
	}

	public void setGentype(String gentype) {
		this.gentype = gentype;
	}

	public String getParentField() {
		return parentField;
	}

	public void setParentField(String parentField) {
		this.parentField = parentField;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getTreeField() {
		return treeField;
	}

	public void setTreeField(String treeField) {
		this.treeField = treeField;
	}

	public Boolean getUseCombo() {
		return useCombo;
	}

	public void setUseCombo(Boolean useCombo) {
		this.useCombo = useCombo;
	}
	
}