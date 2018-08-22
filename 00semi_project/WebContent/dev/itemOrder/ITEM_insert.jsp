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
<form method="post" action='<c:url value="/dev/itemOrder/item.do?cmd=insert"/>'
	enctype="multipart/form-data">
	상품이름 <input type="text" name="item_name"><br>
	분류번호 <input type="text" name="cate_num"><br>
	상품설명 <input type="text" name="item_info"><br>
	상품가격 <input type="text" name="item_price"><br>
	이미지 <input type="file" name="file1"><br>
	<input type="submit" value="입력">
</form>	
	</c:when>
	<c:when test="${param.do1=='update' }">
<form method="post" action='<c:url value="/dev/itemOrder/item.do?cmd=update"/>'
	enctype="multipart/form-data">
	상품번호 <input type="text" readonly="readonly" name="item_num" value="${vo.item_num }"><br>
	상품이름 <input type="text" name="item_name" value="${vo.item_name }"><br>
	분류번호 <input type="text" name="cate_num" value="${vo.cate_num }"><br>
	상품설명 <input type="text" name="item_info" value="${vo.item_info }"><br>
	상품가격 <input type="text" name="item_price" value="${vo.item_price }"><br>
	이미지 <input type="file" name="file1"><br>
	<input type="submit" value="수정">
</form>	
	</c:when>
</c:choose>
</body>
</html>