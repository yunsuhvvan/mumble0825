package com.koreait.ex01.quiz01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("quiz01.xml");

		
		Student student = ctx.getBean("student" , Student.class);
		System.out.println("name : " + student.getName());
		System.out.println("age : " + student.getAge());
		System.out.println("scores : " +student.getExam().getScores().toString());
		System.out.println("average : " +student.getExam().getAverage());
		System.out.println("grade : " +student.getExam().getGrade());
		student.stInfo();
		
		ctx.close();
		
	}

}
