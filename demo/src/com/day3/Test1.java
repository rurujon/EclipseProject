package com.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) throws IOException {
		
		//���� v1.0
		
		BufferedReader br = new BufferedReader(
				
				new InputStreamReader(System.in));
		
		
		int num1, num2;
		System.out.print("ù��° ��?");
		num1 = Integer.parseInt(br.readLine());
		
		//String su1 = br.readLine();
		//num1 = Integer.parseInt(su1);
		
		System.out.print("�ι�° ��?");
		num2 = Integer.parseInt(br.readLine());
		
		int sum = num1 + num2;
		
		System.out.printf("%d + %d = %d\n", num1,num2,sum);
		System.out.printf("%d - %d = %d\n", num1, num2, num1-num2);
		System.out.printf("%d * %d = %d\n", num1, num2, num1*num2);
		System.out.printf("%d / %d = %d\n", num1, num2, num1/num2);
		System.out.printf("%d %% %d = %d\n", num1, num2, num1%num2);
		
		System.out.println("num1 > num2:" + (num1>num2));
		
		
		//���ڴ� �ε�ȣ ��ȣ�� ���ϸ� boolean ���� ���������.
		//�ε�ȣ, ��ȣ
		//>, <, >=, <=, ==, !=
		
		
		String str;
		
		//���׿�����
		str = num1%2==0 ? "¦��" : "Ȧ��";
		System.out.println(str);
		
		str = num1>0 ? "���" : (num1<0 ? "����" : "��");
		System.out.println(str);
		
		//&& : A and B
		//|| : A or B
		
		str = num1%4==0 && num1%100!=0 || num1%400==0 ? "����" : "���";
		System.out.println(str);

	}

}
