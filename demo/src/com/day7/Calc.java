package com.day7;

import java.io.IOException;
import java.util.Scanner;

public class Calc {
	
	int num1, num2;
	char oper;
	
	public void input() throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ù��° ��?");//70
		num1 = sc.nextInt();
		
		System.out.println("�ι�° ��?");//50
		num2 = sc.nextInt();
		
		System.out.println("������ [+ - * /]");
		oper = (char)System.in.read();
	}
	
	public void output() {
		switch(oper) {
		
		
		//%d : ��Ʈ�� , %f : float��, %g : double��,  %c : char��, %s : string��
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
			System.out.printf("�Է� ����!");
			break;
		
		}
	}

}
