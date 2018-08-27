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
						<div class="col-sm-5 loginBox">
							<div
								class="featured-box featured-box-primary align-left mt-xlg"
								style="height: 327px;">
								<div class="box-content">
									<h4 class="heading-primary text-uppercase mb-md">관리자 로그인</h4>
									<form action="<c:url value='/admin.do?cmd=login'/>" id="frmSignIn" method="post">
										<div class="row">
											<div class="form-group">
												<div class="col-md-12">
													<label>아이디</label> <input type="text" value=""
														class="form-control input-lg">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group">
												<div class="col-md-12">
												<label>비밀번호</label>
													<input type="password" value=""
														class="form-control input-lg">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<span class="remember-box checkbox"> <label
													for="rememberme"> <input type="checkbox"
														id="rememberme" name="rememberme">아이디 저장
												</label>
												</span>
											</div>
											<div class="col-md-6">
												<input type="submit" value="Login"
													class="btn btn-primary pull-right mb-xl"
													data-loading-text="Loading...">
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="cboth find_area">
							<ul>
								<li><a href="<c:url value='join.jsp'/>">회원가입</a></li>
								<li><a href="/member/id/find_id.html">아이디찾기</a></li>
								<li><a href="/member/passwd/find_passwd_info.html">비밀번호찾기</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>