package com.day11;

import java.io.IOException;
import java.util.Scanner;

class Ex1{
	
	public void print(String r) {
		System.out.println(r);
	}
}

class Calc4 extends Test{
	String str;
	int num1, num2;
	char op;
	String su;
	
	public void input() throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 개의 수?");//34 56
		su = sc.next();
		
		String ss[] = su.split(",");
		num1 = Integer.parseInt(ss[0]);
		num2 = Integer.parseInt(ss[1]);
		
		System.out.println("연산자?");
		op = (char)System.in.read();
		
	}
	
	public String calc() {
		
		int result = 0;
		
		switch (op) {
		case '+': result = num1 + num2; break;
		case '-': result = num1 - num2; break;
		case '*': result = num1 * num2; break;
		case '/': result = num1 / num2; break;

		default:
			break;
		}
		
		return String.format("%d %c %d = %d",num1,op,num2,result);
		
		
	}
	
	
}
public class Exam1 {

	public static void main(String[] args) throws IOException {
		
		Calc4 ob = new Calc4();
		
		ob.input();
		String r = ob.calc();
		ob.print(r);

	}

}
