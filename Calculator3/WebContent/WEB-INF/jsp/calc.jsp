<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.CalcBeans"%>
<%
CalcBeans calcBeans = (CalcBeans) request.getAttribute("calcBeans");
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>電卓アプリ</title>
</head>
<body>
	<h1>Let's 電卓！</h1>
	<form action="CalcServlet" method="post">
		<input type="text" name="number1"> <select name="calc">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="×">×</option>
			<option value="÷">÷</option>
		</select> <input type="text" name="number2">=
		<%if(errorMsg !=null){ %>
		<%= errorMsg %>
		<%}

		else if (calcBeans.getAns() != null) {
 %>
		<%=calcBeans.getAns()%>
		<%
		}
		%>
		<br><input type="submit" value="計算">
	</form>
</body>
</html>