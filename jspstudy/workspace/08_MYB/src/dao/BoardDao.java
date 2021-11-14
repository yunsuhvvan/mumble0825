package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.BoardDto;
import mybatis.config.MybatisSetting;

public class BoardDao {
	
private SqlSessionFactory factory;
	
	/* singleton */
	private static BoardDao instance;
	private BoardDao() {
		factory = MybatisSetting.getInstance().getFactory();
	}
	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	// 1. 사원 목록 반환
		public List<BoardDto> selectBoardList() {
			SqlSession ss = factory.openSession();
			List<BoardDto> list = ss.selectList("mybatis.mapper.sqlmap.selectBoardList");
			ss.close();
			return list;
		}
		
	// 2. 게시글 갯수
		
		public int getCount() {
			SqlSession ss = factory.openSession();
			int count = ss.selectOne("mybatis.mapper.sqlmap.getCount");
			
			if( count > 0) {
				ss.close();
			}
			
			return count;
			
		}
		
	// 3. 게시글 등록
		
		public int Insert(BoardDto dto) {
			SqlSession ss = factory.openSession(false);
			int result = ss.insert("mybatis.mapper.sqlmap.Insert" , dto);
			if(result > 0 ) {
				ss.commit();
			}
			ss.close();
			return result;
		}
		
	// 4. 게시글 상세정보
		
		public BoardDto detail(Long idx) {
			SqlSession ss = factory.openSession();
			BoardDto result = ss.selectOne("mybatis.mapper.sqlmap.detail" , idx);
			ss.close();
			return result;
			
		}
		
	// 5. 수정
		
		public int update(BoardDto dto) {
			SqlSession ss = factory.openSession(false);
			int result = ss.update("mybatis.mapper.sqlmap.update" , dto);
			if(result >0) ss.commit();
			ss.close();
			return result;
		}
		
		
		// 6. 삭제 
		
		public int delete (Long idx) {
			SqlSession ss = factory.openSession(false);
			int result = ss.delete("mybatis.mapper.sqlmap.delete" , idx);
			if(result > 0) {
				ss.commit();
			}
			ss.close();
			return result;
		}
		
	
	
}
