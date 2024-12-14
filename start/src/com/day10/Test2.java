package com.day10;

//상속(부모-자식)
//1. 부모꺼는 내꺼다.
//2. private로 선언한 것은 부모꺼
//3. protected로 선언한 것은 사용 가능하다.
//4. 내껀 내꺼다. 자식 것은 부모가 사용할 수 없다.
//5. 부모와 자식이 동일한 객체를 가지고 있으면 내꺼 쓴다.

//C언어는 다중상속이 가능
//C# 혹은 java는 단일상속만.

class TestA{
	
	private String title; //private 선언 : 부모꺼
	private int area;
	
	public void set(String title, int area) {
		this.area = area;
		this.title = title;
	}
	
	public void print() {
		System.out.println(title + ":" + area );
		
	}
}

class Rect extends TestA{
	private int w,h;
	
	public Rect(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public void rectArea() {
		int a = w*h;
		set("사각형", a); //1. 부모꺼는 내꺼다.
	}
}



public class Test2 {

	public static void main(String[] args) {
		
		Rect r = new Rect(10, 5);
		r.rectArea();
		r.print(); //1. 부모꺼는 내 거다.

	}

}
