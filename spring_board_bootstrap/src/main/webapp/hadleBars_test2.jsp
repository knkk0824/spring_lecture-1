<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<div id="displayDiv">

</div>	



<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.js"></script>

<script id="template" type="text/x-handlebars-template">
	<h1>
		<p>{{name}}</p>
		<p>{{userid}}</p>
        <p>{{addr}}</p>
	</h1>
</script>

<script>	
	var source=$('#template').html();
	var template=Handlebars.compile(source);
	var data={name:"홍길동",userid:"user00",addr:"대전광역시"};
	
	$('#displayDiv').html(template(data));
</script>	
</body>
</html>





