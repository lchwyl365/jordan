package com.team.platform.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.EUTreeNode;
import com.team.common.pojo.ResponseResult;
import com.team.common.util.JsonUtils;
import com.team.common.util.PrimaryKeyFactory;
import com.team.platform.mapper.CommonMapper;
import com.team.platform.mapper.SysComboBoxMapper;
import com.team.platform.pojo.SysComboBox;
import com.team.platform.pojo.SysComboBoxExample;
import com.team.platform.pojo.SysDictEntry;
import com.team.platform.service.SysComboBoxService;
import com.team.platform.service.SysDictEntryService;

/**
 * Created by liuchao on 2017/02/21
 */
@Service
public class SysComboBoxServiceImpl implements SysComboBoxService {

	@Autowired
	private SysComboBoxMapper sysComboBoxMapper;
	
	@Autowired
	private CommonMapper commonMapper;
	
	@Autowired
	private SysDictEntryService sysDictEntryService;
	
	public EUDataGridResult selectList(EUDataGridModel dgm, SysComboBox sysComboBox) {
		
		//查询列表
		SysComboBoxExample example = new SysComboBoxExample();
		//排序
		if(StringUtils.isNotEmpty(dgm.getSort())){
			example.setOrderByClause(dgm.getSort() + " " + dgm.getOrder());
		}
		//分页处理
		PageHelper.startPage(dgm.getPage(), dgm.getRows());
		List<SysComboBox> list = sysComboBoxMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<SysComboBox> pageInfo = new PageInfo<SysComboBox>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	

	@Override
	public ResponseResult insert(SysComboBox sysComboBox) {
		try {
			//补全pojo内容
		  	if(StringUtils.isEmpty(sysComboBox.getComboid())){
		  		String id = PrimaryKeyFactory.generatePK("");
		  		sysComboBox.setComboid(id);
			}
			sysComboBoxMapper.insert(sysComboBox);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
		
	}

	@Override
	public ResponseResult delete(List<String> comboids) {
		try {
			for (int i = 0; i < comboids.size(); i++) {
				String comboid = comboids.get(i);
			    sysComboBoxMapper.deleteByPrimaryKey(comboid);
			}
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public SysComboBox selectByPrimaryKey(String comboid) {
		SysComboBox sysComboBox = sysComboBoxMapper.selectByPrimaryKey(comboid);
		return sysComboBox;
	}

	@Override
	public ResponseResult update(SysComboBox sysComboBox) {
		try {
			SysComboBox temp = sysComboBoxMapper.selectByPrimaryKey(sysComboBox.getComboid());
			temp.setName(sysComboBox.getName());
			temp.setTableName(sysComboBox.getTableName());
			temp.setValueField(sysComboBox.getValueField());
			temp.setTextField(sysComboBox.getTextField());
			temp.setWhereCondition(sysComboBox.getWhereCondition());
			temp.setParentField(sysComboBox.getParentField());
			temp.setRootValue(sysComboBox.getRootValue());
			sysComboBoxMapper.updateByPrimaryKey(temp);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public List<EUTreeNode> combotree(String comboid) {
		//1:自定义字典
		SysComboBox comboBox = sysComboBoxMapper.selectByPrimaryKey(comboid);
		String sql="select VALUE_FIELD as id,TEXT_FIELD as text from TABLE_NAME ";
		if(comboBox != null){
			sql = sql.replace("VALUE_FIELD", comboBox.getValueField());
			sql = sql.replace("TEXT_FIELD", comboBox.getTextField());
			sql = sql.replace("TABLE_NAME", comboBox.getTableName());
			if(StringUtils.isNotEmpty(comboBox.getParentField())){
				sql = sql + "where "+comboBox.getParentField()+" = ";
			}
			return getComboTree(sql,comboBox.getRootValue());
		}else{
			return null;
		}
	}

	private List<EUTreeNode> getComboTree(String sql, String parentId) {
		String _sql2 = sql;
		boolean load_child = false;
		if(sql.indexOf("where") != -1 && StringUtils.isNotEmpty(parentId)){
			_sql2 = _sql2 + parentId;
			load_child = true;
		}
		List<EUTreeNode> list = commonMapper.findManyData(_sql2);
		if(load_child){
			for (EUTreeNode treeNode : list) {
				List<EUTreeNode> children = getComboTree(sql,treeNode.getId());
				treeNode.setChildren(children);
			}
		}
		return list;
	}

	@Override
	public List<SysComboBox> selectAll() {
		//查询列表
		SysComboBoxExample example = new SysComboBoxExample();
		example.setOrderByClause("NAME");
		List<SysComboBox> list = sysComboBoxMapper.selectByExample(example);
		return list;
	}

	@Override
	public String selectComboid(String comboid) {
		//1:自定义字典信息
		SysComboBox comboBox = sysComboBoxMapper.selectByPrimaryKey(comboid);
		String sql="select VALUE_FIELD as id,TEXT_FIELD as text from TABLE_NAME";
		if(comboBox != null){
			sql = sql.replace("VALUE_FIELD", comboBox.getValueField());
			sql = sql.replace("TEXT_FIELD", comboBox.getTextField());
			sql = sql.replace("TABLE_NAME", comboBox.getTableName());
			
			List<EUTreeNode> list = commonMapper.findManyData(sql);
			return JsonUtils.objectToJson(list);
		}else{
			//2:系统字典信息
			List<SysDictEntry> dictList = sysDictEntryService.selectByType(comboid);
			List<EUTreeNode> entryList = new ArrayList<EUTreeNode>(); 
			if(dictList.size() > 0){
				for (SysDictEntry sysDictEntry : dictList) {
					EUTreeNode e = new EUTreeNode();
					e.setId(sysDictEntry.getDictid());
					e.setText(sysDictEntry.getDictname());
					entryList.add(e);
				}
			}
			return JsonUtils.objectToJson(entryList);
		}
	}

	@Override
	public int insertSysComboBox(SysComboBox sysComboBox) {
		return sysComboBoxMapper.insert(sysComboBox);
	}
}