package com.team.platform.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.ResponseResult;
import com.team.platform.mapper.DB2KeyColuseMapper;
import com.team.platform.mapper.DB2TabConstMapper;
import com.team.platform.mapper.SysColumnsMapper;
import com.team.platform.pojo.Columns;
import com.team.platform.pojo.SysColumns;
import com.team.platform.pojo.SysColumnsExample;
import com.team.platform.pojo.SysColumnsExample.Criteria;
import com.team.platform.pojo.SysColumnsKey;
import com.team.platform.service.SysColumnsService;

/**
 * Created by liuchao on 2017/02/21 0021.
 */
@Service
public class SysColumnsServiceImpl implements SysColumnsService {

	@Autowired
	private SysColumnsMapper sysColumnsMapper;
	@Autowired
	private DB2TabConstMapper db2TabConstMapper;
	@Autowired
	private DB2KeyColuseMapper db2KeyColuseMapper;
	
	@Override
	public SysColumns selectByPrimaryKey(String name, String tbname,
			String tbcreator) {
		SysColumnsKey sysColumnsKey = new SysColumnsKey();
		sysColumnsKey.setColumnName(name);
		sysColumnsKey.setTbname(tbname);
		sysColumnsKey.setTbcreator(tbcreator);
		return sysColumnsMapper.selectByPrimaryKey(sysColumnsKey);
	}

