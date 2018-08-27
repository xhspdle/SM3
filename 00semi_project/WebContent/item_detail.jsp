<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="sm3.ldk.dao.ItemViewDao"%>
<%@page import="sm3.ldk.vo.ItemViewVo"%>
<%@page import="java.util.ArrayList"%>
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
<% ArrayList<ItemViewVo> list = (ArrayList)request.getAttribute("list");
   ItemViewVo vo= list.get(0);
   HashMap<Integer,String> list2 = (HashMap)request.getAttribute("list2");
   Set<Integer> key = list2.keySet();
   Iterator<String> color = 
%>
</head>
<body>
	<div class="body">
		<header id="header"
			data-plugin-options="{'stickyEnabled': true, 'stickyEnableOnBoxed': true, 'stickyEnableOnMobile': true, 'stickyStartAt': 100, 'stickySetTop': '-100px'}">
			<jsp:include page="header.jsp" />
		</header>

		<div role="main" class="main shop">

			<div class="container">

				<div class="row">
					<div class="col-md-12">
						<hr class="tall">
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div>
							<div class="thumbnail">
								<img alt="" class="img-responsive img-rounded"
									src="images/<%=vo.getItem_orgimg() %>">
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="summary entry-summary">
							<!-- 제목 -->
							<h1 class="mb-none">
								<strong><%=vo.getItem_name() %></strong>
							</h1>
							<!-- 리뷰순 -->
							<div class="review_num">
								<span class="count" itemprop="ratingCount">2</span> reviews
							</div>
							<!-- 평균추천수 -->
							<div title="Rated 5.00 out of 5" class="star-rating">
								<span style="width: 100%"><strong class="rating">5.00</strong>
									out of 5</span>
							</div>
							<!-- 가격 -->
							<p class="price">
								<span class="amount"><%=vo.getItem_price() %>원</span>
							</p>
							<div class="cboth de_color">
								<a href="#"><span style="background-color: #101010;">1</span></a>
								<a href="#"><span style="background-color: #282c38;">2</span></a>
								<a href="#"><span style="background-color: #244349;">3</span></a>
							</div>
							<!-- 상품설명 -->
							<p class="taller"><%=vo.getItem_info() %></p>
							<form enctype="multipart/form-data" method="post" class="cart">
								<div class="quantity">
									<input type="button" class="minus" value="-"> <input
										type="text" class="input-text qty text" title="Qty" value="1"
										name="quantity" min="1" step="1"> <input type="button"
										class="plus" value="+">
								</div>
								<a href="<c:url value='item_order_list.jsp'/>"
									class="btn btn-primary btn-icon">주문하기</a> <a
									href="<c:url value='cart.jsp'/>"
									class="btn btn-primary btn-icon">장바구니</a>
							</form>
							<div class="product_meta">
								<span class="posted_in">Categories: <a rel="tag" href="#">Accessories</a>,
									<a rel="tag" href="#">Bags</a>.
								</span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="tabs tabs-product">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#productInfo" data-toggle="tab">상품정보</a></li>
								<li><a href="#productReviews" data-toggle="tab">리뷰 (2)</a></li>
							</ul>
							<div class="tab-content">
								<!-- 상품설명 들어가는 곳 -->

								<div class="tab-pane active" id="productInfo">
									<!-- 상품 사이즈 색상 정보 -->
									<table class="table table-striped mt-xl">
										<tbody>
											<tr>
												<th>Size:</th>
												<td>Unique</td>
											</tr>
											<tr>
												<th>Colors</th>
												<td>Red, Blue</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="tab-pane" id="productReviews">
									<!-- 리뷰게시판 -->
									<ul class="comments">
										<li>
											<div class="comment">
												<!-- 리뷰포토 사진 삽입 -->
												<div class="img-thumbnail">
													<img class="avatar" alt="" src="img/avatars/avatar-2.jpg">
												</div>
												<div class="comment-block">
													<div class="comment-arrow"></div>
													<!-- 리뷰작성자 -->
													<span class="comment-by"> <strong>John Doe</strong>
														<span class="pull-right"> <!-- 평점준	 정도 -->
															<div title="Rated 5.00 out of 5" class="star-rating">
																<span style="width: 100%"><strong class="rating">5.00</strong>
																	out of 5</span>
															</div>
													</span>
													</span>
													<!-- 리뷰 내용 -->
													<p>Lorem ipsum dolor sit amet, consectetur adipiscing
														elit. Nam viverra euismod odio, gravida pellentesque urna
														varius vitae, gravida pellentesque urna varius vitae.
														Lorem ipsum dolor sit amet, consectetur adipiscing elit.
														Nam viverra euismod odio, gravida pellentesque urna varius
														vitae. Sed dui lorem, adipiscing in adipiscing et,
														interdum nec metus. Mauris ultricies, justo eu convallis
														placerat, felis enim ornare nisi, vitae mattis nulla ante
														id dui.</p>
												</div>
											</div>
										</li>
									</ul>
									<hr class="tall">
									<h4 class="heading-primary">Add a review</h4>
									<div class="row">
										<div class="col-md-12">
											<form action="" id="submitReview" method="post"
												enctype="multipart/form-data">
												<div class="row">
													<div class="form-group">
														<div class="col-md-6">
															<!-- 리뷰제목입력란 -->
															<label>Your name *</label> <input type="text" value=""
																data-msg-required="Please enter your name."
																maxlength="100" class="form-control" name="title"
																id="title">
														</div>
														<div class="col-md-6">
															<label>Your email address *</label> <input type="file"
																name="file1" class="form-control">
														</div>
													</div>
												</div>
												<div class="row">
													<div class="form-group">
														<div class="col-md-12">
															<label>Review *</label>
															<textarea maxlength="5000"
																data-msg-required="Please enter your message." rows="10"
																class="form-control" name="message" id="message"></textarea>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<input type="submit" value="Submit Review"
															class="btn btn-primary" data-loading-text="Loading...">
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

				<div class="row">
					<div class="col-md-12">
						<hr class="tall">

						<h4 class="mb-md text-uppercase">
							Related <strong>Products</strong>
						</h4>

						<div class="row">

							<ul class="products product-thumb-info-list">
								<li class="col-sm-3 col-xs-12 product"><a
									href="shop-product-sidebar.html"> <span class="onsale">Sale!</span>
								</a> <span class="product-thumb-info"> <a
										href="shop-cart.html" class="add-to-cart-product"> <span><i
												class="fa fa-shopping-cart"></i> Add to Cart</span>
									</a> <a href="shop-product-sidebar.html"> <span
											class="product-thumb-info-image"> <span
												class="product-thumb-info-act"> <span
													class="product-thumb-info-act-left"><em>View</em></span> <span
													class="product-thumb-info-act-right"><em><i
															class="fa fa-plus"></i> Details</em></span>
											</span> <img alt="" class="img-responsive"
												src="img/products/product-1.jpg">
										</span>
									</a> <span class="product-thumb-info-content"> <a
											href="shop-product-sidebar.html">
												<h4>Photo Camera</h4> <span class="price"> <del>
														<span class="amount">$325</span>
													</del> <ins>
														<span class="amount">$299</span>
													</ins>
											</span>
										</a>
									</span>
								</span></li>
								<li class="col-sm-3 col-xs-12 product"><span
									class="product-thumb-info"> <a href="shop-cart.html"
										class="add-to-cart-product"> <span><i
												class="fa fa-shopping-cart"></i> Add to Cart</span>
									</a> <a href="shop-product-sidebar.html"> <span
											class="product-thumb-info-image"> <span
												class="product-thumb-info-act"> <span
													class="product-thumb-info-act-left"><em>View</em></span> <span
													class="product-thumb-info-act-right"><em><i
															class="fa fa-plus"></i> Details</em></span>
											</span> <img alt="" class="img-responsive"
												src="img/products/product-2.jpg">
										</span>
									</a> <span class="product-thumb-info-content"> <a
											href="shop-product-sidebar.html">
												<h4>Golf Bag</h4> <span class="price"> <span
													class="amount">$72</span>
											</span>
										</a>
									</span>
								</span></li>
								<li class="col-sm-3 col-xs-12 product"><span
									class="product-thumb-info"> <a href="shop-cart.html"
										class="add-to-cart-product"> <span><i
												class="fa fa-shopping-cart"></i> Add to Cart</span>
									</a> <a href="shop-product-sidebar.html"> <span
											class="product-thumb-info-image"> <span
												class="product-thumb-info-act"> <span
													class="product-thumb-info-act-left"><em>View</em></span> <span
													class="product-thumb-info-act-right"><em><i
															class="fa fa-plus"></i> Details</em></span>
											</span> <img alt="" class="img-responsive"
												src="img/products/product-3.jpg">
										</span>
									</a> <span class="product-thumb-info-content"> <a
											href="shop-product-sidebar.html">
												<h4>Workout</h4> <span class="price"> <span
													class="amount">$60</span>
											</span>
										</a>
									</span>
								</span></li>
								<li class="col-sm-3 col-xs-12 product"><span
									class="product-thumb-info"> <a href="shop-cart.html"
										class="add-to-cart-product"> <span><i
												class="fa fa-shopping-cart"></i> Add to Cart</span>
									</a> <a href="shop-product-sidebar.html"> <span
											class="product-thumb-info-image"> <span
												class="product-thumb-info-act"> <span
													class="product-thumb-info-act-left"><em>View</em></span> <span
													class="product-thumb-info-act-right"><em><i
															class="fa fa-plus"></i> Details</em></span>
											</span> <img alt="" class="img-responsive"
												src="img/products/product-4.jpg">
										</span>
									</a> <span class="product-thumb-info-content"> <a
											href="shop-product-sidebar.html">
												<h4>Luxury bag</h4> <span class="price"> <span
													class="amount">$199</span>
											</span>
										</a>
									</span>
								</span></li>
							</ul>

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
