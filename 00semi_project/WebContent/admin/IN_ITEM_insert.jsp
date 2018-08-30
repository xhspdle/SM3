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
				<h1 class="panel-title">상품 입고</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/admin/inItem.do?cmd=insert"/>'>
					<div class="form-group">
						<label class="col-md-3 control-label" for="size_num">사이즈번호</label>
						<div class="col-md-3">
							<select class="form-control" id="sizeAjax" onchange="sizeNum1()">
							</select>
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" id="size_num" name="size_num">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="in_cnt">입고수량</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="in_cnt" name="in_cnt">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="in_cost">주문원가</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="in_cost" name="in_cost">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-6">
						<button type="submit" class="btn btn-primary btn-block">추가</button>
						</div>
					</div>
					<input type="hidden" name="admin_num" value="${sessionScope.admin_num }">
			</form>
			</div>
		</section>
	</div>
</div>
<script>
	var xhr=null;
	window.onload = function(){
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=callback;
		xhr.open('get','itemSize.do?cmd=list&ajax=true',true);
		xhr.send();
	}
	function callback(){
		if(xhr.readyState==4 && xhr.status==200){
			var txt=xhr.responseText;
			var json=JSON.parse(txt);
			var sizeAjax=document.getElementById("sizeAjax");
			for(var i=0;i<json.length;i++){
				var option=document.createElement("option");
				option.setAttribute("value", json[i].size_num);
				option.text=json[i].size_num
				sizeAjax.add(option);
			}
		}
	}
	function sizeNum1(){
		var size_num=document.getElementById("size_num");
		size_num.setAttribute("value", document.getElementById("sizeAjax").value);
	}
</script>	
	</c:when>
	<c:when test="${param.do1=='update' }">
<div style="margin-top:10%;">
	<div class="row">
		<section class="panel panel-admin">
			<header class="panel-heading">
				<h1 class="panel-title">입고 수정</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/admin/inItem.do?cmd=update"/>'>
					<div class="form-group">
						<label class="col-md-3 control-label" for="in_num">입고번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="in_num" readonly="readonly"
							name="in_num" value="${vo.in_num }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="size_num">사이즈번호</label>
						<div class="col-md-3">
							<select class="form-control" id="sizeAjax" onchange="sizeNum1()">
							</select>
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" id="size_num" 
							name="size_num" value="${vo.size_num }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="in_cnt">입고수량</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="in_cnt" 
							name="in_cnt" value="${vo.in_cnt }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="in_cnt">입고수량</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="in_cnt" 
							name="in_cnt" value="${vo.in_cnt }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="admin_num_old">주문관리자</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="admin_num_old" 
							value="${vo.admin_num }" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="in_date">입고날짜</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="in_date" readonly="readonly"
							name="in_date" value="${vo.in_date }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-6">
						<button type="submit" class="btn btn-primary btn-block">수정</button>
						</div>
					</div>
					<input type="hidden" name="admin_num" value="${sessionScope.admin_num }">
			</form>
			</div>
		</section>
	</div>
</div>
<script>
	var xhr=null;
	window.onload = function(){
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=callback;
		xhr.open('get','itemSize.do?cmd=list&ajax=true',true);
		xhr.send();
	}
	function callback(){
		if(xhr.readyState==4 && xhr.status==200){
			var txt=xhr.responseText;
			var json=JSON.parse(txt);
			var sizeAjax=document.getElementById("sizeAjax");
			for(var i=0;i<json.length;i++){
				var option=document.createElement("option");
				option.setAttribute("value", json[i].size_num);
				option.text=json[i].size_num
				sizeAjax.add(option);
			}
		}
	}
	function sizeNum1(){
		var size_num=document.getElementById("size_num");
		size_num.setAttribute("value", document.getElementById("sizeAjax").value);
	}
</script>	
	</c:when>
</c:choose>