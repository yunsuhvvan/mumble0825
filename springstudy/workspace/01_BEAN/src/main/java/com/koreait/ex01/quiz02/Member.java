package com.koreait.ex01.quiz02;

import java.util.Set;

public class Member {
	private String name;
	private double height;
	private double weight;
	private BMICalculator bmiCalculator;
	private Set<String> course;   // 과목	
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String name, double height, double weight, BMICalculator bmiCalculator, Set<String> course) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.bmiCalculator = bmiCalculator;
		this.course = course;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public BMICalculator getBmiCalculator() {
		return bmiCalculator;
	}
	public void setBmiCalculator(BMICalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}
	public Set<String> getCourse() {
		return course;
	}
	public void setCourse(Set<String> course) {
		this.course = course;
	}
	
	public void memberInfo() {
		System.out.println("name : " + name);
		System.out.println("height : " + height +"cm");
		System.out.println("weight : " + weight + "kg");
		bmiCalculator.bmiInfo(weight, height);
		System.out.println("course : " + course.toString()  );
	}
	
	
	
//	public void gogo () {
//	 double result = this.weight / ((this.height / 100 * this.height/ 100));
//		if(result >= 30) {
//			System.out.println( "bmi : "+result+"(고도비만)");
//			bmiCalculator.setObesity(result);
//			return;
//		} else if(25 <= result || result <= 30 ) {
//			System.out.println("bmi : "+result+"(비만)");
//			bmiCalculator.setOverBase(result);
//			return;
//		} else if(20 <= result || result <= 25) {
//			System.out.println("bmi : "+result+"(정상)");
//			bmiCalculator.setNormalBase(result);
//			return;
//		} else {
//			System.out.println("bmi : "+result+"(저체중)");
//		}
//	}
//	
//	public void getsetCourse() {
//		for(String set : course) {
//			if(set != null) {
//				System.out.println(set.toString());
//			}
//		}
//	}
//	
	
}
