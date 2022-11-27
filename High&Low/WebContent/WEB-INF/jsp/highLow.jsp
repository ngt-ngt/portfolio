<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.NumberBeans"%>
<%
NumberBeans numberBeans = (NumberBeans) session.getAttribute("NumberBeans");
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>High&Low</title>

</head>

<body>

	<h1>High & Low</h1>
	<p>１〜１００の数字を生成しました！</p>
	<p>いくつでしょうか？</p>
	<form action="HighLowServlet" method="post">
		<input type="number"  max="100"
    min="1" name="userInput"> <input type="submit">
	</form>
	<% if(errorMsg != null){ %>
	<p><%= errorMsg %></p>
	<% } %>
	<% if (numberBeans.getList().size() >0){ %>
	<p><%=numberBeans.getMessage() %></p>
	<ol>
	<% for(int i:numberBeans.getList()){%>
		<li><%=i %></li>
	<%} %>
	</ol>
<%} %>
<%if(numberBeans.getUserInput()==numberBeans.getRandomAns()){ %>
	<a href="HighLowServlet">もう一度</a>
<%} %>
</body>
</html>