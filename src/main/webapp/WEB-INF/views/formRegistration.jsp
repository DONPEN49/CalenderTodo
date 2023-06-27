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
			<div class="formdisplay">
				<div class="title">
					<h3>
						<form:textarea path="title" rows="3" cols="40" maxlength="100"
							placeholder="タイトル" />
					</h3>
				</div>
				<div class="time">

					<c:out value="${sessionScope.pageModel.year }年"></c:out>
					<c:out value="${sessionScope.pageModel.month }月"></c:out>
					<c:out value="${sessionScope.pageModel.day }日"></c:out>
					<form:hidden path="year" value="${sessionScope.pageModel.year }" />
					<form:hidden path="month" value="${sessionScope.pageModel.month }" />
					<form:hidden path="day" value="${sessionScope.pageModel.day }" />
					<br>


					<form:input path="time" type="time" />
				</div>


				<div class="content">
					<h4>
						<form:textarea path="content" rows="5" cols="40" maxlength="300"
							placeholder="説明を追加" />
					</h4>
				</div>

				<button class="regist" type="submit">保存</button>

			</div>
		</form:form>
	</main>
	<button type="button" onclick="location.href='calendar'">戻る</button>


</body>
</html>