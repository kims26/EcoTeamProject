package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVo;
import vo.VisitVo;

public class VisitDao {
	//singleton pattern : 1���� ��ü�� �����ؼ� ��������
	static VisitDao single = null;
	
	SqlSessionFactory factory;
	public static VisitDao getInstance() {

		if (single == null)
			single = new VisitDao();

		return single;
	}

	//�ܺο��� new VisitDao() ���ϵ��� ����
	private VisitDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	

	
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;

		SqlSession Sqlsession = factory.openSession();
		
		list = Sqlsession.selectList("visit.visit_List");
		
		// 3.������ �۾�
		Sqlsession.close();
		
		return list;
	}
	
	public int insert(VisitVo vo) {

		int res = 0;//ó���� ������

		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("visit.visit_insert",vo);
		
		sqlSession.close();

		return res;
	}
	

}
