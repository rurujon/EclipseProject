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
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
		System.out.println("���� : " + a);
		System.out.println("�ѷ� : " + l);
	}
	
	//�޼��� �����ε�(Overloading, ������, �ߺ�����)
	//�ϳ��� Ŭ���� �ȿ��� �޼ҵ��� �̸��� �����ϰ� ����� �۾�
	//��, ������ �μ��� ������ �ٸ��ų� �ڷ����� �޶�� �Ѵ�.
	public void print() {
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
	}
	public void print(int a) {
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
		System.out.println("���� : " + a);
	}
	public void lengthprint(int l) {
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
		System.out.println("�ѷ� : " + l);
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
