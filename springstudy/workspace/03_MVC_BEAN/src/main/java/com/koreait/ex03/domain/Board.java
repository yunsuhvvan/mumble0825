package com.koreait.ex03.domain;

public class Board {

	private String title;
	private String content;
	
	
	public Board() {
		
	}
	public Board(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
