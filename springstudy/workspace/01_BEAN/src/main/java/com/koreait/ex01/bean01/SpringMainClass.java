package com.koreait.ex01.bean01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {

		// GenericXmlApplicationContext 클래스
		// 1. spring bean configuration file이 만든 <bean>을 생성하는 스프링 클래스
		// 2. AbstractApplicationContext 클래스의 자식 클래스
		
		String resourceLocations = "classpath:app-context1.xml"; // classpath: 생략 가능, 파일명만 적을수 있음
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		// 스프링은 app-context1.xml에 만들어둔 <bean> 태그를 모두 bean으로 생성해서 가지고 있음.
		// getBean() 메소드를 이용해서 생성된 bean을 가져올 수 있음.
		
		EngineerCalculator e1 = ctx.getBean("eCalculator1", EngineerCalculator.class);
		e1.add();
		e1.sub();
		e1.multiply();
		e1.mod();
		e1.div();
		
		ctx.close();
		
	}
}
