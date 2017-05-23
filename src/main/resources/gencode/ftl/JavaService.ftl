package ${model.serviceTargetPackage};

import java.util.List;
<#if model.gentype == "DataGrid">
import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
<#elseif model.gentype == "TreeGrid">
import com.team.platform.vo.${model.domainObjectName}Vo;
</#if>
import com.team.common.pojo.ResponseResult;
import ${model.pojoTargetPackage}.${model.domainObjectName};

/**
 * Created by Administrator on 2017/02/27
 */
public interface ${model.domainObjectName}Service {

<#if model.gentype == "DataGrid">
	public EUDataGridResult selectList(EUDataGridModel dgm,${model.domainObjectName} ${model.variableName});
<#elseif model.gentype == "TreeGrid">
	public List<${model.domainObjectName}Vo> selectList(String ${model.parentField});
</#if>
	
	public ${model.domainObjectName} selectByPrimaryKey(${model.primaryKey});

	public ResponseResult insert(${model.domainObjectName} ${model.variableName});

	public ResponseResult delete(${model.batchServiceParam});

	public ResponseResult update(${model.domainObjectName} ${model.variableName});
	
}