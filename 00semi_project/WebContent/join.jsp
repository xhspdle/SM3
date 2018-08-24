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
<!-- api -->

</head>
<body onload="joinCheck()">
	<div class="body">
		<header id="header"
			data-plugin-options="{'stickyEnabled': true, 'stickyEnableOnBoxed': true, 'stickyEnableOnMobile': true, 'stickyStartAt': 100, 'stickySetTop': '-100px'}">
			<jsp:include page="header.jsp" />
		</header>
		<div role="sub" class="sub">
			<section class="section mt-none section-footer">
				<div class="container main_box">
					<div class="row mt-lg">
						<div class="col-md-12">
							<div class="featured-boxes">
								<div class="row">
									<div class="col-sm-8 loginBox">
										<div
											class="featured-box featured-box-primary align-left mt-xlg">
											<div class="box-content">
												<h4 class="heading-primary text-uppercase mb-md">회원가입</h4>
												<form action="<c:url value='userControll.do?cmd=insert'/>"
													method="post" name="joinForm">
													<div class="row">
														<div class="form-group">
															<div class="col-md-10">
																<label for="id">아이디</label> <span class="spanVal"></span><input id="id"
																	type="text" name="id" class="form-control input-lg">
															</div>
															<div class="col-md-2">
																<a href="javascript:idcheck();" 
																class="btn btn-primary pull-right mb-xl"
																style="margin-top: 30px; margin-bottom:0;">중복체크</a>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="form-group">
															<div class="col-md-12">
																<label for="pwd">비밀번호</label> <span class="spanVal"></span><input
																	id="pwd" name="pwd" type="password" value=""
																	class="form-control input-lg">
															</div>
														</div>
													</div>
													<div class="row">
														<div class="form-group">
															<div class="col-md-12">
																<label for="pwdOk">비밀번호 확인</label> <span class="spanVal"></span><input
																	type="password" name="pwdOk"
																	class="form-control input-lg" id="pwdOk">
															</div>
														</div>
													</div>
													<div class="row">
														<div class="form-group">
															<div class="col-md-12">
																<label for="names">이름</label> <span class="spanVal"></span><input
																	id="names" name="name" type="text"
																	class="form-control input-lg">
															</div>
														</div>
													</div>
													<div class="row">
														<div class="form-group">
															<div class="col-md-12">
																<label>비밀번호 힌트</label> <select
																	class="form-control input-lg" name="pwdHint">
																	<option value="1">당신의 보물 1호는?</option>
																	<option value="2">당신의 취미는?</option>
																	<option value="3">당신의 생일은?</option>
																	<option value="4">당신이 좋아하는 음악은?</option>
																</select>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="form-group">
															<div class="col-md-12">
																<label for="hintOk">힌트 답 입력</label> <span class="spanVal"></span><input
																	type="text" name="hintOk"
																	class="form-control input-lg" id="hintOk">
															</div>
														</div>
													</div>
													<div class="row join_num">
														<div class="form-group">
															<div class="col-md-12">
																<label>핸드폰 번호</label> 
																	<span class="spanVal"></span><select id="phone1" name="phone[]"
																		class="form-control input-lg">
																		<option value="010">010</option>
																		<option value="011">011</option>
																		<option value="016">016</option>
																		<option value="017">017</option>
																		<option value="018">018</option>
																		<option value="019">019</option>
																	</select> - <input id="phone2" name="phone[]" maxlength="4"
																		size="4" type="text" class="form-control input-lg">
																	- <input id="phone3" name="phone[]" maxlength="4"
																		size="4" type="text" class="form-control input-lg">
																
															</div>
														</div>
													</div>
													<div class="row join_num">
														<div class="form-group">
															<div class="col-md-12">
																<label>주소</label> 
																	<span class="spanVal"></span><input type="text" id="sample3_postcode"
																		placeholder="우편번호" name ="addr[]" class="form-control input-lg">
																	<a
																		onclick="sample3_execDaumPostcode()"
																		class="form-control input-lg" id="addSearch" style="width:20%; display: inline-block;">우편번호 찾기</a><br>
																	<div id="wraps"
																		style="display: none; border: 1px solid; width: 500px; height: 300px; margin: 5px 0; position: relative">
																		<img
																			src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png"
																			id="btnFoldWrap"
																			style="cursor: pointer; position: absolute; right: 0px; top: -1px; z-index: 1"
																			onclick="foldDaumPostcode()" alt="접기 버튼">
																	</div>
																	<input type="text" id="sample3_address"
																		class="d_form large  form-control input-lg"
																		placeholder="기본주소" name="addr[]">
																		<input type="text" 
																		class="form-control input-lg"
																		placeholder="상세주소" id="addr" name="addr[]">
																
															</div>
														</div>
													</div>
													<div class="row join_num">
														<div class="form-group">
															<div class="col-md-12">
																<label for="email1">이메일</label>
																	 <span class="spanVal"></span><input id="email1" name="email[]" 
																		size="8" value="" type="text"
																		class="form-control input-lg"> @ <input
																		id="email2" name="email[]"size="8"
																		value="" type="text" class="form-control input-lg">
																
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-md-6" style="margin-top: 40px">
															<input type="submit" value="가입완료"
																class="btn btn-primary pull-right mb-xl"
																data-loading-text="Loading...">
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
				</div>
			</section>
		</div>
		<footer class="short" id="footer">
			<jsp:include page="footer.jsp" />
		</footer>
	</div>


	<!-- 로그인 유효성검사 -->
	<script>
		
		var inputs = document.getElementsByTagName("input");
		var id = document.getElementById("id");
		var pwd = document.getElementById("pwd");
		var names = document.getElementById("names");
		var pwdOk = document.getElementById("pwdOk");
		var hintOk = document.getElementById("hintOk");
		var phone1 = document.getElementById("phone1");
		var phone2 = document.getElementById("phone2");
		var phone3 = document.getElementById("phone3");
		var addr = document.getElementById("addr");
		var addrNum = document.getElementById("sample3_postcode");
		var addrBtn = document.getElementById("addSearch");
		var email1 = document.getElementById("email1");
		var email2 = document.getElementById("email2");
		var spans = document.getElementsByClassName("spanVal");
		
		function idCheck(){
			document.joinForm.action = "<c:url value='userControll.do?cmd=idSearch'/>";
			document.joinForm.submit;
		}
		
		function joinCheck() {
			for (var i = 0; i < inputs.length; i++) {
				inputs[i].onclick = function() {
					
					if (id.value == "") {
						if(this.value == ""){
							id.previousSibling.innerHTML = "*필수 입력 사항입니다.";
							id.focus();
						} 
					} else if (pwd.value == "") {
						if(this.value == ""){
							pwd.previousSibling.innerHTML = "*필수 입력 사항입니다.";
							pwd.focus();
						} 
					} else if (pwdOk.value == "") {
						if(this.value == ""){
							pwdOk.previousSibling.innerHTML = "*필수 입력 사항입니다.";
							pwdOk.focus();
						} 
					} else if (names.value == "") {
						if(this.value == ""){
							names.previousSibling.innerHTML = "*필수 입력 사항입니다.";
							names.focus();
						} 
					} else if (hintOk.value == "") {
						if(this.value == ""){
							hintOk.previousSibling.innerHTML = "*필수 입력 사항입니다.";
							if(this.value == "") hintOk.focus();
						} 
						
					} else if (phone2.value == "") {
						if(this.value == ""){
							phone1.previousSibling.innerHTML = "*필수 입력 사항입니다.";
							if(this.value == "") phone2.focus();
						} 
					} else if (phone3.value == "") {
						if(this.value == ""){
							phone1.previousSibling.innerHTML = "*필수 입력 사항입니다.";
							if(this.value == "") phone3.focus();
						} 
					}else if (addr.value == "") {
						if(this.value == ""){
							addrNum.previousSibling.innerHTML = "*필수입력 사항 입니다.";
							if(this.value == "") addr.focus();
						} 
					}else if (email1.value == "") {
						if(this.value == ""){
							email1.previousSibling.innerHTML = "*필수 입력 사항입니다";
							if(this.value == "") email1.focus();
						} 
						
					}else if (email2.value == "") {
						if(this.value == ""){
							email1.previousSibling.innerHTML = "필수 입력 사항입니다";
							if(this.value == "") email2.focus();
						} 
					}
				}
				inputs[i].onkeydown = function() {
					for (var i = 0; i < spans.length ; i++) {
						spans[i].innerHTML = "";
					}
				}
			}
		}
	</script>



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



	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
		// 우편번호 찾기 찾기 화면을 넣을 element
		var element_wrap = document.getElementById('wraps');

		function foldDaumPostcode() {
			// iframe을 넣은 element를 안보이게 한다.
			element_wrap.style.display = 'none';
		}

		function sample3_execDaumPostcode() {
			// 현재 scroll 위치를 저장해놓는다.
			var currentScroll = Math.max(document.body.scrollTop,
					document.documentElement.scrollTop);
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var fullAddr = data.address; // 최종 주소 변수
							var extraAddr = ''; // 조합형 주소 변수

							// 기본 주소가 도로명 타입일때 조합한다.
							if (data.addressType === 'R') {
								//법정동명이 있을 경우 추가한다.
								if (data.bname !== '') {
									extraAddr += data.bname;
								}
								// 건물명이 있을 경우 추가한다.
								if (data.buildingName !== '') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
								fullAddr += (extraAddr !== '' ? ' ('
										+ extraAddr + ')' : '');
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('sample3_postcode').value = data.zonecode; //5자리 새우편번호 사용
							document.getElementById('sample3_address').value = fullAddr;

							// iframe을 넣은 element를 안보이게 한다.
							// (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
							element_wrap.style.display = 'none';

							// 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
							document.body.scrollTop = currentScroll;
						},
						// 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
						onresize : function(size) {
							element_wrap.style.height = size.height + 'px';
						},
						width : '100%',
						height : '100%'
					}).embed(element_wrap);

			// iframe을 넣은 element를 보이게 한다.
			element_wrap.style.display = 'block';
		}
	</script>

</body>
</html>
