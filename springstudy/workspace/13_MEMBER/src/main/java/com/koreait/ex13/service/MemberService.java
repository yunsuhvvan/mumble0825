package com.koreait.ex13.service;

import com.koreait.ex13.domain.Member;

public interface MemberService {

	public Member selectMemberById(String id);
	public int joinMember(Member member);
	public Member login(Member member);
	public Member selectMemberByEmail(String email);
	public int updatePw(Member member);
	public int updateMember(Member member);
	public int leaveMember(Long no);
	
}
