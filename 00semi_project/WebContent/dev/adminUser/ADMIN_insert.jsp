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
<form method="post" action='<c:url value="/dev/adminUser/admin.do?cmd=insert"/>'>
	관리자아이디 <input type="text" name="admin_id">
	관리자비밀번호 <input type="password" name="admin_pwd">
	<input type="submit" value="입력">
</form>	
	</c:when>
	<c:when test="${param.do1=='update' }">
<form method="post" action='<c:url value="/dev/adminUser/admin.do?cmd=update"/>'>
	관리자번호 <input type="text" readonly="readonly" name="admin_num" value="${vo.admin_num }">
	관리자아이디 <input type="text" name="admin_id" value="${vo.amdin_id }">
	관리자비밀번호 <input type="password" name="admin_pwd" value="${vo.admin_pwd }">
	<input type="submit" value="수정">
</form>	
	</c:when>
</c:choose>
</body>
</html>