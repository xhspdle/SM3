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
<form method="post" action='<c:url value="/order.do?cmd=insert"/>'>
	유저번호 <input type="text" name="user_num"><br>
	구매번호 <input type="text" name="pur_num"><br>
	총주문금액 <input type="text" name="order_total"><br>
	포인트사용액 <input type="text" name="order_point"><br>
	결제금액 <input type="text" name="order_pay"><br>
	받는사람 <input type="text" name="order_recipient"><br>
	배송지우편번호 <input type="text" name="order_post_addr"><br>
	기본배송지 <input type="text" name="order_basic_addr"><br>
	상세배송지 <input type="text" name="order_detail_addr"><br>
	받는사람폰번호 <input type="text" name="order_phone"><br>
	주문날짜 <input type="text" name="order_date"><br>
	주문상태 <input type="text" name="order_status"><br>
	<input type="submit" value="입력">
</form>	
	</c:when>
	<c:when test="${param.do1=='update' }">
<form method="post" action='<c:url value="/order.do?cmd=update"/>'>
	주문번호 <input type="text" name="order_num" readonly="readonly" value="${vo.order_num }"><br>
	유저번호 <input type="text" name="user_num" value="${vo.user_num }"><br>
	구매번호 <input type="text" name="pur_num" value="${vo.pur_num }"><br>
	총주문금액 <input type="text" name="order_total" value="${vo.order_total }"><br>
	포인트사용액 <input type="text" name="order_point" value="${vo.order_point }"><br>
	결제금액 <input type="text" name="order_pay" value="${vo.order_pay }"><br>
	받는사람 <input type="text" name="order_recipient" value="${vo.order_recipient }"><br>
	배송지우편번호 <input type="text" name="order_post_addr" value="${vo.order_post_addr }"><br>
	기본배송지 <input type="text" name="order_basic_addr" value="${vo.order_basic_addr }"><br>
	상세배송지 <input type="text" name="order_detail_addr" value="${vo.order_detail_addr }"><br>
	받는사람폰번호 <input type="text" name="order_phone" value="${vo.order_phone }"><br>
	주문날짜 <input type="text" name="order_date" value="${vo.order_date }"><br>
	주문상태 <input type="text" name="order_status" value="${vo.order_status }"><br>
	<input type="submit" value="수정">
</form>	
	</c:when>
</c:choose>
</body>
</html>