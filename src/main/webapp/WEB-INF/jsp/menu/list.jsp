<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>系统菜单管理</title>
    <script type="text/javascript">
    $(function(){
    	
		var combo7_json = eval('${combo7_json}');
    	
		$('#menuTable').treegrid({
			title:'系统菜单',
			iconCls:'icon-table',
			border:false,
			rownumbers: true,
			fit:true, //高度
			fitColumns:true,
			url:'${contextPath}/platform/menu/queryTreeList?pid=0',
			method: 'get',
			idField:'menuid',
			treeField:'name',
			toolbar:'#tb',
			columns:[[
				{field:'menuid',title:'菜单编号',width:100},
				{field:'name',title:'菜单名称',width:140},
				{field:'menuPos',title:'菜单位置',width:60},
				{field:'href',title:'链接地址',width:100},
				{field:'iconCls',title:'菜单图标',width:100,
					formatter:function(value,row,index){return '<span class="icon '+row.iconCls+'">'+row.iconCls+'</span>';}
				},
				{field:'display',title:'是否显示',width:100},
				{field:'orderNum',title:'序号',width:100},
				{field:'pid',title:'父菜单编号',width:100}
			]]
		});
		
		$("#add-btn").bind('click',AuthMenu.addRow);
		$("#del-btn").bind('click',AuthMenu.deleteRow);
		$("#edit-btn").bind('click',AuthMenu.updateRow);
		$("#search-btn").bind('click',AuthMenu.search);
		$("#clear-btn").bind('click',AuthMenu.clear);

	});
    var AuthMenu = {
    		addRow:function(){//新增
  		        TT.createWindow({
  		    	  title:'添加系统菜单',
  		    	  width:'800px',
  		    	  height:'430px',
  				  url : "${contextPath}/platform/menu/add"
  			    });
    		},
    		updateRow:function(){//更新
    			var rows = $('#menuTable').datagrid('getSelections');
    			if(rows.length==0){
    				$.messager.alert('提示',"请选择你要更新的记录",'info');
    				return;
    			}
    			if(rows.length > 1){
    				$.messager.alert('提示',"只能选择一条记录进行更新",'info');
    				return;
    			}
    			var ps = "";
			  	ps += "/" + rows[0].menuid;
    			TT.createWindow({
    	  			title:'更新操作员信息',
    	  			url:'${contextPath}/platform/menu/update'+ps,
    	  			width:'800px',
    	  			height:'430px'
    	  		});
    		},
    		deleteRow:function(){//删除
    			var rows = $('#menuTable').datagrid('getSelections');
	        	if(rows.length==0){
    				$.messager.alert('提示',"请选择你要更新的记录",'info');
    				return;
    			}
    	  		$.messager.confirm('提示','确定要删除吗?',function(result){
    		        if (result){
    		        	var ps = "?1=1";
    		        	$.each(rows,function(i,n){
					       	ps += "&menuids="+n.menuid;
    		        	});
    		        	$.post('${contextPath}/platform/menu/delete'+ps,function(data){
							$("#menuTable").treegrid("reload");
    		        		$.messager.alert('提示',data.msg,'info');
    		        	});
    		        }
    		    });
    	  	},
    	  	search:function(){//表格查询
    			var params = $('#menuTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
    			var fields =$('#authMenuForm').serializeArray(); //自动序列化表单元素为JSON对象
    			$.each( fields, function(i, field){
    				params[field.name] = field.value; //设置查询参数
    			});
    			$('#menuTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
    		},
    		//清空查询条件
    		clear:function(){
    			$('#authMenuForm').form('clear');
    			AuthMenu.search();
    		}
	};
    </script>
</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
    <div data-options="region:'center',border:false">
    	<table id="menuTable"></table>
    	<div id="tb" style="padding:10px;height:auto">
			<form id="authMenuForm" style="margin-bottom: 0px;">
				<a id="add-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
				<a id="edit-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
				<a id="del-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			</form>
		</div>
    </div>
</body>
</html>