<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容入力画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	<p>
		１箇所以上の項目を変更してください<br> ※IDは変更できません
	</p>

	<form action="updateInput" method="post">
		<fieldset>
			<c:forEach var="update1" items="${updateList1 }">
				<div>
					<label>ID</label><input type="text" name="id"
						value="${update1.user_id}" readonly>
				</div>
				<div>
					<label>名前</label><input type="text" name="newName" value="${update1.user_name}">
				</div>
				<div>
					<label>TEL</label><input type="text" name="newTel" value="${update1.telephone}">
				</div>
				<div>
					<label>PASS</label><input type="password" name="newPass" value="${update1.password}">
				</div>
			</c:forEach>
		</fieldset>
		<div>
			<input type="submit" name="button" value="確認"> <input
				type="submit" name="button" value="戻る"
				onclick="location.href='update.jsp'; return false;">
		</div>
	</form>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>