<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.NumberBeans"%>
<%
NumberBeans numberBeans = (NumberBeans) request.getAttribute("NumberBeans");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果ページ</title>
</head>
<body>
	<h1>結果</h1>
	<p>
		解答：<%=numberBeans.getList()%>
		<%=numberBeans.getMessage()%>
	</p>
	<a href="highLow.jsp">戻る</a>
</body>
</html>