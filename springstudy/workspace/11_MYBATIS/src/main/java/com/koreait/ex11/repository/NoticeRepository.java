package com.koreait.ex11.repository;

import java.util.List;

import com.koreait.ex11.domain.Notice;

public interface NoticeRepository {
	
	// method의 이름은 mapper의 id를 참조한다.
	// namespace 기존과 다름 주의..!
	
	// 기존의 Repository는 mapper와 연결할 수 있는 method를 사용했다면 
	// 오늘 배우는건 인터페이스로..!
	
	public List<Notice> selectNoticeList();
	public Notice selectNoticeByNo(Long no);
	public int insertNotice(Notice notice);
	public int updateNotice(Notice notice);
	public int deleteNotice(Long no);
	
}