	@Override
	public List<SysColumns> selectByExample(SysColumns sysColumns) {
		SysColumnsExample example = new SysColumnsExample();
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(sysColumns.getTbname())){
			criteria.andTbnameEqualTo(sysColumns.getTbname());
		}
		if(StringUtils.isNotEmpty(sysColumns.getTbcreator())){
			criteria.andTbcreatorEqualTo(sysColumns.getTbcreator());
		}
		if(StringUtils.isNotEmpty(sysColumns.getIsdisplay())){
			criteria.andIsdisplayEqualTo(sysColumns.getIsdisplay());
		}
		if(StringUtils.isNotEmpty(sysColumns.getIsadd())){
			criteria.andIsaddEqualTo(sysColumns.getIsadd());
		}
		if(StringUtils.isNotEmpty(sysColumns.getIsupdate())){
			criteria.andIsupdateEqualTo(sysColumns.getIsupdate());
		}
		example.setOrderByClause("COLNO asc");
		return sysColumnsMapper.selectByExample(example);
	}
	
	@Override
	public EUDataGridResult selectList(EUDataGridModel dgm,
			SysColumns sysColumns) {
		//查询列表
		SysColumnsExample sysColumnsExample = new SysColumnsExample();
		Criteria criteria = sysColumnsExample.createCriteria();
		if(StringUtils.isNotEmpty(sysColumns.getTbcreator())){
			criteria.andTbcreatorEqualTo(sysColumns.getTbcreator());
		}
		if(StringUtils.isNotEmpty(sysColumns.getTbname())){
			criteria.andTbnameEqualTo(sysColumns.getTbname());
		}
		//排序
		if(StringUtils.isNotEmpty(dgm.getSort())){
			sysColumnsExample.setOrderByClause(dgm.getSort() + " " + dgm.getOrder());
		}
		//分页处理
		PageHelper.startPage(dgm.getPage(), dgm.getRows());
		List<SysColumns> list = sysColumnsMapper.selectByExample(sysColumnsExample);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<SysColumns> pageInfo = new PageInfo<SysColumns>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public int update(Columns db2SysColumn) {
		SysColumns record = new SysColumns();
		record.setColumnName(db2SysColumn.getColumnName());
		record.setTbname(db2SysColumn.getTableName());
		record.setTbcreator(db2SysColumn.getTableSchema());
		record.setColtype(db2SysColumn.getDataType());
		record.setNulls(db2SysColumn.getIsNullable());
		record.setPropertyLength(db2SysColumn.getLength());
		record.setColno(db2SysColumn.getColno());
		return sysColumnsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int insert(Columns db2SysColumn) {
		SysColumns record = new SysColumns();
		record.setColno(db2SysColumn.getColno());
		record.setColumnName(db2SysColumn.getColumnName());
		record.setTbname(db2SysColumn.getTableName());
		record.setTbcreator(db2SysColumn.getTableSchema());
		record.setColtype(db2SysColumn.getDataType());
		record.setNulls(db2SysColumn.getIsNullable());
		record.setPropertyLength(db2SysColumn.getLength());
		record.setIsprimary("F");
		record.setIsselect("F");
		record.setIslike("F");
		record.setIsadd("T");
		record.setIsupdate("T");
		record.setIsdisplay("T");
		record.setRemarks(db2SysColumn.getColumnComment());
		record.setPropertyTitle(StringUtils.isNotEmpty(db2SysColumn.getColumnComment())?db2SysColumn.getColumnComment():record.getColumnName());
		//PROPERTY_NAME
		String[] names = record.getColumnName().split("_");
		StringBuilder propertyName = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			String sname = names[i].toLowerCase();
			if(i == 0){
				propertyName.append(sname);
			}else{
				propertyName.append(sname.substring(0,1).toUpperCase() + sname.substring(1));
			}
		}
		record.setPropertyName(propertyName.toString());
		//PROPERTY_TYPE
		String propertyType = "";
		switch (db2SysColumn.getDataType().toUpperCase()) {
		case "VARCHAR": propertyType = "String"; break;
		case "CHAR": propertyType = "String"; break;
		case "CHARACTER": propertyType = "String"; break;
		case "TIMESTMP": propertyType = "Date"; break;
		case "TIMESTAMP": propertyType = "Date"; break;
		case "SMALLINT": propertyType = "Short"; break;
		case "BIGINT": propertyType = "Long"; break;
		case "INTEGER": propertyType = "Integer"; break;
		case "INT": propertyType = "Integer"; break;
		case "DOUBLE": propertyType = "Double"; break;
		}
		if(StringUtil.isEmpty(propertyType)){
System.out.println("propertyType:"+propertyType+ " db2SysColumn.getDataType():"+db2SysColumn.getDataType().toUpperCase());
		}
		record.setPropertyType(propertyType);
		record.setWidth(Short.valueOf("100"));
		record.setComponent("easyui-validatebox");
		record.setSortable("F");
		record.setFormatter("function(value,row,index){return row."+record.getPropertyName()+";}");
		record.setDataOptions("required:true,validType:['length[0,"+record.getPropertyLength()+"]']");
		
		//TODO add cloumn
		return sysColumnsMapper.insert(record);
	}

	@Override
	public void update(List<Columns> columns) {
		SysColumns temp = new SysColumns();
		boolean flag = false;
		for (Columns db2SysColumn : columns) {
			temp.setTbname(db2SysColumn.getTableName());
			temp.setTbcreator(db2SysColumn.getTableSchema());
			List<SysColumns> list = selectByExample(temp);
			flag = false;
			for (SysColumns sysColumns : list) {
				if (db2SysColumn.getColumnName().equals(sysColumns.getColumnName())
						&& db2SysColumn.getTableName().equals(sysColumns.getTbname())
						&& db2SysColumn.getTableSchema().equals(sysColumns.getTbcreator())) {
					flag = true;
				}
			}
			if(flag){ //已存在更新
				update(db2SysColumn);
			}else{//不存在添加
				insert(db2SysColumn);
			}
		}
	}

	@Override
	public ResponseResult update(SysColumns sysColumns) {
		if("T".equals(sysColumns.getIslike())){
			sysColumns.setIsselect("F");
		}
		sysColumnsMapper.updateByPrimaryKeySelective(sysColumns);
		return ResponseResult.ok();
	}

	@Override
	public int delete(SysColumns sysColumn) {

		SysColumnsExample sysColumnsExample = new SysColumnsExample();
		Criteria criteria = sysColumnsExample.createCriteria();
		if(StringUtils.isNotEmpty(sysColumn.getTbcreator())){
			criteria.andTbcreatorEqualTo(sysColumn.getTbcreator());
		}
		if(StringUtils.isNotEmpty(sysColumn.getTbname())){
			criteria.andTbnameEqualTo(sysColumn.getTbname());
		}
		if(StringUtils.isNotEmpty(sysColumn.getColumnName())){
			criteria.andColumnNameEqualTo(sysColumn.getColumnName());
		}
		return sysColumnsMapper.deleteByExample(sysColumnsExample);
	}

}
