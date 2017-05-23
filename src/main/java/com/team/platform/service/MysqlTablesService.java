package com.team.platform.service;

import java.util.List;

import com.team.platform.pojo.Tables;

/**
 * Created by Administrator on 2015/9/21 0021.
 */
public interface MysqlTablesService {

	List<Tables> selectTableByCreator(String schema, String type);
	
}