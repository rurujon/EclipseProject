package com.day4;

public class Test5 {

	public static void main(String[] args) {
		
		//���� for ��
		
		int i,j;
		
		for (i=2; i<=9; i++) {
			System.out.println(i + "��");
			
			for(j=1; j<=9; j++) {
				System.out.println(i + "*" + j + "=" + (i*j));
			}
			
			System.out.println("");
		}

	}

}
