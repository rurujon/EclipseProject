package com.day9;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.sql.Connection;
import java.util.Scanner;

//������
//�޸� �Ҵ��� ���� �� ���
//Ŭ������ �̸��� �����ϴ�
//���ϰ��� ���� ������ property�� ����.
//�ߺ����ǰ� �����ϴ�.
//������ �ȿ��� �����ڸ� ȣ�� �����ϴ�
//�� �� ���ο��� �� ���� ȣ�� �����ϴ�.


public class Test3 {

	private int x;
	
	public Test3() {
		
		this(40);//this�� �ڵ� �� ���ο��� ��������, �ߺ� �Ұ�.
		System.out.println("�⺻ ������");
		//x=10;
		System.out.println("x: " + x);
		
	}
	
	public void set(int x) {
		this.x = x;
	}
	
	public void print() {
		System.out.println("x: " + x);
	}
	
	public Test3(int x) {
		
		
		System.out.println("�����ε��� ������");
		this.x = x;
		//System.out.println("x : " + this.x);
		//System.out.println("x : " + x);
	}
	
	public static void main(String[] args) {
		
		Test3 ob1 = new Test3();
		ob1.set(10);
		ob1.print();
		

		Test3 ob2 = new Test3(20);
		ob2.print();

	}
	
	

}
