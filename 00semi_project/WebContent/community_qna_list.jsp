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
<script src="vendor/modernizr/modernizr.min.js">



function searchCheck(frm){
    //검색
   
    if(frm.keyWord.value ==""){
        alert("검색 단어를 입력하세요.");
        frm.keyWord.focus();
        return;
    }
    frm.submit();      
}






</script>

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
							<h2 class="commTitle">QNA</h2>
								<a href="<c:url value='community_qna_write.jsp'/>" class="btn pull-right btn-primary btn-md"> 글쓰기 <i
								class="fa fa-angle-right ml-xs"></i>
							</a>
							<div class="featured-boxes">
								<div class="row">
									<div class="col-sm-12" style="margin-top:10px">
										<table class="table table-hover">
											<thead>
												<tr>
													<th style="width:12%">번호</th>
													<th style="width:60%">제목</th>
													<th style="width:20%">글쓴이</th>
													<th style="width:8%">삭제</th>
												</tr>
												
											</thead>
											<tbody>
											<c:forEach var="vo" items="${requestScope.list }">
												<tr>
													<td>${vo.qa_num }</td>
													<td>
													<c:if test="${vo.lev>0 }">
												<c:forEach var="i" begin="1" end="${vo.lev }">
													&nbsp;&nbsp;
													</c:forEach>
														[re]
														</c:if>
													<a href="<c:url value='/QA_board.do?cmd=detail&qa_num=${vo.qa_num }'/>">${vo.qa_title}</a></td>
													<td>${vo.qa_writer }</td>
													<c:choose>
														<c:when test="${vo.user_num==sessionScope.user_num }">
													<td><a href="<c:url value='/QA_board.do?cmd=delete&qa_num=${vo.qa_num}'/>">삭제</a></td>	
														</c:when>
														<c:otherwise>
													<td>삭제</td>
														</c:otherwise>
													</c:choose>
												</tr>
											</c:forEach>
		<tr>  
        	<td colspan="7"> <br/>
            <form  action="<c:url value='/QA_board.do?cmd=list'/>" name="serach" method ="post">
            <select name="keyField">
                <option value="0"> ----선택----</option>
                <option value="qa_writer">글쓴이</option>
                <option value="qa_title">제목</option>
                <option value="qa_content">내용</option>  
            </select>
            <input type="text" name="keyWord" />
            <input type="button" value="검색" onclick="searchCheck(form)" />
           
            </form>
           
        </td>      
    </tr>
			
			</table>
						
							
			
	<!--검색  -->		
	<div>	
	<!-- 이전 -->
 	<c:choose>
		<c:when test="${startPage>2 }">
			<a href="<c:url value='/QA_board.do?cmd=list&pageNum=${startPage-1 }'/>">[이전]</a>		
			</c:when>
		<c:otherwise>
			[이전]
		</c:otherwise>
	</c:choose>	 	
			
			
			<!--페이징  -->
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
	<c:choose>
		<c:when test="${pageNum==i }"><%-- 현재페이지인경우--%>
			<a href="<c:url value='/QA_board.do?cmd=list&pageNum=${i }'/>"><span style="color:red" >[${i }]</span></a>
		</c:when>
		<c:otherwise>
			<a href="<c:url value='/QA_board.do?cmd=list&pageNum=${i }'/>"><span style="color:#555" >[${i }]</span></a>
		</c:otherwise>
	</c:choose>	
	</c:forEach>
	
	<!-- 다음 -->
 	<c:choose>
		<c:when test="${endPage<pageCount }">
			<a href="<c:url value='/QA_board.do?cmd=list&pageNum=${endPage+1 }'/>">[다음]</a>
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
