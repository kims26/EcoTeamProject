<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>환경오염 WEB 프로젝트</title>
    <link href="https://webfontworld.github.io/gmarket/GmarketSans.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/responsive.css">
    <link rel="stylesheet" type="text/css" href="css/jquery.fullPage.css" />
    <link rel="stylesheet" type="text/css" href="css/slick-theme.css">
    <link rel="stylesheet" type="text/css" href="css/slick.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/slide_main.css">
    <link rel="icon" type="image/favicon.ico" sizes="16x16" href="images/favicon-16x16.ico" type= "이미지/x-icon" >
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon-16x16.png">
    <link rel="stylesheet" type="text/css" href="css/move.css">

	
   
</head>

<body>
     <div id="fullpage">
     <div class="section" id="section0">
    <header class="s_header" id="s_header">
        <div class="background">
        
 		
 		
        <div class="inner">
      
          <div id="disp2"></div>
         <!--  <div id="tit">
        <a href="introduce.jsp"><img alt="제목" src="images/sub/font.png"></a></div>-->
           <ul class="login">
           <li><a class="join" href="member/insert_form.do"></a><span>JOIN</span></li>
           <c:if test="${empty user }">
           	<li><a class="login"  href="member/member_login_form.jsp"></a><span>LOGIN</span></li>
           </c:if>
           <c:if test="${not empty user }">
           	<li><a class="login"  href="member/logout.do"></a><span>LOGOUT</span></li>
           </c:if>
               
               
               
           </ul>
       
            <nav class="s_gnb">

                <ul>
                    <li><a href="#firstPage">HOME</a></li>
                    <li><a href="#secondPage">환경오염의 현실</a></li>
                    <li><a href="#3rdPage">기업들의 노력</a></li>
                    <li><a href="#4rdPage">친환경의 시작</a></li>
                    <li><a href="#content">CONTEST</a></li>
                </ul>
            </nav>
            </div>
       </div>
    </header>
         </div>
   
  
      <div class="section" id="section1">
            <div class="s_cont1">
                <div class="inner">
                    <div class="s_cont_title">
                        <ul class="sub_title">
                            <li><a href="#none">환경</a></li>
                            <li><a href="#none">오염의</a></li>
                            <li><a href="#none">현실</a></li>
                        </ul>
                    </div>

                    <div class="greeting"
                       id="main_slide">
                       <div class="box box1">
                        <div class="top">
                            <!--            <div class="txt1">-->
                            <ul class="txt1">
                                <li><a href="#none"></a></li>
                                
                            </ul>

                            <!--          </div>-->
                        </div>
                        <div class="img_box1">
                            <a href="#none"></a>

                        </div>
                        <div class="top_middle"><ul>
                            <li>  </li>
                        </ul>
                          
                        </div>
                        </div>
                        <div class="box box2">
                      
                           
                        <div class="img_box2"><a href="#none"></a></div>
                        <div class="bottom">
                            <ul class="txt3">
                                <li>
                                    <a href="#none"></a>
                                </li>
                                <li><a href="#none"></a>
                                       
                                   
