package com.day3;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		String str;
		
		System.out.println("���ڸ� �Է��ϼ���");
		num = sc.nextInt();
		
		if(num%2==0) {
			str = "¦��";
		}
		else {
			str = "Ȧ��";
		}
		
		System.out.println(str + "�Դϴ�.");
		
		sc.close();

	}

}
