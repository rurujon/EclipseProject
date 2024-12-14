package com.day10;

class TestD{
	
	private String title;//원-----------"null"
	protected double area;//314.0--------50
	
	public TestD() {}
	
	public TestD(String title) {
		this.title = title;
	}
	
	public void write() {
		System.out.println(title + ":" + area);
	}
	
}

class Circle extends TestD{
	
	private int r;//10
	protected static final double PI=3.14;
	
	public Circle(int r) {
		super("원");
		this.r = r;
	}
	
	public void circleArea() {
		area = (double)r*r*PI;
	}
	
}

class RectD extends TestD{
	
	private int w,h;
	
	public void rectArea(int w,int h) {//10,5
		this.w = w;
		this.h = h;
		
		area = w*h;
	}
	
	//메서드 오버라이드(override)
	//상속관계에서 부모가 가진 메소드와 비슷한 역할을 하는 메소드의 통일성을 위해 사용한다.
	//상속관계에서만 가능.
	@Override // 어노테이션(annotation) 
	public void write() {//5. 부모와 자식이 동일한 객체를 가지고 있다면 무조건 자신 것을 쓴다.
		System.out.println("가로 : " + w + ", 세로 : "+h);
		System.out.println("넓이 : " + area);
	}
	
}



public class Test7 {

	public static void main(String[] args) {
		
		Circle ob1 = new Circle(10);
		
		ob1.circleArea();
		ob1.write();
		
		RectD ob2 = new RectD();
	
		ob2.rectArea(10, 5);
		ob2.write();

	}

}
