package com.koreait.ex01.quiz02;

public class BMICalculator {

	//private double lowBase;		// 20 > lowBase;  [작성 안함]
	private double normalBase;  // 20 <= normal < 25
	private double overBase;    // 25 <= over < 30
	private double obesity;     // 30 <= obesity
	private Calculator calculator;
	
	public BMICalculator() {
		
	}
	
	
	
	public BMICalculator(double normalBase, double overBase, double obesity, Calculator calculator) {
		super();
		this.normalBase = normalBase;
		this.overBase = overBase;
		this.obesity = obesity;
		this.calculator = calculator;
	}

	
	public double getNormalBase() {
		return normalBase;
	}
	public void setNormalBase(double normalBase) {
		this.normalBase = normalBase;
	}
	public double getOverBase() {
		return overBase;
	}
	public void setOverBase(double overBase) {
		this.overBase = overBase;
	}
	public double getObesity() {
		return obesity;
	}
	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public void bmiInfo(double weight, double height) { // 몸무게kg 키 cm로 받아오기
		//체질량지수  = 몸무게kg / (키(m) * 키(m))
		height = calculator.div(height, 100);
		double bmi = calculator.div(weight, calculator.mul(height, height));
		String health = null;
		
		if(bmi >= obesity) {
			health = "비만";
		} else if(bmi >= overBase) {
			health ="과체중";
		} else if(bmi >=normalBase ) {
			health = "정상";
		} else {
			health = "저체중";
		}
		System.out.println("bmi : " + bmi + "("+health+")");
	}
	
}
