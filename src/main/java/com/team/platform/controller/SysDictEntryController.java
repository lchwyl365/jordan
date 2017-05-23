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
import com.team.platform.pojo.SysDictEntry;
import com.team.platform.service.SysDictEntryService;

@Controller
@RequestMapping("/platform/entry")
public class SysDictEntryController {

	private static final Logger logger = Logger.getLogger(SysDictEntryController.class);
	
	@Autowired
	private SysDictEntryService sysDictEntryService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		
    	return "entry/list";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(@RequestParam String dicttypeid,Model model) throws Exception{
		model.addAttribute("dicttypeid",dicttypeid);
		List<SysDictEntry> entrys = sysDictEntryService.selectByType(dicttypeid);
		int sortno = 1;
		if(entrys.size() > 0){
			sortno = entrys.get(0).getSortno() + 1;
		}
		model.addAttribute("sortno", sortno);
    	return "entry/add";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult add(SysDictEntry sysDictEntry) throws Exception{
		ResponseResult result = sysDictEntryService.insert(sysDictEntry);
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult delete(@RequestParam List<String> dicttypeids,@RequestParam List<String> dictids)throws Exception{
		ResponseResult result = sysDictEntryService.delete(dicttypeids,dictids);
		return result;
	}
	
	@RequestMapping(value = "/update/{dicttypeid}/{dictid}",method = RequestMethod.GET)
    public String update(@PathVariable String dicttypeid,@PathVariable String dictid,Model model) throws Exception{
	  	model.addAttribute("dicttypeid", dicttypeid);
	  	model.addAttribute("dictid", dictid);
    	return "entry/update";
    }
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
    public ResponseResult update(SysDictEntry sysDictEntry) throws Exception{
		ResponseResult result = sysDictEntryService.update(sysDictEntry);
		return result;
    }
	
	@RequestMapping(value = "/queryList",method = RequestMethod.POST)
	@ResponseBody
    public EUDataGridResult queryList(EUDataGridModel dgm,SysDictEntry sysDictEntry) throws Exception{
		EUDataGridResult result = sysDictEntryService.selectList(dgm, sysDictEntry);
    	return result;
    }

	@RequestMapping(value="/load/{dicttypeid}/{dictid}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult load(@PathVariable String dicttypeid,@PathVariable String dictid) {
		SysDictEntry sysDictEntry = sysDictEntryService.selectByPrimaryKey(dicttypeid,dictid);
		return new ResponseResult(sysDictEntry);
	}
	
}