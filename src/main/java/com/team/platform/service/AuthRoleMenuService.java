package com.team.platform.service;

import java.util.List;

import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.AuthRoleMenu;

/**
 * Created by Administrator on 2017/02/27
 */
public interface AuthRoleMenuService {
	
	public AuthRoleMenu selectByPrimaryKey(String roleMenuId);

	public ResponseResult insert(AuthRoleMenu authRoleMenu);

	public ResponseResult delete(List<String> roleMenuIds);

	public ResponseResult update(AuthRoleMenu authRoleMenu);

	public ResponseResult insertBatch(String roleid, List<String> menuids);

	public List<AuthRoleMenu> selectList(String roleid);

	public List<AuthRoleMenu> selectList();

	public int insertRoleMenu(AuthRoleMenu roleMenu);
	
}