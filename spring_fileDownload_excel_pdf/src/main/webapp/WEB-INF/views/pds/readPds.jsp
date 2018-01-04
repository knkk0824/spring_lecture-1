<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<ul>
		<li>작성자 : ${pds.writer }</li>
		<li>내용 : ${pds.content }</li>
		<li>날짜 : <fmt:formatDate value="${pds.indate }" pattern="yyyy-MM-dd"/>
		</li>
		<li>첨부파일 : <a href="download?fileName=${pds.fileName }">${pds.fileName }</a></li>
	</ul>
</body>
</html>


