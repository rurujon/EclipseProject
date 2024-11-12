package com.day3;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		
		
		//세 개의 수를 입력받아 작은 수에서 큰 수 순으로 정렬
		//오름차순 정렬
		
		Scanner sc = new Scanner(System.in);
		
		int num1, num2, num3, temp;
		
		System.out.print("숫자 셋");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
		if(num1 > num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		if(num2 > num3) {
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		
		if(num1 > num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		System.out.println(num1 + ","+ num2 +"," + num3);
		
		sc.close();

	}

}
