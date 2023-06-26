<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar Todo</title>
<link rel="stylesheet" href="resources/stylecalender.css">
</head>
<body>
	<div class="formdisplay">
		<header>
			<div class="date">
				<h3>
					<c:out value="${sessionScope.pageModel.year }年"></c:out>
					<c:out value="${sessionScope.pageModel.month }月"></c:out>
				</h3>
			</div>
		</header>
		<div id="form">
			<form:form modelAttribute="formDatasModel">
				<div class="title">
					<form:input path="title" value="予定を入力してください" />
				</div>
				<div class="time">
					<c:out value="${sessionScope.pageModel.year }年"></c:out>
					<c:out value="${sessionScope.pageModel.month }月"></c:out>
					<c:out value="${sessionScope.pageModel.day }日"></c:out>

				</div>


				<div class="content">
					<form:textarea path="content" value="説明を追加" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>