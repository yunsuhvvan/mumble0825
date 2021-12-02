package com.koreait.ex04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.ex04.domain.Member;
import com.koreait.ex04.domain.MemberBuilder;

@Controller
public class MemberController {

	//welcome page 작업
	@GetMapping({"/" , "index.do"}  )
	public String a() {
		return "index";
	}
	
	@GetMapping("member/v1.do")         // <a> ,location.href 전부 다 Get방식이다..!
//	@GetMapping("/member/v1.do")	    // 슬래쉬(/) 로 시작해도 된다.
	public String b() {
		return "member/memberDetail";
	  //return "/member/memberDetail";  // 슬래쉬(/) 로 시작해도 된다.
	}
	
	//<a href="member/v2.do?idx=1&id=user&name=james">회원</a>
	@GetMapping("member/v2.do")
	public String c(HttpServletRequest request) {// 파라미터 처리를 매개변수가 해야한다.
		
		Long idx= Long.parseLong(request.getParameter("idx"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		// Member 생성 - 1
		Member member1 = new Member();
		member1.setId(id);
		member1.setIdx(idx);
		member1.setName(name);
		
		// Member 생성  -2
		Member member2 = new Member(idx, id, name);
		
		// Member 생성 -3 (Builder Pattern 이용하기)    // Member 생성 2의 대체자로 나온것이다.(필요한 것만 넣을수있고, 순서도 상관없음.)
		Member member3 = new MemberBuilder()
				.setIdx(idx)
				.setId(id)
				.setName(name)
				.build();
		// request를 이용해서 Member 넘기기
		request.setAttribute("member", member3);	
		return "member/memberDetail";
	}
	
	//<a href="member/v2.do?idx=1&id=user&name=james">회원</a>
	@GetMapping("member/v3.do")
	public String d(@RequestParam(value="idx") Long idx,
					@RequestParam(value="id") String id,					 // (@RequestParam(value="파라미터명") 저장할변수)
					@RequestParam(value="name") String name, Model model) {  // 파라미터의 값을 Long idx,String id, String name에 저장해라.
			// Model은 JSP에 값을 넘기는 역할이다.
		model.addAttribute("member", new Member(idx, id, name));
		return "member/memberDetail";
	}
	
	
	@GetMapping("member/v4.do")
	public String e (@RequestParam(value = "idx", required=false ,defaultValue = "999") Long idx, 
				 	 @RequestParam(value = "id", required=false, defaultValue = "chul") String id,
				 	 @RequestParam(value = "name", required=false, defaultValue = "철이") String name, Model model) {
		model.addAttribute(new Member(idx, id, name));
		return "member/memberDetail";
	}
	
	
	//<a href="member/v2.do?idx=1&id=user&name=james">회원</a>
	@GetMapping("member/v5.do")
	public String f(Member member, Model model) { //Member 클래스의 setter가 파라미터를 모두 받아준다.
		model.addAttribute("member", member);
		return "member/memberDetail";
	}
	
	@GetMapping("member/v6.do")
	public String g(@ModelAttribute(value = "member") Member member) {  //Model에 "member"란 이름으로 실어준다. Member 클래스의 setter가 파라미터를 모두 받아준다.
		return "member/memberDetail";
	}
}
