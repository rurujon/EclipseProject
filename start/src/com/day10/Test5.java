package com.day10;

//최상위 클래스 : Object
//자바에 있는 모든 클래스, 인터페이스와 앞으로 만들어질 모든 클래스의 부모 클래스이다.

class Aa{
	
	public Aa() {
		super();
	}
	int a=10;
}

class Bb extends Aa{
	
	public Bb() {
		super();
	}
	int b=20;
	
}

class Cc extends Bb{
	
	public Cc() {
		super();
	}
	int c=30;
	
}



public class Test5 {

	public static void main(String[] args) {
		
		Cc ob = new Cc();
		System.out.println(ob.a + ":" + ob.b + ":" + ob.c);

	}

}
