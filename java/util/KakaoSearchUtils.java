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
import org.json.JSONException;
import org.json.JSONObject;

import vo.LocationVo;

public class KakaoSearchUtils {

	public static List<LocationVo> searchKeyword(double latitude,double longitude){
	
		
		List<LocationVo> list = new ArrayList<LocationVo>();
		
	    try {
	    	
	    
	    	
			String str_url = String.format("https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?y=%.7f&x=%.7f",
					                                                                            latitude,longitude      
					);
			    
			URL url = new URL(str_url);
			
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			//Kakao 인증키 설정
			conn.setRequestProperty("Authorization", "KakaoAK 16676b01bd805cd47a5e168ae2ada942");
			
			conn.setRequestProperty("Content-Type", "application/json");
			
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
			
			
			JSONArray localArray = json.getJSONArray("documents");
			
			for(int i=0;i< localArray.length();i++) {
				
				JSONObject local = localArray.getJSONObject(i);
				
				String region_1depth_name = local.getString("region_1depth_name").substring(0,2);
				String str = local.getString("region_2depth_name");
				
				
				String region_2depth_name = str.substring(str.lastIndexOf(" ")+1);
				
				
				double local_latitude  = 0;
				double local_longitude = 0;
				
				try {
					
					local_latitude	= local.getDouble("y");
					local_longitude	= local.getDouble("x");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				
				
				//LocationVo 생성 및 값을 넣는다
				LocationVo  vo = new LocationVo();
				
				vo.setRegion_1depth_name(region_1depth_name);
				vo.setRegion_2depth_name(region_2depth_name);
				
				vo.setLatitude(local_latitude);
				vo.setLongitude(local_longitude);
				
				
				//ArrayList추가
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


