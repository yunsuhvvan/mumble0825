package com.koreait.ex14.service;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.ex14.domain.Employee;
import com.koreait.ex14.repository.EmployeeRepository;
import com.koreait.ex14.utils.PageUtils;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void findAllEmployee(Model model) {  // model에 request가 들어가있다 controller에서 보냄
		EmployeeRepository repository = sqlSession.getMapper(EmployeeRepository.class);
		
		//Model에 저장된 request 꺼내기
		// model을 map으로 바꾸기
		Map<String, Object> m = model.asMap();  
	    HttpServletRequest request = (HttpServletRequest)m.get("request");
	    
	    
	    
		// 전체 레코드 갯수
		int totalRecord = repository.selectTotalRecordCount();

		// 전달 된 페이지 번호
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		//페이징 처리 PageUtils 객체 생성 및 계산
		PageUtils pageUtils = new PageUtils();
		pageUtils.setPageEntity(totalRecord, page);
		
		// beginRecord + endRecord => HashMap
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRecord", pageUtils.getBeginRecord());
		map.put("endRecord", pageUtils.getEndRecord());
		
		// beginRecord ~endRecord 목록 가져오기
		List<Employee> list = repository.selectEmployeeList(map);
		
		// View(employee/list.jsp로 보낼 데이터
		model.addAttribute("list", list);
		model.addAttribute("startNum", totalRecord - (page -1) * pageUtils.getRecordPerPage());
		model.addAttribute("paging" , pageUtils.getPageEntity("findAll")); // 목록을 출력하는 Mapping을 적어주기
		
	} // end of findAllEmployee
	
	@Override
	public void findEmployee(Model model) {
	EmployeeRepository repository = sqlSession.getMapper(EmployeeRepository.class);
		
		//Model에 저장된 request 꺼내기
		// model을 map으로 바꾸기
		Map<String, Object> m = model.asMap();  
	    HttpServletRequest request = (HttpServletRequest)m.get("request");
	    
	    // column + query + begin + end => HashMap (검색할 칼럼 + 검색어)
	    
	    String column = request.getParameter("column");
	    String query = request.getParameter("query");
	    String begin = request.getParameter("begin");
	    String end = request.getParameter("end");
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("column", column);
	    map.put("query",query);
	    map.put("begin", begin);
	    map.put("end", end);
	    
	    
		// 검색 된 레코드 갯수
		int totalRecord = repository.selectFindRecordCount(map); // 칼럼과 쿼리 갯수가 필요..?

		// 전달 된 페이지 번호
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		//페이징 처리 PageUtils 객체 생성 및 계산
		PageUtils pageUtils = new PageUtils();
		pageUtils.setPageEntity(totalRecord, page);
		
		// map + beginRecord + endRecord => HashMap map(column,query,beginRecord,endRecord)가 들어있다.
		map.put("beginRecord", pageUtils.getBeginRecord());
		map.put("endRecord", pageUtils.getEndRecord());
		
		//  검색된 목록 중 beginRecord ~endRecord 사이 가져오기
		List<Employee> list = repository.selectFindList(map);
		
		// View(employee/list.jsp로 보낼 데이터
		model.addAttribute("list", list);
		model.addAttribute("startNum", totalRecord - (page -1) * pageUtils.getRecordPerPage());
		
		// 검색 조건에 따라서  파라미터가 달라짐
		switch(request.getParameter("column")) {
		case "EMPLOYEE_ID": 
		case "FIRST_NAME": 
			model.addAttribute("paging" , pageUtils.getPageEntity("findEmployee?column=EMPLOYEE_ID"+ "&query=" + request.getParameter("query") )); // 목록을 출력하는 Mapping을 적어주기
			break;
		case "HIRE_DATE":
		case "SALARY":
			model.addAttribute("paging" , pageUtils.getPageEntity("findEmployee?column=HIRE_DATE&begin= "+ request.getParameter("begin") + "&end=" + request.getParameter("end")));
			break;
		
		}
	} // end of findEmployee
	
	@Override
	public void autoComplete(Map<String, Object> map, HttpServletResponse response) { 
		
		EmployeeRepository repository = sqlSession.getMapper(EmployeeRepository.class);
		List<Employee> list = repository.autoComplete(map);
		
		// ajax 결과로 반환할 HashMap을 만들고, response로 응답해 줌.
		Map<String, Object> result = new HashMap<String, Object>();
		if (list.size() == 0) {
			result.put("status", 500);
			result.put("list", null);
		} else {
			result.put("status", 200);
			result.put("list", list);
		}
		
		// response 응답
		response.setContentType("text/html; charset=UTF-8");  //사실은 map이지만 보내는 데이터는 JSON이다~~
		try {
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject(result);
			out.println(obj.toString());
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
