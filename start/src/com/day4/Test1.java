package com.day4;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		//�Է¹��� ���� 3�� ������� 4�� ������� ã���ÿ�
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		String str;
		
		System.out.println("���ڸ� �Է����ּ���.");
		num = sc.nextInt();
		
		if(num%3==0 && num%4==0) {
			str = "3�� 4�� ����Դϴ�.";
		}
		
		else if(num%3==0) {
			str = "3�� ����Դϴ�.";
		}
		else if(num%4==0) {
			str = "4�� ����Դϴ�.";
		}
		else {
			str = "3�� 4�� ����� �ƴմϴ�.";
		}
		
		System.out.println("�Է��Ͻ� ���ڴ� " + str);
		sc.close();

	}

}
