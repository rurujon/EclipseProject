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
				System.out.println("��==========================================================��");
				System.out.println("�� 1.ȸ������ 2.�α��� 3.���̵� ã�� 4.��й�ȣ ã�� 5.���� ��");
				System.out.println("��==========================================================��");
				System.out.print("�Է¶� : ");
				ch=sc.nextInt();
				System.out.println();

			}
			while(ch<1||ch>5);

			switch(ch) {

			case 1 : ob2.insert(); break;

			case 2 : 

				logDto = null;

				logDto = ob3.login();

				if (logDto != null) { // �α��� ���� ��
					boolean logOut = true;

					while(logOut) {
						do {
							System.out.println();
							System.out.println("��============================================================================================================��");
							System.out.println("�� 1.��ǰ 2.������ 3.���� 4.���ų��� 5.ȸ��Ż�� 6.ȸ���������� 7.����Ʈ��ȸ 8.������� 9.��ٱ��� 10.�α׾ƿ� ��");	//�α��� �Ǿ�߸� ������ ȭ��.
							System.out.println("��============================================================================================================��");
							System.out.print("�Է¶� : ");
							ch=sc.nextInt();
							System.out.println();

						}
						while(ch<1||ch>10);

						switch(ch) {

						case 1 : 
							System.out.print("1. ��ü 2. ��з� : ");		//��ü product �� ����� ������, �з��� �� ������.
							int a = sc.nextInt();
							switch(a) {

							case 1 : ob.selectAllProduct(); break;			//����� select * ����.
							case 2 : ob.selectPointProduct(); break;		//��з� �Һз� ���� ����.

							default:
								System.out.println("�߸� �Է��ϼ̽��ϴ�.");
								break;
							}

							break;
						case 2 : ob.selectMakerList(); break;			//����� select *
						case 3 : buyOb.buy(logDto); break;					//���Ÿ� �� ��, sales�� �α���ID�� �ʿ��ϹǷ�, �α���DTO�� �Ű������� ����.
						case 4 : ob.selectBuyList(logDto); break;		//�ڽ��� ������ ����Ʈ�� �� �� �־�� �ϱ⿡ ���� �α���DTO�� �Ű������� �����ؼ� �α���ID ���� ����.
						case 5 : ob2.delete(); logOut = false; break;
						case 6 : ob4.update(); break;
						case 7 : po.point(logDto); break;
						case 8 : gr.grade(logDto); break;
						case 9 : buyOb.listBuy(logDto); break;
						case 10 : logOut = false; buydao.delete(); System.out.println("�α׾ƿ� �Ǿ����ϴ�."); break;
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