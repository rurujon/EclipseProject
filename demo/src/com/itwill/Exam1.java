package com.itwill;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int money;
		
		do {
			System.out.print("금액?[최소 10원 단위] : ");
			money = sc.nextInt();
		}
		while(money%10!=0);
		
		System.out.println();
		System.out.println("입력받은 금액 : " + money);
		System.out.println();
		
		int coin600;
		int coin150;
		int coin10;
		
		coin600 = money/600;
		System.out.println("600원 갯수 : " + coin600);
		
		money -= 600*coin600;
		
		coin150 = money/150;
		System.out.println("150원 갯수 : " + coin150);
		
		money -=150*coin150;
		
		coin10 = money/10;
		System.out.println("10원 개수 : " + coin10);
		
		money -=10*coin10;
		
		System.out.println();
		System.out.println("잔액 : " + money);
		System.out.println("동전 갯수 총합 : " + (coin150 + coin600 + coin10));

	}

}
