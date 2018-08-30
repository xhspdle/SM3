<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row">
<h2>분류 목록</h2>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>분류번호</th>
			<th>카테고리명</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<td>${vo.cate_num }</td>
			<td>${vo.cate_name }</td>
			<td><a href="<c:url value='/admin/itemCate.do?cmd=select&cate_num=${vo.cate_num }'/>">수정</a></td>
			<td><a href="<c:url value='/admin/itemCate.do?cmd=delete&cate_num=${vo.cate_num }'/>">삭제</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>