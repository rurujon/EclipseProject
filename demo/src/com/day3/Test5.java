package com.day3;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) throws Exception{
		
		//Scanner : �ܶ������� ������ ����� �����͸� �з�
		//�⺻ ������ ����
		
		Scanner sc = new Scanner(System.in);
		
		String name ;
		
		int kor, eng, mat;
		
		//System.out.print("�̸� ���� ���� ����"); //suzi 30 50 70
		
		System.out.print("�̸�,����,����,����");
		
		sc=new Scanner(sc.next()). useDelimiter("\\s*,\\s*");
		
		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		System.out.println(name + ":" + (kor+eng+mat) + "��");
		
		sc.close();

	}

}
