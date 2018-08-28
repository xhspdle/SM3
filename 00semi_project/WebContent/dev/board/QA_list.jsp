<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Qa_list</title>
<script type="text/javascript">

function searchCheck(frm){
    //검색
   
    if(frm.keyWord.value ==""){
        alert("검색 단어를 입력하세요.");
        frm.keyWord.focus();
        return;
    }
    frm.submit();      
}



</script>
</head>
<body>
			<table width="700" border="1">
			
			<tr>
				<th>글번호</th>
				<th>글쓴이</th>
				<th>글제목</th>
				<th>삭제</th>
				<th>ref</th>
				<th>lev</th>
				<th>step</th>
			</tr>
			<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<td>${vo.qa_num }</td>
			<td>${vo.qa_writer }</td>
			<td>
			<!--글상세보기   -->
			<c:if test="${vo.lev>0 }">
			<c:forEach var="i" begin="1" end="${vo.lev }">
			&nbsp;&nbsp;
				</c:forEach>
					[re]
					</c:if>
			<a href="<c:url value='/dev/board/QA_board.do?cmd=detail&qa_num=${vo.qa_num }'/>">${vo.qa_title}</a></td>  
						
			<%-- <td><a href="/dev/board/QA_board.do?cmd=delete&qa_num=${vo.qa_num}">삭제</a></td>--%>
			<td><a href="<c:url value='/dev/board/QA_board.do?cmd=delete&qa_num=${vo.qa_num}'/>">삭제</a></td>
			<td>${vo.ref }</td>
			<td>${vo.lev }</td>
			<td>${vo.step }</td>
		</tr>
			</c:forEach>
				<!--검색  -->
				
				
		<tr>  
        	<td colspan="7"> <br/>
            <form  action="<c:url value='/dev/board/QA_board.do?cmd=list'/>" name="serach" method ="post">
            <select name="keyField">
                <option value="0"> ----선택----</option>
                <option value="qa_writer">글쓴이</option>
                <option value="qa_title">제목</option>
                <option value="qa_content">내용</option>  
            </select>
            <input type="text" name="keyWord" />
            <input type="button" value="검색" onclick="searchCheck(form)" />
           
            </form>
           
        </td>      
    </tr>
			
			</table>
						
							
			
	<!--검색  -->		
	<div>	
	<!-- 이전 -->
 	<c:choose>
		<c:when test="${startPage>2 }">
			<a href="<c:url value='/dev/board/QA_board.do?cmd=list&pageNum=${startPage-1 }'/>">[이전]</a>		
			</c:when>
		<c:otherwise>
			[이전]
		</c:otherwise>
	</c:choose>	 	
			
			
			<!--페이징  -->
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
	<c:choose>
		<c:when test="${pageNum==i }"><%-- 현재페이지인경우--%>
			<a href="<c:url value='/dev/board/QA_board.do?cmd=list&pageNum=${i }'/>"><span style="color:red" >[${i }]</span></a>
		</c:when>
		<c:otherwise>
			<a href="<c:url value='/dev/board/QA_board.do?cmd=list&pageNum=${i }'/>"><span style="color:#555" >[${i }]</span></a>
		</c:otherwise>
	</c:choose>	
	</c:forEach>
	
	<!-- 다음 -->
 	<c:choose>
		<c:when test="${endPage<pageCount }">
			<a href="<c:url value='/dev/board/QA_board.do?cmd=list&pageNum=${endPage+1 }'/>">[다음]</a>
		</c:when>
		<c:otherwise>
			[다음]
		</c:otherwise>
	</c:choose> 
	</div>
			
</body>
</html>