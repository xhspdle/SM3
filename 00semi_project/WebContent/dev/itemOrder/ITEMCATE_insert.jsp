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
<form method="post" action='<c:url value="/dev/itemOrder/itemCate.do?cmd=insert"/>'>
	상품분류 <input type="text" name="cate_name">
	<input type="submit" value="입력">
</form>	
	</c:when>
	<c:when test="${param.do1=='update' }">
<form method="post" action='<c:url value="/dev/itemOrder/itemCate.do?cmd=update"/>'>
	분류번호 <input type="text" readonly="readonly" name="cate_num" value="${vo.cate_num }">
	상품분류 <input type="text" name="cate_name" value="${vo.cate_name }">
	<input type="submit" value="수정">
</form>	
	</c:when>
</c:choose>
</body>
</html>