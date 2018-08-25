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
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<aside class="sidebar">

							<h4 class="heading-primary" style="text-align:center;">ADMIN-MENU</h4>
							<hr class="short">
							<div class="toggle toggle-primary" data-plugin-toggle="">
								<section class="toggle">
									<label>Admin Managing</label>
									<div class="toggle-content" style="display: none;">
										<div class="list-group">
										  <a href="<c:url value='/admin.jsp?page1=ADMIN_insert.jsp&do1=insert'/>"
										   class="list-group-item">관리자추가</a>
										  <a href="<c:url value='/admin.do?cmd=list'/>"
										   class="list-group-item">관리자목록</a>
										</div>
									</div>
								</section>							
								<section class="toggle">
									<label>Item Managing</label>
									<div class="toggle-content" style="display: none;">
										<div class="list-group">
										  <a href="#" class="list-group-item">분류추가</a>
										  <a href="#" class="list-group-item">분류목록</a>
										  <a href="#" class="list-group-item">컬러추가</a>
										  <a href="#" class="list-group-item">컬러목록</a>
										  <a href="#" class="list-group-item">상품등록</a>
										  <a href="#" class="list-group-item">상품목록</a>
										</div>
									</div>
								</section>													
								<section class="toggle">
									<label>Inventory Managing</label>
									<div class="toggle-content" style="display: none;">
										<div class="list-group">
										  <a href="#" class="list-group-item">상품입고</a>
										  <a href="#" class="list-group-item">입고목록</a>
										  <a href="#" class="list-group-item">재고목록</a>
										</div>
									</div>
								</section>													
								<section class="toggle">
									<label>Sales Report</label>
									<div class="toggle-content" style="display: none;">
										<div class="list-group">
										  <a href="#" class="list-group-item">매출총이익</a>
										  <a href="#" class="list-group-item">기간별판매량</a>
										  <a href="#" class="list-group-item">제품별판매량</a>
										</div>
									</div>
								</section>													
							</div>
							<div class="tabs mb-xlg">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#popularPosts"
										data-toggle="tab"><i class="fa fa-star"></i> Popular</a></li>
									<li><a href="#recentPosts" data-toggle="tab">Recent</a></li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="popularPosts">
										<ul class="simple-post-list">
											<li>
												<div class="post-image">
													<div class="img-thumbnail">
														<a href="blog-post.html"> <img
															src="img/blog/blog-thumb-1.jpg" alt="">
														</a>
													</div>
												</div>
												<div class="post-info">
													<a href="blog-post.html">Nullam Vitae Nibh Un Odiosters</a>
													<div class="post-meta">Jan 10, 2017</div>
												</div>
											</li>
											<li>
												<div class="post-image">
													<div class="img-thumbnail">
														<a href="blog-post.html"> <img
															src="img/blog/blog-thumb-2.jpg" alt="">
														</a>
													</div>
												</div>
												<div class="post-info">
													<a href="blog-post.html">Vitae Nibh Un Odiosters</a>
													<div class="post-meta">Jan 10, 2017</div>
												</div>
											</li>
											<li>
												<div class="post-image">
													<div class="img-thumbnail">
														<a href="blog-post.html"> <img
															src="img/blog/blog-thumb-3.jpg" alt="">
														</a>
													</div>
												</div>
												<div class="post-info">
													<a href="blog-post.html">Odiosters Nullam Vitae</a>
													<div class="post-meta">Jan 10, 2017</div>
												</div>
											</li>
										</ul>
									</div>
									<div class="tab-pane" id="recentPosts">
										<ul class="simple-post-list">
											<li>
												<div class="post-image">
													<div class="img-thumbnail">
														<a href="blog-post.html"> <img
															src="img/blog/blog-thumb-2.jpg" alt="">
														</a>
													</div>
												</div>
												<div class="post-info">
													<a href="blog-post.html">Vitae Nibh Un Odiosters</a>
													<div class="post-meta">Jan 10, 2017</div>
												</div>
											</li>
											<li>
												<div class="post-image">
													<div class="img-thumbnail">
														<a href="blog-post.html"> <img
															src="img/blog/blog-thumb-3.jpg" alt="">
														</a>
													</div>
												</div>
												<div class="post-info">
													<a href="blog-post.html">Odiosters Nullam Vitae</a>
													<div class="post-meta">Jan 10, 2017</div>
												</div>
											</li>
											<li>
												<div class="post-image">
													<div class="img-thumbnail">
														<a href="blog-post.html"> <img
															src="img/blog/blog-thumb-1.jpg" alt="">
														</a>
													</div>
												</div>
												<div class="post-info">
													<a href="blog-post.html">Nullam Vitae Nibh Un Odiosters</a>
													<div class="post-meta">Jan 10, 2017</div>
												</div>
											</li>
										</ul>
									</div>
								</div>
							</div>

							<hr>

							<h4 class="heading-primary">ADMIN</h4>
							<p>admin page를 만들자아</p>

						</aside>
					</div>
					<div class="col-md-9">
						<c:set var="pageName" value="${param.page1 }"/>
						<c:if test="${empty pageName}">
							<c:set var="pageName" value="welcome.jsp"/>
						</c:if>
						<jsp:include page="/admin/${pageName }"/>
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
