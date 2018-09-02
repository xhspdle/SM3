<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<input type="hidden" value="ITEM_VIEW_list" id="here">
<div class="row">
<h2>재고 목록</h2>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>분류명</th>
			<th>상품번호</th>
			<th>상품명</th>
			<th>컬러</th>
			<th>상품가격</th>
			<th>이미지</th>
			<th>재고번호</th>
			<th>사이즈</th>
			<th>재고수량</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<td>${vo.cate_name }</td>
			<td>${vo.item_num }</td>
			<td>${vo.item_name }</td>
			<td>
			<button type="button" class="btn btn-default" 
			style="background-color:${vo.color_code };">&nbsp;&nbsp;</button></td>
			<td>${vo.item_price }</td>
			<td><img src='<c:url value="/DBImages/${vo.item_savimg }"/>' 
			style="width:105px;height:140px;"></td>
			<td>${vo.size_num }</td>
			<td>${vo.size_name }</td>
			<td>${vo.size_cnt }</td>
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
			<c:when test="${search=='item_num' }">
				<c:set var="selected1" value="selected=selected"/>
			</c:when>
			<c:when test="${search=='item_name' }">
				<c:set var="selected2" value="selected=selected"/>
			</c:when>
			<c:when test="${search=='size_num' }">
				<c:set var="selected3" value="selected=selected"/>
			</c:when>
			<c:when test="${search=='size_name' }">
				<c:set var="selected4" value="selected=selected"/>
			</c:when>
		</c:choose>
	</c:if>
	<div class="pull-right" style="width:50%">
	<form method="post" action="<c:url value='/itemView.do?cmd=list'/>">
	<div class="form-group">
		<div class="col-md-4">
			<select class="form-control populate " name="search">
				<optgroup label="검색">
					<option value="item_num" ${selected1 }>상품번호</option>
					<option value="item_name" ${selected2 }>상품이름</option>
					<option value="size_num" ${selected3 }>재고번호</option>
					<option value="size_name" ${selected4 }>사이즈이름</option>
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
			<li><a href="<c:url value='/itemView.do?cmd=list&pageNum=${startPage-1 }&search=${param.search }&keyword=${param.keyword }'/>">
			«</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="#none">«</a></li>
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<li class="active"><a href="<c:url value='/itemView.do?cmd=list&pageNum=${i }&search=${param.search }&keyword=${param.keyword }'/>">
				${i }</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<c:url value='/itemView.do?cmd=list&pageNum=${i }&search=${param.search }&keyword=${param.keyword }'/>">
				${i }</a></li>	
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${endPage<pageCount }">
			<li><a href="<c:url value='/itemView.do?cmd=list&pageNum=${endPage+1 }&search=${param.search }&keyword=${param.keyword }'/>">
			»</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="#none">»</a></li>
		</c:otherwise>
	</c:choose>		
	</ul>
	</div>
</div>