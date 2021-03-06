<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header-body">
	<div class="header-container container">
		<div class="header-row">
			<div class="header-column header-column-center">
				<div class="header-logo">
					<h1>
						<a href="<c:url value='/index.jsp'/>"> Something Like </a>
					</h1>
				</div>
			</div>
		</div>
	</div>

	<div class="header-container container header-nav header-nav-center">
		<button class="btn header-btn-collapse-nav" data-toggle="collapse"
			data-target=".header-nav-main">
			<i class="fa fa-bars"></i>
		</button>
		<div
			class="header-nav-main header-nav-main-effect-1 header-nav-main-sub-effect-1 collapse">
			<nav>
				<ul class="nav nav-pills" id="mainNav">
					<li class="dropdown"><a class="dropdown-toggle"
						href="<c:url value='/item_list.jsp?cate_num=0'/>"> ALL </a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='/item_list.jsp?cate_num=0'/>"> ALL </a></li>
							<li><a href="<c:url value='/item_list.jsp?cate_num=1'/>"> OUTER </a></li>
							<li><a href="<c:url value='/item_list.jsp?cate_num=2'/>"> TOP </a></li>
							<li><a href="<c:url value='/item_list.jsp?cate_num=3'/>"> BOTTOM </a></li>
						</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
						href="<c:url value='/item_list.jsp?cate_num=1'/>"> OUTER </a>
						
					<li class="dropdown"><a class="dropdown-toggle"
						href="<c:url value='/item_list.jsp?cate_num=2'/>"> TOP </a>
						
					<li class="dropdown"><a class="dropdown-toggle"
						href="<c:url value='/item_list.jsp?cate_num=3'/>"> BOTTOM </a>
			
					<c:choose>
						<c:when test="${sessionScope.user_id != null}">
								<li class="dropdown">
									<a class="dropdown-toggle"href="<c:url value='/pointControll.do?cmd=select&user_num=${sessionScope.user_num }'/>"> MYPAGE</a>
									<ul class="dropdown-menu">
										<li><a href="<c:url value='/user_pwdOk.jsp'/>">정보수정</a></li>
										<li><a href="<c:url value='/cart.do?cmd=userCart'/>">장바구니</a></li>
										<li><a
											href="<c:url value='/pointControll.do?cmd=select&user_num=${sessionScope.user_num }'/>">마이페이지</a></li>
										<li><a
											href="<c:url value='/orderlist.do?cmd=list&user_num=${sessionScope.user_num }'/>">주문배송조회</a></li>
									</ul>
								</li>
						</c:when>
						<c:otherwise>
								<li class="dropdown">
									<a class="dropdown-toggle"href="<c:url value='/login.jsp'/>"> MYPAGE</a>
									<ul class="dropdown-menu">
										<li><a href="<c:url value='/login.jsp'/>">정보수정</a></li>
										<li><a href="<c:url value='/login.jsp'/>">장바구니</a></li>
										<li><a
											href="<c:url value='/login.jsp'/>">마이페이지</a></li>
										<li><a
											href="<c:url value='/login.jsp'/>">주문배송조회</a></li>
									</ul>
								</li>
						</c:otherwise>
					</c:choose>
					<li class="dropdown"><a class="dropdown-toggle"
						href="<c:url value='/EventNotice.do?cmd=list'/>"> COMMUNITY </a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='/EventNotice.do?cmd=list'/>">
									EVENT&amp;NOTICE </a></li>
							<li><a href="<c:url value='/QA_board.do?cmd=list'/>">Q&amp;A</a></li>
						</ul></li>	
					<c:choose>
						<c:when test="${user_id == null }">
							<li class="dropdown"><a class="dropdown-toggle"
							href="<c:url value='/login.jsp'/>"> CART </a></li>
						</c:when>
						<c:otherwise>
							<li class="dropdown"><a class="dropdown-toggle"
							href="<c:url value='/cart.do?cmd=userCart'/>"> CART </a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${user_id != null }">
							<li class="dropdown"><a class="dropdown-toggle"
								href="<c:url value='/userControll.do?cmd=logout'/>"> LOGOUT</a></li>
						</c:when>
						<c:otherwise>
							<li class="dropdown"><a class="dropdown-toggle"
								href="<c:url value='/login.jsp'/>"> LOGIN</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</div>
	</div>
</div>