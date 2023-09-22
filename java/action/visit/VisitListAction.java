package action.visit;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VisitDao;
import vo.MemberVo;
import vo.VisitVo;

/**
 * Servlet implementation class VisitListAction
 */



@WebServlet("/visit/list.do")
public class VisitListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		List<VisitVo> list = VisitDao.getInstance().selectList();
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		request.setAttribute("list", list);
		request.setAttribute("user", user);
		
		//Dispatcher
		String forward_page = "visit_list.jsp";
		request.getRequestDispatcher(forward_page).forward(request, response);

	}
}
