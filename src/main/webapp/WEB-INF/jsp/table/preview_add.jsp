<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加预览</title>
</head>
<body style="overflow-y: hidden;margin:0px;padding:10px;" scroll="no" >
	<div title="${sysTables.menuName}" style="margin:0px auto;width:100%;heigth:auto;background-color:#FFF;" >
		<div style="padding:10px;">
			<form id="contentAddForm" method="post">
				<table class="easyui-panel form-table" style="width:100%">
					<c:forEach items="${addPropertys}" var="property" varStatus="status">
						<c:if test="${status.index % 2 == 0 }">
					<tr>
						<td class="form-table-td-left">
							<label for="${property.propertyName}">${property.propertyTitle}:</label>
						</td>
						<td class="form-table-td-right">
							<c:if test="${property.component == 'easyui-validatebox'}">
								<input class="easyui-validatebox" type="text" name="${property.propertyName}" data-options="${property.dataOptions}" />
							</c:if>
							<c:if test="${property.component == 'easyui-switchbutton'}">
								<input class="easyui-switchbutton" name="${property.propertyName}" data-options="${property.dataOptions}" />
							</c:if>
							<c:if test="${property.component == 'easyui-combotree'}">
								<input class="easyui-combotree" name="${property.propertyName}"
								   data-options="url:'${contextPath}/platform/box/combotree?id=${property.comboid}',method:'get'" style="width:100%">
							</c:if>
						</td>
						</c:if>
						<c:if test="${status.index % 2 != 0 }">
						<td class="form-table-td-left">
							<label for="${property.propertyName}">${property.propertyTitle}:</label>
						</td>
						<td class="form-table-td-right">
							<c:if test="${property.component == 'easyui-validatebox'}">
								<input class="easyui-validatebox" type="text" name="${property.propertyName}" data-options="${property.dataOptions}" />
							</c:if>
							<c:if test="${property.component == 'easyui-switchbutton'}">
								<input class="easyui-switchbutton" name="${property.propertyName}" data-options="${property.dataOptions}" />
							</c:if>
							<c:if test="${property.component == 'easyui-combotree'}">
								<input class="easyui-combotree" name="${property.propertyName}"
								   data-options="url:'${contextPath}/platform/box/combotree?id=${property.comboid}',method:'get'" style="width:100%">
							</c:if>
						</td>
			     	</tr>
						</c:if>
					</c:forEach>
			     		<c:if test="${fn:length(addPropertys) % 2 != 0}">
			     		<td class="form-table-td-left">
							<label></label>
						</td>
						<td class="form-table-td-right">
						</td>
			     	</tr>
			     		</c:if>
				</table>
			</form>
		</div>
		<div style="text-align:right;padding:10px 10px;">
			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" style="width:80px">提交</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" style="width:80px">关闭</a>
		</div>
	</div>
<script type="text/javascript">
$(function(){
	
});
</script>
</body>
</html>