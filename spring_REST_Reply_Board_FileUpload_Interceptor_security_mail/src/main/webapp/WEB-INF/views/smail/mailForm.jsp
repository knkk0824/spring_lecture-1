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
					<h3 class="box-title">Mail Send</h3>
				</div>
				<!-- /.box-header -->

				<form id="mailForm" role="form" method="post">
					<input type="hidden" name="uid" value="${loginUser}" />
					<div class="box-body">
						<div class="form-group">
							<label for="from">Sender</label>							
							<input type="email" id="from" name="from" readonly class="form-control" value="${user.uemail }">
						</div>						
						<div class="form-group">
							<label for="to">Send To</label>							
							<input type="email" id="to" name="to" class="form-control" placeholder="Enter Receiver">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Title</label> <input type="text"
								name='title' class="form-control" placeholder="Enter Title">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Content</label>
							<textarea class="form-control" name="content" rows="3"
								placeholder="Enter ..."></textarea>
						</div>
						
						<div class="form-group">
							<label >File DROP Here</label>
							<div class="fileDrop"></div>														
						</div>
					</div>
					<!-- /.box-body -->

					<div class="box-footer">						
						<div>
							<hr />
						</div>
						<ul class="mailbox-attachments clearfix uploadedList">
						</ul>
						<button type="submit" class="btn btn-primary">SEND</button>
					</div>
				</form>


			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript" src="/resources/js/upload.js"></script>
<script id="template" type="text/x-handlebars-template">
<li style="width:10%;font-size:0.8em;">
	<span class="mailbox-attachment-icon has-img">
      <img src="{{imgsrc}}" alt="Attachment"></span>
    <div class="mailbox-attachment-info">
	  <a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
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
	
	$(".fileDrop").on("drop",function(event){
		//event.preventDefault();
		
		var files = event.originalEvent.dataTransfer.files;
		var file=files[0];
		
		//alert(file);
		
		var formData=new FormData();
		formData.append("file",file);
		
		$.ajax({
			url:"/uploadAjax",
			type:"post",
			data:formData,
			processData:false,
			contentType:false,
			dataType:'text',
			success:function(data){
				var fileInfo=getFileInfo(data);
				var html=template(fileInfo);
				$(".uploadedList").append(html);
			}		
			
		});
	});
	
	$('#mailForm').submit(function(event){
		event.preventDefault();
		
		var that=$(this);
		var str="";
		$('.uploadedList .delbtn').each(function(index){
			str+="<input type='hidden' name='files'"
			+"value='"+$(this).attr('href')+"'>";
		});
		
		that.append(str);
		that.get(0).action="mailSend";
		that.get(0).submit();
	});
	
	$('.uploadedList').on('click','.delbtn',function(event){
		event.preventDefault();
		
		var that=$(this);
		
		$.ajax({
			url:'/deleteFile',
			type:'post',
			dataType:'text',
			data:{fileName:$(this).attr("href")},
			success:function(result){
				if(result=='deleted'){
					that.parent('div').parent('li').remove();
				}
			}
		});
	});
</script>
</body>

<%-- <%@include file="../include/footer.jsp"%> --%>






