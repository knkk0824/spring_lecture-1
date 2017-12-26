<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<ul>
		<li><a href="<c:url value="/home/main" />">/home/main</a></li>
		<li><a href="<c:url value="/member/main" />">/member/main</a></li>
		<li><a href="<c:url value="/manager/main" />">/manager/main</a></li>
		<li><a href="<c:url value="/admin/main" />">/admin/main</a></li>
		<li><a href="<c:url value="/j_spring_security_logout" />">
			/j_spring_security_logout
		</a></li>
	</ul>
</body>
</html>



