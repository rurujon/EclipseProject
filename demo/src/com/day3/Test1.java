package com.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) throws IOException {
		
		//계산기 v1.0
		
		BufferedReader br = new BufferedReader(
				
				new InputStreamReader(System.in));
		
		
		int num1, num2;
		System.out.print("첫번째 수?");
		num1 = Integer.parseInt(br.readLine());
		
		//String su1 = br.readLine();
		//num1 = Integer.parseInt(su1);
		
		System.out.print("두번째 수?");
		num2 = Integer.parseInt(br.readLine());
		
		int sum = num1 + num2;
		
		System.out.printf("%d + %d = %d\n", num1,num2,sum);
		System.out.printf("%d - %d = %d\n", num1, num2, num1-num2);
		System.out.printf("%d * %d = %d\n", num1, num2, num1*num2);
		System.out.printf("%d / %d = %d\n", num1, num2, num1/num2);
		System.out.printf("%d %% %d = %d\n", num1, num2, num1%num2);
		
		System.out.println("num1 > num2:" + (num1>num2));
		
		
		//숫자는 부등호 등호로 비교하면 boolean 값이 만들어진다.
		//부등호, 등호
		//>, <, >=, <=, ==, !=
		
		
		String str;
		
		//삼항연산자
		str = num1%2==0 ? "짝수" : "홀수";
		System.out.println(str);
		
		str = num1>0 ? "양수" : (num1<0 ? "음수" : "영");
		System.out.println(str);
		
		//&& : A and B
		//|| : A or B
		
		str = num1%4==0 && num1%100!=0 || num1%400==0 ? "윤년" : "평년";
		System.out.println(str);

	}

}
