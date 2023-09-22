<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- BootStrap 3.x -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<script type="text/javascript"></script>
<style type="text/css">

  #disp2{
    text-align: left;
    /*margin-left: 800px;*/
    position: absolute;
	 top: 95px;
   
  
  }

  .air1{
	font-size: 17px;
    /* font-weight: bold; */
    color: #000;
    position: relative;
    left: 40px;
  }
  
  .air2{
  	font-size: 17px;
   /* font-weight: bold; */
  	color: #FFFF00;
  	position: relative;
    left: 40px;
  
  }
  
  .air3{
  	font-size: 17px;
  	 /* font-weight: bold; */
  	color: #FF8000;
  	 position: relative;
    left: 40px;
  
  }
  
  .air4{
  	font-size: 17px;
  	 /* font-weight: bold; */
  	color: #DF0101;
  	position: relative;
    left: 40px;
  }


</style>




<body>


 

<c:if test="${ vo.pm10Grade eq 1 }">
<p class="air1">미세먼지 좋음

</c:if>

<c:if test="${ vo.pm10Grade eq 2 }">
<p class="air2">미세먼지 보통

</c:if>

<c:if test="${ vo.pm10Grade eq 3 }">
<p class="air3">미세먼지 나쁨

</c:if>

<c:if test="${ vo.pm10Grade eq 4 }">
<p class="air4">미세먼지 매우 나쁨

</c:if>


${ vo.dataTime }
<br>
<c:forEach var="vo" items="${list}">
	<c:if test="${ vo.category eq 'T1H' }">
		온도 : ${ vo.obsrValue }° <br> 
		<br>
	</c:if>
</c:forEach>






 

</body>
</html>
