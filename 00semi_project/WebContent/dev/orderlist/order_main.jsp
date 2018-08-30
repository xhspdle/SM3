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
<h3>주문내역</h3>
<!--<a href="<c:url value='/dev/cartOrder/PURCHASE_LIST_insert.jsp?do1=insert'/>">주문하기</a><br>-->
<a href="<c:url value='/dev/orderlist/orderlist.do?cmd=list'/>">주문내역</a><br>
<hr>
</body>
</html>