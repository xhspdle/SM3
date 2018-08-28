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
		<div role="sub" class="sub commBox">
			<section class="section mt-none section-footer">
				<div class="container main_box">
					<div class="row mt-lg">
						<div class="col-md-12">
							<h2 class="commTitle">EVENT&NOTICE</h2>
							<c:if test="${!empty admin_num }">
								<a href="<c:url value='community_event_write.jsp?cmd1=insert'/>"
									class="btn pull-right btn-primary btn-md"> 글쓰기 <i
									class="fa fa-angle-right ml-xs"></i>
								</a>
							</c:if>
							<div class="featured-boxes">
								<div class="row">
									<div class="col-md-12">
										<div class="recent-posts mb-xl main_box">

											<c:forEach var="vo" items="${requestScope.list }">
												<!-- 리스트 들어갈 위치  -->
												<div class="col-md-4">
													<a href="<c:url value='EventNotice.do?cmd=select&en_num=${vo.en_num }'/>"><img
														class="img-responsive" src="<c:url value='/images/${vo.en_savimg }'/>"
														alt="Blog"></a>  

													<div class="recent-posts mt-md mb-lg">
														<article class="post">
														<h5>
														  <class="text-dark" value='community_event_detail.jsp?cmd=select&en_title=${vo.en_title}'/>${vo.en_title}
														</h5>    
															<div class="post-meta">
																<span>EVENT </span> <span>${vo.en_date }</span>
															</div>
														</article>
													</div>
												</div>

											</c:forEach>
											<!-- 페이징 처리랑 검색 폼-->

											<%
												//선택항목을 눌러서 검색어를 입력하는데 선택항목이 고정되게 해준다.
												String search = request.getParameter("search");
												if (search == null) {
													search = "";
												}
												String selected1 = "";
												String selected2 = "";
												String selected3 = "";
												if (search.equals("en_writer")) {
													selected1 = "selected=selected";
												} else if (search.equals("en_title")) {
													selected2 = " selected=selected";
												} else if (search.equals("en_content")) {
													selected3 = " selected=selected";
												}
											%>
											<form method="post"
												action="<c:url value='EventNotice.do?cmd=list'/>">
												<select name="search">
													<option value="en_writer" <%=selected1%>>글쓴이</option>
													<option value="en_title" <%=selected2%>>제목</option>
													<option value="en_content" <%=selected3%>>내용</option>
												</select> <input type="text" name="keyword" value="${param.keyword }">
												<input type="submit" value="찾기">
											</form>
											<br />
											<div>
												<c:choose>
													<c:when test="${startPage>3}">
														<a
															href="<c:url value ='EventNotice.do?cmd=list&pageNum=${startPage-1 }&search=${param.search}&keyword=${param.keyword}'/>">[이전]</a>
													</c:when>
													<c:otherwise>
													[이전]
													</c:otherwise>
												</c:choose>

												<c:forEach var="i" begin="${startPage }" end="${endPage }">
													<c:choose>
														<c:when test="${i==pageNum }">
															<a
																href="<c:url value='EventNotice.do?cmd=list&pageNum=${i }&search=${param.search}&keyword=${param.keyword }'/>">
																<span style="color: red">[${i }]</span>
															</a>
														</c:when>
														<c:otherwise>
															<a
																href="<c:url value='EventNotice.do?cmd=list&pageNum=${i }&search=${param.search}&keyword=${param.keyword }'/>">
																<span style="color: blue">[${i }]</span>
															</a>
														</c:otherwise>
													</c:choose>
												</c:forEach>
												<c:choose>
													<c:when test="${endPage<pageCount }">
														<a
															href="<c:url value='EventNotice.do?cmd=list&pageNum=${endPage+1 }&search=${param.search}&keyword=${param.keyword}'/>">[다음]</a>
													</c:when>
													<c:otherwise>
													[다음]
													</c:otherwise>
												</c:choose>
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
