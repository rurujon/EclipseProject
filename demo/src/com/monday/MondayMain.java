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
				System.out.println("1.ȸ������ 2.�α���");
				ch=sc.nextInt();
			}
			while(ch<1||ch>7);

			switch(ch) {

			case 1 : ob2.insert(); break;

			case 2 : 
				logDto = ob3.login();		//�α��ΰ� ���ÿ� �α���DTO�� ��ȯ, �ȿ��� �α���ID ���� �������.
				
				boolean logOut = true;

				while(logOut) {
					do {
						System.out.println("1.��ǰ 2.������ 3.���� 4.���ų��� 5.������� 6.��ٱ��� : ");	//�α��� �Ǿ�߸� ������ ȭ��.
						ch=sc.nextInt();
					}
					while(ch<1||ch>6);

					switch(ch) {

					case 1 : 
						System.out.println("1. ��ü, 2. ��з�");		//��ü product �� ����� ������, �з��� �� ������.
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
					case 3 :  break;					//���Ÿ� �� ��, sales�� �α���ID�� �ʿ��ϹǷ�, �α���DTO�� �Ű������� ����.
					case 4 : ob.selectBuyList(logDto); break;		//�ڽ��� ������ ����Ʈ�� �� �� �־�� �ϱ⿡ ���� �α���DTO�� �Ű������� �����ؼ� �α���ID ���� ����.
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
