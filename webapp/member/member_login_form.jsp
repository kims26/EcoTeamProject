<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#box{
		width: 400px;
		margin: auto;
		margin-top: 100px;
	}
	button,input[type='button']{
		width: 90px;
	}
</style>
<script type="text/javascript">
	function send(f) {
		var mem_id	 = f.mem_id.value.trim();
		var mem_pwd  = f.mem_pwd.value.trim();
		
		if(mem_id==''){
			alert('아이디를 입력하세요');
			f.mem_id.value = '';
			f.mem_id.focus();
			return;
		}
		if(mem_pwd==''){
			alert('비밀번호를 입력하세요');
			f.mem_pwd.value = '';
			f.mem_pwd.focus();
			return;
		}
		//전송
		f.action="login.do";//MemberLoginAction
		f.submit();
	}
</script>
<script type="text/javascript">
	//html이 전부 준비되면 가장 먼저 실행되는 메소드
	$(document).ready(function(){
	   
	   // 0.1초후에 호출 : 로그인폼 show된후에 호출
	   setTimeout(show_message,100);
	   //show_message();
	   
   });
	function show_message() {
		//login_form.do?reason=gail_id
		if("${param.reason eq 'fail_id'}"=="true"){
			alert('아이디가 틀렸습니다!!');
		}
		
		if("${param.reason eq 'fail_pwd'}"=="true"){
			alert('비밀번호가 틀렸습니다!!');
		}
		
		if("${param.reason eq 'fail_session_timeout'}"=="true"){
			alert('로그아웃 되었습니다\n로그인후에 이용하세요!!');
		}
	}

</script>

</head>
<body>
<form>
	<div id="box">
		<div class="panel panel-primary">
			<div class="panel-heading"><h4>로그인</h4></div>
			<div class="panel-body">
				<table class="table">
					<tr>
						<th>아이디 : </th>
						<td><input class="form-control" name="mem_id" value="${param.mem_id}"></td>
					</tr>
					<tr>
						<th>비밀번호 : </th>
						<td><input class="form-control" type="password" name="mem_pwd"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<!-- <input class="btn btn-primary" type="button" value="로그인" 
							onclick="send(this.form);"> -->
							<!-- <button> or <input type='image'> 태그들은 자동으로 onsubmit이 실행됨 
							onsubmit()방지 : onclick="send(this); return false;"-->
							<button class="btn btn-primary" onclick="send(this.form);">로그인</button>
							<input class="btn btn-success" type="button" value="메인화면"
							onclick="location.href='../introduce.jsp'">
							
						</td>
					</tr>
				</table>
			</div>
	    </div>
	</div>
</form>
</body>
</html>