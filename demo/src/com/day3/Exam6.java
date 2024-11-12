package com.day3;

import java.util.Scanner;

public class Exam6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int mat, kor, eng;
		
		System.out.println("이름을 입력해주세요.");
		name = sc.next();
		
		System.out.println("수학, 국어. 영어 성적을 각각 적어주세요.");
		mat = sc.nextInt();
		kor = sc.nextInt();
		eng = sc.nextInt();
		
		int sum, avr;
		sum = mat+kor+eng;
		avr = sum/3;
		
		String str;
		
		if (avr < 60) {
			str = "불합격";
		}
		else if (mat<40 || kor<40 || eng<40) {
			str = "과락";
		}
		else {
			str = "합격";
		}
		
		System.out.println("이름 : " + name);
		System.out.println("총점 : " + sum + " 평균 : " + avr + " 판정 : " + str);
		sc.close();

	}

}
