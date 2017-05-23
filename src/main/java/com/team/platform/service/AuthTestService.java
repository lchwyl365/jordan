package com.team.platform.service;

import java.util.List;
import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.AuthTest;

/**
 * Created by Administrator on 2017/02/27
 */
public interface AuthTestService {

	public EUDataGridResult selectList(EUDataGridModel dgm,AuthTest authTest);
	
	public AuthTest selectByPrimaryKey(String testid,String groupId);

	public ResponseResult insert(AuthTest authTest);

	public ResponseResult delete(List<String> testids,List<String> groupIds);

	public ResponseResult update(AuthTest authTest);
	
}