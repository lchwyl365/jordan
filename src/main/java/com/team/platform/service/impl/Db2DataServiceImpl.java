package com.team.platform.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.team.common.util.gencode.InitData;
import com.team.platform.pojo.Columns;
import com.team.platform.pojo.SysColumns;
import com.team.platform.pojo.SysTables;
import com.team.platform.pojo.Tables;
import com.team.platform.service.DB2SysColumnService;
import com.team.platform.service.DB2SysTableService;
import com.team.platform.service.DB2TabConstService;
import com.team.platform.service.SysColumnsService;
import com.team.platform.service.SysTablesService;

@Service
public class Db2DataServiceImpl {

	@Value("${SCHEMA}")
	private String SCHEMA;
	@Autowired
	private DB2SysTableService db2SysTableService;
	@Autowired
	private DB2SysColumnService db2SysColumnService;
	@Autowired
	private SysTablesService sysTablesService;
	@Autowired
	private SysColumnsService sysColumnsService;
	@Autowired
	private DB2TabConstService db2TabConstService;
	
	private static final Logger logger = Logger.getLogger(InitData.class);
	
	public void initDatabase() {
		//查询系统表
		List<Tables> list = db2SysTableService.selectTableByCreator(SCHEMA,"T");
    	//查询系统列
    	List<Columns> db2SysColumns = db2SysColumnService.selectByCondition(SCHEMA, null);
    	//同步数据库中删除的列
    	syncSysColumns(db2SysColumns);
    	
    	Map<String,List<Columns>> map = getColumnsMap(db2SysColumns);
    	//更新表信息
    	for (Tables t : list) {
			List<Columns> columns = map.get(t.getTableSchema()+"."+t.getTableName());
			SysTables table = sysTablesService.selectByPrimaryKey(t.getTableName(),SCHEMA,"T");
			if(table == null){//1.表不存在创建表
				SysTables sysTables = new SysTables();
				sysTables.setTableName(t.getTableName());
				sysTables.setSchemaName(t.getTableSchema());
				sysTables.setRemarks(t.getTableComment());
				sysTables.setType(t.getTableType());
				sysTables.setCtime(t.getCreateTime());
				sysTables.setFid(t.getFid());
				sysTables.setKeycolumns(t.getKeycolumns());
				sysTables.setGenerate("F");
				sysTables.setBusinessName("platform");
				sysTablesService.insert(sysTables,columns);
			}else{//2.表存在，更新字段
				sysColumnsService.update(columns);
			}
		}
    	//更新表的约束信息
    	db2TabConstService.updateTabConst(SCHEMA,null);
    	logger.info("End of DB2SysTable data");
	}
	
	private void syncSysColumns(List<Columns> db2SysColumns) {
		SysColumns temp = new SysColumns();
		temp.setTbcreator(SCHEMA);
		List<SysColumns> sysColumnsList = sysColumnsService.selectByExample(temp);
		for (SysColumns sysColumn : sysColumnsList) {
			boolean flag = true;
			for (Columns db2SysColumn : db2SysColumns) {
				if(db2SysColumn.getColumnName().equals(sysColumn.getColumnName()) 
						&& db2SysColumn.getTableName().equals(sysColumn.getTbname())
						&& db2SysColumn.getTableSchema().equals(sysColumn.getTbcreator())){
					flag = false;
				}
			}
			if(flag){
				sysColumnsService.delete(sysColumn);
			}
		}
	}

	private Map<String, List<Columns>> getColumnsMap(List<Columns> db2SysColumns) {
		Map<String, List<Columns>> map = new HashMap<String, List<Columns>>();
		for (Columns db2SysColumn : db2SysColumns) {
			String key = db2SysColumn.getTableSchema()+"."+db2SysColumn.getTableName();
			List<Columns> value = map.get(key);
			if(value == null){
				List<Columns> list = new ArrayList<Columns>();
				list.add(db2SysColumn);
				map.put(key, list);
			}else{
				value.add(db2SysColumn);
			}
		}
		return map;
	}

}