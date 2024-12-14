package com.day13;

//1. ���� Ŭ����(Inner Ŭ����)

class Outer1{
	
	static int a = 10;
	int b = 20;
	
	//Outer Ŭ������ ��ü���� �ȵǸ� Inner�� ���� �ȵ�.
	//Outer Ŭ������ �����Ǿ��� �ؼ� Inner�� ������ ���� �ƴ�.
	public class Inner1{
		
		int c = 30;
		
		public void write() {//Ŭ���� ���� Ŭ����
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
		
	}
	
	public void print() {	//outer Ŭ�������� ����.
		
		Inner1 ob = new Inner1();
		ob.write();
	}
}

public class Test4 {

	public static void main(String[] args) {
		
		Outer1 out = new Outer1();
		out.print();//1.outer �޼��� �������� ����.
		
		Outer1.Inner1 in = out.new Inner1();//2. ���������� ��ü������ �Ұ����ϱ⿡ outer ���ؼ� ����.

	}

}
