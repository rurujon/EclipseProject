package com.day7;

import java.util.ArrayList;
import java.util.Scanner;

public class D1t2 {
	
	int num1, num2;
	ArrayList<Integer> nu = new ArrayList<>();
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("정수?(종료시 0)");
		int in;
		while((in = sc.nextInt())!=0 ) {
			nu.add(in);
			System.out.println("정수?(종료시 0)");
		}
		
	}
	
	public int max() {
		int max = nu.get(0);
		for(int i=0; i<nu.size();i++) {
			if(max<nu.get(i)) {
				max=nu.get(i);
			}
		}
		return max;
	}
	
	public int min() {
		int min = nu.get(0);
		for(int i=0; i<nu.size();i++) {
			if(min>nu.get(i)) {
				min=nu.get(i);
			}
		}
		return min;
	}
	
	public void output(int a, int b) {
		System.out.println("가장 큰 값 : " + a + ", 가장 작은 값 : " + b);
	}

}
