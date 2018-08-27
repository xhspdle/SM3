<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
	<c:when test="${param.do1=='insert' }">
<form method="post" action='<c:url value="/dev/itemOrder/inItem.do?cmd=insert"/>'>
	사이즈번호 <input type="text" name="size_num"><br>
	관리자번호 <input type="text" name="admin_num"><br>
	입고수량 <input type="text" name="in_cnt"><br>
	주문원가 <input type="text" name="in_cost"><br>
	<input type="submit" value="입력">
</form>	
	</c:when>
	<c:when test="${param.do1=='update' }">
<form method="post" action='<c:url value="/dev/itemOrder/inItem.do?cmd=update"/>'>
	입고번호 <input type="text" readonly="readonly" name="in_num" value="${vo.in_num }">
	사이즈번호 <input type="text" name="size_num" value="${vo.size_num }">
	관리자번호 <input type="text" name="admin_num" value="${vo.admin_num }">
	입고수량 <input type="text" name="in_cnt" value="${vo.in_cnt }">
	주문원가 <input type="text" name="in_cost" value="${vo.in_cost }">
	입고날짜 <input type="text" name="in_date" value="${vo.in_date }" readonly="readonly">
	<input type="submit" value="수정">
</form>	
	</c:when>
</c:choose>