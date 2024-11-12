package com.day3;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) throws Exception{
		
		//Scanner : 단락문자의 패턴을 사용해 데이터를 분류
		//기본 패턴은 공백
		
		Scanner sc = new Scanner(System.in);
		
		String name ;
		
		int kor, eng, mat;
		
		//System.out.print("이름 국어 영어 수학"); //suzi 30 50 70
		
		System.out.print("이름,국어,영어,수학");
		
		sc=new Scanner(sc.next()). useDelimiter("\\s*,\\s*");
		
		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		System.out.println(name + ":" + (kor+eng+mat) + "점");
		
		sc.close();

	}

}
