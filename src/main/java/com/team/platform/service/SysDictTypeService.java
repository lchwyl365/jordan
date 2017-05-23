package com.team.platform.service;

import java.util.List;

import com.team.common.pojo.EUTreeNode;
import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.SysDictType;

/**
 * Created by Administrator on 2017/02/27
 */
public interface SysDictTypeService {

	public SysDictType selectByPrimaryKey(String dicttypeid);

	public ResponseResult insert(SysDictType sysDictType);

	public ResponseResult delete(List<String> dicttypeids);

	public ResponseResult update(SysDictType sysDictType);

	public List<EUTreeNode> selectList(SysDictType sysDictType);

	public List<SysDictType> selectList();

	public int insertSysDictType(SysDictType sysDictType);

}