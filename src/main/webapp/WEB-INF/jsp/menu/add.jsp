<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>系统菜单添加</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center,border:false'">
			<form id="contentAddForm" method="post">
				<table class="easyui-panel form-table">
				   <tr>
						<td class="form-table-td-left">
							<label for="name">菜单名称:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="name" data-options="required:true,validType:['length[0,64]']" />
						</td>
					    <td class="form-table-td-left">
							<label for="menuPos">菜单位置:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="menuPos" data-options="required:false,validType:['length[0,20]']" value="left"/>
						</td>
				    </tr>
				   <tr>
						<td class="form-table-td-left">
							<label for="href">链接地址:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="href" data-options="required:false,validType:['length[0,512]']" />
						</td>
					    <td class="form-table-td-left">
							<label for="iconCls">菜单图标:</label>
						</td>
						<td class="form-table-td-right">
							<input class="easyui-combobox" name="iconCls" style="width:100%;" data-options="
			                    showItemIcon: true,
			                    data: [
			                        {value:'icon-sys',text:'icon-sys',iconCls:'icon-sys'},
			                        {value:'icon-plus',text:'icon-plus',iconCls:'icon-plus'},
			                        {value:'icon-nav',text:'icon-nav',iconCls:'icon-nav',selected:true},
			                        {value:'icon-users',text:'icon-users',iconCls:'icon-users'},
			                        {value:'icon-role',text:'icon-role',iconCls:'icon-role'},
			                        {value:'icon-set',text:'icon-set',iconCls:'icon-set'},
			                        {value:'icon-log',text:'icon-log',iconCls:'icon-log'},
			                        {value:'icon-table',text:'icon-table',iconCls:'icon-table'},
			                        {value:'icon-file',text:'icon-file',iconCls:'icon-file'},
			                        {value:'icon-setting',text:'icon-setting',iconCls:'icon-setting'},
			                        {value:'icon-menu',text:'icon-menu',iconCls:'icon-menu'},
			                        {value:'icon-test',text:'icon-test',iconCls:'icon-test'},
			                        {value:'icon-count',text:'icon-count',iconCls:'icon-count'},
			                        {value:'icon-rule',text:'icon-rule',iconCls:'icon-rule'}
			                    ],
			                    editable: false,
			                    panelHeight: 'auto'
			                    ">
						</td>
				    </tr>
				   <tr>
						<td class="form-table-td-left">
							<label for="display">是否显示:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-switchbutton" name="display" data-options="onText:'开启',offText:'冻结',checked:true">
						</td>
					    <td class="form-table-td-left">
							<label for="orderNum">序号:</label>
						</td>
						<td class="form-table-td-right">
								<input class="easyui-validatebox" type="text" name="orderNum" data-options="required:true,validType:['length[0,11]']" />
						</td>
				    </tr>
				   <tr>
						<td class="form-table-td-left">
							<label for="pid">父菜单编号:</label>
						</td>
						<td class="form-table-td-right">
							<input class="easyui-combotree" name="pid"
								   data-options="url:'${contextPath}/platform/box/combotree?id=4885635448210517',method:'get'" style="width:100%">
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
		
		$.post("${contextPath}/platform/menu/add",$("#contentAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增成功!');
				$("#menuTable").treegrid("reload");
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