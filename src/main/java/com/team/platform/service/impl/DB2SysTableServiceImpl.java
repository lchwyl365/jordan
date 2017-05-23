package com.team.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.platform.mapper.Db2TablesMapper;
import com.team.platform.pojo.Db2TablesExample;
import com.team.platform.pojo.Db2TablesExample.Criteria;
import com.team.platform.pojo.Tables;
import com.team.platform.service.DB2SysTableService;

/**
 * Created by liuchao on 2017/02/21 0021.
 */
@Service
public class DB2SysTableServiceImpl implements DB2SysTableService {

	@Autowired
	private Db2TablesMapper db2TablesMapper;
	
	@Override
	public List<Tables> selectTableByCreator(String schema, String type) {
		Db2TablesExample db2TablesExample = new Db2TablesExample();
    	Criteria criteria = db2TablesExample.createCriteria();
    	criteria.andTableSchemaEqualTo(schema);
    	criteria.andTableTypeEqualTo(type);
    	List<Tables> list = db2TablesMapper.selectByExample(db2TablesExample);
    	return list;
	}

}
