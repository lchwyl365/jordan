package com.team.platform.service;

import java.util.List;
import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.AuthRole;

/**
 * Created by Administrator on 2017/02/27
 */
public interface AuthRoleService {

	public EUDataGridResult selectList(EUDataGridModel dgm,AuthRole authRole);
	
	public AuthRole selectByPrimaryKey(String roleid);

	public ResponseResult insert(AuthRole authRole);

	public ResponseResult delete(List<String> roleids);

	public ResponseResult update(AuthRole authRole);

	public List<AuthRole> selectList();

	public int insertRole(AuthRole authRole);
	
}