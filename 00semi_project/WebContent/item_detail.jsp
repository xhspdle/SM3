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
<%
	String path = application.getContextPath();
	ArrayList<ItemViewVo> list = (ArrayList) request.getAttribute("list");
	ItemViewVo vo = list.get(0);
	HashMap<Integer, String> list2 = (HashMap) request.getAttribute("list2");
	Set<Integer> set = list2.keySet();
	Iterator<Integer> keyList = set.iterator();
%>
</head>

<!-- !!!!!!!!!!!!!!!!  해당 페이지 자동들여쓰기하지말아주세요  !!!!!!!!!!!!!!!!!! ---->


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
									src="DBImages/<%=vo.getItem_orgimg()%>">
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="summary entry-summary">
							<!-- 제목 -->
							<h1 class="mb-none">
								<strong><%=vo.getItem_name()%></strong>
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
							<!-- 상품정보 -->
							<p class="taller"><%=vo.getItem_info()%></p>

							<!-- 컬러 -->
							<div class="cboth de_color">
								<%
									while (keyList.hasNext()) {
										int key = keyList.next();
								%>
								<a
									href="<%=path%>/itemView.do?cmd=select&item_num=<%=key%>&item_name=<%=vo.getItem_name()%>"><span
									style="background-color:<%=list2.get(key)%>;">1</span></a>
								<%
									}
								%>
							</div>
							

