package com.score2;

import java.util.Scanner;


public class ScoreMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Score ob = new ScoreImpl();
		
		int ch;
		
		while(true) {
			
			do {
				System.out.print("1. �Է� 2. ��� 3. ���� 4. �й��˻� 5. �̸��˻� 6. ������������ 7. �й��������� 8. ����");
				ch=sc.nextInt();
			}while(ch<1);
			
			switch(ch) {
			case 1 : ob.input(); break;
			case 2 : ob.print(); break;
			case 3 : ob.deleteHak(); break;
			case 4 : ob.searchHak(); break;
			case 5 : ob.searchName(); break;
			case 6 : ob.descSortTot(); break;
			case 7 : ob.ascSortHot(); break;			
			default: System.exit(0);
			}
		}
		
	}

}
