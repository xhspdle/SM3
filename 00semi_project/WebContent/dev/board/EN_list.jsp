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
제목<input type="text" name="제목" value="${vo.en_title }"><br>
내용<input type="text" name="내용" value="${vo.en_content }"><br>
날짜<input type="text" name="날짜" value="${vo.en_date }"><br>

	<a href="<c:url value='/dev/board/EventNotice.do?cmd=select&en_num=${vo.en_num }'/>">수정</a>
	<a href="<c:url value='/dev/board/EventNotice.do?cmd=delete&en_num=${vo.en_num }'/>">삭제</a><br>
</c:forEach>
</div>
</div>


</body>
</html>