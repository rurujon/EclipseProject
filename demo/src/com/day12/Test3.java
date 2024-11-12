package com.day12;

import java.util.Calendar;

public class Test3 {

	//Calendar를 사용한 만년달력 만들기

	public static void main(String[] args) {

		Calendar now = Calendar.getInstance();

		int y = now.get(Calendar.YEAR);//년
		int m = now.get(Calendar.MONTH)+1;//월(0~11)
		int d = now.get(Calendar.DATE);//일
		int w = now.get(Calendar.DAY_OF_WEEK);//요일(1~7 : 일요일 1)

		System.out.println(y + "-" + m + "-" + d);
		System.out.println(w);

		String[] yoil = {"일", "월", "화", "수", "목", "금", "토"};
		System.out.println(yoil[w-1] + "요일");

		int months[] = {31,28,31,30,31,30,31,31,30,31,30,31};

		int nalsu,i,week;

		int startDay = now.getActualMinimum(Calendar.DATE);//1

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
