<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%@include file="../include/header.jsp"%> --%>
<head>
	<style type="text/css">
		.fileDrop{
			width:80%;
			height:100px;
			border:1px dotted gray;
			background-color:lightslategray;
			margin:auto;
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
					<h3 class="box-title">MODIFY BOARD</h3>
				</div>
				<!-- /.box-header -->

<form role="form" action="modifyPage" method="post">

	<input type='hidden' name='page' value="${cri.page}"> <input
		type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">

					<div class="box-body">

						<div class="form-group">
							<label for="exampleInputEmail1">BNO</label> <input type="text"
								name='bno' class="form-control" value="${boardVO.bno}"
								readonly="readonly">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Title</label> <input type="text"
								name='title' class="form-control" value="${boardVO.title}">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Content</label>
							<textarea class="form-control" name="content" rows="3">${boardVO.content}</textarea>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Writer</label> <input
								type="text" name="writer" class="form-control"
								value="${boardVO.writer}">
						</div>
						<div class="form-group">
							<label >File DROP Here</label>
							<div class="fileDrop"></div>														
						</div>
						
					</div>
					<!-- /.box-body -->
				
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">SAVE</button>
					<button type="submit" class="btn btn-warning">CANCEL</button>
				</div>

	</form>
	
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript" src="/resources/js/upload.js"></script>
<script id="template" type="text/x-handlebars-template">
<li style="width:10%;font-size:0.8em;">
	<span class="mailbox-attachment-icon has-img">
      <img src="{{imgsrc}}" alt="Attachment"></span>
    <div class="mailbox-attachment-info">
	  <a href="{{getLink}} class="mailbox-attachment-name">{{fileName}}</a>
      <a href="{{fullName}}"
         class="btn btn-default btn-xs pull-right delbtn">
			<i class="fa fa-fw fa-remove"></i></a>
    </div>
</li>
</script>
<script>
var template = Handlebars.compile($('#template').html());

$("body").on("dragenter dragover",function(event){
	event.preventDefault();
});

$("body").on("drop",function(event){
	event.preventDefault();
});

$(document).ready(
	function() {

		var formObj = $("form[role='form']");

		console.log(formObj);
		
		formObj.submit(function(event){
			event.preventDefault();
			
			var that=$(this);
			
			var str="";
			$('.uploadedList .delbtn').each(function(index))
		});

		$(".btn-warning")
				.on("click",function() {
					self.location = "/sboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
							+ "&searchType=${cri.searchType}&keyword=${cri.keyword}";
				});

		
	});
</script>




			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->

</body>

<%-- <%@include file="../include/footer.jsp"%> --%>








