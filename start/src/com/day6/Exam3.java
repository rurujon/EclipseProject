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
		String[] rsp = {"����", "����", "��"};

		while(true) {
			while(true) {
				System.out.println(rdnum);
				System.out.print("1: ����, 2: ����, 3: �� ? ");
				a=sc.nextInt();
				if(0<a && a<4) {
					b=a;
					break;
				}
				else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			}

			System.out.println("��ǻ�� : " + rsp[rdnum-1] + " : ����� : " + rsp[b-1]);

			if(rdnum ==1 && a==3) {
				rdnum+=3;
			}
			if(a ==1 && rdnum==3) {
				a+=3;
			}
			if(rdnum==a) {
				System.out.println("�����ϴ�.");
			}
			else if(rdnum>a) {
				System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			}
			else if(rdnum<a) {
				System.out.println("����� �̰���ϴ�.");
			}
			System.out.println("��� �Ͻðڽ��ϱ�? [Y/N]");
			yn=(char)System.in.read();

			if(yn!='y'&&yn!='Y') {	//����(!=) or ����(!=) �� ��� or(||)�� �ƴ� and(&&)�� ����. ���α׷��� ���.
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}

			System.in.skip(2);
		}
		sc.close();
	}

}
