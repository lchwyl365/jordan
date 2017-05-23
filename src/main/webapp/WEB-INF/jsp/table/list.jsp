<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>代码生成-数据库表</title>
    <script type="text/javascript">
    $(function(){
		$('#sysTable').datagrid({
			title:'代码生成-数据库表', //标题
			border:false,
			method:'post',
			iconCls:'icon-table', //图标
			singleSelect:true, //多选
			fit:true, //高度
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:false,//可折叠
			url:"${contextPath}/platform/tables/queryList", //数据来源
			sortName: 'ctime', //排序的列
			sortOrder: 'asc', //倒序
			remoteSort: true, //服务器端排序
			idField:'userid', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				{field:'ck',checkbox:true,width:2}, //显示复选框
				{field:'TABLE_NAME',title:'表名',width:20,sortable:true,
					formatter:function(value,row,index){return row.tableName;} //需要formatter一下才能显示正确的数据
				},
				{field:'SCHEMA_NAME',title:'SCHEMA',width:10,sortable:true,
					formatter:function(value,row,index){return row.schemaName;}
				},
				{field:'MENU_NAME',title:'菜单名称',width:10,sortable:true,
					formatter:function(value,row,index){return row.menuName;}
				},
				{field:'PATH',title:'路径',width:10,sortable:true,
					formatter:function(value,row,index){return row.path;}
				},
				{field:'CTIME',title:'创建时间',width:20,sortable:true,
					formatter:function(value,row,index){
						if (row.ctime != null) {
							var date = new Date(row.ctime);
							return date.format("yyyy-MM-dd hh:mm:ss");
						}
						return "";
					}
				},
				{field:'GENERATE',title:'生成状态',width:10,sortable:true,
					formatter:function(value,row,index){
						if (row.generate == 'F'){
							return '<span style="color:red;">未生成</span>';
						} else {
							return '<span style="color:green;">已生成</span>';
						}
					}
				}
			]],
			toolbar:'#sysTableTb',
			onLoadSuccess:function(){
				$('#sysTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
		
		$("#generate-btn").bind('click',SYSTABLES.generate);
		$("#generate-java-btn").bind('click',SYSTABLES.generateJava);
		$("#generate-mapper-btn").bind('click',SYSTABLES.generateMapper);
		
		$("#search-btn").bind('click',SYSTABLES.search);
		$("#clear-btn").bind('click',SYSTABLES.clear);
		
		$("#update-btn").bind('click',SYSTABLES.updateColumn);

	});
    var SYSTABLES = {
    		generate:function(){//新增
    			var rows = $('#sysTable').datagrid('getSelections');
    			//这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
    			if(rows.length==0){
    				$.messager.alert('提示',"请选择你要生成代码的表",'info');
    				return;
    			}
    			if(rows.length > 1){
    				$.messager.alert('提示',"只能选择一个表进行生成代码",'info');
    				return;
    			}
    	  		window.self.location = '${contextPath}/platform/tables/generate_all/'+rows[0].tableName+"/"+rows[0].schemaName+"/"+rows[0].type;
    		},
    		generateJava:function(){//更新
    			var rows = $('#sysTable').datagrid('getSelections');
    			if(rows.length==0){
    				$.messager.alert('提示',"请选择你要生成代码的表",'info');
    				return;
    			}
    			if(rows.length > 1){
    				$.messager.alert('提示',"只能选择一个表进行生成代码",'info');
    				return;
    			}
    			TT.createWindow({
    	  			title:'自动生成后台代码',
    	  			url:'${contextPath}/platform/tables/generate_java/'+rows[0].tableName+"/"+rows[0].schemaName+"/"+rows[0].type,
    	  			width:'920px',
    	  			height:'470px'
    	  		});
    		},
    		generateMapper:function(){
		        	var rows = $('#sysTable').datagrid('getSelections');
	    			if(rows.length==0){
	    				$.messager.alert('提示',"请选择你要生成代码的表",'info');
	    				return;
	    			}
	    			if(rows.length > 1){
	    				$.messager.alert('提示',"只能选择一个表进行生成代码",'info');
	    				return;
	    			}
		        	$.post('${contextPath}/platform/tables/generate_mapper/'+rows[0].tableName+"/"+rows[0].schemaName+"/"+rows[0].type,function(data){
		        		if(data.status == 200){
	    					$.messager.alert('提示','生成Mapper代码成功!');
		        		}else{
	    					$.messager.alert('生成Mapper代码错误!',data.msg,'error');
	    				}
		        	});
    		},
    	  	search:function(){//表格查询
    			var params = $('#sysTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
    			var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
    			$.each( fields, function(i, field){
    				params[field.name] = field.value; //设置查询参数
    			});
    			$('#sysTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
    		},
    		//清空查询条件
    		clear:function(){
    			$('#queryForm').form('clear');
    			SYSTABLES.search();
    		},
    		updateColumn:function(){
    			var rows = $('#sysTable').datagrid('getSelections');
    			//这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
    			if(rows.length==0){
    				$.messager.alert('提示',"请选择你要生成代码的表",'info');
    				return;
    			}
    			if(rows.length > 1){
    				$.messager.alert('提示',"只能选择一个表进行生成代码",'info');
    				return;
    			}
    			$.post("${contextPath}/platform/tables/updateColumn",{tableName:rows[0].tableName,schemaName:rows[0].schemaName,type:rows[0].type}, function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','更新表结构成功!');
    				}else{
    					$.messager.alert('更新表结构错误!',data.msg,'error');
    				}
    			});
    		}
	};
    </script>
</head>
<body id="tablesBody" class="easyui-layout" style="overflow-y: hidden" scroll="no">
    <div data-options="region:'center',border:false">
    	<table id="sysTable"></table>
    	<div id="sysTableTb" style="padding:10px;height:auto">
			<form id="queryForm" style="margin-bottom: 0px;">
				<label for="tableName" style="margin-left:10px;">操作员名称: </label>
				<input class="easyui-textbox" name="tableName" style="width:120px;">
				<a id="search-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" style="width:80px;">查询</a>
				<a id="clear-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-clear" style="width:80px;">清空</a>
				<span class="datagrid-btn-separator" style="float:none;margin-left:5px;margin-right:5px;"></span>
				<a id="generate-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-folder-add" style="width:100px;">生成代码</a>
				<a id="generate-java-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-folder-add" style="width:140px;">生成后端代码</a>
				<a id="generate-mapper-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-folder-add" style="width:150px;">生成类和Mapper</a>
				<a id="update-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-load" style="width:100px;">更新表结构</a> 
			</form>
		</div>
    </div>
</body>
</html>