package com.team.platform.service;

import java.util.List;

import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.AuthUserRole;

/**
 * Created by Administrator on 2017/02/27
 */
public interface AuthUserRoleService {

	
	public AuthUserRole selectByPrimaryKey(String userRoleId);

	public ResponseResult insert(AuthUserRole authUserRole);

	public ResponseResult delete(List<String> userRoleIds);

	public ResponseResult update(AuthUserRole authUserRole);

	public ResponseResult insert(String roleid,String[] userids);

	public ResponseResult deleteRole(String roleid, String[] userids);

	public List<AuthUserRole> selectList();

	public int insertUserRole(AuthUserRole userRole);
	
}