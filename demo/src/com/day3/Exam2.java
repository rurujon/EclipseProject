package com.day3;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1, num2, temp;
		
		System.out.println("�� ���� ���ڸ� �Է��ϼ���.");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		if (num1 < num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		System.out.printf("ū ���� %d, ���� ���� %d �Դϴ�.", num1, num2);
		
		sc.close();

	}

}
