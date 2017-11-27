<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>에러발생</h1>
	<span>에러메세지 : ${exception.message }</span>
	<a href='<c:url value="/sboard/list" />'>
		<button class="btn btn-primary">첫화면</button>
	</a>
</body>
</html>





