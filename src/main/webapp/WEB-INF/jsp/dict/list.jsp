<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>字典管理管理</title>
    <script type="text/javascript">
    var dicttypeid = '0';
    $(function(){
    	$('#entryTable').datagrid({
			title:'字典项管理', //标题
			border:false,
			method:'post',
			iconCls:'icon-table', //图标
			singleSelect:true, //多选
			fit:true, //高度
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:false,//可折叠
			url:"${contextPath}/platform/entry/queryList", //数据来源
			sortName: 'dicttypeid', //排序的列
			sortOrder: 'desc', //倒序
			remoteSort: true, //服务器端排序
			idField:'dicttypeid', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				{field:'ck',checkbox:true,width:2}, //显示复选框
				{field:'DICTTYPEID',title:'字典编号',width:100,sortable:'F',
						formatter:function(value,row,index){return row.dicttypeid;}
				},
				{field:'DICTID',title:'字典项编号',width:100,sortable:'F',
						formatter:function(value,row,index){return row.dictid;}
				},
				{field:'DICTNAME',title:'字典项名称',width:100,sortable:'F',
						formatter:function(value,row,index){return row.dictname;}
				},
				{field:'STATUS',title:'状态',width:100,sortable:'F',
					formatter:function(value,row,index){
						if (row.status == 'off'){
							return '<span style="color:red;">冻结</span>';
						} else {
							return '正常';
						}
					}
				},
				{field:'SORTNO',title:'序号',width:100,sortable:'F',
						formatter:function(value,row,index){return row.sortno;}
				},
				{field:'RANK',title:'字典等级',width:100,sortable:'F',
						formatter:function(value,row,index){return row.rank;}
				},
				{field:'PARENTID',title:'上级编号',width:100,sortable:'F',
						formatter:function(value,row,index){return row.parentid;}
				}
			]],
			toolbar:'#tb',
			onLoadSuccess:function(){
				$('#entryTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
    	
    	$("#type-add").bind('click',SysDictType.addRow);
    	$("#type-update").bind('click',SysDictType.updateRow);
    	$("#type-delete").bind('click',SysDictType.deleteRow);
    	
    	$("#entry-add").bind('click',SysDictEntry.addRow);
    	$("#entry-edit").bind('click',SysDictEntry.updateRow);
    	$("#entry-delete").bind('click',SysDictEntry.deleteRow);
    });
    var SysDictType = {
    		addRow:function(){//新增
  		        TT.createWindow({
  		    	  title:'添加字典管理',
  		    	  width:'700px',
  		    	  height:'260px',
  				  url : "${contextPath}/platform/dict/add"
  			    });
    		},
    		updateRow:function(){//更新
    			var node = $('#dictTypeGrid').tree('getSelected');
                if (!node){
                	$.messager.alert('提示',"请选择你要更新的记录",'info');
    				return;
                }
    			var ps = "";
			  	ps += "/" + node.id;
    			TT.createWindow({
    	  			title:'更新字典项信息',
    	  			url:'${contextPath}/platform/dict/update'+ps,
    	  			width:'700px',
    	  			height:'260px'
    	  		});
    		},
    		deleteRow:function(){//删除
    			var node = $('#dictTypeGrid').tree('getSelected');
                if (!node){
                	$.messager.alert('提示',"请选择你要删除的记录",'info');
    				return;
                }
	        	
    	  		$.messager.confirm('提示','确定要删除吗?',function(result){
    		        if (result){
    		        	$.post('${contextPath}/platform/dict/delete?dicttypeids='+node.id,function(data){
							$("#dictTypeGrid").tree("reload");
							$("#entryTable").datagrid('reload'); 
    		        		$.messager.alert('提示','删除成功!','info');
    		        	});
    		        }
    		    });
    	  	},
    	  	search:function(){//表格查询
    			var params = $('#dictTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
    			var fields =$('#sysDictTypeForm').serializeArray(); //自动序列化表单元素为JSON对象
    			$.each( fields, function(i, field){
    				params[field.name] = field.value; //设置查询参数
    			});
    			$('#dictTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
    		},
    		//清空查询条件
    		clear:function(){
    			$('#sysDictTypeForm').form('clear');
    			SysDictType.search();
    		},
    		typeClickHandler:function(node){
    			var url = "${contextPath}/platform/entry/queryList?dicttypeid=" +node.id;   
    			//重新赋值url 属性
    		    $('#entryTable').datagrid('options').url=url;
    		    $("#entryTable").datagrid('reload'); 
    	    }
	};
    
    var SysDictEntry = {
    		addRow:function(){//新增
    			var node = $('#dictTypeGrid').tree('getSelected');
                if (!node){
                	$.messager.alert('提示',"请选择你要添加字典项的字典",'info');
    				return;
                }
  		        TT.createWindow({
  		    	  title:'添加字典项管理',
  		    	  width:'700px',
  		    	  height:'260px',
  				  url : "${contextPath}/platform/entry/add?dicttypeid="+node.id
  			    });
    		},
    		updateRow:function(){//更新
    			var rows = $('#entryTable').datagrid('getSelections');
    			if(rows.length==0){
    				$.messager.alert('提示',"请选择你要更新的记录",'info');
    				return;
    			}
    			if(rows.length > 1){
    				$.messager.alert('提示',"只能选择一条记录进行更新",'info');
    				return;
    			}
    			var ps = "";
			  	ps += "/" + rows[0].dicttypeid;
			  	ps += "/" + rows[0].dictid;
    			TT.createWindow({
    	  			title:'更新操作员信息',
    	  			url:'${contextPath}/platform/entry/update'+ps,
    	  			width:'700px',
    	  			height:'260px'
    	  		});
    		},
    		deleteRow:function(){//删除
    			var rows = $('#entryTable').datagrid('getSelections');
	        	if(rows.length==0){
    				$.messager.alert('提示',"请选择你要更新的记录",'info');
    				return;
    			}
    	  		$.messager.confirm('提示','确定要删除吗?',function(result){
    		        if (result){
    		        	var ps = "?1=1";
    		        	$.each(rows,function(i,n){
					       	ps += "&dicttypeids="+n.dicttypeid;
					       	ps += "&dictids="+n.dictid;
    		        	});
    		        	$.post('${contextPath}/platform/entry/delete'+ps,function(data){
							$("#entryTable").datagrid("reload");
    		        		$.messager.alert('提示',data.msg,'info');
    		        	});
    		        }
    		    });
    	  	}
    };
    </script>
</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
	<div data-options="region:'west',split:true,collapsible:false,border:false" title="字典列表" style="width:240px;border-right:1px solid #D3D3D3;">
		<div id="tree-toolbar" style="padding:5px;background-color: #FAFAFA;border-bottom:1px solid #DDDDDD;">
			<table cellpadding="0" cellspacing="0" style="width:100%">
				<tr>
					<td>
						<a href="#" id="type-add" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
						<a href="#" id="type-update" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
						<a href="#" id="type-delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
					</td>
				</tr>
			</table>
		</div>
		<ul id="dictTypeGrid" class="easyui-tree" data-options="url:'${contextPath}/platform/dict/queryList',method:'get',onClick:SysDictType.typeClickHandler"></ul>
	</div>
    <div data-options="region:'center',border:false" style="border-left:1px solid #D3D3D3;">
    	<table id="entryTable"></table>
    	<div id="tb" style="padding:10px;height:auto">
			<form id="sysDictEntryForm" style="margin-bottom: 0px;">
				<a id="entry-add" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
				<a id="entry-edit" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
				<a id="entry-delete" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			</form>
		</div>
    </div>
</body>
</html>