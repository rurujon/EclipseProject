package com.day3;

import java.util.Scanner;

public class Exam6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int mat, kor, eng;
		
		System.out.println("�̸��� �Է����ּ���.");
		name = sc.next();
		
		System.out.println("����, ����. ���� ������ ���� �����ּ���.");
		mat = sc.nextInt();
		kor = sc.nextInt();
		eng = sc.nextInt();
		
		int sum, avr;
		sum = mat+kor+eng;
		avr = sum/3;
		
		String str;
		
		if (avr < 60) {
			str = "���հ�";
		}
		else if (mat<40 || kor<40 || eng<40) {
			str = "����";
		}
		else {
			str = "�հ�";
		}
		
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + sum + " ��� : " + avr + " ���� : " + str);
		sc.close();

	}

}
