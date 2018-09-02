<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<input type="hidden" value="ITEM_COLOR_insert" id="here">
<c:choose>
	<c:when test="${param.do1=='insert' }">
<div style="margin-top:10%;">
	<div class="row">
		<section class="panel panel-admin">
			<header class="panel-heading">
				<h1 class="panel-title">컬러 추가</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/admin/itemColor.do?cmd=insert"/>'>
					<div class="form-group">
						<label class="col-md-3 control-label" for="color_name">컬러이름</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="color_name" name="color_name">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="color_code">컬러코드</label>
						<div class="col-md-6">
							<input type="color" class="form-control" id="color_code" name="color_code">
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
				<h1 class="panel-title">컬러 수정</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/admin/itemColor.do?cmd=insert"/>'>
					<div class="form-group">
						<label class="col-md-3 control-label" for="color_num">컬러번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="color_num" readonly="readonly"
							name="color_num" value="${vo.color_num }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="color_name">컬러이름</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="color_name" 
							name="color_name" value="${vo.color_name }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="color_code">컬러코드</label>
						<div class="col-md-6">
							<input type="color" class="form-control" id="color_code" 
							name="color_code" value="${vo.color_code }">
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
</c:choose>