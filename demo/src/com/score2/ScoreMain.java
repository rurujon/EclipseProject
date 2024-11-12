package com.score2;

import java.util.Scanner;


public class ScoreMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Score ob = new ScoreImpl();
		
		int ch;
		
		while(true) {
			
			do {
				System.out.print("1. 입력 2. 출력 3. 삭제 4. 학번검색 5. 이름검색 6. 총점내림차순 7. 학번오름차순 8. 종료");
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
