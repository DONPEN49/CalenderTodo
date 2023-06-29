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
	<jsp:include page="header.jsp"></jsp:include>
	<main>
		<form:form modelAttribute="formModel">
			<div class="formdisplay">
				<div class="title">
					<h4>
						<form:textarea path="title" rows="5" cols="40" maxlength="100"
							placeholder="タイトル" class="form-title" />
					</h4>
				</div>
				<div class="time">

					<c:out value="${sessionScope.pageModel.year }年"></c:out>
					<c:out value="${sessionScope.pageModel.month }月"></c:out>
					<c:out value="${sessionScope.pageModel.day }日"></c:out>
					<form:hidden path="year" value="${sessionScope.pageModel.year }" />
					<form:hidden path="month" value="${sessionScope.pageModel.month }" />
					<form:hidden path="day" value="${sessionScope.pageModel.day }" />
					<form:input path="time" type="time" value="00:00" />
				</div>


				<div class="content">
					<h4>
						<form:textarea path="content" rows="5" cols="40" maxlength="300"
							placeholder="説明を追加" class="form-content" />
					</h4>
				</div>
				<button class="regist" type="submit">保存</button>
				<button class="back" type="button" onclick="location.href='calendar'">戻る</button>
			</div>
		</form:form>
	</main>



</body>
</html>