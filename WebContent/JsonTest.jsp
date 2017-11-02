<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json交互的测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	//输入的json，输出的json
	function requestJson() {
		$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath }/requestJson.action',
			contentType : 'application/json;charset=utf-8',
			//数据格式是json串
			data : '{"name":"宏碁","价格":3333}',
			success : function(data) {//返回json结果
				alert(data.name);
			}
		});
	}
	//输入的key/value，输出的json
	function responseJson() {
		$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath }/responseJson.action',
			data : 'name=宏碁电脑&price=3333',
			success : function(data) {//返回json结果
				alert(data.name);
			}
		});
	}
</script>
</head>
<body>
	<input type="button" onclick="requestJson()" value="输入的json，输出的json">
	<hr>
	<input type="button" onclick="responseJson()" value="输入的key/value，输出的json">
</body>
</html>