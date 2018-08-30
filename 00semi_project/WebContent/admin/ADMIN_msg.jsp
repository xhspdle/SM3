<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="row" style="margin-top:5%;">
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
	      <img src="<c:url value='/etc/successMsg1.jpg'/>" alt="성공1" style="margin:auto;">
	      <div class="carousel-caption">
	        <h3>ServerMsg</h3>
	        <h1>${msg }</h1>
	      </div>
	    </div>
	
	    <div class="item">
	      <img src="<c:url value='/etc/successMsg2.jpg'/>" alt="성공2" style="margin:auto;">
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
	      <img src="<c:url value='/etc/failMsg1.png'/>" alt="실패1" style="margin:auto;">
	      <div class="carousel-caption">
	        <h3>ServerMsg</h3>
	        <h1>${msg }</h1>
	      </div>
	    </div>
	
	    <div class="item">
	      <img src="<c:url value='/etc/failMsg2.jpg'/>" alt="실패2" style="margin:auto;">
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