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
 * Servlet implementation class MemberCheckAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter 받기
		String mem_id = request.getParameter("mem_id");
		
		//3.Membervo정보 얻어오기
		MemberVo vo = MemberDao.getInstance().selectOne(mem_id);
		
		//4.결과값  만약 중복되는 아이디가 없으면 null이나오고 있으면 값이 들어감
		//이후 JSON으로 포장
		boolean bResult = (vo==null);
		
		String json = String.format("{\"result\":%b}", bResult);
		
		//5.결과전송
		response.setContentType("text/json, charset=utf-8");
		response.getWriter().print(json);
		
		
	}
}
