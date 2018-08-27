<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<table class="table table table-hover">
		<tr>
			<th>분류번호</th>
			<th>분류명</th>
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품설명</th>
			<th>상품가격</th>
			<th>원본이미지</th>
			<th>저장이미지</th>
			<th>사이즈번호</th>
			<th>사이즈이름</th>
			<th>재고수량</th>
			<th>컬러번호</th>
			<th>컬러명</th>
			<th>컬러코드</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<td>${vo.cate_num }</td>
			<td>${vo.cate_name }</td>
			<td>${vo.item_num }</td>
			<td>${vo.item_name }</td>
			<td>${vo.item_info }</td>
			<td>${vo.item_price }</td>
			<td>${vo.item_orgimg }</td>
			<td>${vo.item_savimg }</td>
			<td>${vo.size_num }</td>
			<td>${vo.size_name }</td>
			<td>${vo.size_cnt }</td>
			<td>${vo.color_num }</td>
			<td>${vo.color_name }</td>
			<td>${vo.color_code }</td>
			<td><a href="<c:url value='/dev/itemOrder/itemView.do?cmd=select&item_num=${vo.item_num }'/>">수정</a></td>
			<td><a href="<c:url value='/dev/itemOrder/itemView.do?cmd=delete&item_num=${vo.item_num }'/>">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</html>