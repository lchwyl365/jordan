package com.team.platform.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.common.pojo.ResponseResult;
import com.team.common.util.PrimaryKeyFactory;
import com.team.platform.mapper.AuthRoleMenuMapper;
import com.team.platform.pojo.AuthRoleMenu;
import com.team.platform.pojo.AuthRoleMenuExample;
import com.team.platform.pojo.AuthRoleMenuExample.Criteria;
import com.team.platform.service.AuthRoleMenuService;


/**
 * Created by liuchao on 2017/02/21
 */
@Service
public class AuthRoleMenuServiceImpl implements AuthRoleMenuService {

	@Autowired
	private AuthRoleMenuMapper authRoleMenuMapper;

	@Override
	public ResponseResult insert(AuthRoleMenu authRoleMenu) {
		try {
			//补全pojo内容
		  	if(StringUtils.isEmpty(authRoleMenu.getRoleMenuId())){
				authRoleMenu.setRoleMenuId(PrimaryKeyFactory.generatePK(""));
			}
			authRoleMenuMapper.insert(authRoleMenu);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public ResponseResult delete(List<String> roleMenuIds) {
		try {
			for (int i = 0; i < roleMenuIds.size(); i++) {
				String roleMenuId = roleMenuIds.get(i);
			    authRoleMenuMapper.deleteByPrimaryKey(roleMenuId);
			}
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public AuthRoleMenu selectByPrimaryKey(String roleMenuId) {
		AuthRoleMenu authRoleMenu = authRoleMenuMapper.selectByPrimaryKey(roleMenuId);
		return authRoleMenu;
	}

	@Override
	public ResponseResult update(AuthRoleMenu authRoleMenu) {
		try {
			AuthRoleMenu temp = authRoleMenuMapper.selectByPrimaryKey(authRoleMenu.getRoleMenuId());
			temp.setRoleId(authRoleMenu.getRoleId());
			temp.setMenuId(authRoleMenu.getMenuId());
			authRoleMenuMapper.updateByPrimaryKey(temp);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public ResponseResult insertBatch(String roleid, List<String> menuids) {
		try {
			//先删除
			AuthRoleMenuExample example = new AuthRoleMenuExample();
			Criteria criteria = example.createCriteria();
			criteria.andRoleIdEqualTo(roleid);
			authRoleMenuMapper.deleteByExample(example);
			//后添加
			for (String menuid : menuids) {
				AuthRoleMenu authRoleMenu = new AuthRoleMenu();
				authRoleMenu.setRoleMenuId(PrimaryKeyFactory.generatePK(""));
				authRoleMenu.setRoleId(roleid);
				authRoleMenu.setMenuId(menuid);
				authRoleMenuMapper.insert(authRoleMenu);
			}
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public List<AuthRoleMenu> selectList(String roleid) {
		AuthRoleMenuExample example = new AuthRoleMenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleid);
		return authRoleMenuMapper.selectByExample(example);
	}

	@Override
	public List<AuthRoleMenu> selectList() {
		AuthRoleMenuExample example = new AuthRoleMenuExample();
		return authRoleMenuMapper.selectByExample(example);
	}

	@Override
	public int insertRoleMenu(AuthRoleMenu roleMenu) {
		return authRoleMenuMapper.insert(roleMenu);
	}
}