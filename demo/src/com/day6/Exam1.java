package com.day6;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int[] num = new int[5];
		int i,j, temp;
		
		System.out.println("5���� ������ �Է��ϼ���");
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
		
		System.out.printf("���� ū �� : %d, ���� ���� �� : %d",num[0], num[4]);
		sc.close();

	}

}
