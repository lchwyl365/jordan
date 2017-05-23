package com.team.platform.pojo;

import java.util.Date;

public class SysTables extends SysTablesKey {
    /**
     * 表序号
     */
    private Short fid;

    /**
     * 主键列数量
     */
    private Short keycolumns;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否生成代码
     */
    private String generate;

    /**
     * 生成类型
     */
    private String gentype;

    /**
     * 生成代码时间
     */
    private Date gtime;

    /**
     * 访问路径
     */
    private String path;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 业务包名称
     */
    private String businessName;

    /**
     * 类名称
     */
    private String domainObjectName;

    /**
     * 类对象名称
     */
    private String variableName;

    /**
     * POJO包路径
     */
    private String pojoTargetPackage;

    /**
     * MAPPER包路径
     */
    private String mapperTargetPackage;

    /**
     * SERVICE包路径
     */
    private String serviceTargetPackage;

    /**
     * CONTROLLER包路径
     */
    private String controllerTargetPackage;

    /**
     * 是否可以添加
     */
    private String isadd;

    /**
     * 是否可以修改
     */
    private String isupdate;

    /**
     * 是否可以删除
     */
    private String isdelete;

    /**
     * 主键字段
     */
    private String idField;

    /**
     * 父类字段
     */
    private String parentField;

    /**
     * treefield
     */
    private String treeField;

    /**
     * 表序号
     * @return FID 表序号
     */
    public Short getFid() {
        return fid;
    }

    /**
     * 表序号
     * @param fid 表序号
     */
    public void setFid(Short fid) {
        this.fid = fid;
    }

    /**
     * 主键列数量
     * @return KEYCOLUMNS 主键列数量
     */
    public Short getKeycolumns() {
        return keycolumns;
    }

    /**
     * 主键列数量
     * @param keycolumns 主键列数量
     */
    public void setKeycolumns(Short keycolumns) {
        this.keycolumns = keycolumns;
    }

    /**
     * 创建时间
     * @return CTIME 创建时间
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 创建时间
     * @param ctime 创建时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
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
     * 是否生成代码
     * @return GENERATE 是否生成代码
     */
    public String getGenerate() {
        return generate;
    }

    /**
     * 是否生成代码
     * @param generate 是否生成代码
     */
    public void setGenerate(String generate) {
        this.generate = generate == null ? null : generate.trim();
    }

    /**
     * 生成类型
     * @return GENTYPE 生成类型
     */
    public String getGentype() {
        return gentype;
    }

    /**
     * 生成类型
     * @param gentype 生成类型
     */
    public void setGentype(String gentype) {
        this.gentype = gentype == null ? null : gentype.trim();
    }

    /**
     * 生成代码时间
     * @return GTIME 生成代码时间
     */
    public Date getGtime() {
        return gtime;
    }

    /**
     * 生成代码时间
     * @param gtime 生成代码时间
     */
    public void setGtime(Date gtime) {
        this.gtime = gtime;
    }

    /**
     * 访问路径
     * @return PATH 访问路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 访问路径
     * @param path 访问路径
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 菜单名称
     * @return MENU_NAME 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 菜单名称
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 业务包名称
     * @return BUSINESS_NAME 业务包名称
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * 业务包名称
     * @param businessName 业务包名称
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    /**
     * 类名称
     * @return DOMAIN_OBJECT_NAME 类名称
     */
    public String getDomainObjectName() {
        return domainObjectName;
    }

    /**
     * 类名称
     * @param domainObjectName 类名称
     */
    public void setDomainObjectName(String domainObjectName) {
        this.domainObjectName = domainObjectName == null ? null : domainObjectName.trim();
    }

    /**
     * 类对象名称
     * @return VARIABLE_NAME 类对象名称
     */
    public String getVariableName() {
        return variableName;
    }

    /**
     * 类对象名称
     * @param variableName 类对象名称
     */
    public void setVariableName(String variableName) {
        this.variableName = variableName == null ? null : variableName.trim();
    }

