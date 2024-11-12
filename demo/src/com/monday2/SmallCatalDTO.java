package com.monday2;

public class SmallCatalDTO {
	
	private String bigCatal;
	
	private String smallCatal;
	

	public String getBigCatal() {
		return bigCatal;
	}

	public String getSmallCatal() {
		return smallCatal;
	}
	
	

	public void setBigCatal(String bigCatal) {
		this.bigCatal = bigCatal;
	}

	public void setSmallCatal(String smallCatal) {
		this.smallCatal = smallCatal;
	}
	
	@Override
	public String toString() {

		String str;
		str = String.format("%8s %8s",bigCatal, smallCatal);
		
		return str;
	}

	

}
