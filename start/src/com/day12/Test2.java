package com.day12;

import java.util.Calendar;import java.util.Locale.Category;

public class Test2 {

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
		
		//달의 첫날, 말일 구하기
		int startDay = now.getActualMinimum(Calendar.DATE);//1
		int endDay = now.getActualMaximum(Calendar.DATE);//1
		
		System.out.println(startDay + ":" + endDay);
		
		System.out.printf("%tF\n",now);//2024-06-03 날짜
		System.out.printf("%tT\n",now);//11:10:04 시간
		
		System.out.printf("%1$tF %1$tT\n",now);//
		
		//날짜 재지정
		now.set(2025, 10-1, 21);
		
		y = now.get(Calendar.YEAR);//년
		m = now.get(Calendar.MONTH)+1;//월(0~11)
		d = now.get(Calendar.DATE);//일
		w = now.get(Calendar.DAY_OF_WEEK);//요일(1~7 : 일요일 1)
		System.out.println(y + "-" + m + "-" + d);
		System.out.println(yoil[w-1] + "요일");

	}

}
