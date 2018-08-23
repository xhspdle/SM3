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
<h1>이벤트목록</h1>
<a href="<c:url value='/dev/board/EN_main.jsp'/>">메인으로</a>
<table width="800" border="1">
	<tr>
	<th>글번호</th>
	<th>작성자</th>
	<th>글제목</th>
	<th>글내용</th>
	<th>작성일</th>
	<th>이미지</th>
	<th>수정</th>
	<th>삭제</th>
	</tr>
<c:forEach var="vo" items="${requestScope.list }">
<tr>
	<td>${vo.en_num}</td>
	<td>${vo.en_writer }</td>
	<td>${vo.en_title }</td>
	<td>${vo.en_content }</td>
	<td>${vo.en_date }</td>
	<td><img src='<c:url value="/images/${vo.en_savimg }"/>' style="width:120px;height:120px;" id="img">
	</td>
	<td><a href="<c:url value='/dev/board/EventNotice.do?cmd=getinfo&en_num=${vo.en_num }'/>">수정</a></td>
	<td><a href="<c:url value='/dev/board/EventNotice.do?cmd=delete&en_num=${vo.en_num }'/>">삭제</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>