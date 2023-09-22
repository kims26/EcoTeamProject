<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/temp.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	var rs = dfs_xy_conv("toXY","37.579871","126.989352");
	
	$("#x").html(rs['x']);
	$("#y").html(rs['y']);
	
	$.ajax({
		url  : "temp/temp.do",
		data : {"nx" : rs['x'],
			"ny" : rs['y']},
		datatype : "json",
		success : function (res_data) {
			$("#disp").html(res_data);
		},
		errer : function(err){
			alert(err.status);   //error code
		} 
	})
});



</script>

</head>
<body>
<hr>
	<div>x좌표<p id="x"></p></div>
	<div>x좌표<p id="y"></p></div>
	
	<div id="disp"></div>
	
<hr>
</body>
</html>