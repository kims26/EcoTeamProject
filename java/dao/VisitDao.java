package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVo;
import vo.VisitVo;

public class VisitDao {
	//singleton pattern : 1개의 객체만 생성해서 서비스하자
	static VisitDao single = null;
	
	SqlSessionFactory factory;
	public static VisitDao getInstance() {

		if (single == null)
			single = new VisitDao();

		return single;
	}

	//외부에서 new VisitDao() 못하도록 설정
	private VisitDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	

	
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;

		SqlSession Sqlsession = factory.openSession();
		
		list = Sqlsession.selectList("visit.visit_List");
		
		// 3.마무리 작업
		Sqlsession.close();
		
		return list;
	}
	
	public int insert(VisitVo vo) {

		int res = 0;//처리된 결과행수

		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("visit.visit_insert",vo);
		
		sqlSession.close();

		return res;
	}
	

}
