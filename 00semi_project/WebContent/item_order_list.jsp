<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<form method="post" action="<c:url value='/dev/itemOrder/order.do?cmd=insert'/>">
				<input type="hidden" name="pur_num" value="${vo.pur_num }">
				<input type="hidden" name="user_num" value="${user_num }"><!-- 세션스코프에서받기 -->
				<input type="hidden" name="order_total" id="tt_price" value="">
				<input type="hidden" name="order_pay" id="tt_pay" value="">
					<div class="row">
						<div class="col-md-12">
							<div class="featured-boxes">
								<div class="row">
									<div class="col-md-12">
										<div class="featured-box featured-box-primary align-left mt-sm"
											style="">
											<div class="box-content">
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
														<c:set var="pur_num" value="${vo.pur_num }"/>
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
																		<%-- <input type="button" class="minus" value="-" id="minus" onclick="minus11()"> --%>
																		<input
																			type="text" class="input-text qty text" title="Qty"
																			value="${vo.order_cnt }" name="order_cnt" min="1" step="1" readonly="readonly"> 
																			<%-- <input
																			type="button" class="plus" value="+" id="plus" onclick="plus11()">--%>
																	</div>
																</td>
																<td class="product-subtotal"><span class="it_price" >${vo.order_cnt * vo.item_price }원</span>
																</td>
															</tr>
															</c:forEach>
														</tbody>
													</table>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="featured-box featured-box-primary align-left mt-xlg">
									<div class="box-content">
										<h4 class="heading-primary text-uppercase mb-md">배송지 정보</h4>
											<table summary="" class="table">
												<caption>배송 정보 입력</caption>
												<colgroup>
													<col style="width: 139px;">
													<col style="width: auto;">
												</colgroup>
												<!-- 국내 배송지 정보 -->
												<tbody class="">
													<tr class="">
														<th scope="row">배송지 선택</th>
														<td>
															<div class="address">
																<input id="sameaddr0" name="sameaddr" value="M"
																	type="radio"><label for="sameaddr0">회원
																	정보와 동일</label> <input id="sameaddr1" name="sameaddr" value="F"
																	type="radio"><label for="sameaddr1">새로운배송지</label>
															</div>
														</td>
													</tr>
													<tr>
														<th scope="row">받으시는 분 <img
															src="//img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif"
															alt="필수"></th>
														<td><input id="rname" name="order_recipient"
															class="inputTypeText" placeholder="" size="15" value=""
															type="text"></td>
													</tr>
													<tr>
														<th scope="row">주소 <img
															src="//img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif"
															alt="필수"></th>
														<td>

															<input id="sample3_postcode" name="order_post_addr"
															class="inputTypeText" placeholder="" size="6"
															maxlength="6" readonly="1" value="" type="text">

															<input type="button" onclick="sample3_execDaumPostcode()" value="우편번호 찾기" class="btn btn-primary btn-xs"><br> 
																<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
																	<img src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnFoldWrap"
																	 style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
																</div>
															<input id="sample3_address"
															name="order_basic_addr" class="inputTypeText" placeholder=""
															size="40" readonly="1" value="" type="text" style="margin-top:5px;"> <span
															class="grid">기본주소</span><br> 

															<input id="raddr2"
															name="order_detail_addr" class="inputTypeText" placeholder=""
															size="40" value="" type="text" style="margin-top:5px;"> <span class="grid">나머지주소</span><span
															class="grid displaynone">(선택입력가능)</span></td>
													</tr>
													<tr class="">
														<th scope="row">휴대전화 <span class=""><img
																src="//img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif"
																alt="필수"></span>
														</th>
														<td><select id="rphone2_1" name="order_phone">
																<option value="010">010</option>
																<option value="011">011</option>
																<option value="016">016</option>
																<option value="017">017</option>
																<option value="018">018</option>
																<option value="019">019</option>
														</select>-<input id="rphone2_2" name="order_phone" maxlength="4"
															size="4" value="" type="text">-<input
															id="rphone2_3" name="order_phone" maxlength="4" size="4"
															value="" type="text"></td>
													</tr>
												</tbody>
											</table>
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="featured-box featured-box-primary align-left mt-xlg"
									style="height: 303px;">
									<div class="box-content">
										<h4 class="heading-primary text-uppercase mb-md">결제 예정 금액</h4>
										<table class="cart-totals">
											<tbody>
												<tr class="total">
													<th><strong>총금액</strong></th>
													<td><strong><span class="amount" id="total_price"></span></strong></td>
												</tr>
												<tr class="total">
													<th><strong>적립금할인</strong></th>
													<td><input type="text" size="5" name="order_point" onkeyup="calPay()" value=""> (사용할 금액을
														입력해주세요)</td>
												</tr>
												<tr class="total">
													<th><strong>결제금액</strong></th>
													<td><strong><span class="amount" id="total_pay"></span></strong></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="actions-continue">
										<a class="btn pull-right btn-primary btn-lg" 
										href="<c:url value='/purchase.do?cmd=delete&pur_num=${pur_num }'/>">구매취소</a>
										<button type="submit" class="btn pull-right btn-primary btn-lg">
											구매하기 <i class="fa fa-angle-right ml-xs"></i>
										</button>
										<!-- 여기서 배치프로그램 : 사용자가 구매목록만 등록시키고 실제로 구매단계로 안넘어갈경우, 구매목록 지워주기 -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
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
<script type="text/javascript">
	window.onload = function(){
		var it_price = document.getElementsByClassName("it_price");
		setTimeout(function() {
			var total=0;
			for(var i=0;i<it_price.length;i++){
				total += parseInt(it_price[i].innerHTML);
			}
			document.getElementById("total_price").innerHTML= total +"원";
			document.getElementById("tt_price").value= total;
		}, 100)
	}
	function calPay(){
		var total_price=document.getElementById("total_price").innerHTML;
		var order_point=document.getElementsByName("order_point")[0].value;
		console.log('total_price: '+ total_price);
		console.log('order_point: '+ order_point);
		if(order_point=='' || order_point==null){
			document.getElementById("total_pay").innerHTML="";
			return;
		}
		var total1= parseInt(total_price) - parseInt(order_point)
		document.getElementById("total_pay").innerHTML= total1 + "원";
		document.getElementById("tt_pay").value=total1;
	}
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    // 우편번호 찾기 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    function foldDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_wrap.style.display = 'none';
    }

    function sample3_execDaumPostcode() {
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = data.address; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 기본 주소가 도로명 타입일때 조합한다.
                if(data.addressType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
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
                element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }
</script>
</html>
