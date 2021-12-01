package com.koreait.ex03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex03.domain.Member;

@Configuration
public class MemberConfig {

	@Bean
	public Member member1() { // member1이 Bean의 id 이름이다.
		Member member = new Member();
		member.setId("admin");
		member.setPw("1234");
		
		return member;
	}
	
	@Bean
	public Member member2() {  // member2이 Bean의 id 이름이다.
		return new Member("webmaster", "5678");
	}
	
}
