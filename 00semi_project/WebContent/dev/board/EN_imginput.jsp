<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이미지등록</title>
</head>
<body>
<h1>이벤트 등록</h1>
<c:choose>
	<c:when test="${param.cmd1=='imginput'}">
	<form method="post" action='<c:url value="/dev/board/EventNotice.do?cmd=insert"/>'
				enctype="multipart/form-data">
<table border="1" width="500">
<tr>
	<td>작성자</td>
	<td><input type="text" name="en_writer"></td>
</tr>
<tr>
	<td>제목</td>
	<td><input type="text" name="en_title"></td>
</tr>
<tr>
	<td>글내용</td>
	<td><textarea rows="5" cols="50" name="en_content"></textarea></td>
</tr>
<tr>
	<td>첨부파일</td>
	<td><input type="file" name="file1"></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="전송">
		<input type="hidden" name="admin_num" value="1">
	</td>
</tr>

</table>
	</form>
	</c:when>
<c:when test="${param.cmd1=='update'}">
<form method="post" action='<c:url value="/dev/board/EventNotice.do?cmd=update"/>'
			enctype="multipart/form-data">
<table border="1" width="500">
<tr>
	<td>글번호</td>
	<td><input type="text" readonly="readonly" name="en_num" value="${vo.en_num }"></td>
</tr>
<tr>
	<td>작성자</td>
	<td><input type="text" name="en_writer" value=""></td>
</tr>
<tr>
	<td>제목</td>
	<td><input type="text" name="en_title"></td>
</tr>
<tr>
	<td>글내용</td>
	<td><textarea rows="5" cols="50" name="en_content"></textarea></td>
</tr>
<tr>
	<td>첨부파일</td>
	<td><input type="file" name="file1"></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="확인">
	</td>
</tr>
<tr>
	<td>관리자번호</td>
	<td><input type="text" name="admin_num"></td> 
</tr>
</table>			
</form>
<a href="<c:url value='/dev/board/EventNotice.do?cmd=list'/>">목록보기</a>
<a href="<c:url value='/dev/board/EN_main.jsp'/>">메인으로</a>
</c:when>
</c:choose>
</body>
</html>


