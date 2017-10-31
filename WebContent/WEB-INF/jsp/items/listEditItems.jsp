<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript">
	function saveItems() {
		//提交form
		document.itemsForm.action = "${pageContext.request.contextPath }/items/listEditItemsSubmit.action";
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
	<h1>商品列表</h1>
	<form name="itemsForm" action="${pageContext.request.contextPath }/items/queryItems.action"
		method="post">
		<table border=1 width="50%">
			<tr>
				<!-- <td>商品名称</td>
				<td><input type="text" name="itemsCustom.name"></td>
				<td><input type="button" value="查询" onclick="queryItems()"></td> -->
				<td><input type="button" value="保存全部" onclick="saveItems()"></td>
			</tr>
		</table>

		<table border=1 width="100%">
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>描述</td>
				<td>图片</td>
				<td>时间</td>
			</tr>
			<c:forEach items="${list}" var="item" varStatus="i">
				<tr>
					<td><input type="hidden" name="itemsList[${i.index }].id" value="${item.id}"></td>
					<td><input type="text" name="itemsList[${i.index }].name" value="${item.name}"></td>
					<td><input type="text" name="itemsList[${i.index }].price" value="${item.price}"></td>
					<td><input type="text" name="itemsList[${i.index }].detail" value="${item.detail}"></td>
					<td><input type="text" name="itemsList[${i.index }].pic" value="${item.pic}"></td>
					<td><input type="text" name="itemsList[${i.index }].createtime"
						value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd" />"></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>