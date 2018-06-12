<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	<p>
		検索したいデータ情報を入力してください<br> ※全て空白の場合は全検索を行います
	</p>

	<form action="select" method="get">
		<fieldset>
			<c:choose>
				<c:when test="${not empty updateList1}">
					<c:forEach var="update1" items="${updateList1 }">
						<div>
							<label>ID</label><input type="text" name="id"
								value="${update1.user_id}">
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${not empty id}">
					<div>
						<label>ID</label><input type="text" name="id" value="${id}">
					</div>
				</c:when>
				<c:otherwise>
					<div>
						<label>ID</label><input type="text" name="id">
					</div>
				</c:otherwise>
			</c:choose>
			<div>
				<label>名前</label><input type="text" name="name">
			</div>
			<div>
				<label>TEL</label><input type="text" name="tel">
			</div>
		</fieldset>
		<input type="submit" value="検索">
	</form>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>
