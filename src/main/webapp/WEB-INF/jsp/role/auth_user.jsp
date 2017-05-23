<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>角色管理添加</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center,border:false'">
			<div style="padding:10px;height:auto">
				<form id="queryUserForm" style="margin-bottom: 0px;">
					<label for="status" style="margin-left:10px;">操作员名称: </label>
					<input class="easyui-textbox" name="operatorname" style="width:120px;">
					<label for="status" style="margin-left:10px;">登录用户名: </label>
					<input class="easyui-textbox" name="username" style="width:120px;">
					<a id="search-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" style="width:80px;">查询</a>
				</form>
			</div>
			<div style="height:250px;width:100%;">
				<table id="userTable"></table>
			</div>
		</div>
		<div data-options="region:'south',border:false" style="text-align:right;padding:10px 10px;">
			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="contentAddPage.submitForm()" style="width:80px">提交</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="contentAddPage.clearForm()" style="width:80px">关闭</a>
		</div>
	</div>
<script type="text/javascript">
$(function(){
	$('#userTable').datagrid({
		title:'操作员查询结果',
		border:true,
		iconCls:'icon-table', //图标
		singleSelect:false, //多选
		fit:true, //高度
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped: true, //奇偶行颜色不同
		collapsible:false,//可折叠
		url:"${contextPath}/platform/user/queryList", //数据来源
		sortName: 'altertime', //排序的列
		sortOrder: 'desc', //倒序
		remoteSort: true, //服务器端排序
		idField:'userid', //主键字段
		queryParams:{}, //查询条件
		pagination:true, //显示分页
		rownumbers:true, //显示行号
		columns:[[
			{field:'ck',checkbox:true,width:2}, //显示复选框
			{field:'username',title:'登录用户名',width:20,sortable:true,
				formatter:function(value,row,index){return row.username;}
			},
			{field:'operatorname',title:'操作员名称',width:20,sortable:true,
				formatter:function(value,row,index){return row.operatorname;}
			}
		]],
		onLoadSuccess:function(){
			$('#userTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
	
});
var contentAddPage  = {
	submitForm : function (){
		var rows = $('#userTable').datagrid('getSelections');
		//这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要分配权限的用户",'info');
			return;
		}
		var ps = "?roleid=${roleid}";
    	$.each(rows,function(i,n){
	       	ps += "&userids="+n.userid;
    	});
		$.post("${contextPath}/platform/role/auth_user"+ps, function(data){
			if(data.status == 200){
				$.messager.alert('提示','分配成功!');
				$("#authUserFrame")[0].contentWindow.reload();
				TT.closeCurrentWindow();
			}else{
				$.messager.alert('分配权限错误',data.msg,'error');
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