<!-- !!!!!!!!!!!!!!!!  해당 페이지 자동들여쓰기하지말아주세요  !!!!!!!!!!!!!!!!!! ---->


							<!-- 가격 -->
							<p class="price order-line">
								<span class="left-side">가격</span><span class="amount"><%=vo.getItem_price()%>원</span>
							</p>
							<!-- 사이즈선택 -->
							<p class="size_select order-line">
								<span class="left-side">사이즈</span><span class="amount"> <select
									id="sel_list" onchange="select_list()">
										<option value="0">사이즈를 선택해주세요</option>
										<option>44 ~ 55</option>
										<option>55반 ~ 66</option>
										<option>66반 ~ 77</option>
										<option>77반 ~ 88</option>
								</select></span>
							</p>
							<!-- 폼시쟉~ -->
							<form method="post" action="<c:url value='/purchase.do?cmd=insert'/>" class="cart" name="orderList">
								<!-- 세션에 담긴 유저 넘버도 보내주도록 -->
								<input type="hidden" name="user_num" value="${sessionScope.user_num }">
								<div id="select_list_box">
									<!-- 사이즈 셀렉할 경우 상품 리스트 자바스크립트로 뿌려주는 내용이 들어감.  -->
								</div>
							
								<p class="price_box">
									<input type="hidden" name="total_price" id="total_p">
									<span>총 금액:</span> <span id="total_price"></span>
								</p>
							
							<div class="product_meta">
								<span class="posted_in">Categories: <a rel="tag" href="#"><%=vo.getCate_name()%></a>
								</span>
							</div>
							<!-- submit 버튼 -->
							<p style="float:right; clear: both; padding-right: 10px;">
								<a onclick="submit_change()" class="btn btn-primary btn-icon cart-btn">장바구니</a> 
								<input type="submit" class="btn btn-primary btn-icon" value="주문하기">
							</p>
							</form>
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
												<td>44~55, 55~66, 66~77, 77~88</td>
											</tr>
											<tr>
												<th>정보</th>
												<td><%=vo.getItem_info()%></td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="tab-pane" id="productReviews">
									
									<!-- 리뷰리스트 들어갈 곳 -->
									<ul class="comments">
										<c:forEach var="vo" items="${review_list }">
											<li>
												<div class="comment">
													<!-- 리뷰포토 사진 삽입 -->
													<div class="img-thumbnail">
														<c:choose>
															<c:when test="${vo.review_orgimg == null}">
																<img class="avatar" alt="" src="DBImages/<%=vo.getItem_orgimg()%>">
															</c:when>
															<c:otherwise>
																<img class="avatar" alt="" src="DBImages/${vo.review_orgimg}">
															</c:otherwise>
														</c:choose>
													</div>
													<div class="comment-block">
														<div class="comment-arrow"></div>
														<!-- 리뷰작성자 -->
														<span class="comment-by"> <strong>${vo.user_id}</strong>
															<span class="pull-right"> <!-- 평점준	 정도 -->
																<div title="Rated 5.00 out of 5" class="star-rating">
																	<c:choose>
																		<c:when test="${vo.review_rating == 5}">
																				<span class="stars">sssss</span>
																		</c:when>
																		<c:when test="${vo.review_rating == 4}">
																				<span class="stars">ssss</span>
																		</c:when>
																		<c:when test="${vo.review_rating == 3}">
																				<span class="stars">sss</span>
																		</c:when>
																		<c:when test="${vo.review_rating == 2}">
																				<span class="stars">ss</span>
																		</c:when>
																		<c:when test="${vo.review_rating == 1}">
																				<span class="stars">s</span>
																		</c:when>
																	</c:choose>
																</div>
															</span>
														</span>
														
														<c:if test="${sessionScope.user_id == vo.user_id}">
															<a href="#">삭제</a>
														</c:if>	
														<!-- 리뷰 내용 -->
														<p>${vo.review_content}</p>
													</div>
												</div>
											</li>
										</c:forEach>
									</ul>
									
									
									<hr class="tall">
									<!-- 리뷰남기기 -->
									<h4 class="heading-primary">리뷰 남기기</h4>
										<div class="row">
											<div class="col-md-12">
												<form action="<c:url value='ReviewControll.do?cmd=insert'/>" id="submitReview" method="post"
													enctype="multipart/form-data">
													<div class="row">
														<div class="form-group">
															<div class="col-md-6">
																<!-- 리뷰제목입력란 -->
																<input type="hidden" name="review_item"
																	value="<%=vo.getItem_name()%>">  <!-- 제품이름 -->
																<input type="hidden"
																	name="user_num" value="${sessionScope.user_num }"> <!-- 유저번호 -->
																<input
																	type="hidden" name="order_num" value="1">  <!-- 주문번호 -->
																<input
																	type="hidden" id="review_rating" name="review_rating" value="5">  <!-- 평점정보 -->	
																<label>아이디</label>
																<input type="text" value="${sessionScope.user_id}"
																	data-msg-required="Please enter your name." maxlength="100"
																	class="form-control" name="title" id="title">
															</div>
															<div class="col-md-6">
																<label>후기 사진 추가</label> <input type="file" name="file1"
																	class="form-control"> <!-- 사진정보 -->
															</div>
														</div>
													</div>
													<div class="row">
														<div class="form-group">
															<div class="col-md-12">
																<label>리뷰 내용(최대300자)</label>
																<textarea maxlength="400"
																	data-msg-required="Please enter your message." rows="10"
																	class="form-control" name="review_content" id="message"></textarea> <!-- 리뷰내용 -->
															</div>
														</div>
													</div>
													
													<div class="row">
														<div class="form-group">
															<div class="col-md-12">
																<div id="rating">
																    <svg class="star" id="1" viewBox="0 12.705 512 486.59" x="0px" y="0px" xml:space="preserve" style="fill: #f39c12;">
																     1 <polygon points="256.814,12.705 317.205,198.566 512.631,198.566 354.529,313.435 414.918,499.295 256.814,384.427 98.713,499.295 159.102,313.435 1,198.566 196.426,198.566"></polygon>
																    </svg>
																    <svg class="star" id="2" viewBox="0 12.705 512 486.59" x="0px" y="0px" xml:space="preserve" style="fill: rgb(243, 156, 18);">
																     2 <polygon points="256.814,12.705 317.205,198.566 512.631,198.566 354.529,313.435 414.918,499.295 256.814,384.427 98.713,499.295 159.102,313.435 1,198.566 196.426,198.566"></polygon>
																    </svg>
																    <svg class="star" id="3" viewBox="0 12.705 512 486.59" x="0px" y="0px" xml:space="preserve" style="fill: rgb(243, 156, 18);">
																     3 <polygon points="256.814,12.705 317.205,198.566 512.631,198.566 354.529,313.435 414.918,499.295 256.814,384.427 98.713,499.295 159.102,313.435 1,198.566 196.426,198.566"></polygon>
																    </svg>
																    <svg class="star" id="4" viewBox="0 12.705 512 486.59" x="0px" y="0px" xml:space="preserve" style="fill: rgb(243, 156, 18);">
																     4 <polygon points="256.814,12.705 317.205,198.566 512.631,198.566 354.529,313.435 414.918,499.295 256.814,384.427 98.713,499.295 159.102,313.435 1,198.566 196.426,198.566"></polygon>
																    </svg>
																    <svg class="star" id="5" viewBox="0 12.705 512 486.59" x="0px" y="0px" xml:space="preserve" style="fill: rgb(243, 156, 18);">
																     5 <polygon points="256.814,12.705 317.205,198.566 512.631,198.566 354.529,313.435 414.918,499.295 256.814,384.427 98.713,499.295 159.102,313.435 1,198.566 196.426,198.566"></polygon>
																    </svg>
																  </div>
															</div>
														</div>
													</div>
													
													
													<div class="row">
														<div class="col-md-12">
															<input type="submit" value="등록하기" class="btn btn-primary"
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

				<!-- 연관 카테고리 뿌려주기 -->
				<!-- <div class="row">
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
						
						 -->
					</div>
				</div>
			</div>

		</div>
		<footer class="short" id="footer">
			<jsp:include page="footer.jsp" />
		</footer>
	</div>
	<script>
	//엉엉유유ㅠㅇ어유유ㅠ
	var cnt = 0;
	var n1 = 0;
	var n2 = 0;
	var n3 = 0;
	var n4 = 0;
	
		/* submit 자바스크립트로 주소 변경해주기 */
		function submit_change(){
			document.orderList.action = "cart.do?cmd=insert"; //보낼주소
			document.orderList.submit();
		}
	
	
		/* 셀렉트할때 이벤트 시작 */
		function select_list(){
			var select_box = document.getElementById("select_list_box");
			var sel_list = document.getElementById("sel_list");
			var total_price = document.getElementById("total_price");
			var price = <%=vo.getItem_price()%>;
			var sel_num = sel_list.options.selectedIndex;
			if(sel_num == 0 ) return;
			
			/* 사이즈 중복 추가 오류방지 */
			if(sel_list.options[1].selected) ++n1;
			if(sel_list.options[2].selected) ++n2;
			if(sel_list.options[3].selected) ++n3;
			if(sel_list.options[4].selected) ++n4;
			if(n1>=2){
				alert("이미 선택하신 사이즈 입니다");
				return;
			}
			if(n2>=2){
				alert("이미 선택하신 사이즈 입니다");
				return;
			}
			if(n3>=2){
				alert("이미 선택하신 사이즈 입니다");
				return;
			}
			if(n4>=2){
				alert("이미 선택하신 사이즈 입니다");
				return;
			}
			++cnt;
			total_price.innerHTML =  price * cnt + "원("+cnt+")개";
			var ul= document.createElement("ul");
			var size_num = <%=vo.getSize_num()%>;
			ul.className = "list_sel";
			ul.innerHTML += 
			'<li class="item_name">'+
			'<input type="hidden" name="size_num" value="'+size_num+'">'+ //사이즈 넘버 
			   '<p><%=vo.getItem_name()%></p><p>size: '+sel_list.value+'</p></li>'
					+ '<li><input type="hidden">' //상품 카운트
					+ '<div class="quantity">'
					+ '<input type="button" class="minus" value="-"><input type="text" class="input-text qty text" title="Qty" name="order_cnt" value="1" min="1" step="1"><input type="button" class="plus" value="+">'
					+ '</div></li>'
					+ '<li class="it_price"><input type="hidden" name="item_price" value="'+price +'">'+price+'원</li>' //사이즈 갯수별 금액
					+ '<li><a title="Remove this item" class="remove" href="#none"> <i class="fa fa-times"></i></a></li>'
				select_box.appendChild(ul);
				var plus = document.getElementsByClassName("plus");
				var minus = document.getElementsByClassName("minus");
				var qty = document.getElementsByClassName("qty");
				var it_price = document.getElementsByClassName("it_price");
				var remove = document.getElementsByClassName("remove");
				var ul_box = document.getElementsByClassName("list_sel");
				var total_p = document.getElementById("total_p");
				
				//상품 수 증가할 때
				for (var i = 0; i < plus.length; i++) {
					plus[i].onclick = function(){
						++this.previousSibling.value;
						var item_price = price * this.previousSibling.value;
						this.parentElement.parentElement.nextSibling.innerHTML = "<input type='hidden' name='item_price' value='"+item_price+" '>" +item_price+"원";
						++cnt;
						total_price.innerHTML =  price * cnt +"원("+cnt+")개";
						total_p.value = price * cnt;
					}
				}
				//상품 수 감소할 때
				for (var i = 0; i < minus.length; i++) {
					minus[i].onclick = function(){
						if(this.nextSibling.value>1){
							--this.nextSibling.value;
							--cnt;
						}
						var item_price = price * this.nextSibling.value
						this.parentElement.parentElement.nextSibling.innerHTML = "<input type='hidden' name='item_price' value='"+item_price+" '>"+item_price +"원";
						total_price.innerHTML =  price * cnt +"원("+cnt+")개";
						total_p.value = price * cnt;
					}
				}
				//상품 목록 삭제했을 때
				for (var i = 0; i < remove.length; i++) {
					remove[i].onclick = function(){
						this.parentElement.parentElement.remove();
						var a =this.parentElement.previousSibling.previousSibling.lastChild.lastChild.previousSibling.value;
						cnt = cnt - a ;
						total_price.innerHTML =  price * cnt +"원("+cnt+")개";
						total_p.value = price * cnt;
					}
				}
		}
		
		
		/* 리뷰 평점 별 달아주기 */
		
				
		function starsReducer(state, action) {
		    switch (action.type) {
		      case 'HOVER_STAR': {
		        return {
		          starsHover: action.value,
		          starsSet: state.starsSet
		        }
		      }
		      case 'CLICK_STAR': {
		        return {
		          starsHover: state.starsHover,
		          starsSet: action.value
		        }
		      }
		        break;
		      default:
		        return state
		    }
		  }
		
		  var StarContainer = document.getElementById('rating');
		  var StarComponents = StarContainer.children;
		
		  var state = {
		    starsHover: 0,
		    starsSet: 4
		  }
		
		  function render(value) {
		    for(var i = 0; i < StarComponents.length; i++) {
		      StarComponents[i].style.fill = i < value ? '#f39c12' : '#808080'
		    }
		  }
		
		  for (var i=0; i < StarComponents.length; i++) {
		    StarComponents[i].addEventListener('mouseenter', function() {
		      state = starsReducer(state, {
		        type: 'HOVER_STAR',
		        value: this.id
		      })
		      render(state.starsHover);
		    })
		
		    StarComponents[i].addEventListener('click', function() {
		      state = starsReducer(state, {
		        type: 'CLICK_STAR',
		        value: this.id
		      })
		      render(state.starsHover);
		    })
		  }
		
		  StarContainer.addEventListener('mouseleave', function() {
		    render(state.starsSet);
		  })
		

		
		  var reviews = {
		    reviews: [
		      {
		        stars: 3,
		        name: 'bob',
		        city: 'Noos  k',
		        review: '1 Thompson Greenspon is so grateful to have worked with CPASiteSolutions on our'
		      },{
		        stars: 4,
		        name: 'bobbo',
		        city: 'WinNoosk',
		        review: '2 Thompson Greenspon is so grateful to have worked with CPASiteSolutions on our'
		      },{
		        stars: 2,
		        name: 'bobster',
		        city: 'NooSKI',
		        review: '3 Thompson Greenspon is so grateful to have worked with CPASiteSolutions on our'
		      },
		    ]
		  }
		
		  function ReviewStarContainer(stars) {
		    var div = document.createElement('div');
		    div.className = "stars-container";
		    for (var i = 0; i < 5; i++) {
		      var svg = document.createElementNS("http://www.w3.org/2000/svg", "svg");
		      svg.setAttribute('viewBox',"0 12.705 512 486.59");
		      svg.setAttribute('x',"0px");
		      svg.setAttribute('y',"0px");
		      svg.setAttribute('xml:space',"preserve");
		      svg.setAttribute('class',"star");
		      var svgNS = svg.namespaceURI;
		      var star = document.createElementNS(svgNS,'polygon');
		      star.setAttribute('points', '256.814,12.705 317.205,198.566 512.631,198.566 354.529,313.435 414.918,499.295 256.814,384.427 98.713,499.295 159.102,313.435 1,198.566 196.426,198.566');
		      star.setAttribute('fill', i < stars ? '#f39c12' : '#808080');
		      svg.appendChild(star);
		      div.appendChild(svg);
		    }
		    return div;
		  }
		
		  function ReviewContentContainer(name, city, review) {
		
		    var reviewee = document.createElement('div');
		    reviewee.className = "reviewee footer";
		    reviewee.innerHTML  = '- ' + name + ', ' + city
		
		    var comment = document.createElement('p');
		    comment.innerHTML = review;
		
		    var div = document.createElement('div');
		    div.className = "review-content";
		    div.appendChild(comment);
		    div.appendChild(reviewee);
		
		    return div;
		  }
		
		  function ReviewsContainer(review) {
		    var div = document.createElement('blockquote');
		    div.className = "review";
		    div.appendChild(ReviewStarContainer(review.stars));
		    div.appendChild(ReviewContentContainer(review.name,review.city,review.review));
		    return div;
		  }
		
		
		  /* 별 클릭할 때 평점 수 넣어주기 */
		  
		 var star = document.getElementsByClassName('star');
		 var review_rating = document.getElementById('review_rating');
			
		star[0].onclick = function(){
			var a = this.firstChild.nodeValue;
			review_rating.value = '1' ;
		}
		star[1].onclick = function(){
			var a = this.firstChild.nodeValue;
			review_rating.value = '2' ;
		}
		star[2].onclick = function(){
			var a = this.firstChild.nodeValue;
			review_rating.value = '3' ;
		}
		star[3].onclick = function(){
			var a = this.firstChild.nodeValue;
			review_rating.value = '4' ;
		}
		star[4].onclick = function(){
			var a = this.firstChild.nodeValue;
			review_rating.value = '5' ;
		}
		
		/* 리뷰 목록 평점 수 계산 */
  		
  
			
				
		  
		
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

</body>
</html>
