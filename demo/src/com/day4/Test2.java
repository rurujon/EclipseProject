package com.day4;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		//반복문
		//for, while, do~while
		//시작값과 종료값
		//i++ : 1씩 증가.
		//i+=n : n씩 증가
		
		Scanner sc = new Scanner(System.in);
		int dan;
		
		System.out.println("단 입력");
		dan=sc.nextInt();
		
		
		//시작값 최댓값 증가값 모두를 정확히 안다면 for 문이 유효
		for(int i=1; i<=9; i++) {
			System.out.println(dan + "*" + i + "=" + (dan*i) );
		}
		
		//시작값
		//while(최댓값){증갓값; ...}
		//반복 횟수를 정확히 알지 못 할 때 유효하다.
		
		int j=0;
		while(j<9) {
			j++;
			System.out.println(dan + "*" + j + "=" + (dan*j));
			
		}
		
		
		//do{증가값; ...}
		//while();
		//루프 진입 조건 없음. 실행한 결과를 확인하고 판단한다.
		
		int k = 0;
		do {k++;
			System.out.println(dan + "*" + k + "=" + (dan*k));
		}
		
		while(k<9);
		
		sc.close();

	}

}
