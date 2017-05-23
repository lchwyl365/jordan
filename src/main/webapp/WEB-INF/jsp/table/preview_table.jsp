<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>表格预览</title>
    
</head>
<body style="overflow-y: hidden;" scroll="no" >
	    <table id="tt" class="easyui-datagrid" style="height:auto;min-height:340px;margin:10px;width:100%;"
		        title="${sysTables.menuName}" url='${contextPath}/${sysTables.path}/queryList'
		        toolbar="#tb" rownumbers="true" pagination="true"  fitColumns="true">
		    <thead>
		        <tr>
		        	<c:forEach items="${displayPropertys}" var="sysColumns" varStatus="status">
		        		<th field="${sysColumns.propertyName}" width="${sysColumns.width}" >${sysColumns.propertyTitle}</th>
		        	</c:forEach>
		        </tr>
		    </thead>
		</table>
		<div id="tb" style="padding:10px;height:auto">
		    <form style="margin-bottom: 0px;">
		       	<c:if test="${selectPropertys != null && fn:length(selectPropertys) > 0}">
		       		<c:forEach items="${selectPropertys}" var="property">
			       		<label for="${property.propertyName}" style="margin-left:10px;">${property.propertyTitle}: </label>
						<input class="easyui-textbox" name="${property.propertyName}" style="width:120px;">
			       	</c:forEach>
		       		<a id="search-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" style="width:80px;">查询</a>
					<a id="clear-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-clear" style="width:80px;">清空</a>
					<span class="datagrid-btn-separator" style="float:none;margin-left:5px;margin-right:5px;"></span>
		       	</c:if>
				<c:if test="${sysTables.isadd == 'T'}">
					<a id="add-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
				</c:if>
				<c:if test="${sysTables.isupdate == 'T'}">
					<a id="edit-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
				</c:if>
				<c:if test="${sysTables.isdelete == 'T'}">
					<a id="del-btn" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
				</c:if>
			</form>
		</div>
</body>
<script type="text/javascript">
$(function(){

});
</script>

</html>