package action.kakao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.AirSearchUtils;
import util.KakaoSearchUtils;
import util.TempSearchUtil;
import vo.AirVo;
import vo.LocationVo;
import vo.TempVo;

/**
 * Servlet implementation class KakaoSearchAction
 */
@WebServlet("/kakao/keyword.do")
public class KakaoSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// /keyword.do?latitude=37.483782&longitude=126.9003409&query=약국&page=1&size=15
		
		//여기서 parameter받아서 처리할 것
		
		//온도 검색 
		request.setCharacterEncoding("utf-8");
		int nx = Integer.parseInt(request.getParameter("nx")); 
		int ny = Integer.parseInt(request.getParameter("ny"));
		
		List<TempVo> list2= TempSearchUtil.searchKeyword(nx, ny);
		
		request.setAttribute("list", list2);
		//온도 검색 여기까지 
		
		double latitude  = Double.parseDouble(request.getParameter("latitude"));
		double longitude = Double.parseDouble(request.getParameter("longitude"));
		
		
		List<LocationVo> list = KakaoSearchUtils.searchKeyword(latitude, longitude);
		
//		for(LocationVo vo : list) {
//			System.out.printf("(%4dm) : %s\n",vo.getDistance(), vo.getPlace_name());
//		}
		
		//request binding
		//request.setAttribute("region_1depth_name", list.get(0).getRegion_1depth_name());
		//request.setAttribute("region_2depth_name", list.get(0).getRegion_2depth_name());
		
		String region_1depth_name = list.get(0).getRegion_1depth_name();
		String region_2depth_name = list.get(0).getRegion_2depth_name();
		
		List<AirVo> list1 = 	AirSearchUtils.searchAir(region_1depth_name);
		
		AirVo vo =null;
		
		for(AirVo a : list1) {
			
			if(a.getStationName().equals(region_2depth_name))
				
				//vo.setPm10Value(a.getPm10Value());
				vo = a;
				
		}
		
		
		request.setAttribute("vo", vo);
		
		
		//Cross Domain(다른서버) -> Ajax 요청 허락
		/*
		 * response.setHeader("Access-Control-Allow-Origin","*");
		 * response.setHeader("Access-Control-Allow-Headers","X-Requested-With");
		 */
		
		
		//Dispatcher
		String forward_page = "kakao_keyword_list.jsp";
		request.getRequestDispatcher(forward_page).forward(request, response);

	}
}
