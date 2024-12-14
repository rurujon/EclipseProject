package com.day7;

import java.io.IOException;
import java.util.Scanner;

public class Calc {
	
	int num1, num2;
	char oper;
	
	public void input() throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 수?");//70
		num1 = sc.nextInt();
		
		System.out.println("두번째 수?");//50
		num2 = sc.nextInt();
		
		System.out.println("연산자 [+ - * /]");
		oper = (char)System.in.read();
	}
	
	public void output() {
		switch(oper) {
		
		
		//%d : 인트형 , %f : float형, %g : double형,  %c : char형, %s : string형
		case '+' :
			System.out.printf("%d %c %d = %d", num1, oper, num2, num1+num2);
			break;
		case '-' :
			System.out.printf("%d %c %d = %d", num1, oper, num2, num1-num2);
			break;
		case '*' : 
			System.out.printf("%d %c %d = %d", num1, oper, num2, num1*num2);
			break;
		case '/' :
			System.out.printf("%d %c %d = %d", num1, oper, num2, num1/num2);
			break;
		default :
			System.out.printf("입력 오류!");
			break;
		
		}
	}

}
