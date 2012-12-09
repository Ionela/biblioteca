<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
	<link type="text/css" rel="stylesheet"	href="<c:url value="/resources/css/main.css" />" />
	<link type="text/css" rel="stylesheet"	href="<c:url value="/resources/css/header.css" />" />
	<link type="text/css" rel="stylesheet"	href="<c:url value="/resources/css/body.css" />" />
	<link type="text/css" rel="stylesheet"	href="<c:url value="/resources/css/extra.css" />" />
</head>
<body>
	<div id="wrapper">
		<%@include file="header.jsp"%>
		<div class="clearFloat"></div>
		<%@include file="body.jsp"%>
	</div>
</body>
</html>
