package com.team.platform.service;

import java.util.List;

import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.Columns;
import com.team.platform.pojo.SysColumns;
import com.team.platform.pojo.SysTables;

/**
 * Created by Administrator on 2015/9/21 0021.
 */
public interface SysTablesService {

	SysTables selectByPrimaryKey(String tableName, String schema, String type);

	int insert(SysTables sysTables, List<Columns> columns);

	ResponseResult update(SysTables sysTables);
	
	ResponseResult updateIdField(SysTables sysTables);

	EUDataGridResult selectList(EUDataGridModel dgm, SysTables sysTables);
	
	ResponseResult generateMapper(SysTables sysTables, List<SysColumns> sysColumnsList);

	ResponseResult generateAll(SysTables sysTables,List<SysColumns> sysColumnsList);

	List<SysTables> selectAll();

	ResponseResult generateJava(SysTables sysTables,List<SysColumns> sysColumnsList);

}