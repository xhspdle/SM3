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
	<table width="700" border="1">
		<tr>
			<th>주문번호</th>
			<th>이미지</th>
			<th>상품정보</th>
			<th>상품수량</th>
			<th>총구매금액</th>
			<th>주문처리상태</th>
		</tr>
	<c:forEach var="vo" items="${requestScope.list }">
		<td>${vo.order_num }</td>
		<td><img src='<c:url value="/DBImages/${vo.item_savimg }"/>'
		 style="width:105px;height:140px;" id="img1"></td>
		<td>${vo.item_info }</td>
		<td>${vo.order_cnt }</td>
		<td>${vo.order_pay }</td>
		<td>${vo.order_status }</td>
		<td>
			<c:choose>
				<c:when test="${vo.order_status=='1' }">
		 			배송중
				</c:when>
				<c:when test="${vo.order_status=='2' }">
					배송완료
				</c:when>
				<c:when test="${vo.order_status=='3' }">
					구매확정
				</c:when>
				<c:when test="${vo.order_status=='4' }">
					취소
				</c:when>
				<c:when test="${vo.order_status=='5' }">
					반품
				</c:when>
				<c:otherwise>
					주문내역이 없습니다.<br>
				</c:otherwise>
			</c:choose>
		</td>
	  </c:forEach>
	</table>
</body>
</html>