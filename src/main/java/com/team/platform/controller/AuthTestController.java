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
import com.team.platform.pojo.AuthTest;
import com.team.platform.service.AuthTestService;
import com.team.platform.service.SysComboBoxService;

@Controller
@RequestMapping("/platform/test")
public class AuthTestController {

	private static final Logger logger = Logger.getLogger(AuthTestController.class);
	
	@Autowired
	private AuthTestService authTestService;
	
	@Autowired
	private SysComboBoxService sysComboBoxService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		
	  	String combo1_json = sysComboBoxService.selectComboid("4885635448210517");
		model.addAttribute("combo1_json", combo1_json);
    	return "test/list";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add() throws Exception{
    	return "test/add";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult add(AuthTest authTest) throws Exception{
		ResponseResult result = authTestService.insert(authTest);
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult delete(@RequestParam List<String> testids,@RequestParam List<String> groupIds)throws Exception{
		ResponseResult result = authTestService.delete(testids,groupIds);
		return result;
	}
	
	@RequestMapping(value = "/update/{testid}/{groupId}",method = RequestMethod.GET)
    public String update(@PathVariable String testid,@PathVariable String groupId,Model model) throws Exception{
	  	model.addAttribute("testid", testid);
	  	model.addAttribute("groupId", groupId);
    	return "test/update";
    }
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
    public ResponseResult update(AuthTest authTest) throws Exception{
		ResponseResult result = authTestService.update(authTest);
		return result;
    }
	
	@RequestMapping(value = "/queryList",method = RequestMethod.POST)
	@ResponseBody
    public EUDataGridResult queryList(EUDataGridModel dgm,AuthTest authTest) throws Exception{
		EUDataGridResult result = authTestService.selectList(dgm, authTest);
    	return result;
    }

	@RequestMapping(value="/load/{testid}/{groupId}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult load(@PathVariable String testid,@PathVariable String groupId) {
		AuthTest authTest = authTestService.selectByPrimaryKey(testid,groupId);
		return new ResponseResult(authTest);
	}
	
}