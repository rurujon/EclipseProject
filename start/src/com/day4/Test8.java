package com.day4;

import java.io.IOException;
import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) throws IOException {
		
		//���� v2.0
		Scanner sc = new Scanner(System.in);
		
		int num1, num2;
		char oper;
		
		System.out.println("ù��° ��?");//70
		num1 = sc.nextInt();
		
		System.out.println("�ι�° ��?");//50
		num2 = sc.nextInt();
		
		System.out.println("������ [+ - * /]");
		oper = (char)System.in.read();
		
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
