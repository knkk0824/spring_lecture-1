<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="/WEB-INF/views/include/header.jsp" %>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<!-- left column -->
			<div class="col-md-12">
				<!-- general form elements -->

				<div class="box">
					<div class="box-header with-border">
						<h3 class="box-title">LIST ALL PAGE</h3>
					</div>
					<div class="box-body">
						<a href="createMember"><button class="btn btn-primary">회원등록</button></a>
						<table class="table table-bordered">
							<tr>								
								<th>아이디</th>
								<th>패스워드</th>
								<th>이 름</th>
								<th>이메일</th>
								<th>등록일</th>
								<th>수정일</th>
							</tr>


							<c:forEach items="${memberList}" var="memberVO">

								<tr>
									<td>
										<a href='readMember?userid=${memberVO.userid}'>${memberVO.userid}</a>
									</td>									
									<td>${memberVO.userpw}</td>
									<td>${memberVO.username}</td>
									<td>${memberVO.email}</td>
									
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
											value="${memberVO.regdate}" /></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
											value="${memberVO.updatedate}" /></td>
								</tr>

							</c:forEach>

						</table>

					</div>
					<!-- /.box-body -->
					<div class="box-footer">Footer</div>
					<!-- /.box-footer-->
				</div>
			</div>
			<!--/.col (left) -->

		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>

<%@include file="/WEB-INF/views/include/footer.jsp"%>












