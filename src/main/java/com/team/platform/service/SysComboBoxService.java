package com.team.platform.service;

import java.util.List;

import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.EUTreeNode;
import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.SysComboBox;

/**
 * Created by Administrator on 2017/02/27
 */
public interface SysComboBoxService {

	public EUDataGridResult selectList(EUDataGridModel dgm,SysComboBox sysComboBox);
	
	public SysComboBox selectByPrimaryKey(String comboid);

	public ResponseResult insert(SysComboBox sysComboBox);

	public ResponseResult delete(List<String> comboids);

	public ResponseResult update(SysComboBox sysComboBox);

	public List<EUTreeNode> combotree(String comboid);

	public List<SysComboBox> selectAll();

	public String selectComboid(String comboid);

	public int insertSysComboBox(SysComboBox sysComboBox);
	
}