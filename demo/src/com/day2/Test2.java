package com.day2;

public class Test2 {
	public static void main(String[] args) {
		
		//변수
		//자료형
		//= : 대입연산자
		int a = 10; //변수 초기화
		int b = 5;
		int c, d; //쓰레기값
		c=a+b;
		d=a-b;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		System.out.println(a + "+" + b + "=" + (c));
		System.out.println(a + "-" + b + "=" + (d));
		
		
		a=100;
		b=50;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		c= a+b;
		d= a-b;
		
		System.out.println(c);
		System.out.println(d);
		
		System.out.printf("%d + %d = %d %n",a,b,c);
		System.out.printf("%d - %d = %d \n",a,b,d);
		
	}

}
