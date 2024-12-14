package com.day7;

import java.util.Scanner;

public class D1t1 {
	
	int a;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수?");
		a=sc.nextInt();
	}
	
	public String det() {
		
		String b;
		if(a%2 == 1) {
			b="홀수";
		}
		else {
			b="짝수";
		}
		return b;
	}
	
	public void output(String b) {
		System.out.printf("%d는 %s입니다.",a,b);
	}
}
