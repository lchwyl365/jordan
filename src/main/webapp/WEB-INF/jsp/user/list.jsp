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
			title:'用户列表', //标题
			border:false,
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
				{field:'userid',title:'用户编号',width:20,sortable:true,
					formatter:function(value,row,index){return row.userid;} //需要formatter一下才能显示正确的数据
				},
				{field:'username',title:'登录用户名',width:20,sortable:true,
					formatter:function(value,row,index){return row.username;}
				},
				{field:'operatorname',title:'操作员名称',width:20,sortable:true,
					formatter:function(value,row,index){return row.operatorname;}
				},
				{field:'status',title:'操作员状态',width:20,sortable:true,
					formatter:function(value,row,index){
						if (row.status == 'F'){
							return '<span style="color:red;">冻结</span>';
						} else {
							return '正常';
						}
					}
				},
				{field:'altertime',title:'更新时间',width:20,sortable:true,
					formatter:function(value,row,index){
						if (row.altertime != null) {
							var date = new Date(row.altertime);
							return date.format("yyyy-MM-dd hh:mm:ss");
						}
						return "";
					}
				}
			]],
			toolbar:'#tb',
			onLoadSuccess:function(){
				$('#userTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
		
		$("#add-btn").bind('click',AUTHUSER.addRow);
		$("#del-btn").bind('click',AUTHUSER.deleteRow);
		$("#edit-btn").bind('click',AUTHUSER.updateRow);
		$("#search-btn").bind('click',AUTHUSER.search);
		$("#clear-btn").bind('click',AUTHUSER.clear);

	});
    var AUTHUSER = {
    		addRow:function(){//新增
  		        TT.createWindow({
  		    	  title:'添加操作员',
  		    	  width:'700px',
  		    	  height:'260px',
  				  url : "${contextPath}/platform/user/add"
  			    });
    		},
    		updateRow:function(){//更新
    			var rows = $('#userTable').datagrid('getSelections');
    			//这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
    			if(rows.length==0){
    				$.messager.alert('提示',"请选择你要更新的用户",'info');
    				return;
    			}
    			if(rows.length > 1){
    				$.messager.alert('提示',"只能选择一位用户进行更新",'info');
    				return;
    			}
    			TT.createWindow({
    	  			title:'更新操作员信息',
    	  			url:'${contextPath}/platform/user/update/'+rows[0].userid,
    	  			width:'700px',
    	  			height:'260px'
    	  		});
    		},
    		deleteRow:function(){//删除
    	  		$.messager.confirm('提示','确定要删除吗?',function(result){
    		        if (result){
    		        	var rows = $('#userTable').datagrid('getSelections');
    		        	var ps = "";
    		        	$.each(rows,function(i,n){
    		        		if(i==0) 
    		        			ps += "?userid="+n.userid;
    		        		else
    		        			ps += "&userid="+n.userid;
    		        	});
    		        	$.post('${contextPath}/platform/user/delete'+ps,function(data){
    			        	$('#userTable').datagrid('reload'); 
    		        		$.messager.alert('提示',data.msg,'info');
    		        	});
    		        }
    		    });
    	  	},
    	  	search:function(){//表格查询
    			var params = $('#userTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
    			var fields =$('#queryUserForm').serializeArray(); //自动序列化表单元素为JSON对象
    			$.each( fields, function(i, field){
    				params[field.name] = field.value; //设置查询参数
    			});
    			$('#userTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
    		},
    		//清空查询条件
    		clear:function(){
    			$('#queryUserForm').form('clear');
    			AUTHUSER.search();
    		}
	};
    </script>
</head>
<body id="userBody" class="easyui-layout" style="overflow-y: hidden" scroll="no">
    <div data-options="region:'center',border:false">
    	<table id="userTable"></table>
    	<div id="tb" style="padding:10px;height:auto">
			<form id="queryUserForm" style="margin-bottom: 0px;">
				<label for="status" style="margin-left:10px;">操作员名称: </label>
				<input class="easyui-textbox" name="operatorname" style="width:120px;">
				<label for="status" style="margin-left:10px;">登录用户名: </label>
				<input class="easyui-textbox" name="username" style="width:120px;">
				<a id="search-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" style="width:80px;">查询</a>
				<a id="clear-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-clear" style="width:80px;">清空</a>
				<span class="datagrid-btn-separator" style="float:none;margin-left:5px;margin-right:5px;"></span>
				<a id="add-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
				<a id="edit-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
				<a id="del-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			</form>
		</div>
    </div>
</body>
</html>