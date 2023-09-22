package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import vo.TempVo;


public class TempSearchUtil {
	public static List<TempVo> searchKeyword(int nx, int ny){
		List<TempVo> list = new ArrayList<TempVo>();
		String base_time;
		String ServiseKey = "7h7HdgJNnc%2Frj3B57VREoKPYwykcDV06cKmnQZvrgHm3MMNU5ciLKjO4sr6xQ1L3Bi2zpBYsaVmZ7WB%2BrIBiuw%3D%3D";
		
		LocalDateTime now = LocalDateTime.now();
		int hour = now.getHour();
        int minute = now.getMinute();
        
        if(minute<40) {
        	hour=hour-1;
        }
        
        if(hour<10) {
        	base_time = String.format("0%d00", hour);
        }else {
        	base_time = String.format("%d00", hour);
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String base_date = now.format(formatter);
		
		try {
			//코드가 확실하지 않음
			String str_url = String.format("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?ServiceKey=%s&pageNo=1&numOfRows=1000&dataType=JSON&base_date=%s&base_time=%s&nx=%d&ny=%d",
					ServiseKey,base_date,base_time,nx,ny);
			
			URL url = new URL(str_url);
			
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			
			
			InputStream is = conn.getInputStream();//url.openStream();
			
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			BufferedReader    br  = new BufferedReader(isr);
			
			StringBuffer sb = new StringBuffer();
			
			while(true) {
				
				String data = br.readLine();
				//System.out.println(data);
				
				if(data==null) 
					break;
				sb.append(data);
			}
			
			String json_data = sb.toString();
			
			JSONObject json = new JSONObject(json_data);
			
			
			//카카오 API에서 시작을 documents라고하는 배열로 시작하기 때문에 
			//배열로 먼져 가져온다.
			
			
			JSONObject response = json.getJSONObject("response");
			JSONObject body = response.getJSONObject("body");
			JSONObject items = body.getJSONObject("items");
			
			JSONArray localArray = items.getJSONArray("item");
			
			for(int i=0; i<localArray.length();i++) {
				JSONObject local = localArray.getJSONObject(i);
				
		        String baseDate	            = local.getString("baseDate");
		        String baseTime             = local.getString("baseTime");
		        String category             = local.getString("category");
		        String obsrValue            = local.getString("obsrValue");
		        
		        //LocationVo 생성 및 값을 넣음
		        TempVo vo = new TempVo();
		        vo.setBaseDate(baseDate);
		        vo.setBaseTime(baseTime);
		        vo.setCategory(category);
		        vo.setObsrValue(obsrValue);
		        
		        list.add(vo);
			}

			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;	
	}
}
