package com.team.platform.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.ResponseResult;
import com.team.platform.pojo.Columns;
import com.team.platform.pojo.SysColumns;
import com.team.platform.pojo.SysTables;
import com.team.platform.service.DB2SysColumnService;
import com.team.platform.service.DB2TabConstService;
import com.team.platform.service.SysColumnsService;
import com.team.platform.service.SysComboBoxService;
import com.team.platform.service.SysTablesService;

@Controller
@RequestMapping("/platform/tables")
public class SysTablesController {

	private static final Logger logger = Logger.getLogger(SysTablesController.class);
	
	@Autowired
	private SysTablesService sysTablesService;
	@Autowired
	private SysColumnsService sysColumnsService;
	@Autowired
	private SysComboBoxService sysComboBoxService;
	@Autowired
	private DB2SysColumnService db2SysColumnService;
	@Autowired
	private DB2TabConstService db2TabConstService;
	@Value("${SCHEMA}")
	private String SCHEMA;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		logger.info("SysTablesController list");
    	return "table/list";
    }
	
	@RequestMapping(value = "/datagrid_edit",method = RequestMethod.GET)
    public String datagrid_edit(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
    	return "table/datagrid_edit";
    }
	
	@RequestMapping(value = "/generate/{tableName}/{schemaName}/{type}",method = RequestMethod.GET)
    public String generate(@PathVariable String tableName,@PathVariable String schemaName,@PathVariable String type,Model model) throws Exception{
		model.addAttribute("tableName", tableName);
		model.addAttribute("schemaName", schemaName);
		model.addAttribute("type", type);
		
		SysColumns sysColumns = new SysColumns();
		sysColumns.setTbcreator(schemaName);
		sysColumns.setTbname(tableName);
		List<SysColumns> columns = sysColumnsService.selectByExample(sysColumns);
		model.addAttribute("columns", columns);
		
    	return "table/generate";
    }
	
	@RequestMapping(value = "/generate_all/{tableName}/{schemaName}/{type}",method = RequestMethod.GET)
    public String generate_all(@PathVariable String tableName,@PathVariable String schemaName,@PathVariable String type,Model model) throws Exception{
		model.addAttribute("tableName", tableName);
		model.addAttribute("schemaName", schemaName);
		model.addAttribute("type", type);
		
		SysColumns sysColumns = new SysColumns();
		sysColumns.setTbcreator(schemaName);
		sysColumns.setTbname(tableName);
		List<SysColumns> columns = sysColumnsService.selectByExample(sysColumns);
		model.addAttribute("columns", columns);
		
    	return "table/generate_all";
    }
	
	@RequestMapping(value = "/generate",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult generate(SysTables sysTables) throws Exception{
		
		sysTables.setGenerate("T");
		sysTables.setGtime(new Date());
		ResponseResult result = sysTablesService.update(sysTables);
		if(ResponseResult.SUCCESS.equals(result.getStatus())){
			SysColumns sysColumns = new SysColumns();
			sysColumns.setTbcreator(sysTables.getSchemaName());
			sysColumns.setTbname(sysTables.getTableName());
			List<SysColumns> sysColumnsList = sysColumnsService.selectByExample(sysColumns);
			
			sysTables = sysTablesService.selectByPrimaryKey(sysTables.getTableName(), sysTables.getSchemaName(), sysTables.getType());
			
			ResponseResult temp = sysTablesService.generateAll(sysTables,sysColumnsList);
			return temp;
		}else{
			return result;
		}
    }
	
	@RequestMapping(value = "/generate_java/{tableName}/{schemaName}/{type}",method = RequestMethod.GET)
    public String generate_java(@PathVariable String tableName,@PathVariable String schemaName,@PathVariable String type,Model model) throws Exception{
		model.addAttribute("tableName", tableName);
		model.addAttribute("schemaName", schemaName);
		model.addAttribute("type", type);
    	return "table/generate_java";
    }
	
	@RequestMapping(value = "/generate_java",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult generate_java(SysTables sysTables) throws Exception{
		
		sysTables.setGenerate("T");
		sysTables.setGentype("java");
		sysTables.setGtime(new Date());
		ResponseResult result = sysTablesService.update(sysTables);
		if(ResponseResult.SUCCESS.equals(result.getStatus())){
			SysColumns sysColumns = new SysColumns();
			sysColumns.setTbcreator(sysTables.getSchemaName());
			sysColumns.setTbname(sysTables.getTableName());
			List<SysColumns> sysColumnsList = sysColumnsService.selectByExample(sysColumns);
			sysTables = sysTablesService.selectByPrimaryKey(sysTables.getTableName(), sysTables.getSchemaName(), sysTables.getType());
			ResponseResult temp = sysTablesService.generateJava(sysTables, sysColumnsList);
			return temp;
		}else{
			return result;
		}
    }
	
	@RequestMapping(value = "/generate_mapper/{tableName}/{schemaName}/{type}",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult generate_mapper(@PathVariable String tableName,@PathVariable String schemaName,@PathVariable String type) throws Exception{
		SysTables sysTables = sysTablesService.selectByPrimaryKey(tableName, schemaName, type);
		SysColumns sysColumns = new SysColumns();
		sysColumns.setTbcreator(sysTables.getSchemaName());
		sysColumns.setTbname(sysTables.getTableName());
		List<SysColumns> sysColumnsList = sysColumnsService.selectByExample(sysColumns);
		ResponseResult result = sysTablesService.generateMapper(sysTables, sysColumnsList);
		return result;
	}
	
	@RequestMapping(value = "/preview_table/{tableName}/{schemaName}/{type}")
	public String preview_table(@PathVariable String tableName,@PathVariable String schemaName,@PathVariable String type,Model model){
		
		SysTables sysTables = sysTablesService.selectByPrimaryKey(tableName,schemaName,type);

		List<SysColumns> displayPropertys = new ArrayList<SysColumns>();
		List<SysColumns> selectPropertys = new ArrayList<SysColumns>();
		SysColumns temp = new SysColumns();
		temp.setTbcreator(schemaName);
		temp.setTbname(tableName);
		List<SysColumns> propertys = sysColumnsService.selectByExample(temp);
		for (SysColumns sysColumns : propertys) {
			if("T".equals(sysColumns.getIsdisplay())){
				displayPropertys.add(sysColumns);
			}
			if("T".equals(sysColumns.getIsselect()) || "T".equals(sysColumns.getIslike())){
				selectPropertys.add(sysColumns);
			}
		}
		model.addAttribute("sysTables",sysTables);
		model.addAttribute("displayPropertys",displayPropertys);
		model.addAttribute("selectPropertys",selectPropertys);
		return "table/preview_table";
	}
	
	@RequestMapping(value = "/preview_add/{tableName}/{schemaName}/{type}")
	public String preview_add(@PathVariable String tableName,@PathVariable String schemaName,@PathVariable String type,Model model){
		
		SysTables sysTables = sysTablesService.selectByPrimaryKey(tableName,schemaName,type);
		SysColumns temp = new SysColumns();
		temp.setTbcreator(schemaName);
		temp.setTbname(tableName);
		temp.setIsadd("T");
		List<SysColumns> addPropertys = sysColumnsService.selectByExample(temp);
		model.addAttribute("sysTables",sysTables);
		model.addAttribute("addPropertys",addPropertys);
		return "table/preview_add";
	}
	
	@RequestMapping(value = "/preview_update/{tableName}/{schemaName}/{type}")
	public String preview_update(@PathVariable String tableName,@PathVariable String schemaName,@PathVariable String type,Model model){
		
		SysTables sysTables = sysTablesService.selectByPrimaryKey(tableName,schemaName,type);
		SysColumns temp = new SysColumns();
		temp.setTbcreator(schemaName);
		temp.setTbname(tableName);
		temp.setIsupdate("T");
		temp.setIsprimary("F");
		List<SysColumns> updatePropertys = sysColumnsService.selectByExample(temp);
		model.addAttribute("sysTables",sysTables);
		model.addAttribute("updatePropertys",updatePropertys);
		return "table/preview_update";
	}
	
	@RequestMapping(value = "/property_table/{tableName}/{schemaName}/{type}")
	public String property_table(@PathVariable String tableName,@PathVariable String schemaName,@PathVariable String type,Model model){
		
		SysTables sysTables = sysTablesService.selectByPrimaryKey(tableName,schemaName,type);
		model.addAttribute("sysTables",sysTables);
		return "table/property_table";
	}
	
	@RequestMapping(value = "/property_add/{tableName}/{schemaName}/{type}")
	public String property_add(@PathVariable String tableName,@PathVariable String schemaName,@PathVariable String type,Model model){
		
		SysTables sysTables = sysTablesService.selectByPrimaryKey(tableName,schemaName,type);
		model.addAttribute("sysTables",sysTables);
		
		String comboid_json = sysComboBoxService.selectComboid("4894876433811319");
		model.addAttribute("comboid_json", comboid_json);
		
		return "table/property_add";
	}
	
	@RequestMapping(value = "/property_update/{tableName}/{schemaName}/{type}")
	public String property_update(@PathVariable String tableName,@PathVariable String schemaName,@PathVariable String type,Model model){
		
		SysTables sysTables = sysTablesService.selectByPrimaryKey(tableName,schemaName,type);
		model.addAttribute("sysTables",sysTables);
		
		String comboid_json = sysComboBoxService.selectComboid("4894876433811319");
		model.addAttribute("comboid_json", comboid_json);
		
		return "table/property_update";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
    public ResponseResult update(SysTables sysTables) throws Exception{
		ResponseResult result = sysTablesService.update(sysTables);
		return result;
    }
	
	@RequestMapping(value = "/update_column",method = RequestMethod.POST)
	@ResponseBody
    public ResponseResult update_column(SysColumns sysColumns) throws Exception{
		
		if("easyui-switchbutton".equals(sysColumns.getComponent())){
			String dataOptions = sysColumns.getDataOptions();
			if(dataOptions.indexOf("onText:") == -1){
				sysColumns.setDataOptions("onText:'开启',offText:'冻结',checked:true");
			}
		}
		if("easyui-validatebox".equals(sysColumns.getComponent())){
			String dataOptions = sysColumns.getDataOptions();
			if(dataOptions.indexOf("validType:") == -1){
				sysColumns.setDataOptions("required:true,validType:['length[0,"+sysColumns.getPropertyLength()+"]']");
			}
		}
		
		ResponseResult result = sysColumnsService.update(sysColumns);
		return result;
    }
	
	@RequestMapping(value = "/queryList",method = RequestMethod.POST)
	@ResponseBody
    public EUDataGridResult queryList(EUDataGridModel dgm,SysTables sysTables) throws Exception{
		
		EUDataGridResult result = sysTablesService.selectList(dgm, sysTables);
    	return result;
    }
	
	@RequestMapping(value = "/queryColumnsList")
	@ResponseBody
    public EUDataGridResult queryColumnsList(EUDataGridModel dgm,SysColumns sysColumns) throws Exception{
	    
		EUDataGridResult result = sysColumnsService.selectList(dgm, sysColumns);
    	return result;
    }
	
	@RequestMapping("/load/{tableName}/{schemaName}/{type}")
	@ResponseBody
	public ResponseResult load(@PathVariable String tableName,@PathVariable String schemaName,@PathVariable String type) {
		SysTables sysTables = sysTablesService.selectByPrimaryKey(tableName,schemaName,type);
		return new ResponseResult(sysTables);
	}
	
	@RequestMapping(value = "/queryTableList")
	@ResponseBody
    public List<SysTables> queryTableList() throws Exception{
		List<SysTables> tables = sysTablesService.selectAll();
    	return tables;
    }
	
	@RequestMapping("/updateColumn")
	@ResponseBody
	public ResponseResult updateColumn(@ModelAttribute SysTables sysTables) {
		try {
			//删除表的字段信息
			if(!"SYS_TABLES".equals(sysTables.getTableName()) && !"SYS_COLUMNS".equals(sysTables.getTableName())){
				SysColumns column = new SysColumns();
				column.setTbcreator(sysTables.getSchemaName());
				column.setTbname(sysTables.getTableName());
				sysColumnsService.delete(column);
			}
			//添加表的字段信息
			List<Columns> columnList = db2SysColumnService.selectByCondition(sysTables.getSchemaName(),sysTables.getTableName());
			sysColumnsService.update(columnList);
			
			//更新表的索引信息
			db2TabConstService.updateTabConst(SCHEMA,sysTables.getTableName());
			
		} catch (Exception e) {
			ResponseResult.build(500, e.getMessage());
		}
		return ResponseResult.ok();
	}
}
