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
	<!-- 显示商品错误信息 -->
	<c:if test="${allErrors!=null }">
		<c:forEach items="${allErrors }" var="error">
		${error.defaultMessage }
	</c:forEach>
	</c:if>
	<form action="${pageContext.request.contextPath }/items/editItemsSubmit.action" method="post">
		<input type="hidden" name="id" value="${itemsCustom.id}">
		<table border=1 width="100%">
			<tr>
				<td>名称</td>
				<td><input type="text" name="name" value="${itemsCustom.name}"></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" name="price" value="${itemsCustom.price}"></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><textarea rows="3" name="detail">${itemsCustom.detail}</textarea></td>
			</tr>
			<tr>
				<td>图片</td>
				<td><input type="text" name="pic" value="${itemsCustom.pic}"></td>
			</tr>
			<tr>
				<td>时间</td>
				<td><input type="text" name="createtime"
					value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd" />"></td>
			</tr>
			<tr>
				<td>操作</td>
				<td><input type="submit" value="确认"></td>
		</table>
	</form>
</body>
</html>