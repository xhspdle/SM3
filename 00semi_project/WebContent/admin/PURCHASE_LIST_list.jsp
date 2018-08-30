<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			<td><a href="<c:url value='/dev/cartOrder/purchase.do?cmd=select&pl_num=${vo.pl_num }'/>">수정</a></td>
			<td><a href="<c:url value='/dev/cartOrder/purchase.do?cmd=delete&pur_num=${vo.pur_num }'/>">삭제</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>