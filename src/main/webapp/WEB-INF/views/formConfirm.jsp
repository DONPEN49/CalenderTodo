<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar ToDo</title>
<link rel="stylesheet" href="resources/styleconfirm.css">
</head>
<body>
	<div>
		<jsp:include page="header.jsp"></jsp:include>

		<main>
			<div class="formdisplay">

				<c:forEach var="formdata" items="${formDatas }">

					<div class="formdate">
						⏲　<c:out value="${formdata.day }日"></c:out>
					</div>
					<div class="time">
						<c:out value="${formdata.time }"></c:out>
					</div>
					<div class="formtitle">
						<c:out value="${formdata.title }"></c:out>
					</div>
					<div class="formcontent">
						<c:out value="${formdata.content }"></c:out>
					</div>
					<div class="delete">
						<form:form modelAttribute="pageModel">

							<button class="button-delete"  type="submit">
								削除
								<form:hidden path="toPage" value="delete" />
							</button>
							<input type="hidden" name="dataid" value="${formdata.dataid }">

						</form:form>
					</div>
				</c:forEach>
				<div class="back">
					<button class="button-back" type="button" onclick="location.href='calendar'">戻る</button>
				</div>
			</div>
		</main>
	</div>
</body>
</html>