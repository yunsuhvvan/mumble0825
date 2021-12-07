package com.koreait.ex06.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.ex06.domain.Board;
import com.koreait.ex06.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	
	// 로그 생성기
	//System.out.println() 대체 도구로 활용하기
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// BoardService 인터페이스
	@Autowired
	private BoardService service;
	
	
	@GetMapping(value = "selectBoardList.do")
	public String selectBoardList(Model model) {  // model : jsp로 값을 넘긴다.
//		logger.info("selectBoardList() 호출");  //console에 정보가 찍힘
//		service = new BoardServiceImpl();  @Autowired로 인해 필요없어짐
		List<Board> list = service.selectBoardList();
//		logger.info(list.toString());			// board 목록을 console에 찍어봄
		model.addAttribute("list",list);		// 내부적으로 request.setAttribute("list", list)임
		return "board/list";					// board/list.jsp로 forward함.(model에 저장한 list가 전달된다.)
	}
	
	
	@GetMapping(value = "insertBoardForm.do")
	public String insertBoardForm() {
		return "board/insert";
	}
	
	@PostMapping(value = "insertBoard.do")
	public void insertBoard(HttpServletRequest request , HttpServletResponse response) {
	service.insertBoard(request,response);
//		return "redirect:selectBoardList.do";  // 그냥 forward를 하게 되면 데이터가 2개 출력된다.
//		BoardServiceimpl의 insertBoard에 의해서 처리 되기 때문에 반환타입은 void이다..
	}
	
	@GetMapping(value = "selectBoardByNo.do")
	public String selectBoardByNo(@RequestParam("no") Long no, Model model) {
		model.addAttribute("board", service.selectBoardByNo(no));
		return "board/detail";
	}
	@GetMapping(value = "updateBoardForm.do")
	public String updateBoard(Board board) {  // 전달받은 정보를 jsp로 넘겨줘야한다.  @ModelAttribute(value="board")
		// detail.jsp에서 보낸 파라미터 3개는 Board board가 받고,
		// model에 "board" 속성으로 저장한다. (model.addAttribute("board", board) = @ModelAttribute(value= "board"))
		return "board/update";
	}
	
	@PostMapping(value = "updateBoard.do")
	public void updateBoard(Board board, HttpServletResponse response) {  // 3개의 파라미터를 그냥 bean(Board board)으로 받을 수 있는게 Spring의 능력이다
		service.updateBoard(board,response);
		
	}
	
	@GetMapping(value = "deleteBoard.do")
	public void deleteBoard(@RequestParam(value = "no", required = false, defaultValue = "0")Long no, HttpServletResponse response) {
		service.deleteBoard(no, response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
