package com.day11;

public class Test3 {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("서울");
		sb.append("부산");
		
		System.out.println(sb);
		
		String str = sb.toString();
		System.out.println(str);
		
		//Integer(int) : 래퍼클래스
		int a = 24;
		System.out.println(a);
		System.out.println(Integer.toString(a));
		System.out.println(Integer.toString(a,2));
		System.out.println(Integer.toString(a,16));

	}

}
