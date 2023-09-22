<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
* {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}

a {
    text-decoration: none;
}

.wrap {
    padding: 40px 0;
    background-color: #A8C0D6;
    min-height: 500px;
    width: 1200px;
    margin: 0 auto;
    min-width: 500px;
}

.wrap .chat {
    display: flex;
    align-items: flex-start;
    padding: 20px;
}

.wrap .chat .icon {
    position: relative;
    overflow: hidden;
    width: 50px;
    height: 50px;
    border-radius: 50%;
    background-color: #eee;
}

.wrap .chat .icon i {
    position: absolute;
    width : 100%;
    top: 15px;
    left: 50%;
    color: black;
    transform: translateX(-50%);
    font-family: "윤고딕";
    font-size: 13px;
    text-align: center;
    overflow: hidden;
    line-height: 1.8;
}

.wrap .chat .textbox {
    position: relative;
    display: inline-block;
    max-width: calc(100% - 70px);
    padding: 10px;
    margin-top: 7px;
    font-size: 13px;
    border-radius: 10px;
}

.wrap .chat .textbox::before {
    position: absolute;
    display: block;
    top: 0;
    font-size: 1.5rem;
}

.wrap .ch1 .textbox {
    margin-left: 20px;
    background-color: #ddd;
}

.wrap .ch1 .textbox::before {
    left: -10px;
    content: "◀";
    color: #ddd;
    top: 10px;
}

.wrap .ch2 {
    flex-direction: row-reverse;
}

.wrap .ch2 .textbox {
    margin-right: 20px;
    background-color: #F9EB54;
}

.wrap .ch2 .textbox::before {
    right: -10px;
    content: "▶";
    color: #F9EB54;
    top: 10px;
}
.dddd{
	max-height: 500px;
	max-width: 100%;
	overflow: scroll;	
	overflow-x:hidden;
}
.f_box{

 position: absolute;
 bottom: 10%;
 right: 5%;
}
.f_box textarea.content {
	width: 600px;
	border-radius: 10px;
	border: none;
	
}


#chat_btn{
	position: absolute;
	left: 500px;
	height:50px; 
	
}

.visit_content{
	resize:none; 
	width: 500px;
	margin-bottom: 10px;
	height: 50px;
	border-radius: 5px;
	padding: 5px;
	right: 10px;
    position: relative;
}
.chat_box{
	position: absolute;
	left: 1090px;
	bottom: -	10px;
}


</style>
<script type="text/javascript">
$(document).ready(function(){
	//스크롤을 가장 아래로 내리는코드
	$('#dddd').scrollTop($('#dddd')[0].scrollHeight);
});
function insert_action(f) {
if("${empty user }"=="true"){
	if(confirm("댓글등록은 로그인 후 이용가능 합니다.\n로그인 하시겠습니까?")==false)return;
	location.href='member/login_form.do';
	return;}
	visit_insert(f);
}
</script>

</head>
<body>
<div class="dddd" id="dddd">
	<div class="wrap">
		<c:forEach var= "visit" items="${ list }">
			<c:if test="${visit.mem_idx eq user.mem_idx }">
				<div class="chat ch2">
				    <div class="icon"><i class="fa-solid fa-user">${visit.mem_vo.mem_name} </i></div>
				    <div class="textbox">${ visit.visit_content }</div>
				</div>
			</c:if>
			
			<c:if test="${visit.mem_idx ne user.mem_idx }">
				<div class="chat ch1">
				    <div class="icon"><i class="fa-solid fa-user">${visit.mem_vo.mem_name}</i></div>
				    <div class="textbox">${ visit.visit_content }</div>
				 </div>
			 </c:if>
		 </c:forEach>

	</div>
</div>
<div class="chat_box">
	<form>
		<input type="hidden" name="mem_idx" value="${ user.mem_idx }">
		<div class="f_box">
			<textarea cols="30" class="visit_content" name="visit_content" placeholder="입력하세요"></textarea>
			<input type="button" id="chat_btn" class="btn btn-primary" value="댓글 등록" onclick="insert_action(this.form);">
		</div>
	</form>
</div>

</body>
</html>