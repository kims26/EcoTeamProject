package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberInsertAcrion
 */
@WebServlet("/member/insert.do")
public class MemberInsertAcrion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String mem_name     = request.getParameter("mem_name");
		String mem_id       = request.getParameter("mem_id");
		String mem_pwd      = request.getParameter("mem_pwd");
		String mem_ip       = request.getRemoteAddr(); 
		
		
		MemberVo vo = new MemberVo(mem_name,mem_id,mem_pwd,mem_ip);
		
		int res = MemberDao.getInstance().insert(vo);
		
		
		//메인페이지로 이동
		response.sendRedirect("../introduce.jsp");

	}
}