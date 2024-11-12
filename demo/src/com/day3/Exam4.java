package com.day3;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int year;
		String str;
		
		System.out.println("연도를 입력하세요.");
		year = sc.nextInt();
		
		str = year%4==0 && year%100!=0 || year%400==0 ? "윤년" : "평년";
		System.out.println(str);
		
		sc.close();

	}

}
