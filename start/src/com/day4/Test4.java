package com.day4;

public class Test4 {

	public static void main(String[] args) {
		
		int su, sum = 0;
		//100까지의 합
		for(su=1; su<=100; su++) {
			sum += su;
		}
		
		
		//홀수의 합
		
		sum=0;
		for(su=1; su<=100; su+=2) {
			sum += su;
		}
		
		//짝수의 합
		
		sum = 0;
		for(su=0; su<=100; su+=2) {
			sum += su;
		}
		
		//3의 배수의 합
		sum = 0;
		for(su = 3; su<=100; su+=3) {
			sum += su;
		}
		
		System.out.println("결과 : " + sum);

	}

}
