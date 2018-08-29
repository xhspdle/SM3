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
		<th>주문번호</th>
		<th>유저번호</th>
		<th>구매번호</th>
		<th>총주문금액</th>
		<th>포인트사용액</th>
		<th>결제금액</th>
		<th>받는사람</th>
		<th>배송지우편번호</th>
		<th>기본배송지</th>
		<th>상세배송지</th>
		<th>받는사람폰번호</th>
		<th>주문날짜</th>
		<th>주문상태</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="vo" items="${requestScope.list }">
	<tr>
		<td>${vo.order_num }</td>
		<td>${vo.user_num }</td>
		<td>${vo.pur_num }</td>
		<td>${vo.order_total }</td>
		<td>${vo.order_point }</td>
		<td>${vo.order_pay }</td>
		<td>${vo.order_recipient }</td>
		<td>${vo.order_post_addr }</td>
		<td>${vo.order_basic_addr }</td>
		<td>${vo.order_detail_addr }</td>
		<td>${vo.order_phone }</td>
		<td>${vo.order_date }</td>
		<td>${vo.order_status }</td>
		<td><a href="<c:url value='/order.do?cmd=select&order_num=${vo.order_num }'/>">수정</a></td>
		<td><a href="<c:url value='/order.do?cmd=delete&order_num=${vo.order_num }'/>">삭제</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>