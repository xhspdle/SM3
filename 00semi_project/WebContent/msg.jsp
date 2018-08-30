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
<link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon" />
<link rel="apple-touch-icon" href="<c:url value='/img/apple-touch-icon.png'/>">

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
<link rel="stylesheet" href="<c:url value='/vendor/bootstrap/css/bootstrap.min.css'/>">

<link rel="stylesheet"
	href="<c:url value='/vendor/font-awesome/css/font-awesome.min.css'/>">
<link rel="stylesheet" href="<c:url value='/vendor/animate/animate.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/vendor/simple-line-icons/css/simple-line-icons.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/vendor/owl.carousel/assets/owl.carousel.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/vendor/owl.carousel/assets/owl.theme.default.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/vendor/magnific-popup/magnific-popup.min.css'/>">

<!-- Theme CSS -->
<link rel="stylesheet" href="<c:url value='/css/theme.css'/>">
<link rel="stylesheet" href="<c:url value='/css/theme-elements.css'/>">
<link rel="stylesheet" href="<c:url value='/css/theme-blog.css'/>">
<link rel="stylesheet" href="<c:url value='/css/theme-shop.css'/>">

<!-- Current Page CSS -->
<link rel="stylesheet" href="<c:url value='/vendor/rs-plugin/css/settings.css'/>">
<link rel="stylesheet" href="<c:url value='/vendor/rs-plugin/css/layers.css'/>">
<link rel="stylesheet" href="<c:url value='/vendor/rs-plugin/css/navigation.css'/>">
<link rel="stylesheet"
	href="<c:url value='/vendor/circle-flip-slideshow/css/component.css'/>">

<!-- Skin CSS -->
<link rel="stylesheet" href="<c:url value='/css/skins/default.css'/>">

<!-- Theme Custom CSS -->
<link rel="stylesheet" href="<c:url value='/css/custom.css'/>">
<link rel="stylesheet" href="<c:url value='/css/main.css'/>">


<!-- Head Libs -->
<script src="<c:url value='/vendor/modernizr/modernizr.min.js'/>"></script>

</head>
<body>
	<div class="body">
		<header id="header"
			data-plugin-options="{'stickyEnabled': true, 'stickyEnableOnBoxed': true, 'stickyEnableOnMobile': true, 'stickyStartAt': 100, 'stickySetTop': '-100px'}">
			<jsp:include page="/header.jsp" />
		</header>
		<div role="sub" class="sub">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
						  <!-- Indicators -->
						  <ol class="carousel-indicators">
						    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						    <li data-target="#myCarousel" data-slide-to="1"></li>
						  </ol>
						<c:choose>
						<c:when test="${!empty success }">
						  <!-- Wrapper for slides -->
						  <div class="carousel-inner">
						    <div class="item active">
						      <img src="<c:url value='/etc/successMsg1.jpg'/>" alt="성공1" style="margin:auto;">
						      <div class="carousel-caption">
						        <h3>ServerMsg</h3>
						        <h1>${msg }</h1>
						      </div>
						    </div>
						
						    <div class="item">
						      <img src="<c:url value='/etc/successMsg2.jpg'/>" alt="성공2" style="margin:auto;">
						      <div class="carousel-caption">
						        <h3>ServerMsg</h3>
						        <h1>${msg }</h1>
						      </div>
						    </div>
						  </div>
						 </c:when>
						 <c:otherwise>
						  <!-- Wrapper for slides -->
						  <div class="carousel-inner">
						    <div class="item active">
						      <img src="<c:url value='/etc/failMsg1.png'/>" alt="실패1" style="margin:auto;">
						      <div class="carousel-caption">
						        <h3>ServerMsg</h3>
						        <h1>${msg }</h1>
						      </div>
						    </div>
						
						    <div class="item">
						      <img src="<c:url value='/etc/failMsg2.jpg'/>" alt="실패2" style="margin:auto;">
						      <div class="carousel-caption">
						        <h3>ServerMsg</h3>
						        <h1>${msg }</h1>
						      </div>
						    </div>
						  </div>		 
						</c:otherwise>
						</c:choose>   
						  <!-- Left and right controls -->
						  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
						    <span class="glyphicon glyphicon-chevron-left"></span>
						    <span class="sr-only">Previous</span>
						  </a>
						  <a class="right carousel-control" href="#myCarousel" data-slide="next">
						    <span class="glyphicon glyphicon-chevron-right"></span>
						    <span class="sr-only">Next</span>
						  </a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<footer class="short" id="footer">
			<jsp:include page="/footer.jsp" />
		</footer>
	</div>

	<!-- Vendor -->
	<script src="<c:url value='/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value='/vendor/jquery.appear/jquery.appear.min.js'/>"></script>
	<script src="<c:url value='/vendor/jquery.easing/jquery.easing.min.js'/>"></script>
	<script src="<c:url value='/vendor/jquery-cookie/jquery-cookie.min.js'/>"></script>
	<script src="<c:url value='/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/vendor/common/common.min.js'/>"></script>
	<script src="<c:url value='/vendor/jquery.validation/jquery.validation.min.js'/>"></script>
	<script src="<c:url value='/vendor/jquery.easy-pie-chart/jquery.easy-pie-chart.min.js'/>"></script>
	<script src="<c:url value='/vendor/jquery.gmap/jquery.gmap.min.js'/>"></script>
	<script src="<c:url value='/vendor/jquery.lazyload/jquery.lazyload.min.js'/>"></script>
	<script src="<c:url value='/vendor/isotope/jquery.isotope.min.js'/>"></script>
	<script src="<c:url value='/vendor/owl.carousel/owl.carousel.min.js'/>"></script>
	<script src="<c:url value='/vendor/magnific-popup/jquery.magnific-popup.min.js'/>"></script>
	<script src="<c:url value='/vendor/vide/vide.min.js'/>"></script>

	<!-- Theme Base, Components and Settings -->
	<script src="<c:url value='/js/theme.js'/>"></script>

	<!-- Current Page Vendor and Views -->
	<script src="<c:url value='/vendor/rs-plugin/js/jquery.themepunch.tools.min.js'/>"></script>
	<script src="<c:url value='/vendor/rs-plugin/js/jquery.themepunch.revolution.min.js'/>"></script>
	<script src="<c:url value='/vendor/circle-flip-slideshow/js/jquery.flipshow.min.js'/>"></script>
	<script src="<c:url value='/js/views/view.home.js'/>"></script>

	<!-- Theme Custom -->
	<script src="<c:url value='/js/custom.js'/>"></script>

	<!-- Theme Initialization Files -->
	<script src="<c:url value='/js/theme.init.js'/>"></script>

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
