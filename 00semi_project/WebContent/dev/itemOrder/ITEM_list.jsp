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
<table width="800" border="1">
	<tr>
		<th>상품번호</th>
		<th>상품이름</th>
		<th>분류번호</th>
		<th>상품설명</th>
		<th>상품가격</th>
		<th>이미지</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="vo" items="${requestScope.list }">
	<tr>
		<td>${vo.item_num }</td>
		<td>${vo.item_name }</td>
		<td>${vo.cate_num }</td>
		<td>${vo.item_info }</td>
		<td>${vo.item_price }</td>
		<td><img src='<c:url value="/DBImages/${vo.item_savimg }"/>' 
		style="width:100px;height:100px;" id="img1"></td>
		<td><a href="<c:url value=
		'/dev/itemOrder/item.do?cmd=select&item_num=${vo.item_num }'/>">수정</a></td>
		<td><a href="<c:url value=
		'/dev/itemOrder/item.do?cmd=delete&item_num=${vo.item_num }'/>">삭제</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>