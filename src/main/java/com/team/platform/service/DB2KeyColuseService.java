package com.team.platform.service;

import java.util.List;

import com.team.platform.pojo.DB2KeyColuse;

/**
 * Created by Administrator on 2015/9/21 0021.
 */
public interface DB2KeyColuseService {

	List<DB2KeyColuse> selectByConst(String constname);

}