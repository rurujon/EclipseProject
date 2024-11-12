package com.monday2;

public class BuyDTO {
	
	private String userid;
	private String productname;
	private int price;
	private String maker;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	
	@Override
	public String toString() {
		String str;
		str=String.format("%-10s %-10s %-10d %-10s", userid, productname, price, maker);
		
		return str;
		
	}

}
