<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

		<div role="main" class="main shop">
			<div class="container" style="margin-top: 80px;">
				<div class="row">
					<div class="col-md-12">
						<div class="featured-box featured-box-primary align-left mt-xlg">
							<div class="box-content">
								<table class="table">
									<caption>주문내역</caption>
									<thead>
										<tr>
											<th scope="col"><strong>상품주문번호</strong></th>
											<th scope="col">상품정보</th>
											<th scope="col">상품금액(수량)</th>
											<th scope="col" class="bg_point">배송비</th>
											<th scope="col" class="bg_point">진행상태</th>
										</tr>
									</thead>
									<tbody>
										<tr class="group">
											<td><span class="thm ordernum2">2018073088503591</span></td>
											<td class="product">
												<div>
													<div class="thmb">
														<div class="img_center">
															<a href="" target="_blank"><img
																src="https://order.pay.naver.com/proxy/phinf/shop1/20180512_71/wnsdkadlrj_15261290280296QFQU_JPEG/49435328655598750_619657460.jpg?type=m80"
																alt="탁상용 선풍기 미니 사무실 책상용 소형 저소음 USB 테이블 원룸 작은"></a>
														</div>
													</div>
													<dl>
														<dt>
															<strong>[스마트스토어] 모아두아</strong> <a href="#"
																target="_blank">탁상용 선풍기 미니 사무실 책상용 소형 저소음 USB 테이블 원룸
																작은</a>
														</dt>
														<dd>색상: 화이트, 사이즈: M</dd>
														<dd class="shp_toggle"></dd>
													</dl>
												</div>
											</td>
											<td class="money"><em class="thm">34,900</em>원<br>
												<span>(1개)</span></td>
											<td class="" rowspan="1">
												<div class="send">
													<div class="sum">
														<em class="thm">2,500</em>원
													</div>
													<div class=""
														style="max-width: 200px; display: none; z-index: 100">
														<div class="ly_cont"></div>
														<a href="#" class=""><span class="blind">닫기</span></a>
														<div class="edge_cen"></div>
													</div>
												</div>
											</td>
											<td class="bg_point state">구매확정<br>
											</td>

										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="featured-box featured-box-primary align-left mt-xlg">
							<div class="box-content">
								<table class="table">
									<caption>배송지 정보</caption>
									<thead class="blind">
										<tr>
											<th scope="col">배송지 정보</th>
											<th scope="col">배송지 정보입력</th>
										</tr>
									</thead>
									<tbody>
										<tr class="gap">
											<th scope="row">수령인</th>
											<td>진수현</td>
										</tr>
										<tr>
											<th scope="row">연락처</th>
											<td><span class="tel">010-4234-6618</span> <span></span></td>
										</tr>
										<tr>
											<th scope="row">배송지</th>
											<td class="address">06953<br> 서울시 구구구 등촌동 샤브샤브짱
											<br> 샤브샤브먹고싶어
											</td>
										</tr>
										<tr class="gap3">
											<th scope="row">배송메모</th>
											<td>빨리배송해주세요~</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="featured-box featured-box-primary align-left mt-xlg"
								style="height: 303px;">
								<div class="box-content">
									<h4 class="heading-primary text-uppercase mb-md">결제 예정 금액</h4>
									<table class="cart-totals">
										<tbody>
											<tr class="shipping">
												<th>배송정보</th>
												<td>기본 배송(2500원)<input type="hidden"
													value="free_shipping" id="shipping_method"
													name="shipping_method">
												</td>
											</tr>
											<tr class="total">
												<th><strong>적립금사용액</strong></th>
												<td>500원</td>
											</tr>
											<tr class="total">
												<th><strong>총금액</strong></th>
												<td><strong><span class="amount">$431</span></strong></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="col-md-12">
								<div class="actions-continue">
									<button type="submit" class="btn pull-right btn-primary btn-lg" style="margin-left:10px;">
										반품하기 <i class="fa fa-angle-right ml-xs"></i>
									</button>
									<button type="submit" class="btn pull-right btn-primary btn-lg" >
										취소하기 <i class="fa fa-angle-right ml-xs"></i>
									</button>
								</div>
							</div>
					</div>
				</div>
			</div>
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
