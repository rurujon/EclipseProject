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
				System.out.println("수 입력?");
				su = Integer.parseInt(br.readLine());
			}
			while (su<1||su>5000);
			
			sum = 0;
			for(int i=1;i<=su; i++) {
				sum +=i; //sum = sum+i
			}
			
			System.out.println("1~" + su + "까지의 합 : " + sum);
			
			//계속 진행 여부
			System.out.println("계속할래? [Y/N]");
			ch=(char)System.in.read();
			
			if(ch!='y'&&ch!='Y') {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			System.in.skip(2); //엔터 (아스키 10,13) 삭제
		}
				

	}

}
