package com.day5;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		//�迭 ����
		//�ڷ���[] ������ = new �ڷ��� [����]
		//num.length : �迭 [����]�� �������� �Լ�
		
		int[] num = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5���� ���� : ");
		
		
		for(int i=0; i<num.length; i++) {
			
			num[i] = sc.nextInt();
		}
		
		
		//���
		for(int i=0; i<num.length; i++) {
			System.out.println("num[" + i + "] : " + num[i]);
		}
		
		System.out.println("num[0]: " + num[0]);
		System.out.println("num[1]: " + num[1]);
		System.out.println("num[2]: " + num[2]);
		System.out.println("num[3]: " + num[3]);
		System.out.println("num[4]: " + num[4]);
		
		
		System.out.println("num[0] + num[1] : " + (num[0] + num[1]));

	}

}
