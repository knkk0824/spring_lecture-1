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

.pagination{
	width:100%;
}
.pagination li{
	list-style:none;
	float:left;	
	border:1px solid blue;	
	margin-right:3px;
}
.pagination li a{
	display:block;
	text-align:center;
	text-decoration:none;	
	width:30px;
	height:30px;
	line-height:30px;
			
}
.active a{
	font-weight:bold;
	color:red;
	
}

</style>
</head>
<body>
	<div id="modDiv" style="display:none;" >
		<div class="modal-title"></div>
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
	
	<ul class="pagination">
	</ul>


<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	var bno=12298;
	
	var replyPage = 1 ;

	getPageList(replyPage);
	
	$('#replyDelBtn').on('click',function(){
		var rno=$(".modal-title").html();
		$.ajax({
			type:'delete',
			url:"/replies/"+rno,
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"DELETE"
			},
			dataType:'text',
			success:function(result){
				console.log("result:"+result);
				if(result=='SUCCESS'){
					alert("삭제 되었습니다.");
					$("#modDiv").hide('slow');
					getPageList(replyPage);
				}
			}
		});
		
	});
	
	$('#replyModBtn').on('click',function(){
		var rno=$('.modal-title').html();
		var replytext=$('#replytext').val();
		
		$.ajax({
			type:'put',
			url:'/replies/'+rno,
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"PUT"
			},
			data:JSON.stringify({
				replytext:replytext
			}),
			dataType:'text',
			success:function(result){
				console.log("result:"+result);
				if(result=='SUCCESS'){
					alert("수정 되었습니다");
					$("#modDiv").hide("slow");
					getPageList(replyPage);
				}
			}
		});
	});
	
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
	function getPageList(page){
		$.getJSON("/replies/"+bno+"/"+page,function(data){
			var str="";
			$(data.list).each(function(){
				str+="<li data-rno='"+this.rno+"' class='replyLi'>"
				   +this.rno
				   +":"
				   +this.replytext
				   +"<button>MOD</button></li>";				
			});
			$('#replies').html(str);
			
			printPaging(data.pageMaker);
		});
	}
	
	function printPaging(pageMaker){
		var str="";
		if(pageMaker.prev){
			str+="<li><a href='"+(pageMaker.startPage-1)+"'><<</a></li>";
		}
		for(var i=pageMaker.startPage, len=pageMaker.endPage;i<=len;i++){
			var strClass=pageMaker.cri.page==i?'class="active"':'';
			str+="<li "+strClass+"><a href='"+i+"'>"+i+"</a></li>";
		}
		if(pageMaker.next){
			str+="<li><a href='"+(pageMaker.endPage+1)+"'>>></a></li>";
		}
		$('.pagination').html(str);
	};
	
	$(".pagination").on("click","li a",function(event){
		
		event.preventDefault();
		
		replyPage=$(this).attr("href");
		
		getPageList(replyPage);
	});
	
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
					getPageList(1);
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










