<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>操作员管理</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center,border:false'">
			<form id="contentUpdateForm" method="post">
				<input type="hidden" name="userid" />
				<table class="easyui-panel form-table">
					<tr>
						<td class="form-table-td-left">
							<label for="username">登录用户名:</label>
						</td>
						<td class="form-table-td-right">
							<input class="easyui-validatebox" type="text" name="username" data-options="required:true" />
						</td>
						<td class="form-table-td-left">
							<label for="operatorname">操作员名称:</label>
						</td>
						<td class="form-table-td-right">
							<input class="easyui-validatebox" type="text" name="operatorname" data-options="required:true" />
						</td>
					</tr>
					<tr>
						<td class="form-table-td-left">
							<label for="password">用户密码:</label>
						</td>
						<td class="form-table-td-right">
							<input class="easyui-validatebox" type="password" name="password" data-options="required:true" />
						</td>
						<td class="form-table-td-left">
							<label for="status">操作员状态:</label>
						</td>
						<td class="form-table-td-right">
							<input class="easyui-switchbutton" id="status" name="status" data-options="onText:'开启',offText:'冻结',checked:true">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'south',border:false" style="text-align:right;padding:10px 10px;">
			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="contentUpdatePage.submitForm()" style="width:80px">提交</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="contentUpdatePage.clearForm()" style="width:80px">关闭</a>
		</div>
	</div>
<script type="text/javascript">
var contentUpdatePage  = {
	initFormData:function(){
		$.get("${contextPath}/platform/user/load/${userid}",function(data){
			if(data.status == 200){
				$("#contentUpdateForm").form("load",data.data);
				if(data.data.status == 'T'){  
					$("#status").switchbutton({checked: true});
				}else{  
					$("#status").switchbutton({checked: false});    
				}
			}
		});
	},
	submitForm : function (){
		if(!$('#contentUpdateForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("${contextPath}/platform/user/update",$("#contentUpdateForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增用户成功!');
				$("#userTable").datagrid("reload");
				TT.closeCurrentWindow();
			}
		});
	},
	clearForm : function(){
		TT.closeCurrentWindow();
	}
};
$(function(){
	contentUpdatePage.initFormData();
});
</script>
</body>
</html>