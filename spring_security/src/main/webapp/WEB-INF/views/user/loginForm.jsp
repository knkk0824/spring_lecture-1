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
	
	<c:if test="${param.error=='true' }" >
		<strong style="color:red;">아이디와 패스워드가 일치하지 않습니다.</strong>
	</c:if>
	
	<form action="<c:url value="/user/login" />" method="post">
		아이디 : <input type="text" name="userid" /><br/>
		패스워드 : <input type="password" name="userpwd" /><br/>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>

