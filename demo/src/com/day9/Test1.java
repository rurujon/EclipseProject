package com.day9;

import java.util.Calendar;

//static
//프로그램이 로딩될 때 스스로 메모리상에 올라가 있다.
//객체가 1000개 생성이 되도 메모리는 한 개만 사용된다.

public class Test1 {
	
	public static int a = 10;
	//클래스 변수(스태틱 변수), 클래스 메소드는 클래스가 로딩되는 순간
	//메모리 할당이 이루어지며 [클래스이름.객체이름]으로 접근할 수 있다/
	//ex : Test1.a
	//즉 new를 통해서 메모리할당을 받지 않아도 사용이 가능하다.
	
	private int b=20;
	/// instance 변수는  new를 통해서 객체를 생성하고 객체를 통해서 접근이 가능하다.
	//동일한 클래스 메소드에서는 접근이 바로 가능하지만
	//클래식 메서드에서는 접근이 불가능하다
	
	public Test1() {}
	
	public void write() {	//instance 메서드
		
		System.out.println("class 변수 a : " + a);
		System.out.println("instance 변수 b : " + b);
		
	}
	
	public static void print() {	//클래스 메소드
		System.out.println("class 변수 : a " + a);
		//System.out.println("instance 변수 : " + b);
	}

	public static void main(String[] args) {
		
		System.out.println("class 변수 a : " + a);
		System.out.println("class 변수 a : " + Test1.a);
		//System.out.println("instance 변수 : " + b);
		
		//write();
		print();
		Test1.print();
		
		Test1 ob = new Test1();
		System.out.println(ob.b);//20
		System.out.println(Test1.a);//10
		
		ob.write();
		Test1.print();
		
		
		System.out.println("-------------");
		Test1 ob1 = new Test1();
		ob1.a = 100;
		ob1.b = 200;
		
		ob1.write();
		
		System.out.println("-------------");
		Test1 ob2 = new Test1();
		ob2.a = 1000;
		ob2.b = 2000;
		
		ob2.write();
		
		System.out.println("-------------");
		ob1.write();
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		Calendar c3 = Calendar.getInstance();
		Calendar c4 = Calendar.getInstance();
		

	}
	//4층의 건물, 1층과 4층
	// 1층은 a,b,print(),main()

}
