package com.koreait.ex04.domain;

public class Product {

	private String modelName;
	private int price;
	
	public String getModelName() {
		return modelName;
	}
	public int getPrice() {
		return price;
	}
	
	// constructor
	private Product(Builder builder) {
		this.modelName = modelName;
		this.price = price;
	}
	// BUilder 내부 클래스
	public static class Builder{
		private String modelName;
		private int price;
		
		
		public Builder setModelName(String modelName) {
			this.modelName = modelName;
			return this;
		}
		public Builder setPrice(int price) {
			this.price = price;
			return this;
		}
		public Builder() {
			
		}
		public Product build() {
			
			return new Product(this);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
	
}
