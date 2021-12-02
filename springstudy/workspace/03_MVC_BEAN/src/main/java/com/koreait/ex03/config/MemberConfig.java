package com.koreait.ex03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex03.domain.Member;

@Configuration
public class MemberConfig {

	// 같은 반환타입의 Bean이 2개 이상일 땐,  @Autowired가 불가능
	// 구분을 id(메서드이름)으로 해야한다.
	// ctx.getbean()
	
	// 반환타입이 여러개인 경우는 흔치 않은 경우이다.
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
