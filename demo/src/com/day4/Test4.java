package com.day4;

public class Test4 {

	public static void main(String[] args) {
		
		int su, sum = 0;
		//100������ ��
		for(su=1; su<=100; su++) {
			sum += su;
		}
		
		
		//Ȧ���� ��
		
		sum=0;
		for(su=1; su<=100; su+=2) {
			sum += su;
		}
		
		//¦���� ��
		
		sum = 0;
		for(su=0; su<=100; su+=2) {
			sum += su;
		}
		
		//3�� ����� ��
		sum = 0;
		for(su = 3; su<=100; su+=3) {
			sum += su;
		}
		
		System.out.println("��� : " + sum);

	}

}
