package com.koreait.integration.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.integration.domain.Book;
import com.koreait.integration.service.BookService;

@Controller
public class BookController {

	
	@Autowired
	private BookService service;
	
	
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@PostMapping(value = "book/addBook" ,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> addBook(@RequestBody Book book) { // 전달된 json 데이터는 jackson data-bin에 의해서 bean을 변환됨
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result",service.addBook(book));
		return map;
		// Map, Bean을 반환시켜주면 잭슨에 의해서 Json형태로 바뀐다.
	}
	
	@GetMapping(value = "book/findAllBook", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> findAllBook(){
		
		List<Book> list = service.findAllBook(); // repository에서 받아오는건 list이다.
		Map<String, Object> map = new HashMap<String, Object>();
		if(list.size() == 0) {
			map.put("status", 500);
			map.put("message", "저장된 도서가 없습니다.");
			map.put("list", null);
		} else {
			map.put("status", 200);
			map.put("message", "전체" + list.size() + "개의 도서가 있습니다.");
			map.put("list", list);
		}
		
		return map;
	}
	
	@GetMapping(value = "book/findBook", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> findBook(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", request.getParameter("column"));
		map.put("query", request.getParameter("query"));
		
		List<Book> list = service.findBook(map);
		Map<String, Object> m = new HashMap<String, Object>();
		if(list.size() == 0) {
			m.put("status", 500);
			m.put("message", "검색된 도서가 없습니다.");
			m.put("list", null);
		} else {
			m.put("status", 200);
			m.put("message", "전체" + list.size() + "개의 도서가 검색되었습니다.");
			m.put("list", list);
		}
		return m;
	}
	
}
