package com.day3;

import java.io.IOException;

public class Test2 {

	public static void main(String[] args) throws IOException {
		
		char a = 'a';
		
		System.out.println(a);
		System.out.println(Integer.toString(a)+10);
		
		char ch,result;
		System.out.println("한 개의 문자? ");//65
		ch = (char)System.in.read();
		
		//System.out.println(Integer.toString(ch));
		
		result = ch>=65 && ch <= 90 ? (char)(ch+32) : 
			(ch >= 'a' && ch<= 'z' ? (char)(ch-32) : ch);
		
		System.out.println(ch + "->" + result);

	}

}
