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
<h1>주문프로세스</h1>
<hr>
<h3>장바구니</h3>
<a href="<c:url value='/dev/cartOrder/CART_insert.jsp?do1=insert'/>">장바구니insert</a><br>
<a href="<c:url value='/dev/cartOrder/cart.do?cmd=list'/>">장바구니list</a><br>
<hr>
<h3>구매목록</h3>
<a href="<c:url value='/dev/cartOrder/PURCHASE_LIST_insert.jsp?do1=insert'/>">구매목록insert</a><br>
<a href="<c:url value='/dev/cartOrder/purchase.do?cmd=list'/>">구매목록list</a><br>
<hr>
<h3>주문목록</h3>
<a href="<c:url value='/order.do?cmd=insert'/>">구매목록insert</a><br>
<a href="<c:url value='/order.do?cmd=list'/>">구매목록list</a><br>
<hr>
</body>
</html>