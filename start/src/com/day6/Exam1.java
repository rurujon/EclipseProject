package com.day6;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int[] num = new int[5];
		int i,j, temp;
		
		System.out.println("5개의 정수를 입력하세요");
		for(i=0; i<num.length; i++) {
			num[i]=sc.nextInt();
		}
		
		//Selection sort
		for(i=0; i<num.length; i++) {
			for(j=i+1; j<num.length; j++) {
				if(num[i]<num[j]) {
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		}
		
		System.out.printf("가장 큰 수 : %d, 가장 작은 수 : %d",num[0], num[4]);
		sc.close();

	}

}
