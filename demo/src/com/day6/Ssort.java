package com.day6;

import java.util.Scanner;

public class Ssort {
	
	int[] num = new int[5];
	int i,j, temp;
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("5���� ������ �Է��ϼ���");
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
		System.out.printf("���� ū �� : %d, ���� ���� �� : %d",num[0], num[4]);
	}

}
