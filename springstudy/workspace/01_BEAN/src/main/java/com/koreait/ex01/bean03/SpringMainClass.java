package com.koreait.ex01.bean03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {

		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("app-context3.xml");
		
		ListBean listBean = ctx.getBean("listBean" , ListBean.class);
		listBean.listInfo();
		
		
		SetBean sb = ctx.getBean("setBean" , SetBean.class);
		sb.setInfo();
		
		
		MapBean mb = ctx.getBean("mapBean" , MapBean.class);
		mb.mapInfo();
		
		ctx.close();
		
		
	}

}
