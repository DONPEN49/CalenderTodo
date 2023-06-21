<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="calender">
	<div class="week">
		<div class="day">
			<c:out value="${dateDataModel.thisYear }" >年</c:out>
			<c:out value="${dateDataModel.thisMonth }" >月</c:out>
			<c:out value="${dateDataModel.thisDay }" >日</c:out>
			<c:out value="${dateDataModel.thisWeek }" />
		</div>
	</div>

</div>