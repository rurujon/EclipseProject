package com.day5;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		//배열 정의
		//자료형[] 변수명 = new 자료형 [갯수]
		//num.length : 배열 [갯수]를 가져오는 함수
		
		int[] num = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5개의 정수 : ");
		
		
		for(int i=0; i<num.length; i++) {
			
			num[i] = sc.nextInt();
		}
		
		
		//출력
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
