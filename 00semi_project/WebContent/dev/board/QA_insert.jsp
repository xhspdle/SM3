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


			<form method="post" action="<c:url value='/board/QA_board.do?cmd=insert'/>">
				
				<input type="hidden" name="num" value="${param.num }">
				<input type="hidden" name="ref" value="${param.ref}" />
				<input type="hidden" name="lev" value="${param.lev }"/>
				<input type="hidden" name="step" value="${param.step }"/>
				<input type="hidden" name="user_num" value=2>	<!-- 유저번호 -->
				<input type="hidden" name="admin_num" value=4>	<!-- 관리자번호 -->
				작성자<input type="text" name="user_name" value="유저이름"><br>
				<!--로그인하면 글작성할때  유저이름을 가져온다  -->
				글제목<input type="text" name="qa_title"><br>
				글내용<textarea rows="5" cols="50" name="qa_content" >
				</textarea><br>	
				<input type="submit" value="작성완료">				
			</form >

</body>
</html>