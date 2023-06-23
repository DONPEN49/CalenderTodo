<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<header>
	<div class="header">
		<div>
			<form:form modelAttribute="pageModel">
				<form:hidden path="toPage" value="back" />
				<button class="left_arrow" type="submit"></button>
			</form:form>
		</div>
		<div class="date">
			<h3>
				<c:out value="${calendarModel.thisYear }年"></c:out>
				<c:out value="${calendarModel.thisMonth }月"></c:out>
			</h3>
		</div>
		<div>
			<form:form modelAttribute="pageModel">
				<form:hidden path="toPage" value="next"/>
				<button class="right_arrow" type="submit"></button>
			</form:form>
		</div>
	</div>
</header>