package com.team.platform.vo;

import java.util.List;

import com.team.platform.pojo.AuthMenu;

public class AuthMenuVo extends AuthMenu {

	public static final String LEVEL_TYPE_SYSTEM = "system";
	public static final String LEVEL_TYPE_APPLICATION = "application";
	
	List<AuthMenuVo> children;

	public List<AuthMenuVo> getChildren() {
		return children;
	}

	public void setChildren(List<AuthMenuVo> children) {
		this.children = children;
	}
	
}