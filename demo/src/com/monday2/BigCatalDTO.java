package com.monday2;

public class BigCatalDTO {
	
	private String bigCatal;

	public String getBigCatal() {
		return bigCatal;
	}

	public void setBigCatal(String bigCatal) {
		this.bigCatal = bigCatal;
	}
	
	@Override
	public String toString() {
		
		String str;
		str = String.format("%8s",bigCatal);
		
		return str;
		
		
	}

}
