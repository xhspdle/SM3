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
			<table border="1" width="600">
	<tr>
		<td>글번호</td>
		<td>${vo.qa_num }</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${vo.qa_writer }</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${vo.qa_title }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea rows="5" cols="50" readonly="readonly">${vo.qa_content }</textarea></td>
	</tr>	
	<tr>
		<td colspan="2">
			<a href="QA_insert.jsp?qa_num=${vo.qa_num }&ref=${vo.ref}&lev=${vo.lev}&step=${vo.step}">
			답글</a>
		</table>
</body>
</html>