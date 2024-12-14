package com.day3;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		String str;
		
		System.out.println("숫자를 입력하세요");
		num = sc.nextInt();
		
		if(num%2==0) {
			str = "짝수";
		}
		else {
			str = "홀수";
		}
		
		System.out.println(str + "입니다.");
		
		sc.close();

	}

}
