<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.KujiBeans"%>
<%
KujiBeans kujiBeans = (KujiBeans) request.getAttribute("kujiBeans");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.img {
	width: 400px;
	height: 400px;
	object-fit: contain;
}

.img_small {
	width: 60px;
	height: 60px;
	object-fit: contain;
}
</style>
<title>おみくじ結果！</title>
</head>
<body>
	<h1>今日の運勢は</h1>
	<%
	if (kujiBeans.getKujiNum() == 1) {
	%>
	<img alt="omikuji" src="img/omikuji_daikichi.png" class="img">

	<%
	} else if (kujiBeans.getKujiNum() == 2) {
	%>
	<img alt="omikuji" src="img/omikuji_chukichi.png" class="img">
	<%
	} else if (kujiBeans.getKujiNum() == 3) {
	%>
	<img alt="omikuji" src="img/omikuji_kichi.png" class="img">
	<%
	} else if (kujiBeans.getKujiNum() == 4) {
	%>
	<img alt="omikuji" src="img/omikuji_kyo.png" class="img">
	<%
	} else {
	%>
	<img alt="omikuji" src="img/omikuji_daikyo.png" class="img">
	<%
	}
	%>
	<img alt="omikuji" src="img/omikuji.png" class="img_small">
	<a href="OmikujiServlet">もう一回</a>
</body>
</html>