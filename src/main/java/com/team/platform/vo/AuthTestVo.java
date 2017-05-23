package com.team.platform.vo;

import java.util.List;

import com.team.platform.pojo.AuthTest;

public class AuthTestVo extends AuthTest {

	List<AuthTestVo> children;

	public List<AuthTestVo> getChildren() {
		return children;
	}

	public void setChildren(List<AuthTestVo> children) {
		this.children = children;
	}
	
}