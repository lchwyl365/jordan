<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>字典生成管理添加</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center,border:false'">
			<form id="contentAddForm" method="post">
				<table class="easyui-panel form-table">
				   <tr>
						<td class="form-table-td-left">
							<label for="name">字典名称:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="name" data-options="required:true,validType:['length[0,32]']" />
						</td>
					    <td class="form-table-td-left">
							<label for="tableName">查询表:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="tableName" data-options="required:true,validType:['length[0,64]']" />
						</td>
				    </tr>
				   <tr>
						<td class="form-table-td-left">
							<label for="valueField">valueField:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="valueField" data-options="required:true,validType:['length[0,64]']" />
						</td>
					    <td class="form-table-td-left">
							<label for="textField">textField:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="textField" data-options="required:true,validType:['length[0,64]']" />
						</td>
				    </tr>
				   <tr>
						<td class="form-table-td-left">
							<label for="condition">查询条件(key:value):</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="condition" data-options="required:false,validType:['length[0,64]']" />
						</td>
					    <td class="form-table-td-left">
							<label for="parentField">parentField:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="parentField" data-options="required:false,validType:['length[0,64]']" />
						</td>
				    </tr>
				   <tr>
						<td class="form-table-td-left">
							<label for="rootValue">根节点值:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="rootValue" data-options="required:false,validType:['length[0,64]']" />
						</td>
			     		<td class="form-table-td-left">
							<label></label>
						</td>
						<td class="form-table-td-right">
						</td>
			     	</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'south',border:false" style="text-align:right;padding:10px 10px;">
			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="contentAddPage.submitForm()" style="width:80px">提交</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="contentAddPage.clearForm()" style="width:80px">关闭</a>
		</div>
	</div>
<script type="text/javascript">
$(function(){
	$('#contentAddForm').form('clear');
});
var contentAddPage  = {
	submitForm : function (){
		if(!$('#contentAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("${contextPath}/platform/box/add",$("#contentAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增用户成功!');
				$("#boxTable").datagrid("reload");
				TT.closeCurrentWindow();
			}else{
				$.messager.alert('添加错误',data.msg,'error');
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