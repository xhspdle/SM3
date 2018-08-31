<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row">
<h2>주문 목록</h2>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>주문번호</th>
			<th>유저번호</th>
			<th>구매번호</th>
			<%-- 
			<th>총주문금액</th>
			<th>포인트사용액</th>
			--%>
			<th>결제금액</th>
			<th>받는사람</th>
			<%-- 
			<th>배송지우편번호</th>
			<th>기본배송지</th>
			<th>상세배송지</th>
			--%>
			<th>받는사람폰번호</th>
			<th>주문날짜</th>
			<th>주문상태</th>
			<th>상세</th>
			<th>삭제</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<td>${vo.order_num }</td>
			<td>${vo.user_num }</td>
			<td><a href="<c:url value='/purchase.do?cmd=purNumList&pur_num=${vo.pur_num }'/>">
			:: ${vo.pur_num } ::</a></td>
			<%-- 
			<td>${vo.order_total }</td>
			<td>${vo.order_point }</td>
			--%>
			<td>${vo.order_pay }</td>
			<td>${vo.order_recipient }</td>
			<%-- 
			<td>${vo.order_post_addr }</td>
			<td>${vo.order_basic_addr }</td>
			<td>${vo.order_detail_addr }</td>
			--%>
			<td>${vo.order_phone }</td>
			<td>${vo.order_date }</td>
			<td>${vo.order_status }</td>
			<!-- 구매목록 뭘땡겨올지 정해야댐 -->
			<td><a href="<c:url value='/order.do?cmd=select&order_num=${vo.order_num }'/>">상세</a></td>
			<td><a href="<c:url value='/order.do?cmd=delete&order_num=${vo.order_num }'/>">삭제</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:set var="selected1" value=""/>
	<c:set var="selected2" value=""/>
	<c:set var="selected3" value=""/>
	<c:set var="selected4" value=""/>
	<c:if test="${!empty search }">
		<c:choose>
			<c:when test="${search=='order_num' }">
				<c:set var="selected1" value="selected=selected"/>
			</c:when>
			<c:when test="${search=='user_num' }">
				<c:set var="selected2" value="selected=selected"/>
			</c:when>
			<c:when test="${search=='order_recipient' }">
				<c:set var="selected3" value="selected=selected"/>
			</c:when>
			<c:when test="${search=='order_phone' }">
				<c:set var="selected4" value="selected=selected"/>
			</c:when>
		</c:choose>
	</c:if>
	<div class="pull-right" style="width:50%">
	<form method="post" action="<c:url value='/order.do?cmd=list'/>">
	<div class="form-group">
		<div class="col-md-4">
			<select class="form-control populate " name="search">
				<optgroup label="검색">
					<option value="order_num" ${selected1 }>주문번호</option>
					<option value="user_num" ${selected2 }>유저번호</option>
					<option value="order_recipient" ${selected3 }>받는사람</option>
					<option value="order_phone" ${selected4 }>전화번호</option>
				</optgroup>
			</select>
		</div>
		<div class="input-group input-group-md col-md-7">
			<input class="form-control" placeholder="Search..." name="keyword" value="${param.keyword }" type="text">
			<span class="input-group-btn">
				<button type="submit" class="btn btn-primary btn-md"><i class="fa fa-search"></i></button>
			</span>
		</div>
	</div>
	</form>
	</div>
	<div style="text-align: center; clear: both;">
	<ul class="pagination pagination-md">
	<c:choose>
		<c:when test="${startPage>10 }">
			<li><a href="<c:url value='/order.do?cmd=list&pageNum=${startPage-1 }&search=${param.search }&keyword=${param.keyword }'/>">
			«</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="#none">«</a></li>
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<li class="active"><a href="<c:url value='/order.do?cmd=list&pageNum=${i }&search=${param.search }&keyword=${param.keyword }'/>">
				${i }</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<c:url value='/order.do?cmd=list&pageNum=${i }&search=${param.search }&keyword=${param.keyword }'/>">
				${i }</a></li>	
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${endPage<pageCount }">
			<li><a href="<c:url value='/order.do?cmd=list&pageNum=${endPage+1 }&search=${param.search }&keyword=${param.keyword }'/>">
			»</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="#none">»</a></li>
		</c:otherwise>
	</c:choose>		
	</ul>
	</div>
</div>