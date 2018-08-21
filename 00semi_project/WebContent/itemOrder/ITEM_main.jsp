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
<h1>상품</h1>
<h3>상품분류</h3>
<a href="<c:url value='/itemOrder/ITEMCATE_insert.jsp'/>">상품분류insert</a><br>
<a href="<c:url value='/itemOrder/itemCate.do?cmd=list'/>">상품분류list</a><br><br>
<h3>상품</h3>
<a href="<c:url value='/itemOrder/ITEM_insert.jsp'/>">상품insert</a><br>
<a href="<c:url value='/itemOrder/item.do?cmd=list'/>">상품list</a><br><br>
<h3>상품색상</h3>
<a href="<c:url value='/itemOrder/ITEM_COLOR_insert.jsp'/>">색상insert</a><br>
<a href="<c:url value='/itemOrder/itemColor.do?cmd=list'/>">색상list</a><br><br>
</body>
</html>