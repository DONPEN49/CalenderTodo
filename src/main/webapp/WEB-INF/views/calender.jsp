<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="calendar">
	<c:forEach var="weekList" items="${calendar }">
		<div class="week">
			<c:forEach var="day" items="${weekList }">
				<form:form modelAttribute="pageModel">
					<button class="day" type="submit" id="${day.thisDay }">

						<c:if test="${not empty day.thisWeek }">
							<div class="weeks">
								<c:out value="${day.thisWeek }" />
								<br>
							</div>
						</c:if>


						<c:if test="${day.thisDay != 0}">
							<div class="days">
								<c:out value="${day.thisDay }" />
								<br>
							</div>
						</c:if>

						<c:if test="${not empty day.title }">
							<div class="calendartitle">
								<c:out value="${day.title }" />
							</div>
							<form:hidden path="inData" value="${true }" />
						</c:if>
						<c:if test="${empty day.title }">
							<form:hidden path="inData" value="${false }" />
						</c:if>

						<form:hidden path="year" value="${calendarModel.thisYear }" />
						<form:hidden path="month" value="${calendarModel.thisMonth }" />
						<form:hidden path="day" value="${day.thisDay }" />
						<form:hidden path="toPage" value="form" />

					</button>
				</form:form>
			</c:forEach>
		</div>

	</c:forEach>

</div>