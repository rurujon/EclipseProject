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
		//�θ��� �����ڸ� ȣ���ϴ� ��ɾ ������ �ִ�.
		//super() : �θ� ������ ȣ��
		super("�簢��");
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
