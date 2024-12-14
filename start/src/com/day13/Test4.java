package com.day13;

//1. 내부 클래스(Inner 클래스)

class Outer1{
	
	static int a = 10;
	int b = 20;
	
	//Outer 클래스가 객체생성 안되면 Inner도 생성 안됨.
	//Outer 클래스가 생성되었다 해서 Inner가 생성된 것은 아님.
	public class Inner1{
		
		int c = 30;
		
		public void write() {//클래스 안의 클래스
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
		
	}
	
	public void print() {	//outer 클래스에서 실행.
		
		Inner1 ob = new Inner1();
		ob.write();
	}
}

public class Test4 {

	public static void main(String[] args) {
		
		Outer1 out = new Outer1();
		out.print();//1.outer 메서드 실행으로 생성.
		
		Outer1.Inner1 in = out.new Inner1();//2. 독자적으로 객체생성이 불가능하기에 outer 통해서 생성.

	}

}
