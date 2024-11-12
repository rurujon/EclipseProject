package com.day9;

import java.io.IOException;
import java.util.Scanner;

class Calc{
	
	private int num1, num2;
	private char oper;
	
	public boolean input() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 개의 수?");//30 20
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		System.out.print("연산자?");//+ - * /
		oper = (char)System.in.read();
		
		//연산자 확인
		if(oper!='+'&&oper!='-'&&oper!='*'&&oper!='/') {
			return false;
		}
		
		return true;
		
	
	}
	
	public int result() {
		int r = 0;
		
		switch(oper) {
		case '+' : r=num1 + num2; break;
		case '-' : r=num1 - num2; break;
		case '*' : r=num1 * num2; break;
		case '/' : r=num1 / num2; break;
		}
		return r;
	}
	
	public void print(int r) {
		
		System.out.printf("%d %c %d = %d",num1,oper,num2,r);
	}
	
}


public class Test6 {

	public static void main(String[] args) throws IOException {
		
		//계산기 v3.0
		
		Calc ob = new Calc();
		boolean flag = ob.input();
		System.out.println(flag);
		if(!flag) {
			System.out.println("연산자 오류");
			return;
		}
		
		int r = ob.result();
		System.out.println(r);
		ob.print(r);

	}

}
