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
<script>
	var xhr = null;
	function itemList() {
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open('get', 'itemView.do?cmd=select_cate&cate_num=1', true);
		xhr.send();

	}
	function callback() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var cnt = 8;
			var txt = xhr.responseText;
			var json = JSON.parse(txt);
			var box = document.getElementsByClassName("mt-lg");
			for (var i = 0 ; i < cnt ; i++) {
				if (i%4==0) {
					var div = document.createElement("div");
					div.className = "col-md-3";
					div.innerHTML = "<a href='<c:url value='item_detail.jsp?item_num=${vo.item_num}'/>'>"
							+ "<img class='img-responsive' src='<c:url value='images/"+json.arr[i].item_orgimg+"'/>'alt='Blog'></a>"
							+ "<div class='recent-posts mt-md mb-lg'>"
							+ "<article class='post'>"
							+ "<h5>" + json.arr[i].size_name +
							+ "<a class='text-dark' href='<c:url value='item_detail.jsp'/>'>"
							+ json.arr[i].item_name
							+ "</a>"
							+ "</h5>"
							+ "<div class='post-meta' class='item_info'>"
							+ "<span><i class='fa fa-tag'></i>"
							+ json.arr[i].item_price
							
							+ "</span>"
							+ "<span><i class='fa fa-comments'></i> <a href='#'>500 Comments</a></span>"
							+ "</div>" + "</article>" + "</div>"
					box[0].appendChild(div);
				}

			}
			cnt += 8;
		}
	}
</script>

</head>
<body onload="itemList()">
	<div class="body">
		<header id="header"
			data-plugin-options="{'stickyEnabled': true, 'stickyEnableOnBoxed': true, 'stickyEnableOnMobile': true, 'stickyStartAt': 100, 'stickySetTop': '-100px'}">
			<jsp:include page="header.jsp" />
		</header>
		<div class="col-md-12">
			<div class="tabs tabs-bottom tabs-center tabs-simple">
				<ul class="nav nav-tabs">
					<li class=""><a href="#tabsNavigationSimple1"
						data-toggle="tab" aria-expanded="false">ALL</a></li>
					<li class=""><a href="#tabsNavigationSimple2"
						data-toggle="tab" aria-expanded="false">OUTER</a></li>
					<li class=""><a href="#tabsNavigationSimple3"
						data-toggle="tab" aria-expanded="false">TOP</a></li>
					<li class="active"><a href="#tabsNavigationSimple4"
						data-toggle="tab" aria-expanded="true">BOTTOM</a></li>
				</ul>
			</div>
		</div>
		<div role="sub" class="sub">
			<section class="section mt-none section-footer">
				<div class="container main_box">
					<div class="row mt-lg"></div>
					<p class="txtCenter">
						<button onclick="itemList()" type="button"
							class="btn btn-default mr-xs mb-sm">상품 더보기</button>
					</p>
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
