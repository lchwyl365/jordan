package com.team.${model.businessName}.vo;

import java.util.List;

import ${model.pojoTargetPackage}.${model.domainObjectName};

public class ${model.domainObjectName}Vo extends ${model.domainObjectName} {

	List<${model.domainObjectName}Vo> children;

	public List<${model.domainObjectName}Vo> getChildren() {
		return children;
	}

	public void setChildren(List<${model.domainObjectName}Vo> children) {
		this.children = children;
	}
	
}