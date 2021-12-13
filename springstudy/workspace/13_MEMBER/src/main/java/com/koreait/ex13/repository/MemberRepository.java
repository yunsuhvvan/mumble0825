package com.koreait.ex13.repository;

import org.springframework.stereotype.Repository;

import com.koreait.ex13.domain.Member;
@Repository
public interface MemberRepository {

	public Member selectMemberById(String id);
	public Member login(Member member);
	public Member selectMemberByEmail(String email);

	
	public int joinMember(Member member);
	public int updatePw(Member member);
	public int updateMember(Member member);
	public int leaveMember(Long no);
	
	
}
