<%@page import="sun.security.jca.GetInstance"%>
<%@page import="sm3.jya.vo.EventNoticeVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sm3.jya.dao.EventNoticeDao"%>
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
<div id="wrap">
<div id="north">
	<div>이벤트목록</div><br>
	<a href="<c:url value='/dev/board/EN_main.jsp'/>">메인으로</a><br>
</div>
<div class ="box-underimage">
<!--<img src='<c:url value="/images/${vo.en_savimg }"/>' style="width:120px;height:120px;" id="img"> -->

<c:forEach var="vo" items="${requestScope.list }"><br>
<img src='<c:url value="/images/${vo.en_savimg }"/>' style="width:120px;height:120px;" id="img"><br>
<br>
제목<input type="text" name="en_title" value="${vo.en_title }">
<br>
내용<input type="text" name="en_content" style="width:170px;height:50px;" value="${vo.en_content }"><br>
날짜<input type="text" name="날짜" value="${vo.en_date }"><br>

	<a href="<c:url value='/dev/board/EventNotice.do?cmd=select&en_num=${vo.en_num }'/>">수정</a>
	<a href="<c:url value='/dev/board/EventNotice.do?cmd=delete&en_num=${vo.en_num }'/>">삭제</a><br>
</c:forEach>
</div>
</div>
<br/>
<%
//선택항목을 눌러서 검색어를 입력하는데 선택항목이 고정되게 해준다.
String search =request.getParameter("search");
if(search==null){
	search = "";
}
String selected1 = "";
String selected2 = "";
String selected3 = "";
if(search.equals("en_writer")){
	selected1 = "selected=selected";
}else if(search.equals("en_title")){
	selected2 = " selected=selected";
}else if(search.equals("en_content")){
	selected3 = " selected=selected";
}
%>
<form method="post" action="<c:url value='/dev/board/EventNotice.do?cmd=list'/>">
	<select name="search">
		<option value="en_writer" <%=selected1 %>>글쓴이</option>
		<option value="en_title" <%=selected2 %>>제목</option>
		<option value="en_content" <%=selected3 %>>내용</option>
	</select>
	<input type="text" name="keyword" value="${param.keyword }">
	<input type="submit" value="찾기">
</form>
<br/>
<div>
	<c:choose>
		<c:when test="${startPage>3}">
		<a href="<c:url value ='/dev/board/EventNotice.do?cmd=list&pageNum=${startPage-1 }&search=${param.search}&keyword=${param.keyword}'/>">[이전]</a>
		</c:when>
		<c:otherwise>
		[이전]
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
	<c:choose>
		<c:when test="${i==pageNum }">
			<a href="<c:url value='/dev/board/EventNotice.do?cmd=list&pageNum=${i }&search=${param.search}&keyword=${param.keyword }'/>">
			<span style="color:red">[${i }]</span></a>
		</c:when>
	<c:otherwise>
		<a href="<c:url value='/dev/board/EventNotice.do?cmd=list&pageNum=${i }&search=${param.search}&keyword=${param.keyword }'/>">
		<span style="color:blue">[${i }]</span></a>
	</c:otherwise>
		</c:choose>
			</c:forEach>
			<c:choose>
		<c:when test="${endPage<pageCount }">
			<a href="<c:url value='/dev/board/EventNotice.do?cmd=list&pageNum=${endPage+1 }&search=${param.search}&keyword=${param.keyword}'/>">[다음]</a>
		</c:when>
		<c:otherwise>
		[다음]
		</c:otherwise>
		</c:choose>
</div>
</body>
</html>