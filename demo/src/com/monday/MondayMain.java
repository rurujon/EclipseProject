package com.monday;

import java.util.Scanner;

import com.monday.ProductDTO;
import com.monday2.Buy;

public class MondayMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Monday ob = new Monday();
		LoginDTO logDto = new LoginDTO();
		int ch;
		JoinMemberShip ob2 = new JoinMemberShip();
		Login ob3 = new Login();
		Grade graOb = new Grade();
		Buy buyOb = new Buy();
		
		while(true) {

			do {
				System.out.println("1.회원가입 2.로그인");
				ch=sc.nextInt();
			}
			while(ch<1||ch>7);

			switch(ch) {

			case 1 : ob2.insert(); break;

			case 2 : 
				logDto = ob3.login();		//로그인과 동시에 로그인DTO를 반환, 안에는 로그인ID 값만 들어있음.
				
				boolean logOut = true;

				while(logOut) {
					do {
						System.out.println("1.제품 2.제조사 3.구매 4.구매내역 5.평점등록 6.장바구니 : ");	//로그인 되어야만 나오는 화면.
						ch=sc.nextInt();
					}
					while(ch<1||ch>6);

					switch(ch) {

					case 1 : 
						System.out.println("1. 전체, 2. 대분류");		//전체 product 를 출력할 것인지, 분류로 들어갈 것인지.
						int a = sc.nextInt();
						switch(a) {

						case 1 : ob.selectAllProduct(); break;			//평범한 select * 구현.
						case 2 : ob.selectPointProduct(); break;		//대분류 소분류 각각 구현.

						default:
							System.out.println("잘못 입력하셨습니다.");
							break;
						}

						break;
					case 2 : ob.selectMakerList(); break;			//평범한 select *
					case 3 :  break;					//구매를 할 때, sales에 로그인ID가 필요하므로, 로그인DTO를 매개변수로 투입.
					case 4 : ob.selectBuyList(logDto); break;		//자신이 구매한 리스트만 볼 수 있어야 하기에 역시 로그인DTO를 매개변수로 투입해서 로그인ID 값을 받음.
					case 5 : graOb.grade(logDto); break;
					case 6 :  break;
					default : System.exit(0);	break;

					}
				}


			default : System.exit(0); break;

			}


		}

	}

}
