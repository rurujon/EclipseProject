package com.day3;

import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		float price = 15800;
		int num1;
		float chprice;
		
		System.out.println("구매할 수량을 입력해주세요.");
		num1 = sc.nextInt();
		
		if(num1 > 30) {
			chprice = price*0.8f;
		}
		
		else if (num1 > 20 ) {
			chprice = price*0.85f;
		}
		else if(num1 > 10) {
			chprice = price*0.9f;
		}
		else {
			chprice = price;
		}
		
		int isum;
		isum = (int)chprice*num1;
		
		System.out.println("물건 "+ num1 + "개의 가격은 " + isum +"입니다.");
		
		sc.close();
		
		

	}

}
