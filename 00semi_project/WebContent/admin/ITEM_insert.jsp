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
				<h1 class="panel-title">상품 추가</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/admin/item.do?cmd=insert"/>'
				enctype="multipart/form-data">
					<div class="form-group">
						<label class="col-md-3 control-label" for="item_name">상품이름</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="item_name" name="item_name">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="cate_num">분류번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="cate_num" name="cate_num">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="item_info">상품설명</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="item_info" name="item_info">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="item_price">상품가격</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="item_price" name="item_price">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Image Upload</label>
						<div class="col-md-6">
						<img class="img-responsive" src=""
							alt="이미지" id="oldimg1" style="display:none;">
							<div class="fileupload fileupload-new">
								<div class="uneditable-input">
									<i class="fa fa-file fileupload-exists"></i>
									<span class="fileupload-preview"></span>
								</div>
								<span class="btn btn-default btn-file btn-aa">
									<input type="file" name="file1" id="fileupload" onchange="imgChange()">
								</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="item_price">상품색상</label>
						<div class="col-md-6">
							<select class="form-control" name="color_num">
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
<script type="text/javascript">
	var xhr=null;
	window.onload = function(){
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=callback;
		xhr.open('get','itemColor.do?cmd=list&ajax=true',true);//cmd=list?ajax=true 로 썼다가 낭패봄...ㅠㅠ
		xhr.send();
	}
	function callback(){
		if(xhr.readyState==4 && xhr.status==200){
			var txt=xhr.responseText;
			var json=JSON.parse(txt);
			var color_num=document.getElementsByName("color_num")[0];
			for(var i=0;i<json.length;i++){
				var option=document.createElement("option");
				option.setAttribute("value", json[i].color_num);
				option.text=json[i].color_name;
				color_num.add(option);
			}
		}
	}
	function imgChange(){
		var file=document.getElementsByName("file1")[0].value;
		var fileName=file.split("\\");
		var img=document.getElementById("oldimg1");
		img.src="<%=application.getContextPath()%>/DBImages/" +fileName[2];
		img.style.display="block";
	}
</script>
	</c:when>
	<c:when test="${param.do1=='update' }">
<div style="margin-top:10%;">
	<div class="row">
		<section class="panel panel-admin">
			<header class="panel-heading">
				<h1 class="panel-title">상품 수정</h1>
			</header>
			<div class="panel-body">
			<form class="form-horizontal form-bordered" 
				method="post" action='<c:url value="/admin/item.do?cmd=update"/>'
				enctype="multipart/form-data">
					<div class="form-group">
						<label class="col-md-3 control-label" for="item_num">상품번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="item_num" readonly="readonly"
							name="item_num" value="${vo.item_num }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="item_name">상품이름</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="item_name" 
							name="item_name" value="${vo.item_name }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="cate_num">분류번호</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="cate_num" 
							name="cate_num" value="${vo.cate_num }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="item_info">상품설명</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="item_info" 
							name="item_info" value="${vo.item_info }">
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
						<label class="col-md-3 control-label" for="img_btn"></label>
						<div class="col-md-6">
							<button type="button" class="btn btn-warning" id="img_btn" 
							onclick="showFile()">사진변경</button>
						</div>
					</div>
					<div class="form-group" id="inputFile" style="display:none;">
						<label class="col-md-3 control-label">Image Upload</label>
						<div class="col-md-6">
							<img class="img-responsive" src="<c:url value='/DBImages/${vo.item_savimg }'/>"
							alt="기존이미지" id="oldimg1">
							<div class="fileupload fileupload-new">
								<div class="uneditable-input">
									<i class="fa fa-file fileupload-exists"></i>
									<span class="fileupload-preview"></span>
								</div>
								<span class="btn btn-default btn-file btn-aa">
									<input type="file" name="file1" id="fileupload" onchange="imgChange()">
								</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="item_price">상품색상</label>
						<div class="col-md-6">
							<select class="form-control" name="color_num">
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-6">
						<button type="submit" class="btn btn-primary btn-block">수정</button>
						</div>
					</div>
					<input type="hidden" name="item_orgimg" value="${vo.item_orgimg }">
					<input type="hidden" name="item_savimg" value="${vo.item_savimg }">
			</form>
			</div>
		</section>
	</div>
</div>	
<script type="text/javascript">
	function showFile(){
		var inputFile=document.getElementById("inputFile");
		inputFile.style.display="block";
		var hidden1=document.getElementsByName("item_orgimg")[0];
		var hidden2=document.getElementsByName("item_savimg")[0];
		hidden1.setAttribute("disabled", "disabled");
		hidden2.setAttribute("disabled", "disabled");
	}
	function imgChange(){
		var file=document.getElementsByName("file1")[0].value;
		var fileName=file.split("\\");
		var img=document.getElementById("oldimg1");
		img.src="<%=application.getContextPath()%>/DBImages/" +fileName[2];
	}
	var xhr=null;
	window.onload = function(){
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=callback;
		xhr.open('get','itemColor.do?cmd=list&ajax=true',true);
		xhr.send();
	}
	function callback(){
		if(xhr.readyState==4 && xhr.status==200){
			var txt=xhr.responseText;
			var json=JSON.parse(txt);
			var color_num=document.getElementsByName("color_num")[0];
			for(var i=0;i<json.length;i++){
				var option=document.createElement("option");
				option.setAttribute("value", json[i].color_num);
				option.text=json[i].color_name;
				color_num.add(option);
			}
		}
	}
</script>
	</c:when>
</c:choose>