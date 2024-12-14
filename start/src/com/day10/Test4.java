package com.day10;

class TestC{
	
	private String title;
	protected int area;
	public TestC(String title) {
		this.title =title;
	}
	public void print() {
		System.out.println(title + ":" + area);
	}
}

class RectC extends TestC{
	
	private int w,h;
	
	public RectC(int w, int h) {
		//부모의 생성자를 호출하는 명령어가 숨겨져 있다.
		//super() : 부모 생성자 호출
		super("사각형");
		this.w=w;
		this.h=h;
		
	}
	public void rectArea() {

		RectC r = new RectC(10,5);
		r.rectArea();
		r.print();
	}

}

public class Test4 {

	public static void main(String[] args) {
		
		

	}
	
	
}
