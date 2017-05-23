<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>角色管理管理</title>
    <script type="text/javascript">
    $(function(){
    	
		var combo2_json = eval('${combo2_json}');
    	
		$('#roleTable').datagrid({
			title:'角色管理', //标题
			border:false,
			method:'post',
			iconCls:'icon-table', //图标
			singleSelect:true, //多选
			fit:true, //高度
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:false,//可折叠
			url:"${contextPath}/platform/role/queryList", //数据来源
			sortName: 'roleid', //排序的列
			sortOrder: 'desc', //倒序
			remoteSort: true, //服务器端排序
			idField:'roleid', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				{field:'ck',checkbox:true,width:2}, //显示复选框
				{field:'ROLEID',title:'角色编号',width:100,sortable:'F',
						formatter:function(value,row,index){return row.roleid;}
				},
				{field:'NAME',title:'角色名称',width:100,sortable:'F',
						formatter:function(value,row,index){return row.name;}
				},
				{field:'TYPE',title:'角色类型',width:100,sortable:'F',
						formatter:function(value,row,index){
							var text = '';
							for(var i=0;i<combo2_json.length;i++){  
					    		if(row.type == combo2_json[i].id){
					    			text = combo2_json[i].text;
					    		}
					    	}
							return text;
						}
				},
				{field:'action',title:'操作',width:50,align:'center',
					formatter:function(value,row,index){
						var e = '<a href="javascript:void(0);" onclick="editrow('+row.roleid+')">分配权限</a> ';
						return e;
					}
				}
			]],
			toolbar:'#tb',
			onLoadSuccess:function(){
				$('#roleTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
		
		$("#add-btn").bind('click',AuthRole.addRow);
		$("#del-btn").bind('click',AuthRole.deleteRow);
		$("#edit-btn").bind('click',AuthRole.updateRow);
		$("#save-btn").bind('click',AuthRole.save);
/* 
		$("#user-add-btn").bind('click',AUTHUSER.addRow);
		$("#user-del-btn").bind('click',AUTHUSER.deleteRow);
		$("#user-edit-btn").bind('click',AUTHUSER.updateRow);
		$("#user-search-btn").bind('click',AUTHUSER.search);
		$("#user-clear-btn").bind('click',AUTHUSER.clear);
		 */
	});
    
    var AuthRole = {
    		selectId:"",
    		addRow:function(){//新增
  		        TT.createWindow({
  		    	  title:'添加角色管理',
  		    	  width:'700px',
  		    	  height:'260px',
  				  url : "${contextPath}/platform/role/add"
  			    });
    		},
    		updateRow:function(){//更新
    			var rows = $('#roleTable').datagrid('getSelections');
    			if(rows.length==0){
    				$.messager.alert('提示',"请选择你要更新的记录",'info');
    				return;
    			}
    			if(rows.length > 1){
    				$.messager.alert('提示',"只能选择一条记录进行更新",'info');
    				return;
    			}
    			var ps = "";
			  	ps += "/" + rows[0].roleid;
    			TT.createWindow({
    	  			title:'更新信息',
    	  			url:'${contextPath}/platform/role/update'+ps,
    	  			width:'700px',
    	  			height:'260px'
    	  		});
    		},
    		deleteRow:function(){//删除
    			var rows = $('#roleTable').datagrid('getSelections');
	        	if(rows.length==0){
    				$.messager.alert('提示',"请选择你要更新的记录",'info');
    				return;
    			}
    	  		$.messager.confirm('提示','确定要删除吗?',function(result){
    		        if (result){
    		        	var ps = "?1=1";
    		        	$.each(rows,function(i,n){
					       	ps += "&roleids="+n.roleid;
    		        	});
    		        	$.post('${contextPath}/platform/role/delete'+ps,function(data){
							$("#roleTable").datagrid("reload");
    		        		$.messager.alert('提示',data.msg,'info');
    		        	});
    		        }
    		    });
    	  	},
    		save:function(){
				if(AuthRole.selectId == ''){
					$.messager.alert('提示','请选择要授权的角色','info');
					return false;
				}
				var nodes = $('#menu-tree').tree('getChecked',['checked','indeterminate']);
				var s = '';
				for(var i=0; i<nodes.length; i++){
					if (s != '') s += '&';
					s += "menuids="+nodes[i].id;
				}
				$.post("${contextPath}/platform/role/auth?roleid="+AuthRole.selectId+"&"+s,function(data){
					if(data.status == 200){
						$.messager.alert('提示','授权成功!');
					}else{
						$.messager.alert('授权错误',data.msg,'error');
					}
				});
    		}
	};
    function editrow(rowid){
    	AuthRole.selectId = rowid;
    	var tab = $('#authTab').tabs('getSelected');
    	var index = $('#authTab').tabs('getTabIndex',tab);
    	if(index == 0){//功能权限
    		var url = "${contextPath}/platform/menu/queryMenu?pid=4758592868910319&roleid=" +AuthRole.selectId;
    		//重新赋值url 属性
    	    $("#menu-tree").tree('options').url=url;
        	$("#menu-tree").tree("reload");
    	}else if(index == 1){//权限分配
    		$('#authUserFrame').attr('src', "${contextPath}/platform/role/userlist?roleid="+AuthRole.selectId);
    	}
    }
    function tabSelectHandler(title){
    	if(title == '权限分配'){
    		$('#authUserFrame').attr('src', "${contextPath}/platform/role/userlist?roleid="+AuthRole.selectId);
    	}
    }
    var AUTHUSER = {
    		addRow:function(){//新增
    			if(AuthRole.selectId == ""){
    				$.messager.alert('提示',"请选择要分配权限的角色",'info');
    				return;
    			}
  		        TT.createWindow({
  		    	  title:'权限分配',
  		    	  width:'680px',
  		    	  height:'360px',
  				  url : "${contextPath}/platform/role/auth_user?roleid="+AuthRole.selectId
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
    		deleteRow:function(url){//删除
    			
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
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
    <div data-options="region:'center',border:false" style="border-right:1px solid #D3D3D3;">
    	<table id="roleTable"></table>
    	<div id="tb" style="padding:10px;height:auto">
			<form id="authRoleForm" style="margin-bottom: 0px;">
				<a id="add-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
				<a id="edit-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
				<a id="del-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			</form>
		</div>
		
    </div>
    <div data-options="region:'east',border:false,split:true" style="width:50%;border-left:1px solid #D3D3D3;">
    	<div id="authTab" class="easyui-tabs" data-options="border:false,onSelect:tabSelectHandler">
	        <div title="功能权限" >
	        	<div style="padding:5px;height:auto;background-color: #FAFAFA;border-bottom:1px solid #D3D3D3;">
					<a id="save-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true">保存</a>
				</div>
	            <ul id="menu-tree" class="easyui-tree" data-options="url:'${contextPath}/platform/menu/queryMenu?pid=4758592868910319',method:'get',animate:true,checkbox:true"></ul>
	        </div>
	        <div title="权限分配">
	            <iframe id="authUserFrame" scrolling="auto" frameborder="0"  src="" style="width:100%;height:94%;"></iframe>
	        </div>
	    </div>
    </div>
</body>
</html>