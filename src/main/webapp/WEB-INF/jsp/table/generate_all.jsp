<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>代码生成</title>
</head>
<body style="margin:0px;padding:0px;background-color:#F3F3F3;">
	<div id="code-content" class="easyui-layout" fit="true" style="overflow-y: hidden;"  scroll="no">
		<div region="north" split="false" border="false" style="height:74px;background-color:#FAFAFA;">
	    	<form id="contentAddForm" method="post" style="margin-bottom:0px;">
	    		<input type="hidden" name="type"/>
				<input type="hidden" name="mapperTargetPackage"/>
				<input type="hidden" name="schemaName"/>
				<input type="hidden" name="tableName"/>
				<table class="search-table">
					<tr>
						<td class="search-table-four-td-left">
							<label for="username">表名:</label>
						</td>
						<td class="search-table-four-td-right">
							<label id="tableName">${tableName}</label>
						</td>
						<td class="search-table-four-td-left">
							<label for="password">Java类名:</label>
						</td>
						<td class="search-table-four-td-right">
							<input class="easyui-textbox" type="text" name="domainObjectName" data-options="required:true" style="width:128px;"></input>
						</td>
						<td class="search-table-four-td-left">
							<label for="username">菜单名:</label>
						</td>
						<td class="search-table-four-td-right">
							<input class="easyui-textbox" type="text" name="menuName" data-options="required:true" style="width:128px;"></input>
						</td>
						<td class="search-table-four-td-left">
							<label for="username">访问路径:</label>
						</td>
						<td class="search-table-four-td-right">
							<input class="easyui-textbox" type="text" name="path" data-options="required:true" style="width:128px;"></input>
						</td>
						<td class="search-table-four-td-left">&nbsp;</td>
						<td class="search-table-four-td-right">&nbsp;</td>
					</tr>
					<tr>
						<td class="search-table-four-td-left">
							<label for="status">业务包名:</label>
						</td>
						<td class="search-table-four-td-right">
							<input class="easyui-textbox" type="text" name="businessName" data-options="required:true" style="width:128px;"></input>
						</td>
						<td class="search-table-four-td-left">
							<label for="status">主界面模型:</label>
						</td>
						<td class="search-table-four-td-right">
			                <select id="gentype" class="easyui-combobox" name="gentype" data-options="panelHeight:'auto',editable:false" style="width:100%;">
				                <option value="DataGrid">DataGrid</option>
				                <option value="TreeGrid">TreeGrid</option>
			                </select>
						</td>
						<td class="search-table-four-td-left">
							<label id="parentField_label" style="visibility:hidden">父类字段:</label>
						</td>
						<td class="search-table-four-td-right">
							<div id="parentField_div" style="visibility:hidden">
				                <select id="parentField" class="easyui-combobox" name="parentField" data-options="panelHeight:'auto',editable:false" style="width:100%;">
					                <c:forEach items="${columns}" var="column">
					                	<option value="${column.propertyName}">${column.propertyName}</option>
					                </c:forEach>
				                </select>
			                </div>
						</td>
						<td class="search-table-four-td-left">
							<label id="treeField_label" style="visibility:hidden">treeField:</label>
						</td>
						<td class="search-table-four-td-right">
							<div id="treeField_div" style="visibility:hidden">
				                <select id="treeField" class="easyui-combobox" name="treeField" data-options="panelHeight:'auto',editable:false" style="width:100%;">
					                <c:forEach items="${columns}" var="column">
					                	<option value="${column.propertyName}">${column.propertyName}</option>
					                </c:forEach>
				                </select>
			                </div>
						</td>
						<td colspan="2" style="padding-left:30px;">
							<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="contentAddPage.submitForm()" style="width:80px">生成</a>
							<a class="easyui-linkbutton" data-options="iconCls:'icon-back'" href="javascript:void(0)" onclick="contentAddPage.clearForm()" style="width:80px">返回</a>
						</td>
					</tr>
				</table>
	    	</form>
	    </div>
	    <div id="eastPanel" region="east" split="true" title="属性信息" style="width:55%; border-bottom:0px;" id="west">
			<iframe id="property_frame" scrolling="auto" frameborder="0"  src="${contextPath}/platform/tables/property_table/${tableName}/${schemaName}/${type}" style="width:100%;height:100%;"></iframe>	
	    </div>
	    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden; border-left:0px; border-bottom:0px;">
	        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
				<div title="主页面预览" id="homeTab">
					<iframe id="preview_table" scrolling="auto" frameborder="0"  src="${contextPath}/platform/tables/preview_table/${tableName}/${schemaName}/${type}" style="width:100%;height:100%;"></iframe>
				</div>
				<div title="添加页面预览">
					<iframe id="preview_add" scrolling="auto" frameborder="0"  src="${contextPath}/platform/tables/preview_add/${tableName}/${schemaName}/${type}" style="width:100%;height:100%;"></iframe>
				</div>
				<div title="修改页面预览">
					<iframe id="preview_update" scrolling="auto" frameborder="0"  src="${contextPath}/platform/tables/preview_update/${tableName}/${schemaName}/${type}" style="width:100%;height:100%;"></iframe>
				</div>
			</div>
	    </div>
	</div>
<script type="text/javascript">
var contentAddPage  = {
		initFormData:function(){
			$.get("${contextPath}/platform/tables/load/${tableName}/${schemaName}/${type}",function(data){
				if(data.status == 200){
					$("#contentAddForm").form("load",data.data);
				}
			});
			$('#gentype').combobox({
		          onChange: function (newValue, oldValue) {  
		             if(newValue == 'TreeGrid'){
		            	 $("#parentField_label").css("visibility","visible");
		            	 $("#parentField_div").css("visibility","visible");
		            	 $("#treeField_label").css("visibility","visible");
		            	 $("#treeField_div").css("visibility","visible");
		             }else{
		            	 $("#parentField_label").css("visibility","hidden");
		            	 $("#parentField_div").css("visibility","hidden");
		            	 $("#treeField_label").css("visibility","hidden");
		            	 $("#treeField_div").css("visibility","hidden");
		             }
		          }  
		    });
		},
		submitForm : function (){
			if(!$('#contentAddForm').form('validate')){
				$.messager.alert('提示','表单还未填写完成!');
				return ;
			}
			var win = $.messager.progress({
                title:'Please waiting',
                msg:'Loading data...'
            });
			$.post("${contextPath}/platform/tables/generate",$("#contentAddForm").serialize(), function(data){
				if(data.status == 200){
					$.messager.progress('close');
					$.messager.alert('提示','生成代码成功!');
					$("#sysTable").datagrid("reload");
					//TT.closeCurrentWindow();
				}
			});
		},
		clearForm : function(){
			//TT.closeCurrentWindow();
			window.self.location="${contextPath}/platform/tables/list";
		}
};
$(function(){
	contentAddPage.initFormData();
	$('#tabs').tabs({
	    onSelect:function(title){
	        if('主页面预览' == title){
				$('#property_frame').attr('src', "${contextPath}/platform/tables/property_table/${tableName}/${schemaName}/${type}");
	        }
			if('添加页面预览' == title){
				$('#property_frame').attr('src', "${contextPath}/platform/tables/property_add/${tableName}/${schemaName}/${type}");
	        }
			if('修改页面预览' == title){
				$('#property_frame').attr('src', "${contextPath}/platform/tables/property_update/${tableName}/${schemaName}/${type}");
	        }
	    }
	});
});
</script>
</body>
</html>