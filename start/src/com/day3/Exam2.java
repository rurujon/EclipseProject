package com.day3;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1, num2, temp;
		
		System.out.println("두 개의 숫자를 입력하세요.");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		if (num1 < num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		System.out.printf("큰 수는 %d, 작은 수는 %d 입니다.", num1, num2);
		
		sc.close();

	}

}
