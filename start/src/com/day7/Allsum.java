package com.day7;

import java.util.Scanner;

public class Allsum {
	
	int num1, num2;
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("����?(ù��°)");
		num1 = sc.nextInt();
		System.out.println("����?(�ι�°)");
		num2 = sc.nextInt();
	}
	
	public int Calc() {
		
		int sum = 0;
		int start = Math.min(num1, num2);
		int end = Math.max(num1, num2);
		
		int i;
		for(i=start; i<=end; i++) {
			
			sum = sum + i;
		}
		
		return sum;	
	}
	
	public void output(int a) {
		System.out.printf("%d~%d ������ ��: %d",num1, num2, a);
	}

}
