package com.mondayFinal;

import java.util.Scanner;

import com.monday2.Buy;
import com.monday2.BuyDAO;
import com.monday2.Grade;
import com.monday2.Login;
import com.monday2.LoginDTO;
import com.monday2.Monday;
import com.pointDB.Point;
import com.searchDB.Search;

public class MondayFinalMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Monday ob = new Monday();
		LoginDTO logDto;
		int ch;
		MondayFinalJoinMember ob2 = new MondayFinalJoinMember();
		Login ob3 = new Login();
		InfoUpdate ob4 = new InfoUpdate();
		Search serc = new Search();
		Point po = new Point();
		Grade gr = new Grade();
		Buy buyOb = new Buy();
		BuyDAO buydao = new BuyDAO();
		

		while(true) {

			do {
				System.out.println("♥==========================================================♥");
				System.out.println("♥ 1.회원가입 2.로그인 3.아이디 찾기 4.비밀번호 찾기 5.종료 ♥");
				System.out.println("♥==========================================================♥");
				System.out.print("입력란 : ");
				ch=sc.nextInt();
				System.out.println();

			}
			while(ch<1||ch>5);

			switch(ch) {

			case 1 : ob2.insert(); break;

			case 2 : 

				logDto = null;

				logDto = ob3.login();

				if (logDto != null) { // 로그인 성공 시
					boolean logOut = true;

					while(logOut) {
						do {
							System.out.println();
							System.out.println("♥============================================================================================================♥");
							System.out.println("♥ 1.제품 2.제조사 3.구매 4.구매내역 5.회원탈퇴 6.회원정보수정 7.포인트조회 8.평점등록 9.장바구니 10.로그아웃 ♥");	//로그인 되어야만 나오는 화면.
							System.out.println("♥============================================================================================================♥");
							System.out.print("입력란 : ");
							ch=sc.nextInt();
							System.out.println();

						}
						while(ch<1||ch>10);

						switch(ch) {

						case 1 : 
							System.out.print("1. 전체 2. 대분류 : ");		//전체 product 를 출력할 것인지, 분류로 들어갈 것인지.
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
						case 3 : buyOb.buy(logDto); break;					//구매를 할 때, sales에 로그인ID가 필요하므로, 로그인DTO를 매개변수로 투입.
						case 4 : ob.selectBuyList(logDto); break;		//자신이 구매한 리스트만 볼 수 있어야 하기에 역시 로그인DTO를 매개변수로 투입해서 로그인ID 값을 받음.
						case 5 : ob2.delete(); logOut = false; break;
						case 6 : ob4.update(); break;
						case 7 : po.point(logDto); break;
						case 8 : gr.grade(logDto); break;
						case 9 : buyOb.listBuy(logDto); break;
						case 10 : logOut = false; buydao.delete(); System.out.println("로그아웃 되었습니다."); break;
						default : System.exit(0);

						}
						
					}

				}
				break;
				
			case 3: 
				serc.searchId(); break;
			case 4:
				serc.searchPw(); break;
			default : System.exit(0);
			
			}

		}

	}

}