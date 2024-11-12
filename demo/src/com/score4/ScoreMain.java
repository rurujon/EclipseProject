package com.score4;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Score ob = new Score();
		int ch;
		
		while(true) {
			
			do {
				System.out.println("1.추가 2.수정 3.삭제 4.전체출력 5.학번검색 6.이름검색 7.종료 : ");
				ch=sc.nextInt();
			}
			while(ch<1||ch>7);
			
			switch(ch) {
			
			case 1 : ob.insert(); break;
			case 2 : ob.update(); break;
			case 3 : ob.delete(); break;
			case 4 : ob.selectAll(); break;
			case 5 : ob.searchHak(); break;
			case 6 : ob.searchName(); break;
				
			default :
				System.exit(0);
				break;
			}
		}

	}

}
