package com.day10;

//���(�θ�-�ڽ�)
//1. �θ𲨴� ������.
//2. private�� ������ ���� �θ�
//3. protected�� ������ ���� ��� �����ϴ�.
//4. ���� ������. �ڽ� ���� �θ� ����� �� ����.
//5. �θ�� �ڽ��� ������ ��ü�� ������ ������ ���� ����.

//C���� ���߻���� ����
//C# Ȥ�� java�� ���ϻ�Ӹ�.

class TestA{
	
	private String title; //private ���� : �θ�
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
		set("�簢��", a); //1. �θ𲨴� ������.
	}
}



public class Test2 {

	public static void main(String[] args) {
		
		Rect r = new Rect(10, 5);
		r.rectArea();
		r.print(); //1. �θ𲨴� �� �Ŵ�.

	}

}
