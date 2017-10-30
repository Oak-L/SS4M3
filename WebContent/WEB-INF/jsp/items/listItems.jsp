<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body>
	<h1>1</h1>
	<table border=1 width="100%">
		<tr>
			<td>名称</td>
			<td>价格</td>
			<td>描述</td>
			<td>图片</td>
			<td>时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.detail}</td>
				<td>${item.pic}</td>
				<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd" /></td>
				<td><a href="${pageContext.request.contextPath}/items/editItems.action?id=${item.id}">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>