package com.day10;

//Object Class
//�ڹٿ� �ִ� ��� Ŭ������ ������ ������� ��� Ŭ������ �θ�Ŭ����.

//�ڹٿ��� ���� ū �ڷ����̴�.

class SuperTest{
	
	private int a = 10;
	public void write() {
		System.out.println("a : " + a);
	}
}

public class Test6 {

	public static void main(String[] args) {
				
		SuperTest ob1 = new SuperTest();
		SuperTest ob2 = new SuperTest();
		
		
		System.out.println("ob1==ob2: " + (ob1==ob2));
		System.out.println("ob1.equals(ob2): " + ob1.equals(ob2));
		
		System.out.println("ob1 : " + ob1);//com.day10.SuperTest@15db9742 : @~ �ؽ��±�
		System.out.println("ob1 : " + ob1.toString());
		System.out.println("ob2 : " + ob2.toString());
	}

}
