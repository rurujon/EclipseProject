package com.day5;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Selection sort
		
		int[] num = new int[5];
		System.out.println("5���� ������ �Է��ϼ���.");
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
		
		for(int su:num) {  //�迭������ for �� : �迭������ ������� �ϳ��� �̾ƿ´�.
			System.out.printf("%4d",su);
		}
		System.out.println();
		sc.close();

	}

}
