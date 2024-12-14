package com.day12;

//final
//클래스에 final을 붙이면 상속이 불가능하다.
//메소드에 final을 붙이면 override(오버라이드)가 불가능하다.
//변수에 final을 붙이면 단 한 번만 초기화가 가능한 상수가 된다.

class TestA{
	
public static final double PI;//final로 만들어진 상수는 대문자로 쓴다.
	
	static {
		PI=3.14;
	}
	
	public double area;
	
	public final void write(String title) {
		System.out.println(title + ":" + area);
	}
	
	
}

public class Test7 extends TestA{
	
	//public void write(String title) {
		
	//}
	
	public void circleArea(int r) {
		area = (double)r*r*PI;
	}
	
	public static void main(String[] args) {

	}

}
