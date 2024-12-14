package com.day16;

import java.util.Scanner;

//5~10자 이내의 영문 숫자를 입력받아 출력하는 프로그램

class Myauthen{
	
	public void inputForm(String str) throws Exception{
		
		if(str.length()<5||str.length()>10) {
			throw new Exception("문자열의 길이는 5~10자 입니다.");
		}
		int eng = 0;
		int num = 0;
		
		for(int i=0; i<str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')) {
				eng++;
			}
			else if(ch>='0'&&ch<='9') {
				num++;
			}
		}
		
		if(eng==0||num==0) {
			
			throw new Exception("영문과 숫자의 혼용을 적어주세요.");
		}
		
		
	}
}

public class Test6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		
		Myauthen auth = new Myauthen();
		
		try {
			
			System.out.println("문자열?");
			str = sc.next();
			
			auth.inputForm(str);
			
			System.out.println(str);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}

	}

}
