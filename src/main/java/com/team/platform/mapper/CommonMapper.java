package com.team.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team.common.pojo.EUTreeNode;
import com.team.platform.pojo.AuthMenu;
import com.team.platform.pojo.AuthUser;

public interface CommonMapper {

	/** 
     * 根据sql语句查询多条数据 
     * @author liuchao 
     * @param sql sql语句 
     * @return 
     */  
    public List<EUTreeNode> findManyData(String sql);

	public List<AuthUser> selectUserByRole(@Param(value="roleid")String roleid);
	
	public List<AuthMenu> selectMenuByRole(@Param(value="userid")String userid,@Param(value="pid")String pid,@Param(value="menuPos")String menuPos);

}