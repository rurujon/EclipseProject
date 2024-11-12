package com.monday;

public class MakerListDTO {
	
	private String maker;
	private String addr;
	private String tel;
	private String mainProduct;
	private String maxProduct;
	
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMainProduct() {
		return mainProduct;
	}
	public void setMainProduct(String mainProduct) {
		this.mainProduct = mainProduct;
	}
	public String getMaxProduct() {
		return maxProduct;
	}
	public void setMaxProduct(String maxProduct) {
		this.maxProduct = maxProduct;
	}
	
	@Override
	public String toString() {
		
		String str;
		str=String.format("%10s %10s %10s %10s %10s", maker,addr,tel,mainProduct,maxProduct);
		
		return str;
		
	}
	
	

}
