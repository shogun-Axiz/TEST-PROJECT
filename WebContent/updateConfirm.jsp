<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容確認画面</title>
<link href="css/commons.css" rel="stylesheet">
<style>
.col {
	float: left;
}

.col-clear {
	clear: both;
}

#arrow {
	margin-top: 60px;
}
</style>
</head>
<body>
	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	<p>これでよろしいですか？</p>

	<form action="updateConfirm" method="post">
		<fieldset>
			<c:forEach var="update1" items="${updateList1 }">
				<div>
					<label>ID</label><input type="text" name="id"
						value="${update1.user_id}" readonly>
				</div>
			</c:forEach>
		</fieldset>

		<fieldset class="col">
			<legend>変更前</legend>
			<c:forEach var="update1" items="${updateList1 }">
				<div>
					<label>名前</label><input type="text" value="${update1.user_name}"
						disabled>
				</div>
				<div>
					<label>TEL</label><input type="text" value="${update1.telephone}"
						disabled>
				</div>
				<div>
					<label>PASS</label><input type="password"
						value="${update1.password}" disabled>
				</div>
			</c:forEach>
		</fieldset>

		<div id="arrow" class="col">⇒</div>

		<fieldset class="col label-110">
			<legend>変更後</legend>
			<div>
				<label>名前</label><input type="text" name="newName"
					value="${fn:escapeXml(update2.user_name)}" readonly>
			</div>
			<div>
				<label>TEL</label><input type="text" name="newTel"
					value="${fn:escapeXml(update2.telephone)}" readonly>
			</div>
			<c:if test="${empty oldPass}">
			<div>
				<label>PASS(再入力)</label><input type="password" name="rePass">
			</div>
			</c:if>
			<c:if test="${not empty oldPass}">
			<div>
				<label>PASS(再入力)</label><input type="password" name="rePass"
					value="<%=session.getAttribute("oldPass")%>">
			</div>
			</c:if>
		</fieldset>

		<div class="col-clear">
			<input type="submit" name="button" value="更新"> <input
				type="submit" name="button" value="戻る"
				onclick="location.href='updateInput.jsp'; return false;">
		</div>
	</form>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>