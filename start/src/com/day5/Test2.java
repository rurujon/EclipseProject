package com.day5;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		//만년달력

		Scanner sc = new Scanner(System.in);

		//월별 날짜수를 배열에 저장
		int months[] = {31,28,31,30,31,30,31,31,30,31,30,31};

		int y,m,nalsu,i,week;

		do {
			System.out.print("연도? ");
			y=sc.nextInt();
		}
		while(y<1); //연도 입력

		do {
			System.out.print("월?");
			m=sc.nextInt();
		}
		while(m<1||m>12); //월 입력
		
		//윤년에 따른 2월의 날수 수정
		if(y%4==0 && y%100!=0 ||y%400==0) {
			months[1] = 29;
		}

		//11년 1월부터 현재년 y 전월(m-1)까지의 날수		
		nalsu = ((y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400);

		//int yy = (y-1)/4 - (y-1)/100 + (y-1)/400;
		//System.out.println(nalsu + ":" + yy);


		//m-1 월까지의 날수 합산
		//인덱스 : 0  1  2  3  4  5  6  7  8  9 10 11
		//날수 : {31,28,31,30,31,30,31,31,30,31,30,31}
		//월 : 	   1  2  3  4  5  6  7  8  9 10 11 12
		for(i=0; i<m-1; i++) {

			nalsu = nalsu + months[i];  //nalsu = nalsu+months[i]
		}

		nalsu +=1;  //y년 m월 1일의 날수

		//주위 수 구하기
		week = nalsu %7;

		System.out.println(week);

		//출력
		System.out.println("\n  일  월  화  수  목  금  토");
		System.out.println("------------------------------");

		//공백지정
		for (i=0; i<week; i++) {
			System.out.print("    ");
		}

		//m월의 날짜 출력
		for(i=1; i<=months[m-1]; i++) {
			System.out.printf("%4d",i);

			//한 주의 끝이 출력되면 줄바꿈
			week++;

			if(week%7==0) {
				System.out.println();
			}
		}

		if(week%7!=0) {
			System.out.println();
		}

		System.out.println("------------------------------");
	}

}
