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
						<div class="featured-box featured-box-primary align-left mt-xlg">
							<div class="box-content">
								<p style="float: left; font-size: 18px; color: #555;">주문내역</p>
								<table class="table">

									<thead>
										<tr>
											<th scope="col"><strong>상품주문번호</strong></th>
											<th scope="col">상품정보</th>
											<th scope="col">상품금액(수량)</th>
											<th scope="col">배송비</th>
											<th scope="col" class="bg_point">진행상태</th>
											<th scope="col">주문날짜</th>
											<th scope="col">구매평</th>
										</tr>
									</thead>
									<tbody>

										<!--orderlist.jsp끼워넣기. -->
										<c:forEach var="vo" items="${requestScope.list }">
														<tr class="group">
												<td><span class="thm ordernum2">${vo.order_num }</span></td>
												<td class="product">
													<div>
														<div class="thmb">
															<div class="img_center">
																<a href="<c:url value='/itemView.do?cmd=select&item_num=${vo.item_num }&item_name=${vo.item_name}'/>" > <img
																	src='<c:url value="/DBImages/${vo.item_savimg }"/>'
																	style="width: 105px; height: 100px;" id="img1"></a> <br>
															</div>
														</div>
														<dl>
															<dt>
																<a href="<c:url value="/mypage_pay_list_detail.jsp"/>">${vo.item_name }</a>
																	<br/>
																	${vo.item_info }
															</dt>
														</dl>
													</div>
												</td>
												
												<td class="money"><em class="thm">${vo.order_pay }</em>원<br>
													<span>(${vo.order_cnt }개)</span></td>
													
												<td class="" rowspan="1">
													<div class="send">
														<div class="sum">무료배송</div>
														<div class=""
															style="max-width: 200px; display: none; z-index: 100">
															<div class="ly_cont"></div>
															<div class="edge_cen"></div>
														</div>
													</div>
												</td>
												<c:choose>
													<c:when test="${vo.order_status=='1' }">
														<td class="bg_point state">배송중<br></td>
													</c:when>
													<c:when test="${vo.order_status=='2' }">
														<td class="bg_point state">배송완료<br></td>
													</c:when>
													<c:when test="${vo.order_status=='3' }">
														<td class="bg_point state">구매확정<br></td>
													</c:when>
													<c:when test="${vo.order_status=='4' }">
														<td class="bg_point state">취소<br></td>
													</c:when>
													<c:when test="${vo.order_status=='5' }">
														<td class="bg_point state">반송<br></td>
													</c:when>
													<c:otherwise>
														<td class="bg_point state">주문내역없음<br></td>
													</c:otherwise>
												</c:choose>
												<td class="" rowspan="1">
													<div class="send">
														<div class="sum">${vo.order_date }</div>
														<div class=""
															style="max-width: 200px; display: none; z-index: 100">
															<div class="ly_cont"></div>
															<div class="edge_cen"></div>
														</div>
													</div>
												</td>
													<td class="" rowspan="1">
													<div class="send">
														<div class="sum"><a href="<c:url value='/itemView.do?cmd=select&item_num=${vo.item_num }&item_name=${vo.item_name}&order_num=${vo.order_num }'/>" class="btn pull-right btn-primary btn-lg" style="margin-left:10px;">
										리뷰쓰기 <i class="fa fa-angle-right ml-xs"></i>
									</a></div>
														<div class=""
															style="max-width: 200px; display: none; z-index: 100">
															<div class="ly_cont"></div>
															<div class="edge_cen"></div>
														</div>
													</div>
												</td>
												
											</tr>
										</c:forEach>

										<!--  -->
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
											<td>${voo.order_recipient}</td>
										</tr>
										<tr>
											<th scope="row">연락처</th>
											<td><span class="tel">${voo.order_phone }</span> <span></span></td>
										</tr>
										<tr>
											<th scope="row">기본배송지</th>
											<td class="address">
											${voo.order_basic_addr }
											</td>
										</tr>
										<tr>
											<th scope="row">상세배송지</th>
											<td class="address">
											${voo.order_detail_addr }
											</td>
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
												<td>무료배송<input type="hidden"
													value="free_shipping" id="shipping_method"
													name="shipping_method">
												</td>
											</tr>
											<tr class="total">
												<th><strong>적립금사용액</strong></th>
												<td>${voo.order_point }원</td>
											</tr>
											<tr class="total">
												<th><strong>총금액</strong></th>
												<td><strong><span class="amount">${voo.order_pay }원</span></strong></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="col-md-12">
								<div class="actions-continue">
									
									<a href="<c:url value='/order.do?cmd=user_update&order_status=5&user_num=${user_num }&order_num=${voo.order_num }'/>" class="btn pull-right btn-primary btn-lg" style="margin-left:10px;">
										반품하기 <i class="fa fa-angle-right ml-xs"></i>
									</a>
									<a href="<c:url value='/order.do?cmd=user_update&order_status=4&user_num=${user_num }&order_num=${voo.order_num }'/>" class="btn pull-right btn-primary btn-lg" >
										취소하기 <i class="fa fa-angle-right ml-xs"></i>
									</a>
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
