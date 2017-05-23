package com.team.platform.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.platform.mapper.Db2ColumnsMapper;
import com.team.platform.pojo.Columns;
import com.team.platform.pojo.Db2ColumnsExample;
import com.team.platform.pojo.Db2ColumnsExample.Criteria;
import com.team.platform.service.DB2SysColumnService;

/**
 * Created by liuchao on 2017/02/21 0021.
 */
@Service
public class DB2SysColumnServiceImpl implements DB2SysColumnService {

	@Autowired
	private Db2ColumnsMapper db2ColumnsMapper;
	
	@Override
	public List<Columns> selectByCondition(String tableSchema,
			String tableName) {
		Db2ColumnsExample db2ColumnsExample = new Db2ColumnsExample();
    	Criteria criteria = db2ColumnsExample.createCriteria();
    	if(StringUtils.isNotEmpty(tableSchema)){
    		criteria.andTableSchemaEqualTo(tableSchema);
    	}
    	if(StringUtils.isNotEmpty(tableName)){
    		criteria.andTableNameEqualTo(tableName);
    	}
		List<Columns> columns = db2ColumnsMapper.selectByExample(db2ColumnsExample);
		return columns;
	}

}
