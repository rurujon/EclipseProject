package com.day9;

import java.util.Calendar;

//static
//���α׷��� �ε��� �� ������ �޸𸮻� �ö� �ִ�.
//��ü�� 1000�� ������ �ǵ� �޸𸮴� �� ���� ���ȴ�.

public class Test1 {
	
	public static int a = 10;
	//Ŭ���� ����(����ƽ ����), Ŭ���� �޼ҵ�� Ŭ������ �ε��Ǵ� ����
	//�޸� �Ҵ��� �̷������ [Ŭ�����̸�.��ü�̸�]���� ������ �� �ִ�/
	//ex : Test1.a
	//�� new�� ���ؼ� �޸��Ҵ��� ���� �ʾƵ� ����� �����ϴ�.
	
	private int b=20;
	/// instance ������  new�� ���ؼ� ��ü�� �����ϰ� ��ü�� ���ؼ� ������ �����ϴ�.
	//������ Ŭ���� �޼ҵ忡���� ������ �ٷ� ����������
	//Ŭ���� �޼��忡���� ������ �Ұ����ϴ�
	
	public Test1() {}
	
	public void write() {	//instance �޼���
		
		System.out.println("class ���� a : " + a);
		System.out.println("instance ���� b : " + b);
		
	}
	
	public static void print() {	//Ŭ���� �޼ҵ�
		System.out.println("class ���� : a " + a);
		//System.out.println("instance ���� : " + b);
	}

	public static void main(String[] args) {
		
		System.out.println("class ���� a : " + a);
		System.out.println("class ���� a : " + Test1.a);
		//System.out.println("instance ���� : " + b);
		
		//write();
		print();
		Test1.print();
		
		Test1 ob = new Test1();
		System.out.println(ob.b);//20
		System.out.println(Test1.a);//10
		
		ob.write();
		Test1.print();
		
		
		System.out.println("-------------");
		Test1 ob1 = new Test1();
		ob1.a = 100;
		ob1.b = 200;
		
		ob1.write();
		
		System.out.println("-------------");
		Test1 ob2 = new Test1();
		ob2.a = 1000;
		ob2.b = 2000;
		
		ob2.write();
		
		System.out.println("-------------");
		ob1.write();
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		Calendar c3 = Calendar.getInstance();
		Calendar c4 = Calendar.getInstance();
		

	}
	//4���� �ǹ�, 1���� 4��
	// 1���� a,b,print(),main()

}
