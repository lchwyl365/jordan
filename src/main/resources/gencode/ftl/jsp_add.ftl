<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${model.menuName}添加</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center,border:false'">
			<form id="contentAddForm" method="post">
				<table class="easyui-panel form-table">
			<#list model.addPropertys as property>
				<#if property_index % 2 == 0>
				   <tr>
						<td class="form-table-td-left">
							<label for="${property.propertyName}">${property.propertyTitle}:</label>
						</td>
						<td class="form-table-td-right">
							<#if property.component == 'easyui-validatebox'>
								<input class="easyui-validatebox" type="text" name="${property.propertyName}" data-options="${property.dataOptions}" />
							<#elseif property.component == 'easyui-switchbutton'>
								<input class="easyui-switchbutton" name="${property.propertyName}" data-options="${property.dataOptions}">
							<#elseif property.component == 'easyui-combotree'>
								<input class="easyui-combotree" name="${property.propertyName}"
								   data-options="url:'${r"${contextPath}"}/platform/box/combotree?id=${property.comboid}',method:'get'" style="width:100%">
							</#if>
						</td>
				<#else>
					    <td class="form-table-td-left">
							<label for="${property.propertyName}">${property.propertyTitle}:</label>
						</td>
						<td class="form-table-td-right">
							<#if property.component == 'easyui-validatebox'>
								<input class="easyui-validatebox" type="text" name="${property.propertyName}" data-options="${property.dataOptions}" />
							<#elseif property.component == 'easyui-switchbutton'>
								<input class="easyui-switchbutton" name="${property.propertyName}" data-options="${property.dataOptions}">
							<#elseif property.component == 'easyui-combotree'>
								<input class="easyui-combotree" name="${property.propertyName}"
								   data-options="url:'${r"${contextPath}"}/platform/box/combotree?id=${property.comboid}',method:'get'" style="width:100%">
							</#if>
						</td>
				    </tr>
				</#if>
			</#list>
			     <#if model.addPropertys?size % 2 != 0>
			     		<td class="form-table-td-left">
							<label></label>
						</td>
						<td class="form-table-td-right">
						</td>
			     	</tr>
			     </#if>
				</table>
			</form>
		</div>
		<div data-options="region:'south',border:false" style="text-align:right;padding:10px 10px;">
			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="contentAddPage.submitForm()" style="width:80px">提交</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="contentAddPage.clearForm()" style="width:80px">关闭</a>
		</div>
	</div>
<script type="text/javascript">
$(function(){
	$('#contentAddForm').form('clear');
});
var contentAddPage  = {
	submitForm : function (){
		if(!$('#contentAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("${r"${contextPath}"}/${model.businessName}/${model.path}/add",$("#contentAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增成功!');
				<#if model.gentype == "DataGrid">
				$("#${model.path}Table").datagrid("reload");
				<#elseif model.gentype == "TreeGrid">
				$("#${model.path}Table").treegrid("reload");
				</#if>
				TT.closeCurrentWindow();
			}else{
				$.messager.alert('添加错误',data.msg,'error');
			}
		});
	},
	clearForm : function(){
		TT.closeCurrentWindow();
	}
};
</script>
</body>
</html>