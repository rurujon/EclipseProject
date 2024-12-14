package com.day5;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Selection sort
		
		int[] num = new int[5];
		System.out.println("5개의 정수를 입력하세요.");
		for(int i=0; i<num.length; i++) {
			num[i] = sc.nextInt();
		}
		
		int i,j,temp;
		
		System.out.print("Source Data : ");
		
		for(i=0; i<num.length; i++) {
			System.out.printf("%4d",num[i]);
		}
		System.out.println();
		
		//Selection Sort
		for(i=0;i<num.length-1; i++) {
			for(j=i+1;j<num.length; j++) {
				//System.out.println(i + ":" + j);
				if(num[i]>num[j]) {
					temp =num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		}
		
		
		System.out.print("Sorted Data : ");
		
		for(int su:num) {  //배열에서의 for 문 : 배열에서의 순서대로 하나씩 뽑아온다.
			System.out.printf("%4d",su);
		}
		System.out.println();
		sc.close();

	}

}
