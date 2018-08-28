<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



<ul>
	<li><a href="QA_insert.jsp">글쓰기</a></li>
	
	<li><a href="<c:url value='/dev/board/QA_board.do?cmd=list'/>">리스트보기</a></li>
	
</ul>

</body>  
</html>