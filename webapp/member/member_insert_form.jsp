<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check_id() {
	//제이쿼리
	var mem_id = $('#mem_id').val();
	
	if(mem_id.length<3){
		$("#id_message").html("아이디는 3자리 이상")
		.css("color","red");
		
		//회원가입 버튼 비활성화
		$("#btn_register").attr("disabled",true);
		return;
	}
	//서버 : 아이디 중복체크
	$.ajax({
		url       : "check_id.do",
		data      : {"mem_id" : mem_id},
		dataType  : "json",
		success   : function (res_data) {
			//res_data = {"result" : true} or {"result" : false}
			if(res_data.result==true){
				$("#id_message").html("사용가능한 아이디 입니다.")
				.css("color","blue");
				$("#btn_register").attr("disabled",false);
			}else{
				$("#id_message").html("이미 사용중인 아이디 입니다.")
				.css("color","red");
				$("#btn_register").attr("disabled",true);
			}
		},
		error     : function(err){
			alert(err.responseText);
		}
	});
}

function send(f) {
	//입력항목 체크(이름/비밀번호/주소/우편번호)
	let mem_name = f.mem_name.value.trim();
	let mem_pwd = f.mem_pwd.value.trim();

	if(mem_name==""){
		alert("이름을 입력하세요");
		f.mem_name.value = "";
		f.mem_name.focus();
		return;
	}
	if(mem_pwd==""){
		alert("비밀번호을 입력하세요");
		f.mem_pwd.value = "";
		f.mem_pwd.focus();
		return;
	}

	f.action = "insert.do";
	f.submit();
}

</script>
</head>
<body>
<form class="form-inline">
	<div id="box">
		<div class="panel panel-primary">
		<div class="panel-heading"><h4>회원가입</h4></div>
		<div class="panel-body">
		
			<div class="seperator">
				<label>이름 : </label>
				<input  name="mem_name" >
			</div>
			
			<div class="seperator">
				<label>아이디 : </label> 
				<input name="mem_id" id="mem_id" onkeyup="check_id();">
				<span id="id_message"></span>
			</div>
			<div class="seperator">
				<label>비밀번호 : </label> 
				<input name="mem_pwd"  type="password">
				<span id="id_message"></span>
			</div>
			<hr>
			
			<div style="text-align: center;">
				<input type="button" value="회원가입"  disabled="disabled"	id="btn_register"  onclick="send(this.form);">
				<input type="button" value="목록보기" onclick="location.href='../introduce.jsp'">
				
			</div>
		</div>
    </div>
	</div>
</form>
</body>
</html>