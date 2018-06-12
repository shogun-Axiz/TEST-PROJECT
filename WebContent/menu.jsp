<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${empty name}">
		<c:redirect url="./index.jsp" />
	</c:if>

	<p>${name}さん、こんにちは</p>

	<p>
		<a href="select.jsp">検索</a>
	</p>
	<p>
		<a href="insert.jsp">登録</a>
	</p>
	<p>
		<a href="update.jsp">更新</a>
	</p>
	<p>
		<a href="delete.jsp">削除</a>
	</p>
	<form action="logout" method="post">
		<input type="submit" value="ログアウト">
	</form>
</body>
</html>
