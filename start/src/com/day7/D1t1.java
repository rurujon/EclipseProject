package com.day7;

import java.util.Scanner;

public class D1t1 {
	
	int a;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("����?");
		a=sc.nextInt();
	}
	
	public String det() {
		
		String b;
		if(a%2 == 1) {
			b="Ȧ��";
		}
		else {
			b="¦��";
		}
		return b;
	}
	
	public void output(String b) {
		System.out.printf("%d�� %s�Դϴ�.",a,b);
	}
}
