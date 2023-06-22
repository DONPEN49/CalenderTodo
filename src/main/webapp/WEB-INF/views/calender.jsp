<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="calendar">
	<c:forEach var="weekList" items="${calendar }">
		<div class="week">
			<c:forEach var="day" items="${weekList }">
				<div class="day">
					<c:if test="${not empty day.thisWeek }">
						<c:out value="${day.thisWeek }" /><br>
					</c:if>

					<c:if test="${day.thisDay != 0}">
						<c:out value="${day.thisDay }" />
					</c:if>
				</div>
			</c:forEach>
		</div>
	</c:forEach>
</div>