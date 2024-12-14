package com.day12;

import java.util.Calendar;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		
		int y = now.get(Calendar.YEAR);//년
		int m = now.get(Calendar.MONTH)+1;//월(0~11)
		int d = now.get(Calendar.DATE);//일
		int w = now.get(Calendar.DAY_OF_WEEK);//요일(1~7 : 일요일 1)
		
		System.out.println(y + "-" + m + "-" + d);
		
		String[] yoil = {"일", "월", "화", "수", "목", "금", "토"};
		System.out.println(yoil[w-1] + "요일");
		
		/*int startDay = now.getActualMinimum(Calendar.DATE);//1
		int endDay = now.getActualMaximum(Calendar.DATE);//1
		*/
		
		int[] endDay = {31,28,31,30,31,30,31,31,30,31,30,31};
		Scanner sc = new Scanner(System.in);
		
		System.out.println("며칠 후?");
		int after = sc.nextInt();
				
		d+=after;
		
		int a = w-1+after%7;
		if(a>=7) {
			a-=7;
		}
		
		if(d>endDay[m-1]) {
			after = d-endDay[m-1];
			m++;
		}
		
		while(after>endDay[m-1]) {
			if(y%4==0 && y%100!=0 ||y%400==0) {
				endDay[1] = 29;
			}
			else {
				endDay[1] = 28;
			}
			after = after-endDay[m-1];
			m++;
			if(m>12) {
				m=1;
				y++;
			}
			
		}
		d=after;
		
		
		
		System.out.println(y + "-" + m + "-" + d);
		System.out.println(yoil[a] + "요일");


		//Calendar 
		//년? 2024
		//월? 6 
		//일? 3
		//몇일 후? 2
		//2024 6 3 월요일
		//2024 6 5 수요일
		
	}

}
