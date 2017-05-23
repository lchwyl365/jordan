<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>字典项管理添加</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center,border:false'">
			<form id="contentAddForm" method="post">
				<table class="easyui-panel form-table">
				   <tr>
						<td class="form-table-td-left">
							<label for="dicttypeid">字典编号:</label>
						</td>
						<td class="form-table-td-right">
							<input class="easyui-combotree" name="dicttypeid" id="dicttypeid"
								   data-options="url:'${contextPath}/platform/dict/queryList',method:'get',onLoadSuccess:loadSuccess" style="width:200px">
						</td>
						<td class="form-table-td-left">
							<label for="status">状态:</label>
						</td>
						<td class="form-table-td-right">
							<input class="easyui-switchbutton" name="status" data-options="onText:'开启',offText:'冻结',checked:true">
						</td>
				    </tr>
				   <tr>
				   		<td class="form-table-td-left">
							<label for="dictname">字典项编码:</label>
						</td>
						<td class="form-table-td-right">
							<input class="easyui-validatebox" type="text" name="dictid" data-options="required:true,validType:['length[0,255]']" />
						</td>
						<td class="form-table-td-left">
							<label for="dictname">字典项名称:</label>
						</td>
						<td class="form-table-td-right">
							<input class="easyui-validatebox" type="text" name="dictname" data-options="required:true,validType:['length[0,255]']" />
						</td>
				    </tr>
				   <tr>
				   		<td class="form-table-td-left">
							<label for="sortno">序号:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="sortno" data-options="required:true,validType:['length[0,4]']" />
						</td>
						<td class="form-table-td-left">
							<label for="rank">字典等级:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="rank" data-options="required:false,validType:['length[0,1]']" />
						</td>
				    </tr>
				    <tr>
				    	<td class="form-table-td-left">
							<label for="parentid">上级编号:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="parentid" data-options="required:false,validType:['length[0,255]']" />
						</td>
						<td class="form-table-td-left">
							<label>&nbsp;</label>
						</td>
						<td class="form-table-td-right">
							&nbsp;
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
		
		$.post("${contextPath}/platform/entry/add",$("#contentAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增成功!');
				$("#entryTable").datagrid("reload");
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
function loadSuccess(){
	$("#contentAddForm").form("load",{dicttypeid:'${dicttypeid}',sortno:'${sortno}'});
}
</script>
</body>
</html>