<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
													<c:forEach var="vo" items="${requestScope.list }">
														<tr class="cart_table_item">
															<td class="product-remove"><a
																title="Remove this item" class="remove" href="#none"> <i
																	class="fa fa-times"></i>
															</a></td>
															<td class="product-thumbnail"><a
																href="shop-product-sidebar.html"> <img width="100"
																	height="100" alt="" class="img-responsive"
																	src="<c:url value='/DBImages/${vo.item_savimg }'/>">
															</a></td>
															<td class="product-name"><a
																href="shop-product-sidebar.html">${vo.item_name }</a></td>

															<td class="product-price"><span class="amount">${vo.item_price }</span>
															</td>
															<td class="product-color"><span class="amount">${vo.color_name }</span>
															</td>
															<td class="product-quantity">
																	<div class="quantity">
																		<input type="button" class="minus" value="-" id="minus" onclick="minus11()"> 

																		<input
																			type="text" class="input-text qty text" title="Qty"
																			value="${vo.order_cnt }" name="order_cnt" min="1" step="1"> 

																			<input
																			type="button" class="plus" value="+" id="plus">
																	</div>

																</td>
															<td class="product-subtotal"><span class="amount">${vo.order_cnt * vo.item_price }원</span>
															</td>
														</tr>
													</c:forEach>
														<tr>
															<td class="actions" colspan="6">
																<div class="actions-continue">
																	<input type="submit" value="장바구니 저장"
																		name="update_cart" class="btn btn-default">
																</div>
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
								style="height: 303px;">
								<div class="box-content">
									<h4 class="heading-primary text-uppercase mb-md">Cart
										Totals</h4>
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
<%-- 
<script type="text/javascript">	
var order_cnt = null;
window.onload = function(){
	order_cnt = document.getElementsByName("order_cnt")[0];
}
function minus11(){
	var cnt=parseInt(order_cnt.value);
	if(cnt<=0){
		return;
	}
	cnt -= 1;
	order_cnt.value = cnt;
}
function plus11(){
	var cnt=parseInt(order_cnt.value);
	cnt += 1;
	order_cnt.value = cnt;
}
</script>
--%>
</html>
