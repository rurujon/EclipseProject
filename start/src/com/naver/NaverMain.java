package com.naver;

import java.util.Scanner;


public class NaverMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Naver ob = new NaverImpl();

		int ch;

		while(true) {

			do {
				System.out.print("1. 회원가입 2. 가입목록 3. 기록삭제 4. 아이디찾기 5. 비밀번호찾기 6. 기록수정 7. 종료");
				ch=sc.nextInt();
			}while(ch<1);

			switch(ch) {
			case 1 : ob.input(); break;
			case 2 : ob.print(); break;
			case 3 : ob.delete();; break;
			case 4 : ob.searchId(); break;
			case 5 : ob.searchPassword(); break;
			case 6 : ob.change(); break;			
			default: System.out.println("프로그램을 종료합니다.");
					System.exit(0);
			}
		}

	}

}
