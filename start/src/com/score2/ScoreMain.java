package com.score2;

import java.util.Scanner;


public class ScoreMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Score ob = new ScoreImpl();
		
		int ch;
		
		while(true) {
			
			do {
				System.out.print("1. 입력 2. 출력 3. 학번검색 4. 이름검색 5. 총점내림차순 6. 학번오름차순 7. 종료");
				ch=sc.nextInt();
			}while(ch<1);
			
			switch(ch) {
			case 1 : ob.input(); break;
			case 2 : ob.print(); break;
			case 3 : ob.searchHak(); break;
			case 4 : ob.searchName(); break;
			case 5 : ob.descSortTot(); break;
			case 6 : ob.ascSortHot(); break;			
			default: System.exit(0);
			}
		}
		
	}

}
