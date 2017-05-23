package com.team.platform.service;

import java.util.List;

import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.Columns;
import com.team.platform.pojo.SysColumns;

/**
 * Created by Administrator on 2015/9/21 0021.
 */
public interface SysColumnsService {

	List<SysColumns> selectByExample(SysColumns sysColumns);

	SysColumns selectByPrimaryKey(String name, String tbname, String tbcreator);

	EUDataGridResult selectList(EUDataGridModel dgm, SysColumns sysColumns);
	
	int insert(Columns db2SysColumn);

	int update(Columns db2SysColumn);

	void update(List<Columns> columns);

	ResponseResult update(SysColumns sysColumns);

	int delete(SysColumns sysColumn);

}