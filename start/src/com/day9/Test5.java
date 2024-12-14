package com.day9;

public class Test5 {
	
	int a = 5;
	
	{// 초기화 블럭
		
		System.out.println("초기화 블럭 a : " + a);
		a=10;
		System.out.println("초기화 블럭 a : " + a);
	}
	
	static int b;
	
	static {
		//스태틱 블럭
		System.out.println("static 블럭");
		b=20;
	}
	
	final int C;
	
	public Test5() {
		System.out.println("기본 생성자");
		C=100;
		System.out.println("C: " + C);
	}
	
	public static void main(String[] args) {
		
		Test5 ob = new Test5();
		Test5 ob1 = new Test5();

	}

}
