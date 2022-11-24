<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.HealthBeans" %>
    <% //リクエストスコープに保存されたBeansインスタンスを取得
    HealthBeans healthBeans = (HealthBeans) request.getAttribute("healthBeans");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>診断結果</title>
</head>
<body>
<h1>診断結果発表！</h1>
<p>
身長：<%= healthBeans.getHeight() %><br>
体重：<%= healthBeans.getWeight() %><br>
BMI：<%= healthBeans.getBmi() %><br>
体型：<%= healthBeans.getBodyType() %><br>
</p>
<a href="HealthCheckServlet">戻る</a>
</body>
</html>