package com.day10;

//���(�θ�-�ڽ�)
//1. �θ𲨴� ������.
//2. private�� ������ ���� �θ�
//3. protected�� ������ ���� ��� �����ϴ�.
//4. ���� ������. �ڽ� ���� �θ� ����� �� ����.
//5. �θ�� �ڽ��� ������ ��ü�� ������ ������ ���� ����.

//C���� ���߻���� ����
//C# Ȥ�� java�� ���ϻ�Ӹ�.

class TestB{
	
	private String title; //private ���� : �θ�
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
		set("�簢��"); //1. �θ𲨴� ������.
	}
}



public class Test3 {	//���� ������ �ڸ��� ģ��ô. protected ��� ����.

	public static void main(String[] args) {
		
		RectB r = new RectB(10, 5);
		r.rectArea();
		//r.area=100;
		r.print(); //1. �θ𲨴� �� �Ŵ�.

	}

}
