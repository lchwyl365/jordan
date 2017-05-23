<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>代码生成</title>
</head>
<body class="easyui-layout" fit="true" >
			<form id="contentAddForm" method="post" style="height:99px;margin-bottom:5px;" region="north" split="true" border="false" >
				<input type="hidden" name="type"/>
				<input type="hidden" name="mapperTargetPackage"/>
				<table class="easyui-panel form-table">
					<tr>
						<td class="form-table-three-td-left">
							<label for="operatorname">SCHEMA:</label>
						</td>
						<td class="form-table-three-td-right">
							<input class="easyui-validatebox" type="text" name="schemaName" data-options="required:true" style="width:180px;"/>
						</td>
						<td class="form-table-three-td-left">
							<label for="username">表名:</label>
						</td>
						<td class="form-table-three-td-right">
							<input class="easyui-validatebox" type="text" name="tableName" data-options="required:true" style="width:180px;"/>
						</td>
						<td class="form-table-three-td-left">
							<label for="username">菜单名:</label>
						</td>
						<td class="form-table-three-td-right">
							<input class="easyui-validatebox" type="text" name="menuName" data-options="required:true" style="width:180px;"/>
						</td>
					</tr>
					<tr>
						<td class="form-table-three-td-left">
							<label for="password">Java类名:</label>
						</td>
						<td class="form-table-three-td-right">
							<input class="easyui-validatebox" type="text" name="domainObjectName" data-options="required:true" style="width:180px;"/>
						</td>
						<td class="form-table-three-td-left">
							<label for="username">Controller路径:</label>
						</td>
						<td class="form-table-three-td-right">
							<input class="easyui-validatebox" type="text" name="path" data-options="required:true" style="width:180px;"/>
						</td>
						<td class="form-table-three-td-left">
							<label for="status">业务包名:</label>
						</td>
						<td class="form-table-three-td-right">
							<input class="easyui-validatebox" type="text" name="businessName" data-options="required:true" style="width:180px;"/>
						</td>
					</tr>
					<tr>
						<td class="form-table-three-td-left">
							<label for="password">Service包:</label>
						</td>
						<td class="form-table-three-td-right">
							<input class="easyui-validatebox" type="text" name="serviceTargetPackage" data-options="required:true" style="width:180px;"/>
						</td>
						<td class="form-table-three-td-left">
							<label for="status">Controller包:</label>
						</td>
						<td class="form-table-three-td-right">
							<input class="easyui-validatebox" type="text" name="controllerTargetPackage" data-options="required:true" style="width:180px;"/>
						</td>
						<td class="form-table-three-td-left">
							<label for="status">Pojo包:</label>
						</td>
						<td class="form-table-three-td-right">
							<input class="easyui-validatebox" type="text" name="pojoTargetPackage" data-options="required:true" style="width:180px;"/>
						</td>
					</tr>
				</table>
			</form>
			<table id="sysColumnsTable" region="center" style="height:286px;" >
			
			</table>
			
		<div region="south" style="margin-top:5px;text-align:right;" split="false" >
			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="contentAddPage.submitForm()" style="width:80px">生成</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="contentAddPage.clearForm()" style="width:80px">关闭</a>
		</div>
	
<script type="text/javascript">

var contentAddPage  = {
		initFormData:function(){
			$.get("${contextPath}/platform/tables/load/${tableName}/${schemaName}/${type}",function(data){
				if(data.status == 200){
					$("#contentAddForm").form("load",data.data);
				}
			});
		},
		submitForm : function (){
			if(!$('#contentAddForm').form('validate')){
				$.messager.alert('提示','表单还未填写完成!');
				return ;
			}
			$.post("${contextPath}/platform/tables/generate_java",$("#contentAddForm").serialize(), function(data){
				if(data.status == 200){
					$.messager.alert('提示','生成代码成功!');
					$("#sysTable").datagrid("reload");
					TT.closeCurrentWindow();
				}
			});
		},
		clearForm : function(){
			TT.closeCurrentWindow();
		}
};
$(function(){
	contentAddPage.initFormData();
	
	$('#sysColumnsTable').datagrid({
		title:'字段信息列表', //标题
		border:true,
		method:'post',
		iconCls:'icon-table', //图标
		singleSelect:true, //多选
		fit:false, //高度
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped: true, //奇偶行颜色不同
		collapsible:false,//可折叠
		url:"${contextPath}/platform/tables/queryColumnsList?tbname=${tableName}&tbcreator=${schemaName}", //数据来源
		sortName: 'PROPERTY_NAME', //排序的列
		sortOrder: 'desc', //倒序
		remoteSort: true, //服务器端排序
		idField:'propertyName', //主键字段
		queryParams:{}, //查询条件
		pagination:true, //显示分页
		rownumbers:true, //显示行号
		pageSize:30,
		columns:[[
			{field:'COLUMN_NAME',title:'数据库列',width:10,sortable:true,
				formatter:function(value,row,index){return row.columnName;}
			},
			{field:'PROPERTY_NAME',title:'字段',width:20,sortable:true,
				formatter:function(value,row,index){return row.propertyName;},
				editor:{type:'validatebox',options:{required: true}}
			},
			{field:'PROPERTY_TYPE',title:'类型',width:20,sortable:true,
				formatter:function(value,row,index){return row.propertyType;}
			},
			{field:'PROPERTY_TITLE',title:'表格标题',width:20,sortable:true,
				formatter:function(value,row,index){return row.propertyTitle;}
			},
			{field:'ISLIKE',title:'是否进行查询',width:10,sortable:true,
				formatter:function(value,row,index){return row.islike;}
			}
		]]
	});
});
</script>
</body>
</html>