package com.koreait.ex05.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.ex05.domain.Board;

@RestController  // ajax만 처리하는 컨트롤러 , @ResponseBody를 생략 함
@RequestMapping("board")
public class BoardController {
	
	@GetMapping(value = "v1.do",
				produces = "application/json; charset=utf-8")
	public Board v1(Board board) {
		return board;  //반환되는 bean은 jackson data-bind에 의해서 json으로 변환됨
	}
	
	@PostMapping(value = "v2.do", 
				 produces = "application/json; charset=utf-8")
	public Board v2(@RequestBody Board board) {  //요청 데이터가 body에 포함되어있다.
		return board;
	}
	
	@PostMapping(value = "v3.do",
				 produces = "application/json; charset=utf-8")
	public Map<String, Object> map (@RequestBody Map<String, Object> map){
		
		
		return map;
	}
	
}
