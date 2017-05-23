<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>操作员管理</title>
    <script type="text/javascript">
    $(function(){
		$('#userTable').datagrid({
			border:false,
			iconCls:'icon-table', //图标
			singleSelect:false, //多选
			fit:true, //高度
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:false,//可折叠
			url:"${contextPath}/platform/role/queryUserList?roleid=${roleid}", //数据来源
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
			toolbar:'#tb',
			onLoadSuccess:function(){
				$('#userTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
		
		$("#add-btn").bind('click',AUTHUSER.addRow);
		$("#del-btn").bind('click',AUTHUSER.deleteRow);

	});
    var AUTHUSER = {
   		addRow:function(){//新增
 		     parent.AUTHUSER.addRow();
   		},
   		deleteRow:function(){//删除
   	  		$.messager.confirm('提示','确定要删除吗?',function(result){
   		        if (result){
   		        	var rows = $('#userTable').datagrid('getSelections');
   		        	var ps = "?roleid=${roleid}";
   		        	$.each(rows,function(i,n){
   		        		ps += "&userids="+n.userid;
   		        	});
   		        	var url = '${contextPath}/platform/role/delete_role'+ps;
   		        	$.post(url,function(data){
   		        		$('#userTable').datagrid('reload');
   			        });
   		        }
   		    });
   	  	}
	};
    function reload(){
    	$('#userTable').datagrid('reload');
    }
    </script>
</head>
<body id="userBody" class="easyui-layout" style="overflow-y: hidden" scroll="no">
    <div data-options="region:'center',border:false">
    	<table id="userTable"></table>
    	<div id="tb" style="padding:10px;height:auto">
			<form id="queryUserForm" style="margin-bottom: 0px;">
				<a id="add-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
				<a id="del-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			</form>
		</div>
    </div>
</body>
</html>