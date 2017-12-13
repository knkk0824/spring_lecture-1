<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
.fileDrop{
	width:100%;
	height:200px;
	border:1px dotted blue;
}
</style>
</head>
<body>
	<h3>Ajax File Upload, Drag&Drop</h3>
	<div class='fileDrop'></div>
	
	<div class='uploadedList' ></div>
	
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$(".fileDrop").on("dragenter dragover",function(event){
			event.preventDefault();
		});	
		$(".fileDrop").on("drop",function(event){
			event.preventDefault();
			
			var files=event.originalEvent.dataTransfer.files;
			var file=files[0];
			
			//console.log(file);
			
			var formData=new FormData();
			formData.append("file",file);
			
			$.ajax({
				url:'/uploadAjax',
				type:'post',
				data:formData,
				contentType:false,
				processData:false,
				success:function(data){
					alert(data);
				}
				
			});
			
		});
		
	</script>
</body>
</html>







