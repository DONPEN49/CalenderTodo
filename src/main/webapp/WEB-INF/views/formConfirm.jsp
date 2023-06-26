<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar ToDo</title>
<link rel="stylesheet" href="resources/stylecalender.css">
</head>
<body>
	<div class="formdisplay">
		<header>
			<div>
				<h3>
					<c:out value="${sessionScope.pageModel.year }年"></c:out>
					<c:out value="${sessionScope.pageModel.month }月"></c:out>
					<c:out value="${sessionScope.pageModel.day }日"></c:out>
				</h3>
			</div>
		</header>
		<main>
			<c:forEach var="formdata" items="${formDatas }">

				<div class="formdate">
					<c:out value="${formdata.day }"></c:out>
				</div>
				<div class="formtitle">
					<c:out value="${formdata.title }"></c:out>
				</div>
				<div class="formcontent">
					<c:out value="${formdata.content }"></c:out>
				</div>
			</c:forEach>

		</main>
	</div>

</body>
</html>