package com.day7;

import java.util.Scanner;

public class Hap {
	
	int su, sum;
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수?");
		su = sc.nextInt();
		
		
	}
	
	public int cnt() {
		
		for(int i=1; i<=su; i++) {
			sum = sum+i; //sum+=i			
		}
		return sum;	
	}
	
	public void print(int total) {
		System.out.println("1~" + su + "까지의 합 : " + total);
	}

}
