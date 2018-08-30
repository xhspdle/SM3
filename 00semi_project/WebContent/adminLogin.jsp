<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<section class="section mt-none section-footer">
	<div class="container main_box">
		<div class="row mt-lg">
			<div class="col-md-9">
				<div class="featured-boxes">
					<div class="row">
						<div class="col-sm-8 loginBox">
							<div
								class="featured-box featured-box-primary align-left mt-xlg"
								style="height: 327px;">
								<div class="box-content">
									<h4 class="heading-primary text-uppercase mb-md">관리자 로그인</h4>
									<c:choose>
										<c:when test="${empty sessionScope.admin_id }">
									<form action="<c:url value='/adminLogin.do?cmd=login'/>" id="frmSignIn" method="post">
										<div class="row">
											<div class="form-group">
												<div class="col-md-12">
													<label>아이디</label> <input type="text" value=""
														class="form-control input-lg" name="admin_id">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group">
												<div class="col-md-12">
												<label>비밀번호</label>
													<input type="password" value=""
														class="form-control input-lg" name="admin_pwd">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<input type="submit" value="Login"
													class="btn btn-primary pull-right mb-xl"
													data-loading-text="Loading...">
											</div>
										</div>
									</form>	
										</c:when>
										<c:otherwise>
									<div class="row">
									<div class="col-md-12">
									<h1>${admin_id }님 환영합니다</h1>
									</div>
									</div>
									<div class="row">
											<div class="col-md-12">
												<a href="<c:url value='/adminLogin.do?cmd=logout'/>"
													class="btn btn-primary pull-right mb-xl"
													role="button">로그아웃</a>
											</div>
										</div>
										</c:otherwise>
									</c:choose>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>