    /**
     * POJO包路径
     * @return POJO_TARGET_PACKAGE POJO包路径
     */
    public String getPojoTargetPackage() {
        return pojoTargetPackage;
    }

    /**
     * POJO包路径
     * @param pojoTargetPackage POJO包路径
     */
    public void setPojoTargetPackage(String pojoTargetPackage) {
        this.pojoTargetPackage = pojoTargetPackage == null ? null : pojoTargetPackage.trim();
    }

    /**
     * MAPPER包路径
     * @return MAPPER_TARGET_PACKAGE MAPPER包路径
     */
    public String getMapperTargetPackage() {
        return mapperTargetPackage;
    }

    /**
     * MAPPER包路径
     * @param mapperTargetPackage MAPPER包路径
     */
    public void setMapperTargetPackage(String mapperTargetPackage) {
        this.mapperTargetPackage = mapperTargetPackage == null ? null : mapperTargetPackage.trim();
    }

    /**
     * SERVICE包路径
     * @return SERVICE_TARGET_PACKAGE SERVICE包路径
     */
    public String getServiceTargetPackage() {
        return serviceTargetPackage;
    }

    /**
     * SERVICE包路径
     * @param serviceTargetPackage SERVICE包路径
     */
    public void setServiceTargetPackage(String serviceTargetPackage) {
        this.serviceTargetPackage = serviceTargetPackage == null ? null : serviceTargetPackage.trim();
    }

    /**
     * CONTROLLER包路径
     * @return CONTROLLER_TARGET_PACKAGE CONTROLLER包路径
     */
    public String getControllerTargetPackage() {
        return controllerTargetPackage;
    }

    /**
     * CONTROLLER包路径
     * @param controllerTargetPackage CONTROLLER包路径
     */
    public void setControllerTargetPackage(String controllerTargetPackage) {
        this.controllerTargetPackage = controllerTargetPackage == null ? null : controllerTargetPackage.trim();
    }

    /**
     * 是否可以添加
     * @return ISADD 是否可以添加
     */
    public String getIsadd() {
        return isadd;
    }

    /**
     * 是否可以添加
     * @param isadd 是否可以添加
     */
    public void setIsadd(String isadd) {
        this.isadd = isadd == null ? null : isadd.trim();
    }

    /**
     * 是否可以修改
     * @return ISUPDATE 是否可以修改
     */
    public String getIsupdate() {
        return isupdate;
    }

    /**
     * 是否可以修改
     * @param isupdate 是否可以修改
     */
    public void setIsupdate(String isupdate) {
        this.isupdate = isupdate == null ? null : isupdate.trim();
    }

    /**
     * 是否可以删除
     * @return ISDELETE 是否可以删除
     */
    public String getIsdelete() {
        return isdelete;
    }

    /**
     * 是否可以删除
     * @param isdelete 是否可以删除
     */
    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete == null ? null : isdelete.trim();
    }

    /**
     * 主键字段
     * @return ID_FIELD 主键字段
     */
    public String getIdField() {
        return idField;
    }

    /**
     * 主键字段
     * @param idField 主键字段
     */
    public void setIdField(String idField) {
        this.idField = idField == null ? null : idField.trim();
    }

    /**
     * 父类字段
     * @return PARENT_FIELD 父类字段
     */
    public String getParentField() {
        return parentField;
    }

    /**
     * 父类字段
     * @param parentField 父类字段
     */
    public void setParentField(String parentField) {
        this.parentField = parentField == null ? null : parentField.trim();
    }

    /**
     * treefield
     * @return TREE_FIELD treefield
     */
    public String getTreeField() {
        return treeField;
    }

    /**
     * treefield
     * @param treeField treefield
     */
    public void setTreeField(String treeField) {
        this.treeField = treeField == null ? null : treeField.trim();
    }
}