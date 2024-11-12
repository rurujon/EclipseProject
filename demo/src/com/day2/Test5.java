package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		String name; //String은 자료형이 아니라 클래스.
		int kor, eng, tot;
		
		System.out.print("이름?");//Suzi
		name = br.readLine();
		
		System.out.print("국어?");//50
		kor = Integer.parseInt(br.readLine());
		
		System.out.print("영어?");//70
		eng = Integer.parseInt(br.readLine());
		
		tot = kor + eng;
		
		System.out.print("이름 : " + name);
		System.out.println(" , 총점 : " + tot);

	}

}
