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
<form method="post" action='<c:url value="/dev/itemOrder/itemColor.do?cmd=insert"/>'>
	컬러이름 <input type="text" name="color_name"><br>
	컬러코드 <input type="color" name="color_code"><br>
	<input type="submit" value="입력">
</form>	
	</c:when>
	<c:when test="${param.do1=='update' }">
<form method="post" action='<c:url value="/dev/itemOrder/itemColor.do?cmd=update"/>'>
	컬러번호 <input type="text" readonly="readonly" name="color_num" value="${vo.color_num }">
	컬러이름 <input type="text" name="color_name" value="${vo.color_name }">
	컬러코드 <input type="color" name="color_code" value="${vo.color_code }">
	<input type="submit" value="수정">
</form>	
	</c:when>
</c:choose>
</body>
</html>