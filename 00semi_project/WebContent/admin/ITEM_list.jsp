<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row">
<h2>상품 목록</h2>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>상품번호</th>
			<th>상품이름</th>
			<th>분류번호</th>
			<th>상품설명</th>
			<th>상품가격</th>
			<th>이미지</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<td>${vo.item_num }</td>
			<td>${vo.item_name }</td>
			<td>${vo.cate_num }</td>
			<td>${vo.item_info }</td>
			<td>${vo.item_price }</td>
			<td><img src='<c:url value="/DBImages/${vo.item_savimg }"/>' 
			style="width:105px;height:140px;" id="img1"></td>
			<td><a href="<c:url value=
			'/admin/item.do?cmd=select&item_num=${vo.item_num }'/>">수정</a></td>
			<td><a href="<c:url value=
			'/admin/item.do?cmd=delete&item_num=${vo.item_num }'/>">삭제</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:set var="selected1" value=""/>
	<c:set var="selected2" value=""/>
	<c:set var="selected3" value=""/>
	<c:if test="${!empty search }">
		<c:choose>
			<c:when test="${search=='item_num' }">
				<c:set var="selected1" value="selected=selected"/>
			</c:when>
			<c:when test="${search=='item_name' }">
				<c:set var="selected2" value="selected=selected"/>
			</c:when>
			<c:when test="${search=='item_info' }">
				<c:set var="selected3" value="selected=selected"/>
			</c:when>
		</c:choose>
	</c:if>
	<div class="pull-right" style="width:50%">
	<form method="post" action="<c:url value='/admin/item.do?cmd=list'/>">
	<div class="form-group">
		<div class="col-md-4">
			<select class="form-control populate " name="search">
				<optgroup label="검색">
					<option value="item_num" ${selected1 }>상품번호</option>
					<option value="item_name" ${selected2 }>상품이름</option>
					<option value="item_info" ${selected3 }>상품설명</option>
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
			<li><a href="<c:url value='/admin/item.do?cmd=list&pageNum=${startPage-1 }&search=${param.search }&keyword=${param.keyword }'/>">
			«</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="#none">«</a></li>
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<li class="active"><a href="<c:url value='/admin/item.do?cmd=list&pageNum=${i }&search=${param.search }&keyword=${param.keyword }'/>">
				${i }</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<c:url value='/admin/item.do?cmd=list&pageNum=${i }&search=${param.search }&keyword=${param.keyword }'/>">
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