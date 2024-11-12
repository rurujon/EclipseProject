package com.day6;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Exam3 {

	public static void main(String[] args) throws IOException{

		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		int a, b;
		int rdnum = rd.nextInt(3)+1;
		char yn;
		String[] rsp = {"가위", "바위", "보"};

		while(true) {
			while(true) {
				System.out.println(rdnum);
				System.out.print("1: 가위, 2: 바위, 3: 보 ? ");
				a=sc.nextInt();
				if(0<a && a<4) {
					b=a;
					break;
				}
				else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}

			System.out.println("컴퓨터 : " + rsp[rdnum-1] + " : 사용자 : " + rsp[b-1]);

			if(rdnum ==1 && a==3) {
				rdnum+=3;
			}
			if(a ==1 && rdnum==3) {
				a+=3;
			}
			if(rdnum==a) {
				System.out.println("비겼습니다.");
			}
			else if(rdnum>a) {
				System.out.println("컴퓨터가 이겼습니다.");
			}
			else if(rdnum<a) {
				System.out.println("당신이 이겼습니다.");
			}
			System.out.println("계속 하시겠습니까? [Y/N]");
			yn=(char)System.in.read();

			if(yn!='y'&&yn!='Y') {	//부정(!=) or 부정(!=) 의 경우 or(||)이 아닌 and(&&)를 쓴다. 프로그래밍 약속.
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			System.in.skip(2);
		}
		sc.close();
	}

}
