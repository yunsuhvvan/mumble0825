package com.koreait.ex14.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.ex14.service.EmployeeService;

@Controller
@RequestMapping("search/*")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping(value = "searchPage")
	public String searchPage() {
		return "employee/search";
	}
	
	@GetMapping(value = "findAll")
	public String findAll(HttpServletRequest request, Model model) {  // 현재 몇페이지 정보인지 넘겨받아야만 작업을 수행할 수 있다.
		model.addAttribute("request", request); // model에 request를 실어서 주기
		service.findAllEmployee(model);  		// model안에 request가 들어있어서 빼서 쓸 수 있다.  
		return "employee/search";  //jsp에 정보를 넘기긴 위해선 model이 필요하다
	}
	
	@GetMapping(value="findEmployee")
	public String findEmployee(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		service.findEmployee(model);
		return "employee/search";
	}
	
	@PostMapping(value = "autoComplete", produces = "application/json; charset=utf-8")
	@ResponseBody
	public void autoComplete(@RequestBody Map<String, Object> map, HttpServletResponse response){ //파라미터가 2개
		service.autoComplete(map,response);
	}

	
	
	
}
