<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	<form action="./login" method="post">
		<fieldset>
			<div>
				<label>ID</label><input type="text" name="admin_id" value="${fn:escapeXml(param.admin_id) }">
			</div>
			<div>
				<label>PASS</label><input type="password" name="password" value="${fn:escapeXml(param.password) }">
			</div>
		</fieldset>
		<input type="submit" value="ログイン">
	</form>
	<div>
		<a href="index.jsp">TOP画面へ</a>
	</div>
</body>
</html>