package com.koreait.ex01.quiz02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("quiz02.xml");
		
		Member member = ctx.getBean("member" , Member.class);
		member.memberInfo();
		
		
		
		
		ctx.close();
	}

}
