<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row">
<h2>관리자 목록</h2>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>관리자번호</th>
			<th>관리자아이디</th>
			<th>관리자비밀번호</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<td>${vo.admin_num }</td>
			<td>${vo.admin_id }</td>
			<td>${vo.admin_pwd }</td>
			<td><a href="<c:url value='/admin/admin.do?cmd=select&admin_num=${vo.admin_num }'/>">수정</a></td>
			<td><a href="<c:url value='/admin/admin.do?cmd=delete&admin_num=${vo.admin_num }'/>">삭제</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>