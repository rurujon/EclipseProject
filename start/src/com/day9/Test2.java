package com.day9;

class Rect{
	
	private int w,h;
	
	public void set(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public int area() {
		return w*h;
	}
	
	public int length() {
		
		return (w+h)/2;
	}
	
	public void print(int a, int l) {
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		System.out.println("넓이 : " + a);
		System.out.println("둘레 : " + l);
	}
	
	//메서드 오버로딩(Overloading, 재정의, 중복정의)
	//하나의 클래스 안에서 메소드의 이름을 동일하게 만드는 작업
	//단, 조건은 인수의 갯수가 다르거나 자료형이 달라야 한다.
	public void print() {
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
	}
	public void print(int a) {
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		System.out.println("넓이 : " + a);
	}
	public void lengthprint(int l) {
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		System.out.println("둘레 : " + l);
	}
}

public class Test2 {

	public static void main(String[] args) {
		
		Rect ob = new Rect();
		ob.set(10, 20);
		int a = ob.area();
		int l = ob.length();
		ob.print(a, l);
		ob.lengthprint(l);
		
		String str;

	}
	
	

}
