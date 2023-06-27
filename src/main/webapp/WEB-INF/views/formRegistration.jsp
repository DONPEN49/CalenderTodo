<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar Todo</title>
<link rel="stylesheet" href="resources/styleregistration.css">
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
		<main>
			<form:form modelAttribute="formModel">
				<div class="title">
					<form:input path="title" value="タイトル" />
				</div>
				<div class="time">
					<c:out value="${sessionScope.pageModel.year }年"></c:out>
					<c:out value="${sessionScope.pageModel.month }月"></c:out>
					<c:out value="${sessionScope.pageModel.day }日"></c:out>
					<form:hidden path="year" value="${sessionScope.pageModel.year }" />
					<form:hidden path="month" value="${sessionScope.pageModel.month }" />
					<form:hidden path="day" value="${sessionScope.pageModel.day }" />
					<form:input path="time" type="time" />
				</div>


				<div class="content">
					<form:textarea path="content" rows="5" cols="40" maxlength="300" placeholder="説明を追加"></form:textarea>
				</div>
				<button type="submit">登録</button>
			</form:form>
		</main>
		<button type="button" onclick="location.href='calendar'">戻る</button>
	</div>

</body>
</html>