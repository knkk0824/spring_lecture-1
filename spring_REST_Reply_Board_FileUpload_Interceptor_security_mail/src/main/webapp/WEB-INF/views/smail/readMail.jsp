<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <%@include file="../include/header.jsp"%> --%>
<head>
<style>
	.popup{
		position:absolute;
		left:0px;
		top:0px;
	}
	.back{
		background-color:gray;
		opacity:0.5;
		width:100%;
		height:100%;
		overflow:hidden;
		z-index:1101;
	}
	.front{
		z-index:1110;				
		opacity:1;
		border:1px;	
			}
	.show{
		position:relative;
		width:50%;
		height:50%;
		margin:200px auto;
		overflow:hidden;
	}
</style>
	
</head>
<body>
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ Mail</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" action="modifyPage" method="post">

					<input type='hidden' name='mno' value="${mailVO.mno}"> <input
						type='hidden' name='page' value="${cri.page}"> <input
						type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">

				</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Sender</label> <input type="text"
							name="writer" class="form-control" value="${mailVO.from}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Send To</label> <input type="text"
							name="writer" class="form-control" value="${mailVO.to}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label> <input type="text"
							name='title' class="form-control" value="${mailVO.title}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3"
							readonly="readonly">${mailVO.content}</textarea>
					</div>
					
				</div>
				<!-- /.box-body -->

<!-- attach List -->
<ul class="mailbox-attachments clearfix uploadedList" ></ul>

				<div class="box-footer">
			
					<c:if test="${mailVO.uid eq loginUser }">						
						<button id="removeMailBtn" type="submit" class="btn btn-danger">REMOVE</button>
					</c:if>
					<button id="listMailBtn" type="submit" class="btn btn-primary">GO LIST</button>
				</div>
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
	


</section>
<!-- /.content -->

<script type="text/javascript" src="/resources/js/upload.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.js"></script>


<script id="templateAttach" type="text/x-handlebars-template">
	<li data-src='{{fullName}}'>
		<span class="mailbox-attachment-icon has-img">
			<img src="{{imgsrc}}" alt="Attachment" />
		</span>
		<div class="mailbox-attachment-info">
			<a href="{{getLink}}" class="mailbox-attachment-name">
				{{fileName}}</a>
		</div>
	</li>
</script>


<script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");

		console.log(formObj);

		

		$("#removeMailBtn").on("click", function() {
			
			var arr=[];
			$('.uploadedList li').each(function(index){
				arr.push($(this).attr('data-src'));				
			});
			
			if(arr.length>0){
				$.post('/deleteAllFiles',{files:arr},function(){});
			}
			
			
			formObj.attr("action", "removeMail");
			formObj.submit();
		});

		$("#listMailBtn").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "list");
			formObj.submit();
		});
		
		var mno=${mailVO.mno};
		var template=Handlebars.compile($('#templateAttach').html());
		
		$.getJSON("/smail/getAttach/"+mno,function(list){
			$(list).each(function(){
				var fileInfo=getFileInfo(this);
				
				var html=template(fileInfo);
				$(".uploadedList").append(html);
			});
		});
		
		$('.uploadedList').on('click','.mailbox-attachment-info a',function(event){
			var fileLink=$(this).attr("href");
			if(checkImageType(fileLink)){
				event.preventDefault();
				
				var imgTag=$('#popup_img');
				imgTag.attr('src',fileLink);
				
				//console.log(imgTag.attr('src'));
				
				$('.popup').show('slow');
				imgTag.addClass('show');
			}
		});
		
		$('#popup_img').on('click',function(){
			$('.popup').hide('slow');
		});
	});
</script>
</body>
<%-- <%@include file="../include/footer.jsp"%> --%>










