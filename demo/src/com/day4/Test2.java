package com.day4;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		//�ݺ���
		//for, while, do~while
		//���۰��� ���ᰪ
		//i++ : 1�� ����.
		//i+=n : n�� ����
		
		Scanner sc = new Scanner(System.in);
		int dan;
		
		System.out.println("�� �Է�");
		dan=sc.nextInt();
		
		
		//���۰� �ִ� ������ ��θ� ��Ȯ�� �ȴٸ� for ���� ��ȿ
		for(int i=1; i<=9; i++) {
			System.out.println(dan + "*" + i + "=" + (dan*i) );
		}
		
		//���۰�
		//while(�ִ�){������; ...}
		//�ݺ� Ƚ���� ��Ȯ�� ���� �� �� �� ��ȿ�ϴ�.
		
		int j=0;
		while(j<9) {
			j++;
			System.out.println(dan + "*" + j + "=" + (dan*j));
			
		}
		
		
		//do{������; ...}
		//while();
		//���� ���� ���� ����. ������ ����� Ȯ���ϰ� �Ǵ��Ѵ�.
		
		int k = 0;
		do {k++;
			System.out.println(dan + "*" + k + "=" + (dan*k));
		}
		
		while(k<9);
		
		sc.close();

	}

}
