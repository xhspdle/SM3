<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<!-- Basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Porto - Responsive HTML5 Template 5.7.2</title>

<meta name="keywords" content="HTML5 Template" />
<meta name="description" content="Porto - Responsive HTML5 Template">
<meta name="author" content="okler.net">

<!-- Favicon -->
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<link rel="apple-touch-icon" href="img/apple-touch-icon.png">

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- Web Fonts  -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800%7CShadows+Into+Light"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Shadows+Into+Light"
	rel="stylesheet">

<!-- Vendor CSS -->
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet"
	href="vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="vendor/animate/animate.min.css">
<link rel="stylesheet"
	href="vendor/simple-line-icons/css/simple-line-icons.min.css">
<link rel="stylesheet"
	href="vendor/owl.carousel/assets/owl.carousel.min.css">
<link rel="stylesheet"
	href="vendor/owl.carousel/assets/owl.theme.default.min.css">
<link rel="stylesheet"
	href="vendor/magnific-popup/magnific-popup.min.css">

<!-- Theme CSS -->
<link rel="stylesheet" href="css/theme.css">
<link rel="stylesheet" href="css/theme-elements.css">
<link rel="stylesheet" href="css/theme-blog.css">
<link rel="stylesheet" href="css/theme-shop.css">

<!-- Current Page CSS -->
<link rel="stylesheet" href="vendor/rs-plugin/css/settings.css">
<link rel="stylesheet" href="vendor/rs-plugin/css/layers.css">
<link rel="stylesheet" href="vendor/rs-plugin/css/navigation.css">
<link rel="stylesheet"
	href="vendor/circle-flip-slideshow/css/component.css">

<!-- Skin CSS -->
<link rel="stylesheet" href="css/skins/default.css">

<!-- Theme Custom CSS -->
<link rel="stylesheet" href="css/custom.css">
<link rel="stylesheet" href="css/main.css">


<!-- Head Libs -->
<script src="vendor/modernizr/modernizr.min.js"></script>

