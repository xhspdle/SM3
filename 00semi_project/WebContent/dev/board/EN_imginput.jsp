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
	<td>관리자번호</td>
	<td><input type="text" name="admin_num" value="${vo.admin_num }"></td> 
</tr>
<tr>
	<td>글번호</td>
	<td><input type="text" readonly="readonly" name="en_num" value="${vo.en_num }"></td>
</tr>
<tr>
	<td>작성자</td>
	<td><input type="text" name="en_writer" value="${vo.en_writer }"></td>
</tr>
<tr>
	<td>제목</td>
	<td><input type="text" name="en_title" value="${vo.en_title }"></td>
</tr>
<tr>
	<td>글내용</td>
	<td><textarea rows="5" cols="50" name="en_content"></textarea></td>
</tr>

<img src="<c:url value='/images/${vo.en_savimg }'/>" alt="원본"><br> <!--alt:그림이 없을때 나오는 설명(말풍선)-->
<input type="button" value="이미지변경" onclick="showFile()"><br>
<span id="inputFile" style="display:none;">
첨부파일<input type="file" name="file1" onchange="change()" >
</span>	
</form>
<tr>
	<td colspan="2" align="center">
	<input type="hidden" name="en_orgimg" value="${vo.en_orgimg }">
	<input type="hidden" name="en_savimg" value="${vo.en_savimg }">
	<input type="submit" value="확인">
	</td>
</tr>
</table>
<script>
	function showFile(){  
		var inputFile=document.getElementById("inputFile");
		inputFile.style.display="block";
		var hidden1=document.getElementsByName("en_orgimg")[0];
		var hidden2=document.getElementsByName("en_savimg")[0];
		hidden1.setAttribute("disabled","disabled"); //파일을 보내지 않는다.(원래사진은). *원래사진은..db에서  받고, 새로운 사진은 controller에서 받고.
		hidden2.setAttribute("disabled","disabled"); //그래서 mvc패턴 흐름을
		}
	function Change(){   //이미지 변경 사진을 누르면 바뀌는것.
		var file=document.getElementsByTagName("file1")[0].value; //바꿀사진의 요소를 빼온다.
		var fileName=file.split("\\"); //c://java//~~ 이것처럼 주소를 쪼개준다.
		var img=document.getElementsByTagName("img")[0]; 
		img.src="<%=application.getContextPath()%>/images/" +fileName[2]; //쪼개진 주소에서 3번째 요소를 빼온다. 사진의 이름이 담긴
	}
</script>
<a href="<c:url value='/dev/board/EventNotice.do?cmd=list'/>">목록보기</a>
<a href="<c:url value='/dev/board/EN_main.jsp'/>">메인으로</a>
</c:when>
</c:choose>
</body>
</html>


