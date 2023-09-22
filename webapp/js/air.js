/**
 * 
 */
 
  function air_show(){
        	 if (navigator.geolocation) {
    		     navigator.geolocation.getCurrentPosition(function(position){
    		    	 
    		    	latitude =  position.coords.latitude;
    				longitude=  position.coords.longitude;
    				//alert('위치초기화 완료!!');
   					var rs = dfs_xy_conv("toXY",latitude,longitude);
    				
    				$.ajax({
    					   
    					   url  	: 'kakao/keyword.do',
    					   data 	: { 'latitude':latitude, 'longitude':longitude,"nx" : rs['x'],"ny" : rs['y']},
    					   success 	: function(res_data){
	
    						   $("#disp2").html(res_data);
    					   },
    					   error 	: function(err){
	                           
	                           console.log(err.responseText);
    					   
    						   alert(err.status);
    					   }
    				   });
    		     });
    		 }
    }
