package com.team.platform.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;








import com.team.common.pojo.EUTreeNode;
import com.team.common.pojo.ResponseResult;
import com.team.common.util.PrimaryKeyFactory;
import com.team.platform.mapper.AuthMenuMapper;
import com.team.platform.mapper.CommonMapper;
import com.team.platform.pojo.AuthMenu;
import com.team.platform.pojo.AuthMenuExample;
import com.team.platform.pojo.AuthRoleMenu;
import com.team.platform.pojo.AuthMenuExample.Criteria;
import com.team.platform.service.AuthMenuService;
import com.team.platform.vo.AuthMenuVo;
/**
 * Created by liuchao on 2017/02/21
 */
@Service
public class AuthMenuServiceImpl implements AuthMenuService {

	@Autowired
	private AuthMenuMapper authMenuMapper;
	@Autowired
	private CommonMapper commonMapper;
	
	public List<AuthMenuVo> selectList(String pid,String level) {
		
		//查询列表
		AuthMenuExample example = new AuthMenuExample();
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(pid)){
			criteria.andPidEqualTo(pid);
		}
		if(AuthMenuVo.LEVEL_TYPE_APPLICATION.equals(level)){
			criteria.andLevelTypeEqualTo(level);
		}
		//排序
		/*if(StringUtils.isNotEmpty(dgm.getSort())){
			example.setOrderByClause(dgm.getSort() + " " + dgm.getOrder());
		}*/
		List<AuthMenuVo> authMenuVoList = new ArrayList<AuthMenuVo>();
		List<AuthMenu> list = authMenuMapper.selectByExample(example);
		for (AuthMenu authMenu : list) {
			AuthMenuVo authMenuVo = new AuthMenuVo();
			authMenuVo.setMenuid(authMenu.getMenuid());
			authMenuVo.setName(authMenu.getName());
			authMenuVo.setMenuPos(authMenu.getMenuPos());
			authMenuVo.setHref(authMenu.getHref());
			authMenuVo.setIconCls(authMenu.getIconCls());
			authMenuVo.setDisplay(authMenu.getDisplay());
			authMenuVo.setOrderNum(authMenu.getOrderNum());
			authMenuVo.setPid(authMenu.getPid());
			List<AuthMenuVo> children = selectList(authMenuVo.getMenuid(),level);
			if(children != null && children.size() > 0){
				authMenuVo.setChildren(children);
			}
			authMenuVoList.add(authMenuVo);
		}
		return authMenuVoList;
	}

	@Override
	public ResponseResult insert(AuthMenu authMenu) {
		try {
			//补全pojo内容
		  	if(StringUtils.isEmpty(authMenu.getMenuid())){
				authMenu.setMenuid(PrimaryKeyFactory.generatePK(""));
			}
			authMenuMapper.insert(authMenu);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
		
	}

	@Override
	public ResponseResult delete(List<String> menuids) {
		try {
			for (int i = 0; i < menuids.size(); i++) {
				String menuid = menuids.get(i);
			    authMenuMapper.deleteByPrimaryKey(menuid);
			}
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public AuthMenu selectByPrimaryKey(String menuid) {
		AuthMenu authMenu = authMenuMapper.selectByPrimaryKey(menuid);
		return authMenu;
	}

	@Override
	public ResponseResult update(AuthMenu authMenu) {
		try {
			AuthMenu temp = authMenuMapper.selectByPrimaryKey(authMenu.getMenuid());
			temp.setName(authMenu.getName());
			temp.setMenuPos(authMenu.getMenuPos());
			temp.setHref(authMenu.getHref());
			temp.setIconCls(authMenu.getIconCls());
			temp.setDisplay(authMenu.getDisplay());
			temp.setOrderNum(authMenu.getOrderNum());
			temp.setPid(authMenu.getPid());
			authMenuMapper.updateByPrimaryKey(temp);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, e.getMessage());
		}
	}

	@Override
	public List<AuthMenu> selectListByAuth(String userid,String pid, String menuPos) {
		//查询列表
		List<AuthMenu> list = commonMapper.selectMenuByRole(userid,pid,menuPos);
		return list;
	}

	@Override
	public List<AuthMenu> selectList(AuthMenu authMenu) {
		
		//查询列表
		AuthMenuExample example = new AuthMenuExample();
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(authMenu.getName())){
			criteria.andNameLike("%"+authMenu.getName()+"%");
		}
		List<AuthMenu> list = authMenuMapper.selectByExample(example);
		return list;
	}
	
	/***
	 * 角色授权
	 * @param pid
	 * @param menus
	 * @param level
	 * @return
	 */
	@Override
	public List<EUTreeNode> selectTreeList(String pid,List<AuthRoleMenu> menus, String level) {
		//查询列表
		AuthMenuExample example = new AuthMenuExample();
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(pid)){
			criteria.andPidEqualTo(pid);
		}
		if(AuthMenuVo.LEVEL_TYPE_APPLICATION.equals(level)){
			criteria.andLevelTypeEqualTo(level);
		}
		List<EUTreeNode> nodeList = new ArrayList<EUTreeNode>();
		boolean ischecked = false;
		List<AuthMenu> list = authMenuMapper.selectByExample(example);
		for (AuthMenu authMenu : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(authMenu.getMenuid());
			node.setText(authMenu.getName());
			node.setIconCls(authMenu.getIconCls());
			ischecked = false;
			if(menus != null){
				for (AuthRoleMenu roleMenu : menus) {
					if(roleMenu.getMenuId().equals(node.getId())){
						ischecked = true;
					}
				}
			}
			node.setChecked(ischecked);
			List<EUTreeNode> children = selectTreeList(node.getId(),menus,level);
			if(children != null && children.size() > 0){
				node.setChildren(children);
			}
			nodeList.add(node);
		}
		return nodeList;
	}

	@Override
	public List<AuthMenuVo> selectListByAuth2(String userid, String pid,
			String menuPos) {
		//查询列表
		List<AuthMenuVo> authMenuVoList = new ArrayList<AuthMenuVo>();
		List<AuthMenu> list = commonMapper.selectMenuByRole(userid, pid, menuPos);
		for (AuthMenu authMenu : list) {
			AuthMenuVo authMenuVo = new AuthMenuVo();
			authMenuVo.setMenuid(authMenu.getMenuid());
			authMenuVo.setName(authMenu.getName());
			authMenuVo.setMenuPos(authMenu.getMenuPos());
			authMenuVo.setHref(authMenu.getHref());
			authMenuVo.setIconCls(authMenu.getIconCls());
			authMenuVo.setDisplay(authMenu.getDisplay());
			authMenuVo.setOrderNum(authMenu.getOrderNum());
			authMenuVo.setPid(authMenu.getPid());
			List<AuthMenuVo> children = selectListByAuth2(userid,authMenuVo.getMenuid(),menuPos);
			if(children != null && children.size() > 0){
				authMenuVo.setChildren(children);
			}
			authMenuVoList.add(authMenuVo);
		}
		return authMenuVoList;
	}

	/***
	 * 管理菜单树
	 */
	@Override
	public List<AuthMenuVo> selectTreeList(String pid) {
		//查询列表
		List<AuthMenuVo> authMenuVoList = new ArrayList<AuthMenuVo>();
		AuthMenuExample example = new AuthMenuExample();
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(pid)){
			criteria.andPidEqualTo(pid);
		}
		List<AuthMenu> list = authMenuMapper.selectByExample(example);
		for (AuthMenu authMenu : list) {
			AuthMenuVo authMenuVo = new AuthMenuVo();
			authMenuVo.setMenuid(authMenu.getMenuid());
			authMenuVo.setName(authMenu.getName());
			authMenuVo.setMenuPos(authMenu.getMenuPos());
			authMenuVo.setHref(authMenu.getHref());
			authMenuVo.setIconCls(authMenu.getIconCls());
			authMenuVo.setDisplay(authMenu.getDisplay());
			authMenuVo.setOrderNum(authMenu.getOrderNum());
			authMenuVo.setPid(authMenu.getPid());
			List<AuthMenuVo> children = selectTreeList(authMenu.getMenuid());
			if(children != null && children.size() > 0){
				authMenuVo.setChildren(children);
			}
			authMenuVoList.add(authMenuVo);
		}
		return authMenuVoList;
	}


	@Override
	public List<AuthMenu> selectList() {
		return authMenuMapper.selectByExample(new AuthMenuExample());
	}

	@Override
	public int insertMenu(AuthMenu authMenu) {
		return authMenuMapper.insert(authMenu);
	}

}