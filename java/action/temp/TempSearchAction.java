package action.temp;	

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.TempSearchUtil;
import vo.TempVo;

/**
 * Servlet implementation class TempSearchAction
 */
@WebServlet("/temp/temp.do")
public class TempSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		int nx = Integer.parseInt(request.getParameter("nx")); 
		int ny = Integer.parseInt(request.getParameter("ny"));
		
		List<TempVo> list= TempSearchUtil.searchKeyword(nx, ny);
		
		request.setAttribute("list", list);
		
		String forward_page = "temp_list.jsp";
		request.getRequestDispatcher(forward_page).forward(request, response);

	}
}
