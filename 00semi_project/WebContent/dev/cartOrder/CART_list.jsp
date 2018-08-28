<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="700" border="1">
	<tr>
		<th>장바구니번호</th>
		<th>유저번호</th>
		<th>사이즈번호</th>
		<th>주문수량</th>
		<th>상품가격</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="vo" items="${requestScope.list }">
	<tr>
		<td>${vo.cart_num }</td>
		<td>${vo.user_num }</td>
		<td>${vo.size_num }</td>
		<td>${vo.order_cnt }</td>
		<td>${vo.item_price }</td>
		<td><a href="<c:url value='/dev/cartOrder/cart.do?cmd=select&cart_num=${vo.cart_num }'/>">수정</a></td>
		<td><a href="<c:url value='/dev/cartOrder/cart.do?cmd=delete&user_num=${vo.user_num }'/>">삭제</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>