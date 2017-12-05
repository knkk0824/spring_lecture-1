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
	{{#each .}}
		<li class="replyLi">
			<div>{{rno}}</div>
  			<div>{{replyer}}</div>
		    <div>{{replytext}}</div>
			<div>{{replydate}}</div>
		</li>
	{{/each}}
</script>

<script>	
	var source=$('#template').html();
	var template=Handlebars.compile(source);
	var data=[
	          {rno:1, replyer:"user00",replytext:"1번 댓글..",replydate:new Date()},
	          {rno:2, replyer:"user01",replytext:"2번 댓글..",replydate:new Date()},
	          {rno:3, replyer:"user02",replytext:"3번 댓글..",replydate:new Date()},
	          {rno:4, replyer:"user03",replytext:"4번 댓글..",replydate:new Date()},
	          {rno:5, replyer:"user04",replytext:"5번 댓글..",replydate:new Date()},
	          ];
	
	$('#displayDiv').html(template(data));
</script>	
</body>
</html>





