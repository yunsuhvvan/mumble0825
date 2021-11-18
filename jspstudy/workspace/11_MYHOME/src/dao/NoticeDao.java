package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Notice;
import mybatis.config.DBService;

public class NoticeDao {

	
	// MyBatis는 SqlSession 객체를 이용해서 DB에 접근한다.
	// SqlSession 객체는 메소드별로 만들고 닫는 것이 좋다.
	// SqlSession 객체를 만들 수 있는 SqlSessionFactory를 준비해 둔다.
	
	private SqlSessionFactory factory;   // 공장만 만들어 둔다.
	
	// singleton  NoticeDao 자기 자신을 객체로 만드는것
	private static NoticeDao instance;
	
	private NoticeDao() {
		factory = DBService.getInstance().getFactory();
	}
	public static NoticeDao getInstance() {
		
		if(instance == null) {
			instance = new NoticeDao();
		}
		return instance;
	}
	
	
	
	public List<Notice> selectNoticeList(){
		SqlSession ss = factory.openSession();
		List<Notice> list = ss.selectList("dao.notice.selectNoticeList");
		ss.close();
		return list;
	}
	
	public Notice selectNoticeview(Long nNo) {
		SqlSession ss = factory.openSession();
		Notice notice = ss.selectOne("dao.notice.selectNoticeview" , nNo);
		ss.close();
		return notice;
	}
	
	
	public int updateNoticeHit(Long nNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.notice.updateNoticeHit", nNo);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	
	public int insertNotice (Notice notice) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.notice.insertNotice" , notice);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	public int updateNotice(Notice notice) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.notice.updateNotice", notice);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	public int deleteNotice(Long nNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.notice.deleteNotice", nNo);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
