<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calender Todo</title>
<link rel="stylesheet" href="resources/stylecalender.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="container">
	<main>
		<jsp:include page="calender.jsp" />
	</main>
	</div>
</body>
</html>