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
		<!-- 댓글 -->                <!-- user_num -->  -->
		<% session.setAttribute("user_num", 1); %><!-- 세션에 유저넘버저장 -->
											<!-- uer_name -->
		<% session.setAttribute("comm_writer","lee"); %><!-- 세션에 유저이름저장 -->
		<form action="<c:url value='/dev/board/QA_COMMboard.do?cmd=insert'/>" method='post'>
	
		<input type='text' name=qa_num value="${vo.qa_num}">
		<table>
			
			<tr>
				<td><textarea name='comm_content'></textarea></td>
				<td rowspan=2><input type='submit' value='댓글완료'></td>
			</tr>
			<tr>    
				<td>작성자<input type='text' name="comm_writer" value="${comm_writer}"></td>
			</tr>
		</table>
		</form>
		<!-- 댓글 -->
		
		<jsp:include page="QA_commdetail.jsp" />
		
</body>
</html>