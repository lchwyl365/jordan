package com.team.platform.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.util.ExceptionUtil;

import com.team.common.pojo.ResponseResult;
import com.team.common.util.PrimaryKeyFactory;
import com.team.platform.mapper.AuthTestMapper;
import com.team.platform.pojo.AuthTest;
import com.team.platform.pojo.AuthTestExample;
import com.team.platform.pojo.AuthTestExample.Criteria;
import com.team.platform.service.AuthTestService;


import com.team.platform.pojo.AuthTestKey;


/**
 * Created by liuchao on 2017/02/21
 */
@Service
public class AuthTestServiceImpl implements AuthTestService {

	@Autowired
	private AuthTestMapper authTestMapper;
	
	public EUDataGridResult selectList(EUDataGridModel dgm, AuthTest authTest) {
		
		//查询列表
		AuthTestExample example = new AuthTestExample();
		Criteria criteria = example.createCriteria();
		
	
		//排序
		if(StringUtils.isNotEmpty(dgm.getSort())){
			example.setOrderByClause(dgm.getSort() + " " + dgm.getOrder());
		}
		//分页处理
		PageHelper.startPage(dgm.getPage(), dgm.getRows());
		List<AuthTest> list = authTestMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<AuthTest> pageInfo = new PageInfo<AuthTest>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	

	@Override
	public ResponseResult insert(AuthTest authTest) {
		try {
			//补全pojo内容
		  	if(StringUtils.isEmpty(authTest.getTestid())){
				authTest.setTestid(PrimaryKeyFactory.generatePK(""));
			}
		  	if(StringUtils.isEmpty(authTest.getGroupId())){
				authTest.setGroupId(PrimaryKeyFactory.generatePK(""));
			}
			authTestMapper.insert(authTest);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
		
	}

	@Override
	public ResponseResult delete(List<String> testids,List<String> groupIds) {
		try {
			for (int i = 0; i < testids.size(); i++) {
				String testid = testids.get(i);
				String groupId = groupIds.get(i);
				AuthTestKey key = new AuthTestKey();
				key.setTestid(testid);
				key.setGroupId(groupId);
				authTestMapper.deleteByPrimaryKey(key);
			}
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public AuthTest selectByPrimaryKey(String testid,String groupId) {
		AuthTestKey key = new AuthTestKey();
		key.setTestid(testid);
		key.setGroupId(groupId);
		AuthTest authTest = authTestMapper.selectByPrimaryKey(key);
		return authTest;
	}

	@Override
	public ResponseResult update(AuthTest authTest) {
		try {
			AuthTestKey key = new AuthTestKey();
			key.setTestid(authTest.getTestid());
			key.setGroupId(authTest.getGroupId());
			AuthTest temp = authTestMapper.selectByPrimaryKey(key);
			temp.setTestname(authTest.getTestname());
			authTestMapper.updateByPrimaryKeySelective(authTest);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}
}