package com.team.platform.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.platform.mapper.DB2TabConstMapper;
import com.team.platform.pojo.DB2KeyColuse;
import com.team.platform.pojo.DB2TabConst;
import com.team.platform.pojo.DB2TabConstExample;
import com.team.platform.pojo.SysColumns;
import com.team.platform.pojo.SysTables;
import com.team.platform.service.DB2KeyColuseService;
import com.team.platform.service.DB2TabConstService;
import com.team.platform.service.SysColumnsService;
import com.team.platform.service.SysTablesService;

/**
 * Created by liuchao on 2017/02/21 0021.
 */
@Service
public class DB2TabConstServiceImpl implements DB2TabConstService {

	@Autowired
	private DB2TabConstMapper db2TabConstMapper;
	@Autowired
	private DB2KeyColuseService db2KeyColuseService;
	@Autowired
	private SysTablesService sysTablesService;
	@Autowired
	private SysColumnsService sysColumnsService;
	
	@Override
	public List<DB2TabConst> selectByTabConst(String schema,String tabname) {
		DB2TabConstExample tabConstExample = new DB2TabConstExample();
		DB2TabConstExample.Criteria tabConstCriteria = tabConstExample.createCriteria();
		tabConstCriteria.andTabschemaEqualTo(schema);
		tabConstCriteria.andTypeEqualTo("P");
		if(StringUtils.isNotEmpty(tabname)){
			tabConstCriteria.andTabnameEqualTo(tabname);
		}
		List<DB2TabConst> tabConsts = db2TabConstMapper.selectByExample(tabConstExample);
		return tabConsts;
	}

	@Override
	public void updateTabConst(String schema,String tabname) {
		List<DB2TabConst> tabConsts = selectByTabConst(schema,tabname);
    	for (int i = 0; i < tabConsts.size(); i++) {
    		DB2TabConst tabConst = tabConsts.get(i);
    		List<DB2KeyColuse> keyColuses = db2KeyColuseService.selectByConst(tabConst.getConstname());
    		for (DB2KeyColuse db2KeyColuse : keyColuses) {
    			SysColumns sysColumns = new SysColumns();
    			sysColumns.setTbname(db2KeyColuse.getTabname());
    			sysColumns.setColumnName(db2KeyColuse.getColname());
    			sysColumns.setTbcreator(db2KeyColuse.getTabschema());
    			sysColumns.setIsprimary("T");
    			sysColumns.setIsupdate("F");
    			sysColumnsService.update(sysColumns);
    			
    			SysColumns temp = sysColumnsService.selectByPrimaryKey(sysColumns.getColumnName(), sysColumns.getTbname(), sysColumns.getTbcreator());
    			//设置主键列
    			SysTables sysTables = new SysTables();
    			sysTables.setSchemaName(sysColumns.getTbcreator());
    			sysTables.setTableName(sysColumns.getTbname());
    			sysTables.setType("T");
    			sysTables.setIdField(temp.getPropertyName());
    			sysTablesService.updateIdField(sysTables);
			}
		}
	}
}
