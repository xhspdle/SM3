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
<c:set var="do1" value="${param.form1 }"/>
<c:choose>
	<c:when test="${do1=='insert' }">
<form method="post" action='<c:url value="/itemOrder/item.do?cmd=insert"/>'
	enctype="multipart/form-data">
	
	상품분류 <input type="text" name="cate_name"><br>
	분류추가 <input type="button" onclick="cateInsert()">
	<br>
	상품이름 <input type="text" name="item_name"><br>
	<%-- 분류번호 <input type="text" name="cate_num"><br>--%>
	분류번호 
	<select name="cate_num" onclick="cateList()">
	</select><br>
	상품설명 <input type="text" name="item_info"><br>
	상품가격 <input type="text" name="item_price"><br>
	이미지 <input type="file" name="file1"><br>
	상품추가 <input type="button" onclick="itemInsert()">
	<br>
	컬러이름 <input type="text" name="color_name"><br>
	컬러코드 <input type="text" name="color_code"><br>
	<%-- 상품번호 <input type="text" name="item_num"><br>--%>
	상품번호
	<select name="item_num" onclick="itemList()">
	</select><br>
	컬러추가 <input type="button" onclick="colorInsert()">
	<br>
	사이즈이름 <input type="text" name="size_name"><br>
	<%-- 컬러번호 <input type="text" name="color_num"><br>--%>
	컬러번호
	<select name="color_num" onclick="colorList()">
	</select><br>
	재고수량 <input type="text" name="size_cnt"><br>
	사이즈추가 <input type="button" onclick="sizeInsert()">
	<input type="submit" value="상품입력">
</form>
	</c:when>
	<c:when test="${do1=='update' }">
<form method="post" action='<c:url value="/itemOrder/item.do?cmd=update"/>'
	enctype="multipart/form-data">
	
	분류번호 <input type="text" readonly="readonly" name="cate_num" value="${vo.cate_num }"><br>
	상품분류 <input type="text" name="cate_name" value="${vo.cate_name }"><br>
	<br>
	상품번호 <input type="text" readonly="readonly" name="item_num" value="${vo.item_num }"><br>
	상품이름 <input type="text" name="item_name" value="${vo.item_name }"><br>
	분류번호 <input type="text" name="cate_num" value="${vo.cate_num }"><br>
	상품설명 <input type="text" name="item_info" value="${vo.item_info }"><br>
	상품가격 <input type="text" name="item_price" value="${vo.item_price }"><br>
	이미지 <input type="file" name="file1"><br>
	<input type="submit" value="상품수정">
</form>		
	</c:when>
</c:choose>
</body>
</html>