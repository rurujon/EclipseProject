package com.day11;

//String�� class�̴�.(�ڷ����� �ƴϴ�.)
//���󵵴� ���� ����Ǵ� �������� ���� ũ�� ������
//�ڷ���ó�� ����ϴ� ���̴�.
//String�� �����ʹ� �Һ��� ��Ģ�� ������ �ִ�.
//String �����ʹ� equals�� ���Ѵ�.

public class Test1 {

	public static void main(String[] args) {
		
		String ob1 = "Seoul";
		String ob2 = "Seoul";
		String ob3 = new String("Seoul");
		
		System.out.println("ob1==ob2 : " + (ob1==ob2));//true : (Call By Reference) heap ������ �����Ͱ� �����ϱ⿡ �ּҰ� ����ȴ�
		System.out.println("ob1==ob3 : " + (ob1==ob3));//false : new�� ���簡 �Ǳ� ������ �ּ� ���� �ٸ���.
		System.out.println("ob1.equals(ob3): " + ob1.equals(ob3));//true : �ּҰ� �ƴ� �����͸� ��.
		
		ob2 = "korea";
		System.out.println("ob1==on2 : " + (ob1==ob2));//false : �ּҹ����� ���� ���������.
		System.out.println(ob2);
		System.out.println(ob1.equals(ob2));
		
		ob2 = "japan";
		System.out.println("ob1==on2 : " + (ob1==ob2));//false :
		System.out.println(ob2);
		System.out.println(ob1.equals(ob2));
		
		ob2 = "Seoul";
		System.out.println("ob1==on2 : " + (ob1==ob2));//true :
		System.out.println(ob2);
		System.out.println(ob1.equals(ob2));
		
		System.out.println(ob2);
		System.out.println(ob2.toString());
		System.out.println(ob3);

	}

}
