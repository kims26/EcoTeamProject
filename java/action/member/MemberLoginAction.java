package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberLoginAction
 */
@WebServlet("/member/login.do")
public class MemberLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// /member/login.do?mem_id=hong&mem_pwd=1234
		
		//1.�������ڵ�����
		request.setCharacterEncoding("utf-8");
		
		//2.parameter �ޱ�
		String mem_id = request.getParameter("mem_id");
		String mem_pwd = request.getParameter("mem_pwd");
		
		//3.mem_id �ش�Ǵ� ������ �� ������ ���´�
		MemberVo user = MemberDao.getInstance().selectOne(mem_id);
		
		//���̵� Ʋ�����
		if(user==null) {
			response.sendRedirect("login_form.do?reason=fail_id");
			return;
		}
		if(user.getMem_pwd().equals(mem_pwd)==false) {
			response.sendRedirect("login_form.do?reason=fail_pwd&mem_id="+mem_id);
			return;
		}
		
		//�α���ó��
		HttpSession session = request.getSession();
		//���ǿ� �α����� user������ ����
		session.setAttribute("user", user);
		
		//������������ �̵�
		response.sendRedirect("../introduce.jsp");
		
		

	}
}