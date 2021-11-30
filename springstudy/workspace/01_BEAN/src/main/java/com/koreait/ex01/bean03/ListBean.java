
package com.koreait.ex01.bean03;

public class ListBean {

	//field
	
	private java.util.List<String> list;

	

	
	//constructor
	// 디폴트 생성자 사용
	
	//getter/setter
	public java.util.List<String> getList() {
		return list;
	}
	public void setList(java.util.List<String> list) {
		this.list = list;
	}
	public void listInfo() {
		for(int i=0, length = list.size(); i< length; i++) {
			System.out.println((i + 1 ) + "번째 요소 :" +list.get(i));
		}
	}
	
	
}
