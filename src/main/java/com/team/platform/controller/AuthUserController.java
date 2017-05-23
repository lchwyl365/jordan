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
import com.team.platform.pojo.AuthUser;
import com.team.platform.service.AuthUserService;

@Controller
@RequestMapping("/platform/user")
public class AuthUserController {

	private static final Logger logger = Logger.getLogger(AuthUserController.class);
	
	@Autowired
	private AuthUserService authUserService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		logger.info("AuthUserController list");
    	return "user/list";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add() throws Exception{
    	return "user/add";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult add(AuthUser user) throws Exception{
		ResponseResult result = authUserService.insert(user);
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult delete(@RequestParam List<String> userid)throws Exception{
		ResponseResult result = authUserService.delete(userid);
		return result;
	}
	
	@RequestMapping(value = "/update/{userid}",method = RequestMethod.GET)
    public String update(@PathVariable String userid,Model model) throws Exception{
		//AuthUser authUser = authUserService.selectByPrimaryKey(userid);
		model.addAttribute("userid", userid);
    	return "user/update";
    }
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
    public ResponseResult update(AuthUser authUser) throws Exception{
		ResponseResult result = authUserService.update(authUser);
		return result;
    }
	
	@RequestMapping(value = "/queryList",method = RequestMethod.POST)
	@ResponseBody
    public EUDataGridResult queryList(EUDataGridModel dgm,AuthUser user) throws Exception{
		EUDataGridResult result = authUserService.selectList(dgm, user);
    	return result;
    }
	
	@RequestMapping(value="/load/{userid}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult load(@PathVariable String userid) {
		AuthUser authUser = authUserService.selectByPrimaryKey(userid);
		return new ResponseResult(authUser);
	}
	
}