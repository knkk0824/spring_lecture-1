<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
#modDiv{
	width:300px;
	height:100px;
	background-color:gray;
	position:absolute;
	top:50%;
	left:50%;
	margin-top:-50px;
	margin-left:-150px;
	padding:10px;
	z-index:999999;
	
}
</style>
</head>
<body>
	<div id="modDiv" style="display:none;" >
		<div class="model-title"></div>
		<div>
			<input type="text" id="replytext" />
		</div>
		<div>
			<button type="button" id="replyModBtn">Modify</button>
			<button type="button" id="replyDelBtn">Delete</button>
			<button type="button" id="closeBtn">Close</button>
		</div>
	</div>
	
	<h2>Ajax Test Page</h2>
	<div>
		<form name="frm">
			<input type="hidden" name="bno" value="12298" />
			<div>
				Replyaer <input type='text' name="replyer" id="newReplyWriter" />
			</div>
			<div>
				Reply text <input type="text" name="replytext" id="newReplyText" />
			</div>
			<button id="replyAddBtn">Add reply</button>
		</form>
	</div>
	
	<ul	id="replies">
	</ul>
	


<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>

	$('#closeBtn').on('click',function(){
		$('#modDiv').hide("slow");
	});
	
	
	$('#replies').on("click",".replyLi button",function(){
		var reply=$(this).parent();
		var rno=reply.attr("data-rno");
		var replytext=reply.text();
		
		$('.modal-title').html(rno);
		$('#replytext').val(replytext);
		$('#modDiv').show("slow");
		
	});
	
	var bno=12298;
	
	getAllList();
	
	function getAllList(){
		$.getJSON("/replies/all/"+bno,function(data){
			var str="";
			$(data).each(function(){
				str+="<li data-rno='"+this.rno+"' class='replyLi'>"
				   +this.rno
				   +":"
				   +this.replytext
				   +"<button>MOD</button></li>";				
			});
			$('#replies').html(str);
		});
	};


	$('#replyAddBtn').on("click", function(event) {
		
		event.preventDefault();
		
		var formData = $("form[name='frm']").serialize();
				
		$.ajax({
			type:'post',
			url:"/replies",
			dataType:'text',
			data:formData,
			headers:{				
				"X-HTTP-Method-Override":"POST"
			},
			success : function(result) {
				if (result == 'SUCCESS') {
					alert("등록 되었습니다..");
					getAllList();
				}
			}
		});
		
		
		/* var replyer = $('#newReplyWriter').val();
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
 */
	});
</script>

</body>
</html>










