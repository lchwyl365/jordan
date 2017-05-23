package com.team.platform.service;

import java.util.List;

import com.team.platform.pojo.DB2TabConst;

/**
 * Created by Administrator on 2015/9/21 0021.
 */
public interface DB2TabConstService {

	List<DB2TabConst> selectByTabConst(String schema,String tabname);

	void updateTabConst(String schema,String tabname);

}