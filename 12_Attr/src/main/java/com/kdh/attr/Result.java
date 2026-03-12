package com.kdh.attr;

// Java Bean
// VO, DTO, POJO
public class Result {
// 필드, 속성, 멤버변수, 인스턴스변수
	// 결과에서 뭘 쓸지?
	private int price;
	private int money;
	private int Ex;
	private String say;
	
	
	
	
	
	

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getEx() {
		return Ex;
	}
	public void setEx(int Ex) {
		this.Ex = Ex;
	}
	public String getSay() {
		return say;
	}
	public void setSay(String say) {
		this.say = say;
	}
	
	public Result(int price, int money, int Ex, String say) {
		super();
		this.price = price;
		this.money = money;
		this.Ex = Ex;
		this.say = say;
	}
	
	
	
	
	
}
