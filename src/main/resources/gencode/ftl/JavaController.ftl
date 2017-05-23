package ${model.controllerTargetPackage};

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

<#if model.gentype == "DataGrid">
import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
<#elseif model.gentype == "TreeGrid">
import com.team.platform.vo.${model.domainObjectName}Vo;
</#if>

import com.team.common.pojo.ResponseResult;
import ${model.pojoTargetPackage}.${model.domainObjectName};
import ${model.serviceTargetPackage}.${model.domainObjectName}Service;
<#if model.useCombo == true>
import com.team.platform.service.SysComboBoxService;
</#if>

@Controller
@RequestMapping("/${model.businessName}/${model.path}")
public class ${model.domainObjectName}Controller {

	private static final Logger logger = Logger.getLogger(${model.domainObjectName}Controller.class);
	
	@Autowired
	private ${model.domainObjectName}Service ${model.variableName}Service;
	
	<#if model.useCombo == true>
	@Autowired
	private SysComboBoxService sysComboBoxService;
	</#if>
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		
	<#list model.propertys as property>
	  <#if property.component == 'easyui-combotree' && property.comboid?? >
	  	String combo${property_index}_json = sysComboBoxService.selectComboid("${property.comboid}");
		model.addAttribute("combo${property_index}_json", combo${property_index}_json);
      </#if>
	</#list>	
    	return "${model.path}/list";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add() throws Exception{
    	return "${model.path}/add";
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult add(${model.domainObjectName} ${model.variableName}) throws Exception{
		ResponseResult result = ${model.variableName}Service.insert(${model.variableName});
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult delete(${model.requestParam})throws Exception{
		ResponseResult result = ${model.variableName}Service.delete(${model.callRequestParam});
		return result;
	}
	
	@RequestMapping(value = "/update${model.pathPrimaryKeyURL}",method = RequestMethod.GET)
    public String update(${model.pathVariable},Model model) throws Exception{
	<#list model.propertys as property>
	  <#if property.isprimary == "T">
	  	model.addAttribute("${property.propertyName}", ${property.propertyName});
      </#if>
	</#list>
    	return "${model.path}/update";
    }
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
    public ResponseResult update(${model.domainObjectName} ${model.variableName}) throws Exception{
		ResponseResult result = ${model.variableName}Service.update(${model.variableName});
		return result;
    }
	
<#if model.gentype == "DataGrid">
	@RequestMapping(value = "/queryList",method = RequestMethod.POST)
	@ResponseBody
    public EUDataGridResult queryList(EUDataGridModel dgm,${model.domainObjectName} ${model.variableName}) throws Exception{
		EUDataGridResult result = ${model.variableName}Service.selectList(dgm, ${model.variableName});
    	return result;
    }
<#elseif model.gentype == "TreeGrid">
	@RequestMapping(value = "/queryList/{${model.parentField}}")
	@ResponseBody
    public List<${model.domainObjectName}Vo> queryList(@PathVariable String ${model.parentField}) throws Exception{
		List<${model.domainObjectName}Vo> list = ${model.variableName}Service.selectList(${model.parentField});
    	return list;
    }
</#if>

	@RequestMapping(value="/load${model.pathPrimaryKeyURL}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult load(${model.pathVariable}) {
		${model.domainObjectName} ${model.variableName} = ${model.variableName}Service.selectByPrimaryKey(${model.callPathVariable});
		return new ResponseResult(${model.variableName});
	}
	
}