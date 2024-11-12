package com.monday2;

public class ProductDTO {
	
	private String productNo;
	private String productName;
	private int price;
	private String maker;
	private int grade;
	private String bigCatal;
	private String smallCatal;
	
	private String searchCatal;
	
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getBigCatal() {
		return bigCatal;
	}
	public void setBigCatal(String bigCatal) {
		this.bigCatal = bigCatal;
	}
	public String getSmallCatal() {
		return smallCatal;
	}
	public void setSmallCatal(String smallCatal) {
		this.smallCatal = smallCatal;
	}
	
	@Override
	public String toString() {
		String str;
		str=String.format("%-10s %-40s %-10d %-30s %-10d %-30s %-30s", piecing(productNo,10), piecing(productName,40), price, piecing(maker,30), grade, piecing(bigCatal,30), piecing(smallCatal,30));
		
		return str;
	}
	public String getSearchCatal() {
		return searchCatal;
	}
	public void setSearchCatal(String searchCatal) {
		this.searchCatal = searchCatal;
	}
	
	private String piecing(String str, int length) {
		if (str == null) {
            return String.format("%-" + length + "s", "");
        }
        if (str.length() > length) {
            return str.substring(0, length);
        } else {
            return String.format("%-" + length + "s", str);
        }
    }

}
