package com.koreait.ex01.bean02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {

		// GenericXmlApplicationContext 클래스
		// 1. spring bean configuration file이 만든 <bean>을 생성하는 스프링 클래스
		// 2. AbstractApplicationContext 클래스의 자식 클래스
		
		String resourceLocations = "classpath:app-context2.xml"; // classpath: 생략 가능, 파일명만 적을수 있음
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		
		
		for(int i = 0; i< 3; i++) {
			
		}
		Car car1 =  ctx.getBean("car1" , Car.class);
		
		System.out.println("엔집타입 : " + car1.getEngine().getType());
		System.out.println("배기량  : "+ car1.getEngine().getCc());
		System.out.println("마력 : "+ car1.getEngine().getHp());
		System.out.println("연비 : " + car1.getEngine().getEfficiency() );
		System.out.println("모델명 : "+ car1.getModel());
		System.out.println("***********************");
		Car car2 =  ctx.getBean("car2" , Car.class);
		
		System.out.println("엔집타입 : " + car2.getEngine().getType());
		System.out.println("배기량  : "+ car2.getEngine().getCc());
		System.out.println("마력 : "+ car2.getEngine().getHp());
		System.out.println("연비 : " + car2.getEngine().getEfficiency() );
		System.out.println("모델명 : "+ car2.getModel());
		System.out.println("***********************");
		
		Car car3 =  ctx.getBean("car3" , Car.class);
		
		System.out.println("엔집타입 : " + car3.getEngine().getType());
		System.out.println("배기량  : "+ car3.getEngine().getCc());
		System.out.println("마력 : "+ car3.getEngine().getHp());
		System.out.println("연비 : " + car3.getEngine().getEfficiency() );
		System.out.println("모델명 : "+ car3.getModel());
		System.out.println("***********************");
		
		ctx.close();
		
		
		
		
		
		
		
	}
}
