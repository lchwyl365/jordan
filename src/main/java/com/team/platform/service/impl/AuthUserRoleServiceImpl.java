package com.team.platform.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.common.pojo.ResponseResult;
import com.team.common.util.PrimaryKeyFactory;
import com.team.platform.mapper.AuthUserRoleMapper;
import com.team.platform.pojo.AuthUserRole;
import com.team.platform.pojo.AuthUserRoleExample;
import com.team.platform.pojo.AuthUserRoleExample.Criteria;
import com.team.platform.service.AuthUserRoleService;

/**
 * Created by liuchao on 2017/02/21
 */
@Service
public class AuthUserRoleServiceImpl implements AuthUserRoleService {

	@Autowired
	private AuthUserRoleMapper authUserRoleMapper;

	@Override
	public ResponseResult insert(AuthUserRole authUserRole) {
		try {
			//补全pojo内容
		  	if(StringUtils.isEmpty(authUserRole.getUserRoleId())){
				authUserRole.setUserRoleId(PrimaryKeyFactory.generatePK(""));
			}
			authUserRoleMapper.insert(authUserRole);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
		
	}

	@Override
	public ResponseResult delete(List<String> userRoleIds) {
		try {
			for (int i = 0; i < userRoleIds.size(); i++) {
				String userRoleId = userRoleIds.get(i);
			    authUserRoleMapper.deleteByPrimaryKey(userRoleId);
			}
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public AuthUserRole selectByPrimaryKey(String userRoleId) {
		AuthUserRole authUserRole = authUserRoleMapper.selectByPrimaryKey(userRoleId);
		return authUserRole;
	}

	@Override
	public ResponseResult update(AuthUserRole authUserRole) {
		try {
			AuthUserRole temp = authUserRoleMapper.selectByPrimaryKey(authUserRole.getUserRoleId());
			temp.setUserId(authUserRole.getUserId());
			temp.setRoleId(authUserRole.getRoleId());
			authUserRoleMapper.updateByPrimaryKey(temp);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public ResponseResult insert(String roleid,String[] userids) {
		try {
			for (int i = 0; i < userids.length; i++) {
				String userid = userids[i];
				AuthUserRoleExample example = new AuthUserRoleExample();
				Criteria criteria = example.createCriteria();
				if(StringUtils.isNotEmpty(roleid)){
					criteria.andRoleIdEqualTo(roleid);
				}
				if(StringUtils.isNotEmpty(userid)){
					criteria.andUserIdEqualTo(userid);
				}
				List<AuthUserRole> userRoles = authUserRoleMapper.selectByExample(example);
				if(userRoles.size() == 0){
					AuthUserRole record = new AuthUserRole();
					record.setUserRoleId(PrimaryKeyFactory.generatePK(""));
				    record.setUserId(userid);
				    record.setRoleId(roleid);
				    authUserRoleMapper.insert(record);
				}
			}
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public ResponseResult deleteRole(String roleid, String[] userids) {
		try {
			for (int i = 0; i < userids.length; i++) {
				String userid = userids[i];
				AuthUserRoleExample example = new AuthUserRoleExample();
				Criteria criteria = example.createCriteria();
				if(StringUtils.isNotEmpty(roleid)){
					criteria.andRoleIdEqualTo(roleid);
				}
				if(StringUtils.isNotEmpty(userid)){
					criteria.andUserIdEqualTo(userid);
				}
				authUserRoleMapper.deleteByExample(example);
			}
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public List<AuthUserRole> selectList() {
		List<AuthUserRole> list = authUserRoleMapper.selectByExample(new AuthUserRoleExample());
		return list;
	}

	@Override
	public int insertUserRole(AuthUserRole userRole) {
		return authUserRoleMapper.insert(userRole);
	}
	
}