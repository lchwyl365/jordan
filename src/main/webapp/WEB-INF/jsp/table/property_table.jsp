<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>表格属性设置</title>
</head>
<body class="easyui-layout">
    <div data-options="region:'north'" style="height:46px;border-left:0px;border-right:0px;border-top:0px;padding:10px;background-color:#FAFAFA;">
    	<c:if test="${sysTables.isadd == 'T'}">
    		<label style="line-height:19px;"><input id="isAddBtn" type="checkbox" checked="checked"/>显示添加按钮</label>
    	</c:if>
    	<c:if test="${sysTables.isadd != 'T'}">
    		<label style="line-height:19px;"><input id="isAddBtn" type="checkbox" />显示添加按钮</label>
    	</c:if>
    	<c:if test="${sysTables.isupdate == 'T'}">
    		<label style="line-height:19px;"><input id="isUpdateBtn" type="checkbox" checked="checked"/>显示修改按钮</label>
    	</c:if>
    	<c:if test="${sysTables.isupdate != 'T'}">
    		<label style="line-height:19px;"><input id="isUpdateBtn" type="checkbox" />显示修改按钮</label>
    	</c:if>
        <c:if test="${sysTables.isdelete == 'T'}">
        	<label style="line-height:19px;"><input id="isDeleteBtn" type="checkbox" checked="checked"/>显示删除按钮</label>
    	</c:if>
    	<c:if test="${sysTables.isdelete != 'T'}">
    		<label style="line-height:19px;"><input id="isDeleteBtn" type="checkbox" />显示删除按钮</label>
    	</c:if>
    </div>
    <div data-options="region:'center',border:false">
		<table id="sysColumnsTable" style="width:100%"></table>
    </div>
    
<script type="text/javascript">
var PROPERTY = {
		refreshPreview:function(){//新增
			var url = parent.$('#preview_table').attr('src');
			parent.$('#preview_table').attr('src', url);
		},
		update:function(param){
			$.post("${contextPath}/platform/tables/update?tableName=${tableName}&schemaName=${schemaName}&type=${type}&"+param,function(data){
    			if(data.status == 200){
    				PROPERTY.refreshPreview();
    			}else{
    				$.messager.alert('错误',data.msg);
    			}
    		});
		}
};
$(function(){
	
	$("#isAddBtn").click(function(){
		var isAdd = $('#isAddBtn').is(':checked');
		var addValue = isAdd ? "F" : "T";
		PROPERTY.update("isadd="+addValue);
	});
	$("#isUpdateBtn").click(function(){
		var isUpdate = $('#isUpdateBtn').is(':checked');
		var updateValue = isUpdate ? "T" : "F";
		PROPERTY.update("isupdate="+updateValue);
	});
	$("#isDeleteBtn").click(function(){
		var isDelete = $('#isDeleteBtn').is(':checked');
		var deleteValue = isDelete ? "T" : "F";
		PROPERTY.update("isdelete="+deleteValue);
	});
	$('#sysColumnsTable').datagrid({
		title:'字段信息列表', //标题
		iconCls:'icon-table', //图标
		border:false,
		singleSelect:true, //多选
		idField:'propertyName', //主键字段
		fit:false, //高度
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		url:"${contextPath}/platform/tables/queryColumnsList?tbname=${tableName}&tbcreator=${schemaName}", //数据来源
		sortName: 'COLNO', //排序的列
		sortOrder: 'asc', //倒序
		remoteSort: true, //服务器端排序
		rownumbers:true, //显示行号
		idField:'propertyName', //主键字段
		queryParams:{}, //查询条件
		pagination:false, //显示分页
		rownumbers:true, //显示行号
		pageSize:50,
		columns:[[
			{field:'columnName',title:'数据库列',width:20,sortable:true,
				formatter:function(value,row,index){return row.columnName;}
			},
			{field:'propertyTitle',title:'字段标题',width:23,sortable:true,editor:'textbox',
				formatter:function(value,row,index){return row.propertyTitle;}
			},
			{field:'propertyName',title:'属性名',width:23,sortable:true,editor:'textbox',
				formatter:function(value,row,index){return row.propertyName;}
			},
			{field:'width',title:'宽度',width:12,editor:'textbox',
				formatter:function(value,row,index){return row.width;}
			},
			{field:'isdisplay',title:'显示',width:10,
				formatter:function(value,row){return row.isdisplay;},
				editor:{
					type:'checkbox',
					options:{
						on: 'T',
						off: 'F'
					}
				}
			},
			{field:'isselect',title:'equal',width:10,
				formatter:function(value,row,index){return row.isselect;},
				editor:{
					type:'checkbox',
					options:{
						on: 'T',
						off: 'F'
					}
				}
			},
			{field:'islike',title:'like',width:10,
				formatter:function(value,row){return row.islike || value;},
				editor:{
					type:'checkbox',
					options:{
						on: 'T',
						off: 'F'
					}
				}
			},
			{field:'sortable',title:'排序',width:10,
				formatter:function(value,row){return row.sortable || value;},
				editor:{
					type:'checkbox',
					options:{
						on: 'T',
						off: 'F'
					}
				}
			},
			{field:'formatter',title:'格式化',width:30,editor:'textbox',
				formatter:function(value,row,index){return row.formatter;}
			},
			{field:'action',title:'操作',width:22,align:'center',
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
			propertyName:row.propertyName,
			propertyTitle:row.propertyTitle,
			width:row.width,
			isselect:row.isselect,
			islike:row.islike,
			isdisplay:row.isdisplay
		}, function(data){
			if(data.status == 200){
				$('#sysColumnsTable').datagrid("reload");
				PROPERTY.refreshPreview();
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