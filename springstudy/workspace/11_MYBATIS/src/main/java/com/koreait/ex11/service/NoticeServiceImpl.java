package com.koreait.ex11.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex11.domain.Notice;
import com.koreait.ex11.repository.NoticeRepository;

public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private SqlSessionTemplate sqlSession;  // 그전에는 Repository에서 필요했었음..
	
	
	@Override
	public List<Notice> selectNoticeList(){
	     NoticeRepository repository = sqlSession.getMapper(NoticeRepository.class);      //xml 매퍼랑 repository를 직접 연결  
																					     // 여기에서 mapper는 repository가 된다  //NoticeRepository를 Mapper로 활용하기 위해서
	     return repository.selectNoticeList();
	     // NoticeRepository의 selectNoticeList()호출 --> notice.xml의 id="selectNoticeList" 실행
	     // repository의 호출은 곧 동일 id를 가진 mapper의 호출이다..
	}
	
	@Override
	public Notice selectNoticeByNo(Long no) {
		NoticeRepository repository = sqlSession.getMapper(NoticeRepository.class);
		
		return repository.selectNoticeByNo(no);
	}
	
	@Override
	public int insertNotice(Notice notice) {
		NoticeRepository repository = sqlSession.getMapper(NoticeRepository.class);
		return repository.insertNotice(notice);
		
	}
	
	@Override
	public int updateNotice(Notice notice) {
		NoticeRepository repository = sqlSession.getMapper(NoticeRepository.class);
		return repository.updateNotice(notice);
	}
	
	@Override
	public int deleteNotice(Long no) {
		NoticeRepository repository = sqlSession.getMapper(NoticeRepository.class);
		return repository.deleteNotice(no);
	}
	
	
	
	
	
}
