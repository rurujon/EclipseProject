package com.day4;

public class Exam2 {

	public static void main(String[] args) {
		
		int i,j=0;
		
		for(i=1; i<=100; i++) {
			
			if(i%3==0) {
				j++;
			}
		}
		
		System.out.printf("1~100까지의 숫자 중 3의 배수는 %d",j);
		
		

	}

}
