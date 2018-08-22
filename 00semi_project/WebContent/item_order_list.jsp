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
						<h4>kekerori님의 적립 포인트는 000입니다</h4>
						<hr class="tall">
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">

						<div class="featured-boxes">
							<div class="row">
								<div class="col-md-12">
									<div class="featured-box featured-box-primary align-left mt-sm"
										style="">
										<div class="box-content">
											<form method="post" action="">
												<table class="shop_table cart">
													<thead>
														<tr>
															<th class="product-remove">&nbsp;</th>
															<th class="product-thumbnail">&nbsp;</th>
															<th class="product-name">Product</th>
															<th class="product-price">가격</th>
															<th class="product-color">색상</th>
															<th class="product-quantity">수량</th>
															<th class="product-subtotal">Total</th>
														</tr>
													</thead>
													<tbody>

														<tr class="cart_table_item">
															<td class="product-remove"><a
																title="Remove this item" class="remove" href="#"> <i
																	class="fa fa-times"></i>
															</a></td>
															<td class="product-thumbnail"><a
																href="shop-product-sidebar.html"> <img width="100"
																	height="100" alt="" class="img-responsive"
																	src="img/products/product-1.jpg">
															</a></td>
															<td class="product-name"><a
																href="shop-product-sidebar.html">Photo Camera</a></td>

															<td class="product-price"><span class="amount">30000원</span>
															</td>
															<td class="product-color"><span class="amount">red</span>
															</td>
															<td class="product-quantity">
																<div class="quantity">
																	<input type="button" class="minus" value="-"> <input
																		type="text" class="input-text qty text" title="Qty"
																		value="1" name="quantity" min="1" step="1"> <input
																		type="button" class="plus" value="+">
																</div>

															</td>
															<td class="product-subtotal"><span class="amount">$299</span>
															</td>
														</tr>
										
													</tbody>
												</table>

											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="featured-box featured-box-primary align-left mt-xlg"
								style="height: 450px;">
								<div class="box-content">
									<h4 class="heading-primary text-uppercase mb-md">배송지 정보</h4>
									<form action="/" id="frmCalculateShipping" method="post">
										<table summary="" class="table">
											<caption>배송 정보 입력</caption>
											<colgroup>
												<col style="width: 139px;">
												<col style="width: auto;">
											</colgroup>
											<!-- 국내 배송지 정보 -->
											<tbody class="">
												<tr class="">
													<th scope="row">배송지 선택</th>
													<td>
														<div class="address">
															<input id="sameaddr0" name="sameaddr" value="M"
																type="radio"><label for="sameaddr0">회원
																정보와 동일</label> <input id="sameaddr1" name="sameaddr" value="F"
																type="radio"><label for="sameaddr1">새로운배송지</label>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="row">받으시는 분 <img
														src="//img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif"
														alt="필수"></th>
													<td><input id="rname" name="rname"
														class="inputTypeText" placeholder="" size="15" value=""
														type="text"></td>
												</tr>
												<tr>
													<th scope="row">주소 <img
														src="//img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif"
														alt="필수"></th>
													<td><input id="rzipcode1" name="rzipcode1"
														class="inputTypeText" placeholder="" size="6"
														maxlength="6" readonly="1" value="" type="text"> <a
														href="#none" id="btn_search_rzipcode"><img
															src="//img.echosting.cafe24.com/skin/base_ko_KR/order/btn_zipcode.gif"
															alt="우편번호"></a><br> <input id="raddr1"
														name="raddr1" class="inputTypeText" placeholder=""
														size="40" readonly="1" value="" type="text"> <span
														class="grid">기본주소</span><br> <input id="raddr2"
														name="raddr2" class="inputTypeText" placeholder=""
														size="40" value="" type="text"> <span class="grid">나머지주소</span><span
														class="grid displaynone">(선택입력가능)</span></td>
												</tr>
												<tr class="">
													<th scope="row">일반전화 <span class=""><img
															src="//img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif"
															alt="필수"></span>
													</th>
													<td><select id="rphone1_1" name="rphone1_[]">
															<option value="02">02</option>
															<option value="031">031</option>
															<option value="032">032</option>
															<option value="033">033</option>
															<option value="041">041</option>
															<option value="042">042</option>
															<option value="043">043</option>
															<option value="044">044</option>
															<option value="051">051</option>
															<option value="052">052</option>
															<option value="053">053</option>
															<option value="054">054</option>
															<option value="055">055</option>
															<option value="061">061</option>
															<option value="062">062</option>
															<option value="063">063</option>
															<option value="064">064</option>
															<option value="0502">0502</option>
															<option value="0503">0503</option>
															<option value="0504">0504</option>
															<option value="0505">0505</option>
															<option value="0506">0506</option>
															<option value="0507">0507</option>
															<option value="070">070</option>
															<option value="010">010</option>
															<option value="011">011</option>
															<option value="016">016</option>
															<option value="017">017</option>
															<option value="018">018</option>
															<option value="019">019</option>
													</select>-<input id="rphone1_2" name="rphone1_[]" maxlength="4"
														size="4" value="" type="text">-<input
														id="rphone1_3" name="rphone1_[]" maxlength="4" size="4"
														value="" type="text"></td>
												</tr>
												<tr class="">
													<th scope="row">휴대전화 <span class=""><img
															src="//img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif"
															alt="필수"></span>
													</th>
													<td><select id="rphone2_1" name="rphone2_[]">
															<option value="010">010</option>
															<option value="011">011</option>
															<option value="016">016</option>
															<option value="017">017</option>
															<option value="018">018</option>
															<option value="019">019</option>
													</select>-<input id="rphone2_2" name="rphone2_[]" maxlength="4"
														size="4" value="" type="text">-<input
														id="rphone2_3" name="rphone2_[]" maxlength="4" size="4"
														value="" type="text"></td>
												</tr>
											</tbody>
										</table>
									</form>
								</div>
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
												<th><strong>적립금할인</strong></th>
												<td><input type="text" size="5"> (사용할 금액을
													입력해주세요)</td>
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
						<div class="row">
							<div class="col-md-12">
								<div class="actions-continue">
									<button type="submit" class="btn pull-right btn-primary btn-lg">
										구매하기 <i class="fa fa-angle-right ml-xs"></i>
									</button>
								</div>
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
