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
<form method="post" action='<c:url value="/dev/itemOrder/itemSize.do?cmd=insert"/>'>
	사이즈이름 <input type="text" name="size_name"><br>
	상품번호 <input type="text" name="item_num"><br>
	컬러번호 <input type="text" name="color_num"><br>
	재고수량 <input type="text" name="size_cnt" readonly="readonly"><br>
	<input type="submit" value="입력">
</form>	
	</c:when>
	<c:when test="${param.do1=='update' }">
<form method="post" action='<c:url value="/dev/itemOrder/itemSize.do?cmd=updateInfo"/>'>
	사이즈번호 <input type="text" readonly="readonly" name="size_num" value="${vo.size_num }">
	사이즈이름 <input type="text" name="size_name" value="${vo.size_name }">
	상품번호 <input type="text" name="item_num" value="${vo.item_num }">
	컬러번호 <input type="text" name="color_num" value="${vo.color_num }">
	재고수량 <input type="text" name="size_cnt" value="${vo.size_cnt }" readonly="readonly">
	<input type="submit" value="수정">
</form>	
	</c:when>
</c:choose>
</body>
</html>