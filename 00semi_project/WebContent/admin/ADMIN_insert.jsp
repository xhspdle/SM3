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
				<h1 class="panel-title">관리자 관리</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/admin/admin.do?cmd=insert"/>'>
				<div class="form-group">
					<label class="control-label col-md-3">관리자 추가</label>
					<div class="col-md-6">
						<section class="form-group-vertical">
							<div class="input-group input-group-icon">
								<span class="input-group-addon">
									<span class="icon"><i class="fa fa-user"></i></span>
								</span>
								<input class="form-control" type="text" name="admin_id" placeholder="Admin ID">
							</div>
							<div class="input-group input-group-icon">
								<span class="input-group-addon">
									<span class="icon"><i class="fa fa-key"></i></span>
								</span>
								<input class="form-control" type="password" name="admin_pwd" placeholder="Password">
							</div>
						<button type="submit" class="btn btn-primary btn-block">등록</button>
						</section>
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
				<h1 class="panel-title">관리자 관리</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/admin/admin.do?cmd=update"/>'>
				<div class="form-group">
					<label class="col-md-3 control-label" for="inputFocus">관리자 번호</label>
					<div class="col-md-6">
						<input class="form-control" type="text" readonly="readonly"
							 name="admin_num" value="${vo.admin_num }">
					</div>	
				</div>
				<div class="form-group">					
					<label class="control-label col-md-3">수정 사항</label>
					<div class="col-md-6">
						<section class="form-group-vertical">
							<div class="input-group input-group-icon">
								<span class="input-group-addon">
									<span class="icon"><i class="fa fa-user"></i></span>
								</span>
								<input class="form-control" type="text" name="admin_id"
								value="${vo.admin_id }" placeholder="Admin ID">
							</div>
							<div class="input-group input-group-icon">
								<span class="input-group-addon">
									<span class="icon"><i class="fa fa-key"></i></span>
								</span>
								<input class="form-control" type="password" name="admin_pwd"
								value="${vo.admin_pwd }" placeholder="Password">
							</div>
						<button type="submit" class="btn btn-primary btn-block">등록</button>
						</section>
					</div>
				</div>
			</form>
			</div>
		</section>
	</div>
</div>	
	</c:when>
</c:choose>