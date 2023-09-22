<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript">

  var latitude;
  var longitude;
	
   //browser초기화시 현재 위치의 위도/경도를 구한다
   window.onload = function(){
	   
	   
	   
		 if (navigator.geolocation) {
		     navigator.geolocation.getCurrentPosition(function(position){
		    	 
		    	latitude =  position.coords.latitude;
				longitude=  position.coords.longitude;
				//alert('위치초기화 완료!!');
				send();  
				  
		     });
		 }
		 
		

   };
   
 function send(){
	   
	  
	//jQuery Ajax
	   $.ajax({
		   
		   url  	: '../kakao/keyword.do',
		   data 	: { 'latitude':latitude, 'longitude':longitude},
		   success 	: function(res_data){
			   $("#disp").html(res_data);
		   },
		   error 	: function(err){
			   alert(err.status);
		   }
		   
		   
	   });
	  
	   
	   
	  
   }

</script>
</head>
<body>
<form>



</form>


<div id="disp">


</div>



</body>
</html>