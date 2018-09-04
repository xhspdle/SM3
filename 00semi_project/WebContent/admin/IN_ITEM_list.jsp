<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<input type="hidden" value="IN_ITEM_list" id="here">
<div class="row">
<h2>입고 목록</h2>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>입고번호</th>
			<th>사이즈번호</th>
			<th>관리자번호</th>
			<th>입고수량</th>
			<th>주문원가</th>
			<th>입고날짜</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<td>${vo.in_num }</td>
			<td>${vo.size_num }</td>
			<td>${vo.admin_num }</td>
			<td>${vo.in_cnt }</td>
			<td>${vo.in_cost }</td>
			<td>${vo.in_date }</td>
			<td><a href="<c:url value='/admin/inItem.do?cmd=select&in_num=${vo.in_num }'/>">수정</a></td>
			<td><a href="<c:url value='/admin/inItem.do?cmd=delete&in_num=${vo.in_num }'/>">삭제</a></td>
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
			<c:when test="${search=='in_num' }">
				<c:set var="selected1" value="selected=selected"/>
			</c:when>
			<c:when test="${search=='size_num' }">
				<c:set var="selected2" value="selected=selected"/>
			</c:when>
			<c:when test="${search=='admin_num' }">
				<c:set var="selected3" value="selected=selected"/>
			</c:when>
			<c:when test="${search=='in_date' }">
				<c:set var="selected4" value="selected=selected"/>
			</c:when>
		</c:choose>
	</c:if>
	<div class="pull-right" style="width:50%">
	<form method="post" action="<c:url value='/admin/inItem.do?cmd=list'/>">
	<div class="form-group">
		<div class="col-md-4">
			<select class="form-control populate " name="search">
				<optgroup label="검색">
					<option value="in_num" ${selected1 }>입고번호</option>
					<option value="size_num" ${selected2 }>사이즈번호</option>
					<option value="admin_num" ${selected3 }>관리자번호</option>
					<option value="in_date" ${selected4 }>입고날짜</option>
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
			<li><a href="<c:url value='/admin/inItem.do?cmd=list&pageNum=${startPage-1 }&search=${param.search }&keyword=${param.keyword }'/>">
			«</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="#none">«</a></li>
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<li class="active"><a href="<c:url value='/admin/inItem.do?cmd=list&pageNum=${i }&search=${param.search }&keyword=${param.keyword }'/>">
				${i }</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<c:url value='/admin/inItem.do?cmd=list&pageNum=${i }&search=${param.search }&keyword=${param.keyword }'/>">
				${i }</a></li>	
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${endPage<pageCount }">
			<li><a href="<c:url value='/admin/inItem.do?cmd=list&pageNum=${endPage+1 }&search=${param.search }&keyword=${param.keyword }'/>">
			»</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="#none">»</a></li>
		</c:otherwise>
	</c:choose>		
	</ul>
	</div>
</div>