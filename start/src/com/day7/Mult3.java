package com.day7;

import java.util.Scanner;

public class Mult3 {
	
	int a,b;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자?");
		a= sc.nextInt();
	}
	
	public int calc() {
		int i,j=0;
		for(i=1; i<=a; i++) {
			
			if(i%3==0) {
				j++;
			}
		}
		return j;
	}
	
	public void output(int k) {
		
		System.out.printf("1~%d까지의 숫자 중 3의 배수는 %d",a,k);
	}

}
