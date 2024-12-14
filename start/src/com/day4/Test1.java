package com.day4;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		//입력받은 수가 3의 배수인지 4의 배수인지 찾으시오
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		String str;
		
		System.out.println("숫자를 입력해주세요.");
		num = sc.nextInt();
		
		if(num%3==0 && num%4==0) {
			str = "3과 4의 배수입니다.";
		}
		
		else if(num%3==0) {
			str = "3의 배수입니다.";
		}
		else if(num%4==0) {
			str = "4의 배수입니다.";
		}
		else {
			str = "3과 4의 배수가 아닙니다.";
		}
		
		System.out.println("입력하신 숫자는 " + str);
		sc.close();

	}

}
