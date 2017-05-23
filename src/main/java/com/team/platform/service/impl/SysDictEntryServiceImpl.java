package com.team.platform.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.ResponseResult;
import com.team.common.util.PrimaryKeyFactory;
import com.team.platform.mapper.SysDictEntryMapper;
import com.team.platform.pojo.SysDictEntry;
import com.team.platform.pojo.SysDictEntryExample;
import com.team.platform.pojo.SysDictEntryExample.Criteria;
import com.team.platform.pojo.SysDictEntryKey;
import com.team.platform.service.SysDictEntryService;


/**
 * Created by liuchao on 2017/02/21
 */
@Service
public class SysDictEntryServiceImpl implements SysDictEntryService {

	@Autowired
	private SysDictEntryMapper sysDictEntryMapper;
	
	public EUDataGridResult selectList(EUDataGridModel dgm, SysDictEntry sysDictEntry) {
		
		//查询列表
		SysDictEntryExample example = new SysDictEntryExample();
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(sysDictEntry.getDicttypeid())){
			criteria.andDicttypeidEqualTo(sysDictEntry.getDicttypeid());
		}
		//排序
		if(StringUtils.isNotEmpty(dgm.getSort())){
			example.setOrderByClause(dgm.getSort() + " " + dgm.getOrder());
		}
		//分页处理
		PageHelper.startPage(dgm.getPage(), dgm.getRows());
		List<SysDictEntry> list = sysDictEntryMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<SysDictEntry> pageInfo = new PageInfo<SysDictEntry>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	

	@Override
	public ResponseResult insert(SysDictEntry sysDictEntry) {
		try {
			//补全pojo内容
		  	if(StringUtils.isEmpty(sysDictEntry.getDicttypeid())){
				sysDictEntry.setDicttypeid(PrimaryKeyFactory.generatePK(""));
			}
		  	if(StringUtils.isEmpty(sysDictEntry.getDictid())){
				sysDictEntry.setDictid(PrimaryKeyFactory.generatePK(""));
			}
			sysDictEntryMapper.insert(sysDictEntry);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
		
	}

	@Override
	public ResponseResult delete(List<String> dicttypeids,List<String> dictids) {
		try {
			for (int i = 0; i < dicttypeids.size(); i++) {
				String dicttypeid = dicttypeids.get(i);
				String dictid = dictids.get(i);
				SysDictEntryKey key = new SysDictEntryKey();
				key.setDicttypeid(dicttypeid);
				key.setDictid(dictid);
				sysDictEntryMapper.deleteByPrimaryKey(key);
			}
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public SysDictEntry selectByPrimaryKey(String dicttypeid,String dictid) {
		SysDictEntryKey key = new SysDictEntryKey();
		key.setDicttypeid(dicttypeid);
		key.setDictid(dictid);
		SysDictEntry sysDictEntry = sysDictEntryMapper.selectByPrimaryKey(key);
		return sysDictEntry;
	}

	@Override
	public ResponseResult update(SysDictEntry sysDictEntry) {
		try {
			SysDictEntryKey key = new SysDictEntryKey();
			key.setDicttypeid(sysDictEntry.getDicttypeid());
			key.setDictid(sysDictEntry.getDictid());
			SysDictEntry temp = sysDictEntryMapper.selectByPrimaryKey(key);
			temp.setDictname(sysDictEntry.getDictname());
			temp.setStatus(sysDictEntry.getStatus());
			temp.setSortno(sysDictEntry.getSortno());
			temp.setRank(sysDictEntry.getRank());
			temp.setParentid(sysDictEntry.getParentid());
			sysDictEntryMapper.updateByPrimaryKeySelective(sysDictEntry);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public int deleteByDictType(String dicttypeid) {
		SysDictEntryExample example = new SysDictEntryExample();
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(dicttypeid)){
			criteria.andDicttypeidEqualTo(dicttypeid);
		}
		return sysDictEntryMapper.deleteByExample(example);
	}

	@Override
	public List<SysDictEntry> selectByType(String dicttypeid) {
		SysDictEntryExample example = new SysDictEntryExample();
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(dicttypeid)){
			criteria.andDicttypeidEqualTo(dicttypeid);
		}
		example.setOrderByClause("SORTNO DESC");
		return sysDictEntryMapper.selectByExample(example);
	}

	@Override
	public List<SysDictEntry> selectList() {
		return sysDictEntryMapper.selectByExample(new SysDictEntryExample());
	}

	@Override
	public int insertSysDictEntry(SysDictEntry sysDictEntry) {
		return sysDictEntryMapper.insert(sysDictEntry);
	}
}