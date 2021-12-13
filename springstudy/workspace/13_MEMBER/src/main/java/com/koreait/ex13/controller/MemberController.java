package com.koreait.ex13.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.ex13.domain.Member;
import com.koreait.ex13.service.MemberService;

@Controller
@RequestMapping("member/*")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	@GetMapping(value = "loginPage")
	public String loginPage() {
		return "member/login";
	}
	
	
	@GetMapping(value = "joinPage")
	public String joinPage() {
		return "member/join";
	}
	
	// 자바측에서는 맵 데이터를 jackson이 출동해서 제이슨 데이터로 변환
	@PostMapping(value = "idCheck" , produces="application/json; charset=utf-8") //내가 json을 답으로 할거예요~~	
	@ResponseBody																// json을 응답할거예요~~
	public Map<String, Object> idCheck(@RequestParam("id") String id) {
		
		//jackson이 사용할 수 있는 객체나 map으로 만들어줘야한다.	
		return service.idCheck(id);
	}
	
	@PostMapping(value = {"EmailCheck", "findId"} , produces = "application/json; charset=utf-8")  // 재활용하는거 잘 생각해보기..!!
	@ResponseBody
	public Map<String, Object> findMemberByEmail(@RequestParam("email") String email){
		return service.findMemberByEmail(email);
	}
	
	@PostMapping(value = "sendAuthCode", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> sendAuthCode(@RequestParam("email") String email){
		return service.sendAuthCode(email);
	}
	
	@PostMapping(value = "join")
	public String join(Member member) {
		service.join(member);
		return "redirect:/";  // index.jsp로 리다이렉트
	}
	
	
	@PostMapping(value = "login")
	public String login(HttpServletRequest request) {  //(Member member ,HttpSession session)
		service.login(request);
		return "redirect:/";
	}
	
	@GetMapping(value = "logout")
	public String logout(HttpSession session) {// 로그아웃 할 때 세션이 필요하다
		if(session.getAttribute("loginUser")!= null ) {
			session.invalidate();
		}
		return "redirect:/";
	}

	@GetMapping(value = "findIdPage")
	public String findIdPage() {
		return "member/findId";
	}
	@GetMapping(value = "findPwPage")
	public String findPwPage() {
		return "member/findPw";
	}
	
	@GetMapping(value = "updatePwPage")
	public String updatePwPage(@ModelAttribute("email") String email) {  // email이란 이름으로 model에 실어라 
		return "member/updatePw";
	}
	
	@PostMapping(value = "updatePw")
	public String updatePw(Member member) {
		service.updatePw(member);
		return "redirect:loginPage";
	}
	
	@GetMapping(value = "myPage")
	public String myPage() {
		return "member/myPage";
	}
	
	@PostMapping(value = "updateMember")
	public String updateMember(Member member , HttpSession session) {
		service.updateMember(member , session);
		return "redirect:/";
	}
	
	@PostMapping(value = "deleteMember")
	public String deleteMember(@RequestParam("no")Long no) {
		service.leaveMember(no);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
