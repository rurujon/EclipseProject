package com.day9;

public class Test5 {
	
	int a = 5;
	
	{// �ʱ�ȭ ��
		
		System.out.println("�ʱ�ȭ �� a : " + a);
		a=10;
		System.out.println("�ʱ�ȭ �� a : " + a);
	}
	
	static int b;
	
	static {
		//����ƽ ��
		System.out.println("static ��");
		b=20;
	}
	
	final int C;
	
	public Test5() {
		System.out.println("�⺻ ������");
		C=100;
		System.out.println("C: " + C);
	}
	
	public static void main(String[] args) {
		
		Test5 ob = new Test5();
		Test5 ob1 = new Test5();

	}

}
