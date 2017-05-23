package com.team.platform.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.team.platform.pojo.Columns;
import com.team.platform.pojo.SysColumns;
import com.team.platform.pojo.SysTables;
import com.team.platform.pojo.Tables;
import com.team.platform.service.MysqlColumnsService;
import com.team.platform.service.MysqlTablesService;
import com.team.platform.service.SysColumnsService;
import com.team.platform.service.SysTablesService;

@Service
public class MysqlDataServiceImpl  {
	
	@Value("${SCHEMA}")
	private String SCHEMA;
	
	@Autowired
	private MysqlTablesService mysqlTablesService;
	
	@Autowired
	private MysqlColumnsService mysqlColumnsService;
	
	@Autowired
	private SysTablesService sysTablesService;
	
	@Autowired
	private SysColumnsService sysColumnsService;
	
	public void initDatabase() {
		
		//查询系统表
		List<Tables> tables = mysqlTablesService.selectTableByCreator(SCHEMA, "BASE TABLE");
		
		//查询系统列
		List<Columns> mysql_columns = mysqlColumnsService.selectByCondition(SCHEMA, null);
		
		//同步数据库中删除的列
    	syncSysColumns(mysql_columns);
    	
    	Map<String,List<Columns>> map = getColumnsMap(mysql_columns);
    	//更新表信息
    	for (Tables t : tables) {
			List<Columns> columns = map.get(t.getTableSchema()+"."+t.getTableName());
			SysTables table = sysTablesService.selectByPrimaryKey(t.getTableName(),SCHEMA,"T");
			if(table == null){//1.表不存在创建表
				SysTables sysTables = new SysTables();
				sysTables.setTableName(t.getTableName());
				sysTables.setSchemaName(t.getTableSchema());
				sysTables.setRemarks(t.getTableComment());
				sysTables.setType("T");
				sysTables.setCtime(t.getCreateTime());
				sysTables.setKeycolumns(Short.valueOf(columns.size()+""));
				sysTables.setGenerate("F");
				sysTables.setBusinessName("platform");
				sysTablesService.insert(sysTables,columns);
			}else{//2.表存在，更新字段
				sysColumnsService.update(columns);
			}
		}
    	
	}
	/****
	 * 同步数据库中删除的列
	 * @param columns
	 */
	private void syncSysColumns(List<Columns> columns) {
		SysColumns temp = new SysColumns();
		temp.setTbcreator(SCHEMA);
		List<SysColumns> sysColumnsList = sysColumnsService.selectByExample(temp);
		for (SysColumns sysColumn : sysColumnsList) {
			boolean flag = true;
			for (Columns mysqlColumn : columns) {
				if(mysqlColumn.getColumnName().equals(sysColumn.getColumnName()) 
						&& mysqlColumn.getTableName().equals(sysColumn.getTbname())
						&& mysqlColumn.getTableSchema().equals(sysColumn.getTbcreator())){
					flag = false;
				}
			}
			if(flag){
				sysColumnsService.delete(sysColumn);
			}
		}
	}
	
	private Map<String, List<Columns>> getColumnsMap(List<Columns> columns) {
		Map<String, List<Columns>> map = new HashMap<String, List<Columns>>();
		for (Columns column : columns) {
			String key = column.getTableSchema()+"."+column.getTableName();
			List<Columns> value = map.get(key);
			if(value == null){
				List<Columns> list = new ArrayList<Columns>();
				list.add(column);
				map.put(key, list);
			}else{
				value.add(column);
			}
		}
		return map;
	}

}
