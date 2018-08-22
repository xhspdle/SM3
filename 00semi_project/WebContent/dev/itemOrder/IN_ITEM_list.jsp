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
		<th>입고번호</th>
		<th>사이즈번호</th>
		<th>관리자번호</th>
		<th>입고수량</th>
		<th>주문원가</th>
		<th>입고날짜</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="vo" items="${requestScope.list }">
	<tr>
		<td>${vo.in_num }</td>
		<td>${vo.size_num }</td>
		<td>${vo.admin_num }</td>
		<td>${vo.in_cnt }</td>
		<td>${vo.in_cost }</td>
		<td>${vo.in_date }</td>
		<td><a href="<c:url value='/dev/itemOrder/inItem.do?cmd=select&in_num=${vo.in_num }'/>">수정</a></td>
		<td><a href="<c:url value='/dev/itemOrder/inItem.do?cmd=delete&in_num=${vo.in_num }'/>">삭제</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>