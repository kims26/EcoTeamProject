package action.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLogoutAction
 */
@WebServlet("/member/logout.do")
public class MemberLogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//request에는 세션이 들어가있기때문에 받아오는 처리
		HttpSession session = request.getSession();
		
		//세션에 들어가 있던값들 삭제
		session.removeAttribute("user"); 
		
		//메인페이지로 이동
		response.sendRedirect("../introduce.jsp");

	}
}
