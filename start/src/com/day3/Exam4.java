package com.day3;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int year;
		String str;
		
		System.out.println("������ �Է��ϼ���.");
		year = sc.nextInt();
		
		str = year%4==0 && year%100!=0 || year%400==0 ? "����" : "���";
		System.out.println(str);
		
		sc.close();

	}

}
