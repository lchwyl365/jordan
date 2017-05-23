package com.team.platform.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.platform.mapper.DB2KeyColuseMapper;
import com.team.platform.pojo.DB2KeyColuse;
import com.team.platform.pojo.DB2KeyColuseExample;
import com.team.platform.pojo.DB2KeyColuseExample.Criteria;
import com.team.platform.service.DB2KeyColuseService;

/**
 * Created by liuchao on 2017/02/21 0021.
 */
@Service
public class DB2KeyColuseServiceImpl implements DB2KeyColuseService {

	@Autowired
	private DB2KeyColuseMapper db2KeyColuseMapper;

	@Override
	public List<DB2KeyColuse> selectByConst(String constname) {
		DB2KeyColuseExample example = new DB2KeyColuseExample();
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(constname)){
			criteria.andConstnameEqualTo(constname);
		}
		example.setOrderByClause("COLSEQ DESC");
		return db2KeyColuseMapper.selectByExample(example);
	}

}
