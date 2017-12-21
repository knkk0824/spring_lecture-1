<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">CREATE MEMBER</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">아이디</label> 
							<input type="text"
								name='userid' class="form-control" placeholder="Enter UserID">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">패스워드</label>
							<input class="form-control" type="password" name="userpw" rows="3"
								placeholder="Enter Password"  />
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">이름</label> 
							<input type="text"
								name="username" class="form-control" 
								placeholder="Enter Name">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">이메일</label> 
							<input type="email"
								name="email" class="form-control" 
								placeholder="Enter Email">
						</div>
					</div>
					<!-- /.box-body -->
				
					<div class="box-footer">
						<button type="submit" class="btn btn-primary">등록완료</button>
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
</div>
<!-- /.content-wrapper -->

<%@include file="/WEB-INF/views/include/footer.jsp"%>
