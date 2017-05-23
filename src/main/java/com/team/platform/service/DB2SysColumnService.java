package com.team.platform.service;

import java.util.List;

import com.team.platform.pojo.Columns;

/**
 * Created by Administrator on 2015/9/21 0021.
 */
public interface DB2SysColumnService {

	List<Columns> selectByCondition(String schemaName, String tableName);

}