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
<c:choose>
	<c:when test="${param.do1=='insert' }">
<form method="post" action='<c:url value="/dev/cartOrder/cart.do?cmd=insert"/>'>
	유저번호 <input type="text" name="user_num"><br>
	사이즈번호 <input type="text" name="size_num"><br>
	주문수량 <input type="text" name="order_cnt"><br>
	상품가격 <input type="text" name="item_price"><br>
	사이즈번호 <input type="text" name="size_num"><br>
	주문수량 <input type="text" name="order_cnt"><br>
	상품가격 <input type="text" name="item_price"><br>
	<input type="submit" value="입력">
</form>	
	</c:when>
	<c:when test="${param.do1=='update' }">
<form method="post" action='<c:url value="/dev/cartOrder/cart.do?cmd=update"/>'>
	장바구니번호 <input type="text" readonly="readonly" name="cart_num" value="${vo.cart_num }"><br>
	유저번호 <input type="text" name="user_num" value="${vo.user_num }"><br>
	사이즈번호 <input type="text" name="size_num" value="${vo.size_num }"><br>
	주문수량 <input type="text" name="order_cnt" value="${vo.order_cnt }"><br>
	상품가격 <input type="text" name="item_price" value="${vo.item_price }"><br>
	<input type="submit" value="수정">
</form>	
	</c:when>
</c:choose>
</body>
</html>