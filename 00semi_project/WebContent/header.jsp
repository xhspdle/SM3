<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header-body">
	<div class="header-container container">
		<div class="header-row">
			<div class="header-column header-column-center">
				<div class="header-logo">
					<h1>
						<a href="index.jsp"> Something Like </a>
					</h1>
				</div>
				<div class="header-search hidden-xs">
					<form id="searchForm" action="page-search-results.html"
						method="get" novalidate="novalidate">
						<div class="input-group">
							<input type="text" class="form-control" name="q" id="q"
								placeholder="Search..." aria-required="true">
							<span class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div>
					</form>
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
						href="<c:url value='item_list.jsp'/>"> NEW </a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='item_list.jsp?cate_num=1'/>"> ALL </a></li>
							<li><a href="index.html"> OUTER </a></li>
							<li><a href="index.html"> TOP </a></li>
							<li><a href="index.html"> BOTTOM </a></li>
						</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
						href="<c:url value='item_list.jsp?cate_num=1'/>"> OUTER </a>
						<ul class="dropdown-menu">
							<li><a href="index.html"> ALL </a></li>
							<li><a href="index.html"> OUTER </a></li>
							<li><a href="index.html"> TOP </a></li>
							<li><a href="index.html"> BOTTOM </a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						href="<c:url value='item_list.jsp?cate_num=2'/>"> TOP </a>
						<ul class="dropdown-menu">
							<li><a href="index.html"> ALL </a></li>
							<li><a href="index.html"> OUTER </a></li>
							<li><a href="index.html"> TOP </a></li>
							<li><a href="index.html"> BOTTOM </a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						href="<c:url value='item_list.jsp?cate_num=3'/>"> BOTTOM </a>
						<ul class="dropdown-menu">
							<li><a href="index.html"> ALL </a></li>
							<li><a href="index.html"> OUTER </a></li>
							<li><a href="index.html"> TOP </a></li>
							<li><a href="index.html"> BOTTOM </a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						href="<c:url value='item_list.jsp'/>"> SALE </a>
						<ul class="dropdown-menu">
							<li><a href="index.html"> ALL </a></li>
							<li><a href="index.html"> OUTER </a></li>
							<li><a href="index.html"> TOP </a></li>
							<li><a href="index.html"> BOTTOM </a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						href="<c:url value='mypage_mypage.jsp'/>"> MYPAGE</a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='cart.jsp'/>">장바구니</a></li>
							<li><a href="<c:url value='mypage_mypage.jsp'/>">마이페이지</a></li>
							<li><a href="<c:url value='mypage_pay_list.jsp'/>">주문배송조회</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						href="<c:url value='community_event_list.jsp'/>"> COMMUNITY </a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='EventNotice.do?cmd=list'/>">
									EVENT&amp;NOTICE </a></li>
							<li><a href="<c:url value='community_qna_list.jsp'/>">Q&amp;A</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						href="<c:url value='cart.jsp'/>"> CART </a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						href="<c:url value='login.jsp'/>"> LOGIN</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>