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
				<div>
					<c:out value="${formdata.time }"></c:out>
				</div>
				<div class="formtitle">
					<c:out value="${formdata.title }"></c:out>
				</div>
				<div class="formcontent">
					<c:out value="${formdata.content }"></c:out>
				</div>
				<form:form modelAttribute="pageModel">
					<div>
						<button type="submit">
							削除
							<form:hidden path="toPage" value="delete" />

						</button>
						<input type="hidden" name="dataid" value="${formdata.dataid }">
					</div>
				</form:form>

			</c:forEach>
			<div>
				<form:form modelAttribute="pageModel">
					<button type="submit">
						追加
						<form:hidden path="toPage" value="add" />
					</button>
				</form:form>
			</div>
			<button type="button" onclick="location.href='calendar'">戻る</button>
		</main>
	</div>

</body>
</html>