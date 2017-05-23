package com.team.platform.service;

import java.util.List;

import com.team.platform.vo.AuthMenuVo;
import com.team.common.pojo.EUTreeNode;
import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.AuthMenu;
import com.team.platform.pojo.AuthRoleMenu;

/**
 * Created by Administrator on 2017/02/27
 */
public interface AuthMenuService {

	public List<AuthMenuVo> selectList(String pid,String level);
	
	public AuthMenu selectByPrimaryKey(String menuid);

	public ResponseResult insert(AuthMenu authMenu);

	public ResponseResult delete(List<String> menuids);

	public ResponseResult update(AuthMenu authMenu);

	public List<AuthMenu> selectListByAuth(String userid,String pid, String menuPos);
	
	public List<AuthMenu> selectList(AuthMenu authMenu);

	public List<EUTreeNode> selectTreeList(String pid,List<AuthRoleMenu> menus,String level);

	public List<AuthMenuVo> selectListByAuth2(String userid, String pid,
			String pos);
	
	public List<AuthMenuVo> selectTreeList(String pid);

	public List<AuthMenu> selectList();

	public int insertMenu(AuthMenu authMenu);
	
}