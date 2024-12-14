package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test7 {

	public static void main(String[] args) throws IOException{


		//밑변과 높이를 입력받아 삼각형의 넓이 구하기
		//밑변? 10
		//높이? 20
		//넓이 = ?

		//선언
		//입력
		//연산
		//출력


		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		int a,h;

		double s;

		System.out.println("밑변?");
		a = Integer.parseInt(br.readLine());

		System.out.println("높이?");
		h = Integer.parseInt(br.readLine());

		s=((a*h)/2.0);
		System.out.println("삼각형의 넓이 : " +  s);

	}

}
