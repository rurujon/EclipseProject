package com.day10;

//�ֻ��� Ŭ���� : Object
//�ڹٿ� �ִ� ��� Ŭ����, �������̽��� ������ ������� ��� Ŭ������ �θ� Ŭ�����̴�.

class Aa{
	
	public Aa() {
		super();
	}
	int a=10;
}

class Bb extends Aa{
	
	public Bb() {
		super();
	}
	int b=20;
	
}

class Cc extends Bb{
	
	public Cc() {
		super();
	}
	int c=30;
	
}



public class Test5 {

	public static void main(String[] args) {
		
		Cc ob = new Cc();
		System.out.println(ob.a + ":" + ob.b + ":" + ob.c);

	}

}
