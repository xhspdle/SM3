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
<c:choose>
<c:when test="${param.cmd1=='insert' }">
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
						
							<div class="featured-boxes">
								<div class="row">
									<div class="col-md-12">
											<h2 class="commTitle">게시글 작성</h2>
										<form action='<c:url value="EventNotice.do?cmd=insert"/>' id="submitReview" method="post"
											enctype="multipart/form-data">
											<div class="row">
												<div class="form-group">
													
														<!-- 리뷰제목입력란 -->
													<div class="col-md-12">
														<label>글번호</label> <input type="text" value=""
															data-msg-required="Please enter your name."
															maxlength="100" class="form-control" name="en_title"
															id="title">
													</div>
													<div class="col-md-12">
														<label>작성자</label> <input type="text" value=""
															data-msg-required="Please enter your name."
															maxlength="100" class="form-control" name="en_writer"
															id="title">
													</div>
													<div class="col-md-12">
														<label>글제목</label> <input type="text" value=""
															data-msg-required="Please enter your name."
															maxlength="100" class="form-control" name="en_title"
															id="title">
													</div>

													<div class="form-group">
														<div class="col-md-12">
															<label>글내용</label>
															<textarea maxlength="5000"
																data-msg-required="Please enter your message." rows="10"
																class="form-control" name="en_content" id="message"></textarea>
														</div>
													</div>
													
													<div class="form-group">
													<div class="col-md-12">
														<label>파일 업로드</label> 
														<div class="col-md-12">
														<img class="img-responsive" src=""
															alt="이미지" id="oldimg1" style="display:none;">
															<div class="fileupload fileupload-new">
																<div class="uneditable-input">
																	<i class="fa fa-file fileupload-exists"></i>
																	<span class="fileupload-preview"></span>
																</div>
															<span class="btn btn-default btn-file btn-aa">
																<input type="file" name="file1" id="fileupload" onchange="Change()">
															</span>
														</div>
													   </div>
													</div>
												</div>
											</div>
										</div>
											<div class="row">
												<div class="col-md-12">
													<input type="submit" value="등록하기"
														class="btn btn-primary" data-loading-text="Loading...">
														<input type="hidden" name="admin_num" value="1">
												</div>
											</div>
										</form>
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
	</c:when>
	<c:when test="${param.cmd1=='update' }">
	<div class="container" style="margin-top:10%;">
		<div class="row">
		<div class="col-md-12">
			<section class="panel panel-admin">
				<header class="panel-heading">
					<h1 class="panel-title">상품 수정</h1>
				</header>
				<form action='<c:url value="EventNotice.do?cmd=update"/>' id="submitReview" method="post"
												enctype="multipart/form-data">
												<div class="row">
													<div class="form-group">
														
															<!-- 리뷰제목입력란 -->
														<div class="col-md-12">
															<label>글번호</label> <input type="text" value=""
																data-msg-required="Please enter your name."
																maxlength="100" class="form-control" name="en_num"
																id="title" readonly="readonly" name="en_num" value="${vo.en_num }">
														</div>
														<div class="col-md-12">
															<label>작성자</label> <input type="text" value=""
																data-msg-required="Please enter your name."
																maxlength="100" class="form-control" name="en_writer"
																id="en_writer" name="en_writer" value="${vo.en_writer }">
														</div>
														<div class="col-md-12">
															<label>글제목</label> <input type="text" value=""
																data-msg-required="Please enter your name."
																maxlength="100" class="form-control" name="en_title"
																id="en_title" name="en_title" value="${vo.en_title }">
														</div>
	
														<div class="form-group">
															<div class="col-md-12">
																<label>글내용</label>
																<textarea maxlength="5000"
																	data-msg-required="Please enter your message." rows="10"
																	class="form-control" name="en_content" id="message" value="${vo.en_content }"></textarea>
															</div>
														</div>
													<div class="form-group">
							<label class="col-md-3 control-label" for="img_btn"></label>
							<div class="col-md-12">
								<button type="button" class="btn btn-warning" id="img_btn" 
								onclick="showFile()">사진변경</button>
							</div>
						</div>
						<div class="form-group" id="inputFile" style="display:none;">
							<label>이미지 업로드</label>
							<div class="col-md-12">
								<img class="img-responsive" src="<c:url value='/images/${vo.en_savimg }'/>"
								alt="기존이미지" id="img">
								<div class="fileupload fileupload-new">
									<div class="uneditable-input">
										<i class="fa fa-file fileupload-exists"></i>
										<span class="fileupload-preview"></span>
									</div>
									<span class="btn btn-default btn-file btn-aa">
										<input type="file" name="file1" id="fileupload" onchange="Change()">
									</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
			<div class="form-group">
			<label class="col-md-3 control-label"></label>
							<div class="col-md-12">
							<button type="submit" class="btn btn-primary btn-block">수정확인</button>
							</div>
						</div>	
						<input type="hidden" name="en_orgimg" value="${vo.en_orgimg }">
						<input type="hidden" name="en_savimg" value="${vo.en_savimg }">
				</section>
				</div>
				</div>
				</div>
				<script>
		function showFile(){  
			var inputFile=document.getElementById("inputFile");
			inputFile.style.display="block";
			var hidden1=document.getElementsByName("en_orgimg")[0];
			var hidden2=document.getElementsByName("en_savimg")[0];
			hidden1.setAttribute("disabled","disabled"); //파일을 보내지 않는다.(원래사진은). *원래사진은..db에서  받고, 새로운 사진은 controller에서 받고.
			hidden2.setAttribute("disabled","disabled"); //그래서 mvc패턴 흐름을
			}
		function Change(){   //이미지 변경 사진을 누르면 바뀌는것.
			var file=document.getElementsByTagName("file1")[0].value; //바꿀사진의 요소를 빼온다.
			var fileName=file.split("\\"); //c://java//~~ 이것처럼 주소를 쪼개준다.
			var img=document.getElementsByTagName("img")[0]; 
			img.src="<%=application.getContextPath()%>/images/" +fileName[2]; //쪼개진 주소에서 3번째 요소를 빼온다. 사진의 이름이 담긴
		}
		</script>
	</c:when>
</c:choose>
	
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

</body>
</html>
