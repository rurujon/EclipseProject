package com.day10;

//상속(부모-자식)
//1. 부모꺼는 내꺼다.
//2. private로 선언한 것은 부모꺼
//3. protected로 선언한 것은 사용 가능하다.
//4. 내껀 내꺼다. 자식 것은 부모가 사용할 수 없다.
//5. 부모와 자식이 동일한 객체를 가지고 있으면 내꺼 쓴다.

//C언어는 다중상속이 가능
//C# 혹은 java는 단일상속만.

class TestB{
	
	private String title; //private 선언 : 부모꺼
	protected int area;
	
	public void set(String title) {
		this.title = title;
	}
	
	public void print() {
		System.out.println(title + ":" + area );
		
	}
}

class RectB extends TestB{
	private int w,h;
	
	public RectB(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public void rectArea() {
		area = w*h;
		set("사각형"); //1. 부모꺼는 내꺼다.
	}
}



public class Test3 {	//같은 공간에 자리한 친인척. protected 사용 가능.

	public static void main(String[] args) {
		
		RectB r = new RectB(10, 5);
		r.rectArea();
		//r.area=100;
		r.print(); //1. 부모꺼는 내 거다.

	}

}
