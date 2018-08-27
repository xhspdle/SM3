<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="container">
	<div class="row">
	<div class="col-lg-9">
	<h2>상품 목록</h2>
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
				style="background-color:${vo.color_code };">&nbsp&nbsp</button></td>
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
	</div>
	</div>
</div>