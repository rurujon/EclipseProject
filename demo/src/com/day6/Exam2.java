package com.day6;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) throws IOException {

		Random rd = new Random();

		Scanner sc = new Scanner(System.in);

		int i,j, rdnum, num;
		char yn;
		while(true) {
			rdnum = rd.nextInt(10)+1;
			System.out.println(rdnum);
			for(i=0; i<3; i++) {
				System.out.print("정수 입력? : ");
				num = sc.nextInt();
				if(num!=rdnum) {
					System.out.println("틀렸어요!");
				}
				else {
					System.out.println("맞았어요!");
					break;
				}
			}

			System.out.println("정답은 " + rdnum + "입니다.");
			System.out.println("계속 하시겠습니까? [Y/N]");
			yn=(char)System.in.read();

			if(yn!='y'&&yn!='Y') {	//부정(!=) or 부정(!=) 의 경우 or(||)이 아닌 and(&&)를 쓴다. 프로그래밍 약속.
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			System.in.skip(2); //엔터 (아스키 10,13) 삭제

		}
	}

}
