package com.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test3 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(
				
				new InputStreamReader(System.in));
		
		int su, sum;
		char ch;
		
		while(true) {
			
			
			do {
				System.out.println("�� �Է�?");
				su = Integer.parseInt(br.readLine());
			}
			while (su<1||su>5000);
			
			sum = 0;
			for(int i=1;i<=su; i++) {
				sum +=i; //sum = sum+i
			}
			
			System.out.println("1~" + su + "������ �� : " + sum);
			
			//��� ���� ����
			System.out.println("����ҷ�? [Y/N]");
			ch=(char)System.in.read();
			
			if(ch!='y'&&ch!='Y') {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			
			System.in.skip(2); //���� (�ƽ�Ű 10,13) ����
		}
				

	}

}
