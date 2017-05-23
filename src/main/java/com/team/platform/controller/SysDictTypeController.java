package com.team.platform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.common.pojo.EUTreeNode;
import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.SysDictType;
import com.team.platform.service.SysDictTypeService;

@Controller
@RequestMapping("/platform/dict")
public class SysDictTypeController {

	@Autowired
	private SysDictTypeService sysDictTypeService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		
    	return "dict/list";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add() throws Exception{
    	return "dict/add";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult add(SysDictType sysDictType) throws Exception{
		ResponseResult result = sysDictTypeService.insert(sysDictType);
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult delete(@RequestParam List<String> dicttypeids)throws Exception{
		ResponseResult result = sysDictTypeService.delete(dicttypeids);
		return result;
	}
	
	@RequestMapping(value = "/update/{dicttypeid}",method = RequestMethod.GET)
    public String update(@PathVariable String dicttypeid,Model model) throws Exception{
	  	model.addAttribute("dicttypeid", dicttypeid);
    	return "dict/update";
    }
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
    public ResponseResult update(SysDictType sysDictType) throws Exception{
		ResponseResult result = sysDictTypeService.update(sysDictType);
		return result;
    }
	
	@RequestMapping(value = "/queryList",method = RequestMethod.GET)
	@ResponseBody
    public List<EUTreeNode> queryList(@ModelAttribute SysDictType sysDictType) throws Exception{
		List<EUTreeNode> list = sysDictTypeService.selectList(sysDictType);
    	return list;
    }

	@RequestMapping(value="/load/{dicttypeid}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult load(@PathVariable String dicttypeid) {
		SysDictType sysDictType = sysDictTypeService.selectByPrimaryKey(dicttypeid);
		return new ResponseResult(sysDictType);
	}
	
}