package com.team.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.platform.mapper.MysqlTablesMapper;
import com.team.platform.pojo.MysqlTablesExample;
import com.team.platform.pojo.MysqlTablesExample.Criteria;
import com.team.platform.pojo.Tables;
import com.team.platform.service.MysqlTablesService;

/**
 * Created by liuchao on 2017/02/21 0021.
 */
@Service
public class MysqlTablesServiceImpl implements MysqlTablesService {

	@Autowired
	private MysqlTablesMapper mysqlTablesMapper;
	
	@Override
	public List<Tables> selectTableByCreator(String schema, String type) {
		MysqlTablesExample tablesExample = new MysqlTablesExample();
    	Criteria criteria = tablesExample.createCriteria();
    	criteria.andTableSchemaEqualTo(schema);
    	criteria.andTableTypeEqualTo(type);
    	List<Tables> list = mysqlTablesMapper.selectByExample(tablesExample);
    	return list;
	}

}
