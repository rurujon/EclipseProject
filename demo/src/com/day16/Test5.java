package com.day16;

import java.util.Scanner;

//5~10자 이내의 영문자를 입력받아 출력하는 프로그램

//문자열? abcde
//abcde

class MyAuthenticator{
	
	public void inputFormat(String str) throws Exception{
		//length, 아스키값 활용
		
		
		if(!(str.length()>4 && str.length()<11)) {
			throw new Exception("문자열 길이 오류");
		}
		
		for(int i=0; i<str.length(); i++) {
			char s = str.charAt(i);		// String의 메서드. 한 개의 문자를 뽑아낸다.
			if (!((s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z'))) {	//((ch<'a'||ch>'z')&&(ch<'A'||ch>'Z'))
				throw new Exception("영문자열이 아닙니다.");
			}
		}
		
		
		
	}
}

public class Test5 {
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str;
		
		MyAuthenticator auth = new MyAuthenticator();
		
		
		
		try {
			
			System.out.println("문자열");//abcde,abcd
			
			str = sc.next();
			
			auth.inputFormat(str);
			
			System.out.println(str);
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			// TODO: handle exception
		}

	}

}
