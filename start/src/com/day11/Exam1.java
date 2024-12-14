package com.day11;

class Test{
	
	public void print(String r) {
		System.out.println(r);
	}
}

class Calc extends Test{
	String str;
	public void input() {
		
	}
	
	public String calc() {
		
		
		return "";
	}
	
	
}
public class Exam1 {

	public static void main(String[] args) {
		
		Calc ob = new Calc();
		
		ob.input();
		String r = ob.calc();
		ob.print(r);

	}

}
