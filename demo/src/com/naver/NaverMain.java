package com.naver;

import java.util.Scanner;


public class NaverMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Naver ob = new NaverImpl();

		int ch;

		while(true) {

			do {
				System.out.print("1. ȸ������ 2. ���Ը�� 3. ��ϻ��� 4. ���̵�ã�� 5. ��й�ȣã�� 6. ��ϼ��� 7. ����");
				ch=sc.nextInt();
			}while(ch<1);

			switch(ch) {
			case 1 : ob.input(); break;
			case 2 : ob.print(); break;
			case 3 : ob.delete();; break;
			case 4 : ob.searchId(); break;
			case 5 : ob.searchPassword(); break;
			case 6 : ob.change(); break;			
			default: System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
			}
		}

	}

}
