<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
	<c:when test="${param.do1=='insert' }">
<div>
	<div class="row">
		<section class="panel panel-admin">
			<header class="panel-heading">
				<h1 class="panel-title">주문 추가</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/order.do?cmd=insert"/>'>
					<div class="form-group">
						<label class="col-md-3 control-label" for="user_num">유저번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="user_num" name="user_num">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="pur_num">구매번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="pur_num" name="pur_num">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_total">총주문금액</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_total" name="order_total">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_point">포인트사용액</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_point" name="order_point">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_pay">결제금액</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_pay" name="order_pay">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_recipient">받는사람</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_recipient" name="order_recipient">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_post_addr">배송지우편번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_post_addr" name="order_post_addr">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_basic_addr">기본배송지</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_basic_addr" name="order_basic_addr">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_detail_addr">상세배송지</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_detail_addr" name="order_detail_addr">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_phone">받는사람폰번호</label>
						<div class="col-md-2">
							<input type="text" class="form-control" id="order_phone" name="order_phone">
						</div>
						<div class="col-md-2">
							<input type="text" class="form-control" id="order_phone" name="order_phone">
						</div>
						<div class="col-md-2">
							<input type="text" class="form-control" id="order_phone" name="order_phone">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_status">주문상태</label>
						<div class="col-md-6">
							<select class="form-control populate" id="order_status"
							name="order_status">
								<optgroup label="주문상태">
									<option value="1">배송중</option>
									<option value="2">배송완료</option>
									<option value="3">구매확정</option>
									<option value="4">취소</option>
									<option value="5">반품</option>
								</optgroup>
							</select>
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
<div>
	<div class="row">
		<section class="panel panel-admin">
			<header class="panel-heading">
				<h1 class="panel-title">주문 상세/수정</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/order.do?cmd=update"/>'>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_num">주문번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_num" 
							name="order_num" readonly="readonly" value="${vo.order_num }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="user_num">유저번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="user_num" 
							name="user_num" value="${vo.user_num }">
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
						<label class="col-md-3 control-label" for="order_total">총주문금액</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_total" 
							name="order_total" value="${vo.order_total }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_point">포인트사용액</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_point" 
							name="order_point" value="${vo.order_point }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_pay">결제금액</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_pay" 
							name="order_pay" value="${vo.order_pay }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_recipient">받는사람</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_recipient" 
							name="order_recipient" value="${vo.order_recipient }">
						</div>
					</div> 
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_post_addr">배송지우편번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_post_addr" 
							name="order_post_addr" value="${vo.order_post_addr }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_basic_addr">기본배송지</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_basic_addr" 
							name="order_basic_addr" value="${vo.order_basic_addr }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_detail_addr">상세배송지</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_detail_addr" 
							name="order_detail_addr" value="${vo.order_detail_addr }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_phone">받는사람폰번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_phone" 
							value="${vo.order_phone }" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="">번호수정</label>
						<div class="col-md-2">
							<input type="text" class="form-control" id="order_phone" 
							name="order_phone">
						</div>
						<div class="col-md-2">
							<input type="text" class="form-control" id="order_phone" 
							name="order_phone">
						</div>
						<div class="col-md-2">
							<input type="text" class="form-control" id="order_phone" 
							name="order_phone">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_date">주문날짜</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="order_date" 
							name="order_date" value="${vo.order_date }" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="order_status">주문상태</label>
						<div class="col-md-6">
							<select class="form-control populate" id="order_status"
							name="order_status">
								<optgroup label="주문상태">
									<option value="1">배송중</option>
									<option value="2">배송완료</option>
									<option value="3">구매확정</option>
									<option value="4">취소</option>
									<option value="5">반품</option>
								</optgroup>
							</select>
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