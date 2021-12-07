package com.koreait.ex07.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.ex07.command.BoardDeleteCommand;
import com.koreait.ex07.command.BoardInsertCommand;
import com.koreait.ex07.command.BoardListCommand;
import com.koreait.ex07.command.BoardUpdateCommand;
import com.koreait.ex07.command.BoardViewCommand;
import com.koreait.ex07.dto.Board;

@Controller
@RequestMapping("board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	@Autowired  //bean으로 등록시켜야 @Autowired가 가능하다.
	private BoardListCommand boardListCommand;
	@Autowired
	private BoardInsertCommand boardInsertCommand;
	@Autowired
	private BoardViewCommand boardViewCommand;
	@Autowired
	private BoardUpdateCommand boardUpdateCommand;
	@Autowired
	private BoardDeleteCommand boardDeleteCommand;
	
	
	
	
	@GetMapping(value = "selectBoardList.do")
	public String selectBoardList(Model model) {  // view에 보여줘야하니깐 Model이 필요하다.
		boardListCommand.execute(model);
		return "board/list";
	}
	
	@GetMapping(value = "insertBoardForm.do")
	public String insertBoardForm() {
		return "board/insert";
	}
	@PostMapping(value = "insertBoard.do")
	public void insertBoard(HttpServletRequest request, HttpServletResponse response, Model model) {
		// BoardInsertCommand는 Model만 받을 수 있음 .
		// Model에 request, response만 저장해 둠
		// BoardInsertCommand는 받은 Model에서 request, response 꺼내서 사용함
		model.addAttribute("request", request);    //jsp에 반환하기 위한 Model이 아니다.
		model.addAttribute("response", response);
		boardInsertCommand.execute(model);
	}
	
	@GetMapping(value = "selectBoardByNo.do")
	public String selectBoardByNo(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		boardViewCommand.execute(model);
		return "board/detail";
	}
	
	@GetMapping(value = "updateBoardForm.do")
	public String updateBoardForm(Board board) {
		return "board/update";
	}
	
	@PostMapping(value = "updateBoard.do")
	public void updateBoard(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response",response);
		boardUpdateCommand.execute(model);
		
	}
	
	@GetMapping(value = "deleteBoard.do")
	public void deleteBoard(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("request", request);
		model.addAttribute("response",response);
		boardDeleteCommand.execute(model);
		
		
	}
	
}
