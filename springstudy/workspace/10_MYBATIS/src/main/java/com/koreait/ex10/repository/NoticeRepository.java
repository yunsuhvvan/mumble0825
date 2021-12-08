package com.koreait.ex10.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex10.domain.Notice;

public class NoticeRepository {//***************** D A O ***************
	
	// MyBatisConfig SqlSessionTemplate sqlSession() 가져오기
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Notice> selectNoticeList(){
		return sqlSession.selectList("mapper.notice.selectNoticeList");
	}
	
	public Notice selectNoticeByNo(Long no) {
		return sqlSession.selectOne("mapper.notice.selectNoticeByNo", no);
	}
	
	public int insertNotice(Notice notice) {     // DML은 여기서 commit쓰면 안된다.
		return sqlSession.insert("mapper.notice.insertNotice", notice);
		
	}
	
	public int updateNotice(Notice notice) {   // DML은 여기서 commit쓰면 안된다.
		return sqlSession.update("mapper.notice.updateNotice", notice);
	}
	
	public int deleteNotice(Long no) {   // DML은 여기서 commit쓰면 안된다.
		return sqlSession.delete("mapper.notice.deleteNotice" , no);
	}
	
}
