package com.team.platform.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.common.pojo.EUTreeNode;
import com.team.common.pojo.ResponseResult;
import com.team.common.util.PrimaryKeyFactory;
import com.team.platform.mapper.SysDictTypeMapper;
import com.team.platform.pojo.SysDictType;
import com.team.platform.pojo.SysDictTypeExample;
import com.team.platform.service.SysDictEntryService;
import com.team.platform.service.SysDictTypeService;

/**
 * Created by liuchao on 2017/02/21
 */
@Service
public class SysDictTypeServiceImpl implements SysDictTypeService {

	@Autowired
	private SysDictTypeMapper sysDictTypeMapper;
	
	@Autowired
	private SysDictEntryService sysDictEntryService;
	
	@Override
	public ResponseResult insert(SysDictType sysDictType) {
		try {
			//补全pojo内容
		  	if(StringUtils.isEmpty(sysDictType.getDicttypeid())){
				sysDictType.setDicttypeid(PrimaryKeyFactory.generatePK(""));
			}
			sysDictTypeMapper.insert(sysDictType);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
		
	}

	@Override
	public ResponseResult delete(List<String> dicttypeids) {
		try {
			for (int i = 0; i < dicttypeids.size(); i++) {
				String dicttypeid = dicttypeids.get(i);
			    sysDictTypeMapper.deleteByPrimaryKey(dicttypeid);
			    
			    sysDictEntryService.deleteByDictType(dicttypeid);
			}
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public SysDictType selectByPrimaryKey(String dicttypeid) {
		SysDictType sysDictType = sysDictTypeMapper.selectByPrimaryKey(dicttypeid);
		return sysDictType;
	}

	@Override
	public ResponseResult update(SysDictType sysDictType) {
		try {
			SysDictType temp = sysDictTypeMapper.selectByPrimaryKey(sysDictType.getDicttypeid());
			temp.setDicttypename(sysDictType.getDicttypename());
			temp.setRank(sysDictType.getRank());
			temp.setParentid(sysDictType.getParentid());
			sysDictTypeMapper.updateByPrimaryKey(temp);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}


	@Override
	public List<EUTreeNode> selectList(SysDictType sysDictType) {
		//查询列表
		SysDictTypeExample example = new SysDictTypeExample();
		//排序
		example.setOrderByClause("DICTTYPENAME");
		List<SysDictType> list = sysDictTypeMapper.selectByExample(example);
		List<EUTreeNode> dicts = new ArrayList<EUTreeNode>();
		for (SysDictType item : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(item.getDicttypeid());
			node.setText(item.getDicttypename());
			dicts.add(node);
		}
		return dicts;
	}

	@Override
	public List<SysDictType> selectList() {
		return sysDictTypeMapper.selectByExample(new SysDictTypeExample());
	}

	@Override
	public int insertSysDictType(SysDictType sysDictType) {
		return sysDictTypeMapper.insert(sysDictType);
	}

}