</head>
<body>
	<div class="body">
		<header id="header"
			data-plugin-options="{'stickyEnabled': true, 'stickyEnableOnBoxed': true, 'stickyEnableOnMobile': true, 'stickyStartAt': 100, 'stickySetTop': '-100px'}">
			<jsp:include page="header.jsp" />
		</header>
		<div role="sub" class="sub">
			<section class="section mt-none section-footer">
				<div class="container main_box">
					<div class="row mt-lg">
						<div class="col-md-12">
							<div class="featured-boxes">
								<div class="row">
									<div class="col-sm-8 loginBox">
										<div
											class="featured-box featured-box-primary align-left mt-xlg"
											style="height: 1000px;">
											<div class="box-content">
												<h4 class="heading-primary text-uppercase mb-md">회원가입</h4>
												<form action="/" id="frmSignIn" method="post">
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
																<label>비밀번호</label> <input type="password" value=""
																	class="form-control input-lg">
															</div>
														</div>
													</div>
													<div class="row">
														<div class="form-group">
															<div class="col-md-12">
																<label>비밀번호 확인</label> <input type="password" value=""
																	class="form-control input-lg">
															</div>
														</div>
													</div>
													<div class="row">
														<div class="form-group">
															<div class="col-md-12">
																<label>비밀번호 힌트</label> <select
																	class="form-control input-lg">
																	<option>당신의 보물 1호는?</option>
																	<option>당신의 취미는?</option>
																	<option>당신의 생일은?</option>
																	<option>당신이 좋아하는 음악은?</option>
																</select>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="form-group">
															<div class="col-md-12">
																<label>힌트 답 입력</label> <input type="password" value=""
																	class="form-control input-lg">
															</div>
														</div>
													</div>
													<div class="row join_num">
														<div class="form-group">
															<div class="col-md-12">
																<label>핸드폰 번호</label>
																<div>
																	<select id="rphone2_1" name="rphone2"
																		class="form-control input-lg">
																		<option value="010">010</option>
																		<option value="011">011</option>
																		<option value="016">016</option>
																		<option value="017">017</option>
																		<option value="018">018</option>
																		<option value="019">019</option>
																	</select> - <input id="rphone2_2" name="rphone2_[]"
																		maxlength="4" size="4" value="" type="text"
																		class="form-control input-lg"> - <input
																		id="rphone2_3" name="rphone2" maxlength="4" size="4"
																		value="" type="text" class="form-control input-lg">
																</div>
															</div>
														</div>
													</div>
													<div class="row join_num">
														<div class="form-group">
															<div class="col-md-12">
																<label>주소</label>
																<div>
																	<input id="rzipcode1" name="rzipcode1"
																		 placeholder="" size="6"
																		maxlength="6" readonly="1" value="" type="text"
																		class="form-control input-lg"> <a href="#none"
																		id="btn_search_rzipcode"><img
																		src="//img.echosting.cafe24.com/skin/base_ko_KR/order/btn_zipcode.gif"
																		alt="우편번호"></a><br> <input id="raddr1"
																		name="raddr1"placeholder=""
																		size="40" readonly="1" value="" type="text"
																		class="form-control input-lg"> <span
																		class="grid">기본주소</span><br> <input id="raddr2"
																		name="raddr2"  placeholder=""
																		size="40" value="" type="text"
																		class="form-control input-lg"> <span
																		class="grid">나머지주소</span><span
																		class="grid displaynone">(선택입력가능)</span>
																</div>
															</div>
														</div>
													</div>
													<div class="row join_num">
														<div class="form-group">
															<div class="col-md-12">
																<label>이메일</label>
																<div>
																	<input id="rphone2_2" name="email" maxlength="4"
																		size="8" value="" type="text"
																		class="form-control input-lg"> @ <input
																		id="rphone2_3" name="email" maxlength="4" size="8"
																		value="" type="text" class="form-control input-lg">
																</div>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-md-6" style="margin-top:40px">
															<input type="submit" value="가입완료"
																class="btn btn-primary pull-right mb-xl"
																data-loading-text="Loading...">
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>

								</div>

							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<footer class="short" id="footer">
			<jsp:include page="footer.jsp" />
		</footer>
	</div>

	<!-- Vendor -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/jquery.appear/jquery.appear.min.js"></script>
	<script src="vendor/jquery.easing/jquery.easing.min.js"></script>
	<script src="vendor/jquery-cookie/jquery-cookie.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/common/common.min.js"></script>
	<script src="vendor/jquery.validation/jquery.validation.min.js"></script>
	<script src="vendor/jquery.easy-pie-chart/jquery.easy-pie-chart.min.js"></script>
	<script src="vendor/jquery.gmap/jquery.gmap.min.js"></script>
	<script src="vendor/jquery.lazyload/jquery.lazyload.min.js"></script>
	<script src="vendor/isotope/jquery.isotope.min.js"></script>
	<script src="vendor/owl.carousel/owl.carousel.min.js"></script>
	<script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
	<script src="vendor/vide/vide.min.js"></script>

	<!-- Theme Base, Components and Settings -->
	<script src="js/theme.js"></script>

	<!-- Current Page Vendor and Views -->
	<script src="vendor/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
	<script src="vendor/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
	<script src="vendor/circle-flip-slideshow/js/jquery.flipshow.min.js"></script>
	<script src="js/views/view.home.js"></script>

	<!-- Theme Custom -->
	<script src="js/custom.js"></script>

	<!-- Theme Initialization Files -->
	<script src="js/theme.init.js"></script>

	<!-- Google Analytics: Change UA-XXXXX-X to be your site's ID. Go to http://www.google.com/analytics/ for more information.
		<script>
			(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
			(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
			m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
			})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
		
			ga('create', 'UA-12345678-1', 'auto');
			ga('send', 'pageview');
		</script>
		 -->

</body>
</html>
