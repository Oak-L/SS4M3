<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript">
	function deleteItems() {
		//提交form
		document.itemsForm.action = "${pageContext.request.contextPath }/items/deleteItems.action";
		document.itemsForm.submit();
	}
	function queryItems() {
		//提交form
		document.itemsForm.action = "${pageContext.request.contextPath }/items/queryItems.action";
		document.itemsForm.submit();
	}
</script>
</head>
<body>
	<c:if test="${user!=null }">
		<h1>当前用户：${user}</h1>
		<a href="${pageContext.request.contextPath }/logout.action">退出</a>
	</c:if>
	<h1>商品列表</h1>
	<form name="itemsForm" action="${pageContext.request.contextPath }/items/queryItems.action"
		method="post">
		<table border=1 width="50%">
			<tr>
				<td>商品名称</td>
				<td>商品类型<select name="itemType">
						<c:forEach items="${itemTypes }" var="itemType">
							<option value="${itemType.key }">${itemType.value }
						</c:forEach>
				</select>
				</td>
				<td><input type="text" name="itemsCustom.name"></td>
				<td><input type="button" value="查询" onclick="queryItems()"></td>
				<td><input type="button" value="删除选中" onclick="deleteItems()"></td>
				<td><input type="button" value="批量修改"
					onclick="javascrtpt:window.location.href='${pageContext.request.contextPath }/items/listEditItems.action'"></td>
			</tr>
		</table>

		<table border=1 width="100%">
			<tr>
				<td>选择</td>
				<td>名称</td>
				<td>价格</td>
				<td>描述</td>
				<td>图片</td>
				<td>时间</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list}" var="item">
				<tr>
					<td><input type="checkbox" name="items_ids" value="${item.id}"></td>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td>${item.detail}</td>
					<td>${item.pic}</td>
					<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd" /></td>
					<td><a href="${pageContext.request.contextPath}/items/editItems.action?id=${item.id}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>