package action.visit;

import java.io.IOException;

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
 * Servlet implementation class VisitInsertAction
 */
@WebServlet("/visit/visit_insert.do")
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MemberVo mem_vo = (MemberVo) session.getAttribute("user");
		int mem_idx = mem_vo.getMem_idx();

		String visit_content = request.getParameter("content").replaceAll("\n", "<br>");
		String visit_ip = request.getLocalAddr();
		
		//int mem_idx = Integer.parseInt(request.getParameter("mem_idx"));
		
		VisitVo vo = new VisitVo(mem_idx, visit_content, visit_ip);
		
		int res = VisitDao.getInstance().insert(vo);
		
		
		String json = String.format("{\"result\": %b}", res==1);
		
		response.setContentType("text/json;charset=utf-8;");
		response.getWriter().print(json);
		
				
		
		
		
	}
}
