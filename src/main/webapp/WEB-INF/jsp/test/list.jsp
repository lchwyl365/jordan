<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>测试表管理</title>
    <script type="text/javascript">
    $(function(){
    	
		var combo1_json = eval('${combo1_json}');
    	
		$('#testTable').datagrid({
			title:'测试表', //标题
			border:false,
			method:'post',
			iconCls:'icon-table', //图标
			singleSelect:false, //多选
			fit:true, //高度
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:false,//可折叠
			url:"${contextPath}/platform/test/queryList", //数据来源
			sortName: 'testid', //排序的列
			sortOrder: 'desc', //倒序
			remoteSort: true, //服务器端排序
			idField:'testid', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				{field:'ck',checkbox:true,width:2}, //显示复选框
				{field:'TESTID',title:'测试编号',width:100,sortable:'F',
						formatter:function(value,row,index){return row.testid;}
				},
				{field:'GROUP_ID',title:'组编号',width:100,sortable:'F',
						formatter:function(value,row,index){
							var text = '';
							for(var i=0;i<combo1_json.length;i++){  
					    		if(row.groupId == combo1_json[i].id){
					    			text = combo1_json[i].text;
					    		}
					    	}
							return text;
						}
				},
				{field:'TESTNAME',title:'测试名称',width:100,sortable:'F',
						formatter:function(value,row,index){return row.testname;}
				}
			]],
			toolbar:'#tb',
			onLoadSuccess:function(){
				$('#testTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
		
		$("#add-btn").bind('click',AuthTest.addRow);
		$("#del-btn").bind('click',AuthTest.deleteRow);
		$("#edit-btn").bind('click',AuthTest.updateRow);
		$("#search-btn").bind('click',AuthTest.search);
		$("#clear-btn").bind('click',AuthTest.clear);

	});
    var AuthTest = {
    		addRow:function(){//新增
  		        TT.createWindow({
  		    	  title:'添加测试表',
  		    	  width:'700px',
  		    	  height:'260px',
  				  url : "${contextPath}/platform/test/add"
  			    });
    		},
    		updateRow:function(){//更新
    			var rows = $('#testTable').datagrid('getSelections');
    			if(rows.length==0){
    				$.messager.alert('提示',"请选择你要更新的记录",'info');
    				return;
    			}
    			if(rows.length > 1){
    				$.messager.alert('提示',"只能选择一条记录进行更新",'info');
    				return;
    			}
    			var ps = "";
			  	ps += "/" + rows[0].testid;
			  	ps += "/" + rows[0].groupId;
    			TT.createWindow({
    	  			title:'更新操作员信息',
    	  			url:'${contextPath}/platform/test/update'+ps,
    	  			width:'700px',
    	  			height:'260px'
    	  		});
    		},
    		deleteRow:function(){//删除
    			var rows = $('#testTable').datagrid('getSelections');
	        	if(rows.length==0){
    				$.messager.alert('提示',"请选择你要更新的记录",'info');
    				return;
    			}
    	  		$.messager.confirm('提示','确定要删除吗?',function(result){
    		        if (result){
    		        	var ps = "?1=1";
    		        	$.each(rows,function(i,n){
					       	ps += "&testids="+n.testid;
					       	ps += "&groupIds="+n.groupId;
    		        	});
    		        	$.post('${contextPath}/platform/test/delete'+ps,function(data){
							$("#testTable").datagrid("reload");
    		        		$.messager.alert('提示',data.msg,'info');
    		        	});
    		        }
    		    });
    	  	},
    	  	search:function(){//表格查询
    			var params = $('#testTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
    			var fields =$('#authTestForm').serializeArray(); //自动序列化表单元素为JSON对象
    			$.each( fields, function(i, field){
    				params[field.name] = field.value; //设置查询参数
    			});
    			$('#testTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
    		},
    		//清空查询条件
    		clear:function(){
    			$('#authTestForm').form('clear');
    			AuthTest.search();
    		}
	};
    </script>
</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
    <div data-options="region:'center',border:false">
    	<table id="testTable"></table>
    	<div id="tb" style="padding:10px;height:auto">
			<form id="authTestForm" style="margin-bottom: 0px;">
				<a id="add-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
				<a id="edit-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
				<a id="del-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			</form>
		</div>
    </div>
</body>
</html>