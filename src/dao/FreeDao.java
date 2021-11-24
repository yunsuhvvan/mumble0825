package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Free;
import dto.Member;
import mybatis.config.DBService;

public class FreeDao {

	private SqlSessionFactory factory;
	
	private static FreeDao instance;
	
	private FreeDao() {
		factory = DBService.getInstance().getFactory();
	}
	
	public static FreeDao getInstance() {
		if(instance == null) {
			instance = new FreeDao();
		}
		return instance;
	}
	
	
	public List<Free> selectFreeList(Map<String, Integer> map){
		SqlSession ss = factory.openSession();
		List<Free> list = ss.selectList("dao.free.selectFreeList", map);
		ss.close();
		return list;
	}
	
	public int getCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne("dao.free.getCount");
		ss.close();
		return count;
		
	}
	
	public int insertFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.free.insertFree", free);
		if(result >0 ) ss.commit();
		ss.close();
		return result;
	}
	
	public Free selectFreeByfNo(Long fNo) {
		SqlSession ss = factory.openSession();
		Free free = ss.selectOne("dao.free.selectFreeByfNo", fNo);
		ss.close();
		return free;
		
	}
	
	public int updateHit(Long fNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.free.updateHit", fNo);
		if(result >0 ) ss.commit();
		ss.close();
		return result;
		
	}
	
	public int updateFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.free.updateFree", free);
		if(result >0 ) ss.commit();
		ss.close();
		return result;
		
	}
	
	public int deleteFree(Long fNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.free.deleteFree", fNo);
		if(result >0 ) ss.commit();
		ss.close();
		return result;
		
	}
	
	public int insertReply(Free reply) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.free.insertReply", reply);
		if(result >0 ) ss.commit();
		ss.close();
		return result;
		
	}
	
	
	public int updatePreviousReplyGroupOrd(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.free.updatePreviousReplyGroupOrd", free);
		if(result >0 ) ss.commit();
		ss.close();
		return result;
		
	}
	
	public List<Free> findFree(Map<String, String> map){
		SqlSession ss = factory.openSession();
		List<Free> list = ss.selectList("dao.free.findFree", map);
		ss.close();
		return list;
	}
	
	public int selectFindCount(Map<String, String> map) {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne("dao.free.selectFindCount" , map);
		ss.close();
		return count;
	}
	
	
	
	
	
	
	
	
}
