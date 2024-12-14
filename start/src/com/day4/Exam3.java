package com.day4;

import java.util.Scanner;

public class Exam3 {

	public static void main(String[] args) {
		
		int num1, num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 개의 숫자를 입력하세요.");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int start = Math.min(num1, num2);
		int end = Math.max(num1, num2);
		
		int i,sum=0;
		
		for(i=start; i<=end; i++) {
			
			sum = sum + i;
		}
		
		System.out.printf("%d 에서 %d 까지의 숫자의 합은 %d 입니다.",num1, num2, sum);

	}

}
