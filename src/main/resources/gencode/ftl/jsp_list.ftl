<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${model.menuName}管理</title>
    <script type="text/javascript">
    $(function(){
    	
    <#list model.propertys as property>
	  <#if property.component == "easyui-combotree" && property.comboid?? >
		var combo${property_index}_json = eval('${r"$"}{combo${property_index}_json}');
      </#if>
	</#list>
    	
		<#if model.gentype == "DataGrid">
		$('#${model.path}Table').datagrid({
			title:'${model.menuName}', //标题
			border:false,
			method:'post',
			iconCls:'icon-table', //图标
			singleSelect:false, //多选
			fit:true, //高度
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:false,//可折叠
			url:"${r"${contextPath}"}/${model.businessName}/${model.path}/queryList", //数据来源
			sortName: '${model.idField}', //排序的列
			sortOrder: 'desc', //倒序
			remoteSort: true, //服务器端排序
			idField:'${model.idField}', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				{field:'ck',checkbox:true,width:2}, //显示复选框
			<#list model.displayPropertys as property>
				{field:'${property.columnName}',title:'${property.propertyTitle}',width:${property.width},sortable:'${property.sortable}',
					<#if property.component == "easyui-combotree" && property.comboid?? >
						formatter:function(value,row,index){
							var text = '';
							for(var i=0;i<combo${property_index}_json.length;i++){  
					    		if(row.${property.propertyName} == combo${property_index}_json[i].id){
					    			text = combo${property_index}_json[i].text;
					    		}
					    	}
							return text;
						}
					<#else>
						formatter:${property.formatter}
					</#if>
				}<#sep>,</#sep>
			</#list>
			]],
			toolbar:'#tb',
			onLoadSuccess:function(){
				$('#${model.path}Table').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
		<#elseif model.gentype == "TreeGrid">
		$('#${model.path}Table').treegrid({
			title:'${model.menuName}',
			iconCls:'icon-table',
			border:false,
			rownumbers: true,
			fit:true, //高度
			fitColumns:true,
			url:'${r"${contextPath}"}/${model.businessName}/${model.path}/queryList/0',
			method: 'get',
			idField:'${model.idField}',
			treeField:'${model.treeField}',
			toolbar:'#tb',
			columns:[[
				<#list model.displayPropertys as property>
				{field:'${property.propertyName}',title:'${property.propertyTitle}',width:${property.width}}<#sep>,</#sep>
				</#list>
			]]
		});
		</#if>
		
		$("#add-btn").bind('click',${model.domainObjectName}.addRow);
		$("#del-btn").bind('click',${model.domainObjectName}.deleteRow);
		$("#edit-btn").bind('click',${model.domainObjectName}.updateRow);
		$("#search-btn").bind('click',${model.domainObjectName}.search);
		$("#clear-btn").bind('click',${model.domainObjectName}.clear);

	});
    var ${model.domainObjectName} = {
    		addRow:function(){//新增
  		        TT.createWindow({
  		    	  title:'添加${model.menuName}',
  		    	  width:'700px',
  		    	  height:'260px',
  				  url : "${r"${contextPath}"}/${model.businessName}/${model.path}/add"
  			    });
    		},
    		updateRow:function(){//更新
    			var rows = $('#${model.path}Table').datagrid('getSelections');
    			if(rows.length==0){
    				$.messager.alert('提示',"请选择你要更新的记录",'info');
    				return;
    			}
    			if(rows.length > 1){
    				$.messager.alert('提示',"只能选择一条记录进行更新",'info');
    				return;
    			}
    			var ps = "";
	        <#list model.propertys as property>
			  <#if property.isprimary == "T">
			  	ps += "/" + rows[0].${property.propertyName};
	          </#if>
			</#list>
    			TT.createWindow({
    	  			title:'更新信息',
    	  			url:'${r"${contextPath}"}/${model.businessName}/${model.path}/update'+ps,
    	  			width:'700px',
    	  			height:'260px'
    	  		});
    		},
    		deleteRow:function(){//删除
    			var rows = $('#${model.path}Table').datagrid('getSelections');
	        	if(rows.length==0){
    				$.messager.alert('提示',"请选择你要更新的记录",'info');
    				return;
    			}
    	  		$.messager.confirm('提示','确定要删除吗?',function(result){
    		        if (result){
    		        	var ps = "?1=1";
    		        	$.each(rows,function(i,n){
    		        	<#list model.propertys as property>
					       <#if property.isprimary == "T">
					       	ps += "&${property.propertyName}s="+n.${property.propertyName};
					       </#if>
					   </#list>
    		        	});
    		        	$.post('${r"${contextPath}"}/${model.businessName}/${model.path}/delete'+ps,function(data){
    			        	<#if model.gentype == "DataGrid">
							$("#${model.path}Table").datagrid("reload");
							<#elseif model.gentype == "TreeGrid">
							$("#${model.path}Table").treegrid("reload");
							</#if>
    		        		$.messager.alert('提示',data.msg,'info');
    		        	});
    		        }
    		    });
    	  	},
    	  	search:function(){//表格查询
    			var params = $('#${model.path}Table').datagrid('options').queryParams; //先取得 datagrid 的查询参数
    			var fields =$('#${model.variableName}Form').serializeArray(); //自动序列化表单元素为JSON对象
    			$.each( fields, function(i, field){
    				params[field.name] = field.value; //设置查询参数
    			});
    			$('#${model.path}Table').datagrid('reload'); //设置好查询参数 reload 一下就可以了
    		},
    		//清空查询条件
    		clear:function(){
    			$('#${model.variableName}Form').form('clear');
    			${model.domainObjectName}.search();
    		}
	};
    </script>
</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
    <div data-options="region:'center',border:false">
    	<table id="${model.path}Table"></table>
    	<div id="tb" style="padding:10px;height:auto">
			<form id="${model.variableName}Form" style="margin-bottom: 0px;">
			<#list model.selectPropertys as property>
				<label for="${property.propertyName}" style="margin-left:10px;">${property.propertyTitle}: </label>
				<input class="easyui-textbox" name="${property.propertyName}" style="width:120px;">
			</#list>
			<#if (model.selectPropertys?size > 0)>
				<a id="search-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" style="width:80px;">查询</a>
				<a id="clear-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-clear" style="width:80px;">清空</a>
				<span class="datagrid-btn-separator" style="float:none;margin-left:5px;margin-right:5px;"></span>
			</#if>
			<#if model.isadd == "T">
				<a id="add-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			</#if>
			<#if model.isupdate == "T">
				<a id="edit-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			</#if>
			<#if model.isdelete == "T">
				<a id="del-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			</#if>
			</form>
		</div>
    </div>
</body>
</html>