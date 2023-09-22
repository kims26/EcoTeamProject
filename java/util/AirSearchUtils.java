package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import vo.AirVo;

public class AirSearchUtils {
	

	public static List<AirVo> searchAir(String local){
	
		
		List<AirVo> list = new  ArrayList<AirVo>();
		
	    try {
	    	
	    	
	    	
	    	String query = URLEncoder.encode(local,"utf-8");
	    	//System.out.println(query);
	    	int   page = 1;
	    	int   count = 10;
	    	String serviceKey = "sv0E5AnjNnQVhZHxGExJHyFyM2pjTpl3vBy4FshUC4HnxVrJRZKWghRZAA%2BKBTRViiwyMZV6QFU5aiomzA3%2BbQ%3D%3D";
	    	
			/*
			 * String str_url = String.format(
			 * "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?serviceKey=%s&returnType=json&pageNo=1&numOfRows=10&stationName=%s&dataTerm=DAILY&ver=1.0",
			 * serviceKey,query );
			 */
			
	    	String str_url = String.format("https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=%s&returnType=json&numOfRows=100&pageNo=1&sidoName=%s&ver=1.0", 
	    			serviceKey,query);
			    
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
				
				if(data==null) break;
				
				sb.append(data);
			}
			
			String json_data = sb.toString();
			
			//System.out.println(json_data);
			
			//JSON Parsing......
			JSONObject json = new JSONObject(json_data);
			
			
			
			JSONArray itemArray = json.getJSONObject("response").getJSONObject("body").getJSONArray("items");//
			
			for(int i=0;i< itemArray.length();i++) {
				
				
				
				JSONObject item = itemArray.getJSONObject(i);
				
				String stationName = item.getString("stationName");
                String   pm10Value = item.getString("pm10Value");
                String    dataTime = item.getString("dataTime");
                int     pm10Grade = 0;
                
                
                
                
                try {
				   pm10Grade = item.getInt("pm10Grade");	
				} catch (Exception e) {
					// TODO: handle exception
				}
                
                
               AirVo vo = new AirVo();
               
               vo.setDataTime(dataTime);
               vo.setPm10Grade(pm10Grade);
               vo.setPm10Value(pm10Value);
               vo.setStationName(stationName);
               
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