</li>
                                <li><a href="#none"></a></li>
                                <li> <a href="#none"></a></li>
                                <li>
                                    <a href="#none"></a></li>
                            </ul>
                        </div>

                    </div>
                </div>
                 </div>
          </div>   </div>  
                <div class="section" id="section2">
                <div class="intro">
                <div class="s_cont2">
                  <div class="inner">
                   <div class="s_cont_title">
                    <ul class="sub_title">
                        <li><a href="#none">지구를 위한</a></li>
                        <li><a href="#none">기업들의</a></li>
                       
                        <li><a href="#none">노력</a></li>
                    </ul>
                    </div>
                    <div class="slide" id="slide1">
                    <div class="box box1">
                    <div class="museum_area" >
                    <ul>
                    	<li>
                        <a href="https://www.hyundai.co.kr/news/CONT0000000000004269" target="_blank"><img alt="현대모비스 재사용 물품 기증식" src="images/sub/green_1.jpg"></a>
                        </li>
                    	<li>
                        <a href="http://www.foodneconomy.com/news/articleView.html?idxno=347041" target="_blank"><img alt="CJ프레시웨이, 플라스틱 가림막 회수/재활용 체계" src="images/sub/green_2.png"></a>
                        </li>
                     </ul>
                     <ul>
                    	 <li>
                         <a href="https://biz.newdaily.co.kr/site/data/html/2019/04/22/2019042200088" target="_blank"><img alt="이마트, 친환경 브랜드 런칭 및 플라스틱 수거" src="images/sub/green_3.jpg"></a>
                         </li>
                    	 <li>
                         <a href="https://m.mbn.co.kr/news/economy/4766034" target="_blank"><img alt="한솥, 버려진 페트병으로 만든 친환경 유니폼 도입" src="images/sub/green_4.jpg"></a>
                         </li>
                      </ul>

                        </div>
                        </div>
                        </div>
                        
                   
                        
                </div>
            </div></div>
      </div>
            
                   <div class="section" id="section3">
                <div class="s_cont4">
                   <div class="inner">
                       <div class="s_cont_title">
                  
                    <ul class="sub_title">
                        <li><a href="#none">이제</a></li>
                        <li><a href="#none">우리도</a></li>
                     
                        <li><a href="#none">시작해야 합니다</a></li>
                    </ul></div>
                     <form target="_blank">
						<div class="button_container" id="button_container1">

						   <input type="hidden" name="latitude"   id="latitude">
						   <input type="hidden" name="longitude"  id="longitude">
						   
						
						   <input type="hidden" name="query"   value="리필스테이션">
						   <input id="btn" type="button"  value="리필스테이션" onclick="send(this.form);">
						   
						</div>
						</form>
						
						
						<form target="_blank">
						<div class="button_container" id="button_container2">

						   <input type="hidden" name="latitude"   id="latitude1">
						   <input type="hidden" name="longitude"  id="longitude1">
						
						   <input  type="hidden" name="query"   value="비건식당">
						   <input id="btn1" type="button"  value="비건식당" onclick="send(this.form);"> 
						
					</div>
						</form>
						
												
						<form target="_blank">
						<div class="button_container" id="button_container3">
						   <input type="hidden" name="latitude"   id="latitude2">
						   <input type="hidden" name="longitude"  id="longitude2">
						 
						   
						   
						   <input type="hidden" name="query"   value="제로웨이스트샵">
						   <input id="btn100" type="button"  value="제로웨이스트샵" onclick="send(this.form);">
						   
						 
						    </div>
						</form>  
                        
                    </div>
                </div>
            </div>
              <div class="section fp-auto-height" id="section4">

 
     
        <footer class="footer" id="footer">
        <div class="inner">
			<div id="disp"></div>
			
        </div>
    </footer>
    </div>
     </div>
     
     
       
</body>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/jquery.fullPage.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/common.js"></script>
 <script src="js/visit.js"></script> 
 <script src="js/temp.js"></script>
	<script src="js/air.js"></script>
<script type="text/javascript">

   //browser초기화시 현재 위치의 위도/경도를 구한다
   window.onload = function(){

		 if (navigator.geolocation) {
		     navigator.geolocation.getCurrentPosition(function(position){
		    	  var latitude =  position.coords.latitude;
				  var longitude=  position.coords.longitude;
				  
				  console.log(latitude,longitude);
				  
				  document.getElementById("latitude").value  = latitude;
				  document.getElementById("longitude").value = longitude;
				  
				  document.getElementById("latitude1").value  = latitude;
				  document.getElementById("longitude1").value = longitude;
				  
				  document.getElementById("latitude2").value  = latitude;
				  document.getElementById("longitude2").value = longitude;
		    	 
		     });
		 } 

   };
   
  function send(f){
	   
	   var query = f.query.value.trim();
	   
	   if(query==''){
	
		   f.query.vlaue='';
		   f.query.focus();
		   return;   
	   }
	  
	   f.action = "kakao/keyword1.do";
	   f.submit();
	   
   }
   
   </script>


<script>

   

    $(document).ready(function() {
    	
    	
   
    	  show_comment();
    	  air_show();
    	
    	 
		
        if ($(window).width() < 1024) {
            $('#fullpage').removeAttr('id');
         
           
        }
        $('#fullpage').fullpage({
            anchors: ['firstPage', 'secondPage', '3rdPage','4rdPage','content'],
           
            navigation: true,
            navigationTooltips: ['First page', 'Second page', 'Third and last page'],

            'afterLoad': function(index, nextIndex, direction) {
            	
            	console.log(index,nextIndex,direction);
            	
                if (nextIndex == 1) {
                      
                	//$(window).load(function() {
                    
                		$("#section0").addClass("on");
                		  
                   
                   // });
                } else if (nextIndex == 2) {
                    $("#section1").addClass("on");
                } else if (nextIndex == 3) {
                    $("#section2").addClass("on");
                } else if (nextIndex == 4) {
                    $("#section3").addClass("on");
              
                } else if (nextIndex == 5) {
                }
           
            }
        });
   });
    
    
  $(function(){
	  
	  
	  
  });  
</script>
<script>

    $(function() {
    	
    	
        $('#main_slide').slick({
            slide: 'div',
            infinite: true,
            slidesToShow: 1,
            slidesToScroll: 1,
            speed: 100,
            arrows: true,
            autoplay: true,
            autoplaySpeed: 5000,
            pauseOnFocus: false,
            pauseOnHover: false,
            prevArrow: "<button type='button' class='slick-prev'>Previous</button>",
            nextArrow: "<button type='button' class='slick-next'>Next</button>",
        });

    });
</script>
</html>
