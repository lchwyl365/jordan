package com.team.platform.controller;

import java.util.ArrayList;
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
import com.team.common.pojo.EUTreeNode;
import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.SysComboBox;
import com.team.platform.pojo.SysDictEntry;
import com.team.platform.service.SysComboBoxService;
import com.team.platform.service.SysDictEntryService;
import com.team.platform.service.SysDictTypeService;

@Controller
@RequestMapping("/platform/box")
public class SysComboBoxController {

	private static final Logger logger = Logger.getLogger(SysComboBoxController.class);
	
	@Autowired
	private SysComboBoxService sysComboBoxService;
	
	@Autowired
	private SysDictTypeService sysDictTypeService;
	
	@Autowired
	private SysDictEntryService sysDictEntryService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		logger.info("SysComboBoxController list");
    	return "box/list";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add() throws Exception{
    	return "box/add";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult add(SysComboBox sysComboBox) throws Exception{
		ResponseResult result = sysComboBoxService.insert(sysComboBox);
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult delete(@RequestParam List<String> comboids)throws Exception{
		ResponseResult result = sysComboBoxService.delete(comboids);
		return result;
	}
	
	@RequestMapping(value = "/update/{comboid}",method = RequestMethod.GET)
    public String update(@PathVariable String comboid,Model model) throws Exception{
	  	model.addAttribute("comboid", comboid);
    	return "box/update";
    }
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
    public ResponseResult update(SysComboBox sysComboBox) throws Exception{
		ResponseResult result = sysComboBoxService.update(sysComboBox);
		return result;
    }
	
	@RequestMapping(value = "/queryList",method = RequestMethod.POST)
	@ResponseBody
    public EUDataGridResult queryList(EUDataGridModel dgm,SysComboBox sysComboBox) throws Exception{
		EUDataGridResult result = sysComboBoxService.selectList(dgm, sysComboBox);
    	return result;
    }

	@RequestMapping(value="/load/{comboid}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult load(@PathVariable String comboid) {
		SysComboBox sysComboBox = sysComboBoxService.selectByPrimaryKey(comboid);
		return new ResponseResult(sysComboBox);
	}

	@RequestMapping(value="/combotree",method = RequestMethod.GET)
	@ResponseBody
	public List<EUTreeNode> combotree(@RequestParam(value="id",required=false)  String id) {
		
		List<EUTreeNode> list = sysComboBoxService.combotree(id);
		if(list == null){
			List<SysDictEntry> entrys = sysDictEntryService.selectByType(id);
			if(entrys.size() > 0){
				list = new ArrayList<EUTreeNode>();
				for (SysDictEntry sysDictEntry : entrys) {
					EUTreeNode treeNode = new EUTreeNode();
					treeNode.setId(sysDictEntry.getDictid());
					treeNode.setText(sysDictEntry.getDictname());
					list.add(treeNode);
				}
			}
		}
		return list;
	}
	
	@RequestMapping(value = "/queryAll",method = RequestMethod.POST)
	@ResponseBody
    public List<SysComboBox> queryAll() throws Exception{
		List<SysComboBox> list = sysComboBoxService.selectAll();
		List<EUTreeNode> typeList = sysDictTypeService.selectList(null);
		for (EUTreeNode euTreeNode : typeList) {
			SysComboBox temp = new SysComboBox();
			temp.setComboid(euTreeNode.getId());
			temp.setName(euTreeNode.getText());
			list.add(temp);
		}
    	return list;
    }
	
}