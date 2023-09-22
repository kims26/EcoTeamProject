package dao;




import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVo;

public class MemberDao {
	//singleton pattern : 1개의 객체만 생성해서 서비스하자
	static MemberDao single = null;
	
	SqlSessionFactory factory;
	
	public static MemberDao getInstance() {

		if (single == null)
			single = new MemberDao();

		return single;
	}

	//외부에서 new ProjectDao() 못하도록 설정
	private MemberDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	
	public MemberVo selectOne(String mem_id) {

		MemberVo vo = null;

		SqlSession Sqlsession = factory.openSession();
		
		vo = Sqlsession.selectOne("member.member_selectOne",mem_id);
		
		// 3.마무리 작업
		Sqlsession.close();
		
		return vo;
	}
	
	public int insert(MemberVo vo) {
		
		int res = 0;
		
		SqlSession Sqlsession = factory.openSession(true);
		
		res = Sqlsession.insert("member.member_insert",vo);
		
		// 3.마무리 작업
		Sqlsession.close();
		
		return res;
	}
}
