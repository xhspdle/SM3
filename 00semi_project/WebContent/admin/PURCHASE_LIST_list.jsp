<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<input type="hidden" value="PURCHASE_LIST_list" id="here">
<div class="row">
<h2>구매 목록</h2>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>구매목록번호</th>
			<th>구매번호</th>
			<th>사이즈번호</th>
			<th>주문수량</th>
			<th>상품가격</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<td>${vo.pl_num }</td>
			<td>${vo.pur_num }</td>
			<td>${vo.size_num }</td>
			<td>${vo.order_cnt }</td>
			<td>${vo.item_price }</td>
			<td><a href="<c:url value='/purchase.do?cmd=select&pl_num=${vo.pl_num }'/>">수정</a></td>
			<td><a href="<c:url value='/purchase.do?cmd=delete&pur_num=${vo.pur_num }'/>">삭제</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:set var="selected1" value=""/>
	<c:if test="${!empty search }">
		<c:choose>
			<c:when test="${search=='size_num' }">
				<c:set var="selected1" value="selected=selected"/>
			</c:when>
		</c:choose>
	</c:if>
	<div class="pull-right" style="width:50%">
	<form method="post" action="<c:url value='/purchase.do?cmd=purNumList&pur_num=${param.pur_num }'/>">
	<div class="form-group">
		<div class="col-md-4">
			<select class="form-control populate " name="search">
				<optgroup label="검색">
					<option value="size_num" ${selected1 }>사이즈번호</option>
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
			<li><a href="<c:url value='/purchase.do?cmd=purNumList&pageNum=${startPage-1 }&search=${param.search }&keyword=${param.keyword }&pur_num=${param.pur_num }'/>">
			«</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="#none">«</a></li>
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<li class="active"><a href="<c:url value='/purchase.do?cmd=purNumList&pageNum=${i }&search=${param.search }&keyword=${param.keyword }&pur_num=${param.pur_num }'/>">
				${i }</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<c:url value='/purchase.do?cmd=purNumList&pageNum=${i }&search=${param.search }&keyword=${param.keyword }&pur_num=${param.pur_num }'/>">
				${i }</a></li>	
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${endPage<pageCount }">
			<li><a href="<c:url value='/purchase.do?cmd=purNumList&pageNum=${endPage+1 }&search=${param.search }&keyword=${param.keyword }&pur_num=${param.pur_num }'/>">
			»</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="#none">»</a></li>
		</c:otherwise>
	</c:choose>		
	</ul>
	</div>
</div>