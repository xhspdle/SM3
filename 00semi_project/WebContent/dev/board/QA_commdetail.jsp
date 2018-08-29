<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#div2 {width: 340px;
    
    border: 3px solid #73AD21;
}

</style>
</head>
<body>
	<%-- 	   <table border="1" width="600"> 
		<c:forEach var="vo" items="${requestScope.list }">
				<tr>
				 <td>작성자</td><td> "${vo.comm_writer}" </td>
					
				</tr>
				<tr>
					<td>댓글내용</td><td> ${vo.comm_content} </td>
				</tr>
		</c:forEach>		
		
		</table>  --%>
		<c:forEach var="vo" items="${requestScope.list }">
		<div id="div2" >
		<input type="text" value="${vo.comm_writer }"><br>
		<textarea rows="3" cols="50"> ${vo.comm_content}</textarea>
		<a href="<c:url value='/dev/board/QA_COMMboard.do?cmd=delete&comm_num=${vo.comm_num}'/>">삭제</a>
		</div>
		</c:forEach>
		
		
</body>
</html>