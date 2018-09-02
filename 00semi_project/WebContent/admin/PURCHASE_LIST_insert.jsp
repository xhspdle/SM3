<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<input type="hidden" value="PURCHASE_LIST_insert" id="here">
<c:choose>
	<c:when test="${param.do1=='insert' }">
<div style="margin-top:10%;">
	<div class="row">
		<section class="panel panel-admin">
			<header class="panel-heading">
				<h1 class="panel-title">구매 추가</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/purchase.do?cmd=insert"/>'>
					<div class="form-group">
						<label class="col-md-3 control-label" for="size_num">사이즈번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="size_num" name="size_num">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_cnt">주문수량</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_cnt" name="order_cnt">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="item_price">상품가격</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="item_price" name="item_price">
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
				<h1 class="panel-title">구매 수정</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/purchase.do?cmd=update"/>'>
					<div class="form-group">
						<label class="col-md-3 control-label" for="pl_num">구매목록번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="pl_num" 
							name="pl_num" readonly="readonly" value="${vo.pl_num }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="pur_num">구매번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="pur_num" 
							name="pur_num" value="${vo.pur_num }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="size_num">사이즈번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="size_num" 
							name="size_num" value="${vo.size_num }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_cnt">주문수량</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_cnt" 
							name="order_cnt" value="${vo.order_cnt }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="item_price">상품가격</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="item_price" 
							name="item_price" value="${vo.item_price }">
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