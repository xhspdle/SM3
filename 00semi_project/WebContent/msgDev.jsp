<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-lg-9">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
			  <!-- Indicators -->
			  <ol class="carousel-indicators">
			    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			    <li data-target="#myCarousel" data-slide-to="1"></li>
			  </ol>
			<c:choose>
			<c:when test="${!empty success }">
			  <!-- Wrapper for slides -->
			  <div class="carousel-inner">
			    <div class="item active">
			      <img src="<c:url value='/etc/successMsg1.jpg'/>" alt="성공1">
			      <div class="carousel-caption">
			        <h3>ServerMsg</h3>
			        <h1>${msg }</h1>
			      </div>
			    </div>
			
			    <div class="item">
			      <img src="<c:url value='/etc/successMsg2.jpg'/>" alt="성공2">
			      <div class="carousel-caption">
			        <h3>ServerMsg</h3>
			        <h1>${msg }</h1>
			      </div>
			    </div>
			  </div>
			 </c:when>
			 <c:otherwise>
			  <!-- Wrapper for slides -->
			  <div class="carousel-inner">
			    <div class="item active">
			      <img src="<c:url value='/etc/failMsg1.png'/>" alt="실패1">
			      <div class="carousel-caption">
			        <h3>ServerMsg</h3>
			        <h1>${msg }</h1>
			      </div>
			    </div>
			
			    <div class="item">
			      <img src="<c:url value='/etc/failMsg2.jpg'/>" alt="실패2">
			      <div class="carousel-caption">
			        <h3>ServerMsg</h3>
			        <h1>${msg }</h1>
			      </div>
			    </div>
			  </div>		 
			</c:otherwise>
			</c:choose>   
			  <!-- Left and right controls -->
			  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="right carousel-control" href="#myCarousel" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
		</div>
	</div>
</div>
</body>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>