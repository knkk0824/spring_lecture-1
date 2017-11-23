<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">Modify MEMBER</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">아이디</label> 
							<input type="text" name="userid" class="form-control" value="${memberVO.userid}" readonly="readonly" />
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">패스워드</label> 
							<input type="text" name='userpw' class="form-control" value="${memberVO.userpw}" />
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">이름</label> 
							<input type="text" name="username" class="form-control"	value="${memberVO.username}" />
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">이메일</label> 
							<input type="text" name="email" class="form-control" value="${memberVO.email}">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">가입날짜</label> 
							<input type="text" class="form-control"
								value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm" 
					value="${memberVO.regdate}" />"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">수정날짜</label> 
							<input type="text" class="form-control"
								value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
					value="${memberVO.updatedate}" />"
								readonly="readonly">
						</div>
					</div>
				</form>


				<div class="box-footer">
					<button type="submit" class="btn btn-primary">SAVE</button>
					<button type="submit" class="btn btn-warning">CANCEL</button>
				</div>

				<script>
					$(document).ready(function() {

						var formObj = $("form[role='form']");

						console.log(formObj);

						$(".btn-warning").on("click", function() {
							self.location = "listAll";
						});

						$(".btn-primary").on("click", function() {
							formObj.submit();
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
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>
