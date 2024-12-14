package com.day12;

//추상 클래스
//메모리의 낭비 없이 클래스를 미리 설계
//메소드를 재정의(Override)해서 사용한다.

//자바는 인터페이스를 더 많이 쓴다.
//자바는 인터페이스의 언어다.


abstract class ShapeClass{ //abstract : 추상클래스의 시작.
	
	abstract void draw(); //추상클래스에는 반드시 하나 이상의 추상메소드가 있어야한다.
	
	
}

class Circ extends ShapeClass{

	@Override
	public void draw() {
		System.out.println("원을 그린다....");
	}
	
	
}

class Rect extends ShapeClass{

	@Override
	public void draw() {
		
		System.out.println("사각형을 그린다...");
	}
	
	
}

class Tri extends ShapeClass{
	@Override
	public void draw() {
		
		System.out.println("삼각형을 그린다...");
	}
	
}


public class Test8 {

	public static void main(String[] args) {
		
		Circ c = new Circ(); //상속을 받은 이상 반드시 사용해야 한다.
		Rect r = new Rect();
		Tri t = new Tri();
		
		c.draw();
		r.draw();
		t.draw();
		

	}

}
