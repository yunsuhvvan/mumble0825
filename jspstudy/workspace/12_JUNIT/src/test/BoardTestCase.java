package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.mybatis.BoardDAO;
import dto.Board;

class BoardTestCase {
	
	@BeforeEach
	void 선행작업() {
		Board board = new Board();
		board.setbNo("99999");
		board.setWriter("테스터");
		board.setContent("테스트내용");
		
		int result= BoardDAO.getInstance().insertBoard(board);
		assertEquals(1, result, "등록오류");
	}
	
	@AfterEach
	void 후처리작업() {
		int result = BoardDAO.getInstance().deleteBoard("99999");
		assertEquals(1, result,"삭제오류");
	}

	//@Test  // 이 메소드는 JUnit테스트 할 때 실행되는 메소드이다.
	void 게시글목록가져오기_테스트() { // 테스트 코드 메소드명은 "한글"로 해도된다.
		//게시글 목록 가져와서 현재 개수 맞는지 점검
//		assertEquals("기대한값", "실제값",  ["에러메시지"]);
		 System.out.println("게시글목록가져오기_테스트");
		assertEquals(4, BoardDAO.getInstance().selectBoardList().size());
	}
	@Test
	void 게시글가져오기_테스트(){
		// 게시글번호 10000인 게시글을 가져와서 null 유무 점검하기
		System.out.println("게시글가져오기_테스트");
		assertNotNull(BoardDAO.getInstance().selectBoardBybNo("99999"));
	}

}
