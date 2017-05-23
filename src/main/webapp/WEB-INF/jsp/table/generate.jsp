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
							<input class="easyui-validatebox" type="text" name="schemaName" data-options="required:true,readonly:true" style="width:180px;"/>
						</td>
						<td class="form-table-three-td-left">
							<label for="username">表名:</label>
						</td>
						<td class="form-table-three-td-right">
							<input class="easyui-validatebox" type="text" name="tableName" data-options="required:true,readonly:true" style="width:180px;"/>
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
							<label for="username">访问路径:</label>
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
							<input class="easyui-validatebox" type="text" name="serviceTargetPackage" data-options="required:true,readonly:true" style="width:180px;"/>
						</td>
						<td class="form-table-three-td-left">
							<label for="status">Controller包:</label>
						</td>
						<td class="form-table-three-td-right">
							<input class="easyui-validatebox" type="text" name="controllerTargetPackage" data-options="required:true,readonly:true" style="width:180px;"/>
						</td>
						<td class="form-table-three-td-left">
							<label for="status">Pojo包:</label>
						</td>
						<td class="form-table-three-td-right">
							<input class="easyui-validatebox" type="text" name="pojoTargetPackage" data-options="required:true,readonly:true" style="width:180px;"/>
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
			var win = $.messager.progress({
                title:'Please waiting',
                msg:'Loading data...'
            });
			$.post("${contextPath}/platform/tables/generate",$("#contentAddForm").serialize(), function(data){
				if(data.status == 200){
					$.messager.progress('close');
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

/* 
 * 复选框数据
  var products = [
    {productid:'String',name:'String'},
	{productid:'Integer',name:'Integer'},
	{productid:'Date',name:'Date'},
	{productid:'RP-LI-02',name:'Iguana'},
	{productid:'FL-DSH-01',name:'Manx'},
	{productid:'FL-DLH-02',name:'Persian'},
	{productid:'AV-CB-01',name:'Amazon Parrot'}
]; */

$(function(){
	contentAddPage.initFormData();
	
	$('#sysColumnsTable').datagrid({
		title:'字段信息列表', //标题
		iconCls:'icon-table', //图标
		singleSelect:true, //多选
		idField:'propertyName', //主键字段
		fit:false, //高度
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		url:"${contextPath}/platform/tables/queryColumnsList?tbname=${tableName}&tbcreator=${schemaName}", //数据来源
		sortName: 'COLNO', //排序的列
		sortOrder: 'asc', //倒序
		remoteSort: true, //服务器端排序
		idField:'propertyName', //主键字段
		queryParams:{}, //查询条件
		pagination:true, //显示分页
		rownumbers:true, //显示行号
		pageSize:20,
		columns:[[
			{field:'columnName',title:'数据库列',width:20,sortable:true,
				formatter:function(value,row,index){return row.columnName;}
			},
			{field:'propertyName',title:'字段',width:20,sortable:true,
				formatter:function(value,row,index){return row.propertyName;}
			},
			{field:'propertyType',title:'类型',width:12,sortable:true,
				formatter:function(value,row){return row.propertyType;}
			},
			/* 复选框编辑
			   {field:'propertyType',title:'类型',width:10,sortable:true,
				formatter:function(value,row){return row.propertyType || value;},
				editor:{
					type:'combobox',
					options:{
						valueField:'productid',
						textField:'name',
						data:products,
						required:true
					}
				}
			}, */
			{field:'propertyTitle',title:'字段标题',width:25,sortable:true,editor:'textbox',
				formatter:function(value,row,index){return row.propertyTitle;}
			},
			{field:'isselect',title:'精确查询',width:15,
				formatter:function(value,row,index){return row.isselect;},
				editor:{
					type:'checkbox',
					options:{
						on: 'T',
						off: 'F'
					}
				}
			},
			{field:'islike',title:'模糊查询',width:15,
				formatter:function(value,row){return row.islike || value;},
				editor:{
					type:'checkbox',
					options:{
						on: 'T',
						off: 'F'
					}
				}
			},
			{field:'isdisplay',title:'表格中显示',width:15,
				formatter:function(value,row){return row.isdisplay;},
				editor:{
					type:'checkbox',
					options:{
						on: 'T',
						off: 'F'
					}
				}
			},
			{field:'isadd',title:'添加时显示',width:15,
				formatter:function(value,row){return row.isadd;},
				editor:{
					type:'checkbox',
					options:{
						on: 'T',
						off: 'F'
					}
				}
			},
			{field:'isupdate',title:'修改时显示',width:15,
				formatter:function(value,row){return row.isupdate;},
				editor:{
					type:'checkbox',
					options:{
						on: 'T',
						off: 'F'
					}
				}
			},
			{field:'action',title:'操作',width:20,align:'center',
				formatter:function(value,row,index){
					if (row.editing){
						var s = '<a href="javascript:void(0)" onclick="saverow(this)">保存</a> ';
						var c = '<a href="javascript:void(0)" onclick="cancelrow(this)">取消</a>';
						return s+c;
					} else {
						var e = '<a href="javascript:void(0)" onclick="editrow(this)">编辑</a> ';
						return e;
					}
				}
			}
		]],
		onEndEdit:function(index,row){
			/* 复选框选中
			var ed = $("#sysColumnsTable").datagrid('getEditor', {
				index: index,
				field: 'productid'
			});
			row.propertyType = $(ed.target).combobox('getText'); */
			
			console.log("onEndEdit");
		},
		onBeforeEdit:function(index,row){
			row.editing = true;
			$(this).datagrid('refreshRow', index);
			console.log("onBeforeEdit");
		},
		onAfterEdit:function(index,row){
			row.editing = false;
			$(this).datagrid('refreshRow', index);
			console.log("onAfterEdit:function");
		},
		onCancelEdit:function(index,row){
			row.editing = false;
			$(this).datagrid('refreshRow', index);
			
			console.log("onCancelEdit:function");
		}
	});
});
function getRowIndex(target){
	var tr = $(target).closest('tr.datagrid-row');
	return parseInt(tr.attr('datagrid-row-index'));
}
function editrow(target){
	$('#sysColumnsTable').datagrid('beginEdit', getRowIndex(target));
}
function deleterow(target){
	$.messager.confirm('Confirm','Are you sure?',function(r){
		if (r){
			$('#sysColumnsTable').datagrid('deleteRow', getRowIndex(target));
		}
	});
}
function saverow(target){
	var index = getRowIndex(target);
	$('#sysColumnsTable').datagrid('endEdit', index);
	var rows = $('#sysColumnsTable').datagrid('getRows');
	var row = rows[index];
	$.post("${contextPath}/platform/tables/update_column",{
			tbname:row.tbname,
			columnName:row.columnName,
			tbcreator:row.tbcreator,
			propertyTitle:row.propertyTitle,
			isselect:row.isselect,
			islike:row.islike,
			isadd:row.isadd,
			isupdate:row.isupdate
		}, function(data){
			if(data.status == 200){
				$('#sysColumnsTable').datagrid("reload");
			}
	});
}
function cancelrow(target){
	$('#sysColumnsTable').datagrid('cancelEdit', getRowIndex(target));
}
function insert(){
	var row = $('#sysColumnsTable').datagrid('getSelected');
	var index = 0;
	if (row){
		index = $('#sysColumnsTable').datagrid('getRowIndex', row);
	}
	$('#sysColumnsTable').datagrid('insertRow', {
		index: index,
		row:{
			status:'P'
		}
	});
	$('#sysColumnsTable').datagrid('selectRow',index);
	$('#sysColumnsTable').datagrid('beginEdit',index);
}
</script>
</body>
</html>