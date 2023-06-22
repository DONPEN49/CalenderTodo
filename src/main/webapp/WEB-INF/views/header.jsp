<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<header>
	<div class="header">
			<div>
				<a href="back" class="left_arrow"></a>
			</div>
			<div class="date">
				<h3>
					<c:out value="${calendarModel.thisYear }年"></c:out>
					<c:out value="${calendarModel.thisMonth }月"></c:out>
				</h3>
			</div>
			<div>
				<a href="next" class="right_arrow"></a>
			</div>
	</div>
</header>