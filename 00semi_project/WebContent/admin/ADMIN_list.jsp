<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<table class="table table-hover">
		<tr>
			<th>관리자번호</th>
			<th>관리자아이디</th>
			<th>관리자비밀번호</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<td>${vo.admin_num }</td>
			<td>${vo.admin_id }</td>
			<td>${vo.admin_pwd }</td>
			<td><a class="btn btn-light" href="<c:url value='/dev/adminUser/admin.do?cmd=select&admin_num=${vo.admin_num }'/>">수정</a></td>
			<td><a class="btn btn-light" href="<c:url value='/dev/adminUser/admin.do?cmd=delete&admin_num=${vo.admin_num }'/>">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</html>