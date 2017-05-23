package com.team.platform.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.platform.mapper.MysqlColumnsMapper;
import com.team.platform.pojo.Columns;
import com.team.platform.pojo.MysqlColumnsExample;
import com.team.platform.pojo.MysqlColumnsExample.Criteria;
import com.team.platform.service.MysqlColumnsService;

/**
 * Created by liuchao on 2017/02/21 0021.
 */
@Service
public class MysqlColumnsServiceImpl implements MysqlColumnsService {

	@Autowired
	private MysqlColumnsMapper mysqlColumnsMapper;
	
	@Override
	public List<Columns> selectByCondition(String tableSchema,
			String tableName) {
		MysqlColumnsExample columnsExample = new MysqlColumnsExample();
    	Criteria criteria = columnsExample.createCriteria();
    	if(StringUtils.isNotEmpty(tableSchema)){
    		criteria.andTableSchemaEqualTo(tableSchema);
    		
    	}
    	if(StringUtils.isNotEmpty(tableName)){
    		criteria.andTableNameEqualTo(tableName);
    	}
		List<Columns> columns = mysqlColumnsMapper.selectByExample(columnsExample);
		return columns;
	}

}
