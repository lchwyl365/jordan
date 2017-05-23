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

import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.AuthRole;
import com.team.platform.pojo.AuthUser;
import com.team.platform.service.AuthRoleMenuService;
import com.team.platform.service.AuthRoleService;
import com.team.platform.service.AuthUserRoleService;
import com.team.platform.service.AuthUserService;
import com.team.platform.service.SysComboBoxService;

@Controller
@RequestMapping("/platform/role")
public class AuthRoleController {

	private static final Logger logger = Logger.getLogger(AuthRoleController.class);
	
	@Autowired
	private AuthRoleService authRoleService;
	
	@Autowired
	private AuthRoleMenuService authRoleMenuService;
	
	@Autowired
	private SysComboBoxService sysComboBoxService;
	
	@Autowired
	private AuthUserService authUserService;
	
	@Autowired
	private AuthUserRoleService authUserRoleService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		
	  	String combo2_json = sysComboBoxService.selectComboid("50596844418116");
		model.addAttribute("combo2_json", combo2_json);
    	return "role/list";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add() throws Exception{
    	return "role/add";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult add(AuthRole authRole) throws Exception{
		ResponseResult result = authRoleService.insert(authRole);
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult delete(@RequestParam List<String> roleids)throws Exception{
		ResponseResult result = authRoleService.delete(roleids);
		return result;
	}
	
	@RequestMapping(value = "/update/{roleid}",method = RequestMethod.GET)
    public String update(@PathVariable String roleid,Model model) throws Exception{
	  	model.addAttribute("roleid", roleid);
    	return "role/update";
    }
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
    public ResponseResult update(AuthRole authRole) throws Exception{
		ResponseResult result = authRoleService.update(authRole);
		return result;
    }
	
	@RequestMapping(value = "/queryList",method = RequestMethod.POST)
	@ResponseBody
    public EUDataGridResult queryList(EUDataGridModel dgm,AuthRole authRole) throws Exception{
		EUDataGridResult result = authRoleService.selectList(dgm, authRole);
    	return result;
    }

	@RequestMapping(value="/load/{roleid}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult load(@PathVariable String roleid) {
		AuthRole authRole = authRoleService.selectByPrimaryKey(roleid);
		return new ResponseResult(authRole);
	}
	
	@RequestMapping(value="/auth",method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult auth(@RequestParam String roleid,@RequestParam List<String> menuids)throws Exception{
		ResponseResult result = authRoleMenuService.insertBatch(roleid,menuids);
		return result;
	}
	
	@RequestMapping(value = "/userlist",method = RequestMethod.GET)
    public String userlist(@RequestParam String roleid,Model model) throws Exception{
		model.addAttribute("roleid", roleid);
    	return "role/userlist";
    }
	
	@RequestMapping(value = "/queryUserList",method = RequestMethod.POST)
	@ResponseBody
    public EUDataGridResult queryUserList(@RequestParam String roleid,EUDataGridModel dgm,AuthUser user) throws Exception{
		EUDataGridResult result = authUserService.selectListByRole(dgm, user,roleid);
    	return result;
    }
	
	@RequestMapping(value = "/auth_user",method = RequestMethod.GET)
    public String authUser(@RequestParam String roleid,Model model) throws Exception{
		model.addAttribute("roleid", roleid);
    	return "role/auth_user";
    }
	
	@RequestMapping(value = "/auth_user",method = RequestMethod.POST)
	@ResponseBody
    public ResponseResult authUser(@RequestParam String roleid,@RequestParam String[] userids) throws Exception{
		ResponseResult result = authUserRoleService.insert(roleid,userids);
    	return result;
    }
	
	@RequestMapping(value = "/delete_role",method = RequestMethod.POST)
	@ResponseBody
    public ResponseResult deleteRole(@RequestParam String roleid,@RequestParam String[] userids) throws Exception{
		ResponseResult result = authUserRoleService.deleteRole(roleid,userids);
    	return result;
    }
	
}