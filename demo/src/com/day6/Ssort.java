package com.day6;

import java.util.Scanner;

public class Ssort {
	
	int[] num = new int[5];
	int i,j, temp;
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("5개의 정수를 입력하세요");
		for(i=0; i<num.length; i++) {
			num[i]=sc.nextInt();
		}
	}
	
	public void array() {
		for(i=0; i<num.length; i++) {
			for(j=i+1; j<num.length; j++) {
				if(num[i]<num[j]) {
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		}
	}
	
	public void out() {
		System.out.printf("가장 큰 수 : %d, 가장 작은 수 : %d",num[0], num[4]);
	}

}
