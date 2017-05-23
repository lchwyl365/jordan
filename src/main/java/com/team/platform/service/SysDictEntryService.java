package com.team.platform.service;

import java.util.List;

import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.SysDictEntry;

/**
 * Created by Administrator on 2017/02/27
 */
public interface SysDictEntryService {

	public EUDataGridResult selectList(EUDataGridModel dgm,SysDictEntry sysDictEntry);
	
	public SysDictEntry selectByPrimaryKey(String dicttypeid,String dictid);

	public ResponseResult insert(SysDictEntry sysDictEntry);

	public ResponseResult delete(List<String> dicttypeids,List<String> dictids);

	public ResponseResult update(SysDictEntry sysDictEntry);

	public int deleteByDictType(String dicttypeid);

	public List<SysDictEntry> selectByType(String dicttypeid);

	public List<SysDictEntry> selectList();

	public int insertSysDictEntry(SysDictEntry sysDictEntry);
	
}