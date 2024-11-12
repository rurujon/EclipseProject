package com.day12;

//final
//Ŭ������ final�� ���̸� ����� �Ұ����ϴ�.
//�޼ҵ忡 final�� ���̸� override(�������̵�)�� �Ұ����ϴ�.
//������ final�� ���̸� �� �� ���� �ʱ�ȭ�� ������ ����� �ȴ�.

class TestA{
	
	public static final double PI;//final�� ������� ����� �빮�ڷ� ����.
	
	static {
		PI=3.14;
	}
	
	public double area;
	
	//�޼ҵ忡 final�� ���̸� override �Ұ���
	public final void write(String title) {
		System.out.println(title + ":" + area);
		//Pi=23.6;
	}
	
	
}

public class Test7 extends TestA{
	
	//public void write(String title) {
		
	//}
	
	public void circleArea(int r) {
		area = (double)r*r*PI;
	}
	
	public static void main(String[] args) {
		
		TestA ob = new TestA();
		ob.write(null);

	}

}
