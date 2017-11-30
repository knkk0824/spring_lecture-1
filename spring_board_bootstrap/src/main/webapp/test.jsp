<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h2>Ajax Test Page</h2>
	<div>
		<form name="frm">
			<div>
				Replyaer <input type='text' name="replyer" id="newReplyWriter" />
			</div>
			<div>
				Reply text <input type="text" name="replytext" id="newReplyText" />
			</div>
			<button id="replyAddBtn">Add reply</button>
		</form>
	</div>
</body>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$('#replyAddBtn').on("click", function() {
		var replyer = $('#newReplyWriter').val();
		var replytext = $('#newReplyText').val();

		$.ajax({
			type : 'post',
			url : '/replies',
			dataType : 'text',
			contentType : 'application/json',
			data : JSON.stringify({
				bno : 12298,
				replyer : replyer,
				replytext : replytext
			}),
			success : function(result) {
				if (result == 'SUCCESS') {
					alert("등록 되었습니다..");
				}
			}
		});

	});
</script>
</html>










