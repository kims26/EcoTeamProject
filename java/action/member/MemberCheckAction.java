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
		
		//1.�������ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		//2.parameter �ޱ�
		String mem_id = request.getParameter("mem_id");
		
		//3.Membervo���� ������
		MemberVo vo = MemberDao.getInstance().selectOne(mem_id);
		
		//4.�����  ���� �ߺ��Ǵ� ���̵� ������ null�̳����� ������ ���� ��
		//���� JSON���� ����
		boolean bResult = (vo==null);
		
		String json = String.format("{\"result\":%b}", bResult);
		
		//5.�������
		response.setContentType("text/json, charset=utf-8");
		response.getWriter().print(json);
		
		
	}
}
