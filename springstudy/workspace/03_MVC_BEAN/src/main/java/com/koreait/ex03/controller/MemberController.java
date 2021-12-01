package com.koreait.ex03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.ex03.config.MemberConfig;
import com.koreait.ex03.domain.Member;

@Controller
public class MemberController {
	
	/*** Spring4부터 @Getmapping, @PostMapping 지원***/
	
	// 공통적으로 사용하기 위해서 ctx위치를 iv로 잡음
	AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(MemberConfig.class);
	
	//@RequestMapping(value = "/" , method = RequestMethod.GET)
	@GetMapping("/")    // 속성이 하나 일땐 속성을 적지 않고 값만 적어주면 된다.
	
	public String welcome(HttpServletRequest request) {
		
		// member1을 만들어서 index.jsp로 보내기
		
		Member member1 = ctx.getBean("member1", Member.class);
		
		request.setAttribute("member1", member1);
		
		return "index";     //기본이동은 forward이므로 request가 전달된다.
	}
	
	//@RequestMapping(value = "memberView.do" , method = RequestMethod.GET)
	@GetMapping("memberView.do")
	
	public String detailPage(Model model) {
		
		// Model 
		// 안녕 난 request를 사용하는 클래스야. 보안이 더 좋아~!  (model을 쓰면 request에 저장이 된다.)
		// addAttribute()를 사용하면 실제로는 request.setAttribute() 처럼 동작해~
		// member2을 만들어서 memberDetail.jsp로 보내기
		
		Member member2 = ctx.getBean("member2", Member.class);
		
		model.addAttribute("member2", member2);
		
		return "member/memberDetail";
	}
	
}
