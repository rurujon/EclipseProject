package com.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test3 {

	public static void main(String[] args) throws IOException {
		
		//제어문
		//if, for, while, do~while, switch
		
		
		BufferedReader br = new BufferedReader(
				
				new InputStreamReader(System.in));
		
		int num;
		String str="";
		
		System.out.print("수 입력?"); //788
		num = Integer.parseInt(br.readLine());
		
		//if (조건식){작업}else{작업}
		//단일 if문
		
		if(num%2==0) {
			str = "짝수";
			
		}
		else str = "홀수";
		
		System.out.println(num + ":" + str);

	}

}
