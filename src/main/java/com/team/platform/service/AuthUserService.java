package com.team.platform.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.AuthUser;
import com.team.platform.pojo.AuthUserRole;

/**
 * Created by Administrator on 2015/9/21 0021.
 */
public interface AuthUserService {
	
	public EUDataGridResult selectList(EUDataGridModel dgm,AuthUser authUser);
	
	public AuthUser selectByPrimaryKey(String userid);

	public ResponseResult insert(AuthUser authUser);

	public ResponseResult delete(List<String> userids);

	public ResponseResult update(AuthUser authUser);
	
	public ResponseResult userLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response);

	public AuthUser getUserByToken(String token);

	public EUDataGridResult selectListByRole(EUDataGridModel dgm,AuthUser user, String roleid);

	public List<AuthUser> selectList();

	public int insertUser(AuthUser user);

}