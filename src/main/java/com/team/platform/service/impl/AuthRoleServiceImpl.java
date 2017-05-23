package com.team.platform.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.ResponseResult;
import com.team.common.util.PrimaryKeyFactory;
import com.team.platform.mapper.AuthRoleMapper;
import com.team.platform.pojo.AuthRole;
import com.team.platform.pojo.AuthRoleExample;
import com.team.platform.pojo.AuthUser;
import com.team.platform.pojo.AuthUserExample;
import com.team.platform.pojo.AuthRoleExample.Criteria;
import com.team.platform.service.AuthRoleService;

/**
 * Created by liuchao on 2017/02/21
 */
@Service
public class AuthRoleServiceImpl implements AuthRoleService {

	@Autowired
	private AuthRoleMapper authRoleMapper;
	
	public EUDataGridResult selectList(EUDataGridModel dgm, AuthRole authRole) {
		
		//查询列表
		AuthRoleExample example = new AuthRoleExample();
		Criteria criteria = example.createCriteria();
	
		//排序
		if(StringUtils.isNotEmpty(dgm.getSort())){
			example.setOrderByClause(dgm.getSort() + " " + dgm.getOrder());
		}
		//分页处理
		PageHelper.startPage(dgm.getPage(), dgm.getRows());
		List<AuthRole> list = authRoleMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<AuthRole> pageInfo = new PageInfo<AuthRole>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	

	@Override
	public ResponseResult insert(AuthRole authRole) {
		try {
			//补全pojo内容
		  	if(StringUtils.isEmpty(authRole.getRoleid())){
				authRole.setRoleid(PrimaryKeyFactory.generatePK(""));
			}
			authRoleMapper.insert(authRole);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
		
	}

	@Override
	public ResponseResult delete(List<String> roleids) {
		try {
			for (int i = 0; i < roleids.size(); i++) {
				String roleid = roleids.get(i);
			    authRoleMapper.deleteByPrimaryKey(roleid);
			}
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public AuthRole selectByPrimaryKey(String roleid) {
		AuthRole authRole = authRoleMapper.selectByPrimaryKey(roleid);
		return authRole;
	}

	@Override
	public ResponseResult update(AuthRole authRole) {
		try {
			AuthRole temp = authRoleMapper.selectByPrimaryKey(authRole.getRoleid());
			temp.setName(authRole.getName());
			temp.setType(authRole.getType());
			authRoleMapper.updateByPrimaryKey(temp);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public List<AuthRole> selectList() {
		List<AuthRole> list = authRoleMapper.selectByExample(new AuthRoleExample());
		return list;
	}


	@Override
	public int insertRole(AuthRole authRole) {
		return authRoleMapper.insert(authRole);
	}
	
}