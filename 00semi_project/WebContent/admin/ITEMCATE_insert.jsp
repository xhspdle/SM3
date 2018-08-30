<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
	<c:when test="${param.do1=='insert' }">
<div style="margin-top:10%;">
	<div class="row">
		<section class="panel panel-admin">
			<header class="panel-heading">
				<h1 class="panel-title">분류 추가</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/admin/itemCate.do?cmd=insert"/>'>
					<div class="form-group">
						<label class="col-md-3 control-label" for="cate_name">상품분류</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="cate_name" name="cate_name">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-6">
						<button type="submit" class="btn btn-primary btn-block">추가</button>
						</div>
					</div>
			</form>
			</div>
		</section>
	</div>
</div>	
	</c:when>
	<c:when test="${param.do1=='update' }">
<div style="margin-top:10%;">
	<div class="row">
		<section class="panel panel-admin">
			<header class="panel-heading">
				<h1 class="panel-title">분류 수정</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/admin/itemCate.do?cmd=update"/>'>
					<div class="form-group">
						<label class="col-md-3 control-label" for="cate_num">분류번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="cate_num" readonly="readonly"
							name="cate_num" value="${vo.cate_num }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="cate_name">상품분류</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="cate_name" 
							name="cate_name" value="${vo.cate_name }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-6">
						<button type="submit" class="btn btn-primary btn-block">수정</button>
						</div>
					</div>
			</form>
			</div>
		</section>
	</div>
</div>	
	</c:when>
</c:choose>