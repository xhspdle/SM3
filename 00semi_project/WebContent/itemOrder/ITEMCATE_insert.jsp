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
<form method="post" action='<c:url value="/itemOrder/item.do?cmd=insert"/>' id="form1">
	상품번호 <input type="text" readonly="readonly" name="cate_num" value="${vo.cate_num }">
	상품분류 <input type="text" name="cate_name" value="${vo.cate_name }">
	<input type="submit" value="입력">
	<input type="button" value="수정" onclick="goUpdate()">
</form>
</body>
<script type="text/javascript">
	function goUpdate(){
		var upForm=document.getElementById("form1");
		upForm.action="item.do?cmd=update";
		upForm.submit();		
	}
</script>
</html>