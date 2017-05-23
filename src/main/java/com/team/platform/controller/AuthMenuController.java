package com.team.platform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.common.pojo.EUTreeNode;
import com.team.common.pojo.ResponseResult;
import com.team.common.util.CookieUtils;
import com.team.platform.pojo.AuthMenu;
import com.team.platform.pojo.AuthRole;
import com.team.platform.pojo.AuthRoleMenu;
import com.team.platform.pojo.AuthUser;
import com.team.platform.service.AuthMenuService;
import com.team.platform.service.AuthRoleMenuService;
import com.team.platform.service.AuthRoleService;
import com.team.platform.service.AuthUserService;
import com.team.platform.service.SysComboBoxService;
import com.team.platform.vo.AuthMenuVo;

@Controller
@RequestMapping("/platform/menu")
public class AuthMenuController {

	private static final Logger logger = Logger.getLogger(AuthMenuController.class);
	
	@Autowired
	private AuthMenuService authMenuService;
	
	@Autowired
	private SysComboBoxService sysComboBoxService;
	
	@Autowired
	private AuthRoleMenuService authRoleMenuService;
	
	@Autowired
	private AuthRoleService authRoleService;
	
	@Autowired
	private AuthUserService authUserService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		
	  	String combo7_json = sysComboBoxService.selectComboid("4885635448210517");
		model.addAttribute("combo7_json", combo7_json);
    	return "menu/list";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add() throws Exception{
    	return "menu/add";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult add(AuthMenu authMenu) throws Exception{
		ResponseResult result = authMenuService.insert(authMenu);
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult delete(@RequestParam List<String> menuids)throws Exception{
		ResponseResult result = authMenuService.delete(menuids);
		return result;
	}
	
	@RequestMapping(value = "/update/{menuid}",method = RequestMethod.GET)
    public String update(@PathVariable String menuid,Model model) throws Exception{
	  	model.addAttribute("menuid", menuid);
    	return "menu/update";
    }
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
    public ResponseResult update(AuthMenu authMenu) throws Exception{
		ResponseResult result = authMenuService.update(authMenu);
		return result;
    }
	/***
	 * 登录获取菜单
	 * @param request
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryList")
	@ResponseBody
    public List<AuthMenuVo> queryList(HttpServletRequest request,@RequestParam(value="pid",required=false) String pid) throws Exception{
		//从cookie中取token
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		//根据token换取用户信息，调用sso系统的接口。
		AuthUser user = authUserService.getUserByToken(token);
		String pos = "left";
		List<AuthMenuVo> list = authMenuService.selectListByAuth2(user.getUserid(), pid, pos);
    	return list;
    }
	
	/***
	 * 管理菜单
	 * @param request
	 * @param pid
	 * @param level
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryTreeList")
	@ResponseBody
    public List<AuthMenuVo> queryTreeList(HttpServletRequest request,@RequestParam(value="pid",required=false) String pid) throws Exception{
		//从cookie中取token
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		//根据token换取用户信息，调用sso系统的接口。
		AuthUser user = authUserService.getUserByToken(token);
		if(user == null) return null;
		
		List<AuthMenuVo> list = authMenuService.selectTreeList(pid);
    	return list;
    }
	
	/***
	 * 角色授权
	 * @param pid
	 * @param roleid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryMenu")
	@ResponseBody
	public List<EUTreeNode> queryMenu(@RequestParam(value="pid",required=false) String pid,@RequestParam(value="roleid",required=false) String roleid) throws Exception{
		List<AuthRoleMenu> menus = null;
		String level = AuthMenuVo.LEVEL_TYPE_APPLICATION;
		if(roleid != null){
			menus = authRoleMenuService.selectList(roleid);
			AuthRole role = authRoleService.selectByPrimaryKey(roleid);
			if(role != null){
				level = role.getType();
			}
		}
		List<EUTreeNode> list = authMenuService.selectTreeList(pid,menus,level);
		return list;
	}

	@RequestMapping(value="/load/{menuid}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult load(@PathVariable String menuid) {
		AuthMenu authMenu = authMenuService.selectByPrimaryKey(menuid);
		return new ResponseResult(authMenu);
	}
	
}