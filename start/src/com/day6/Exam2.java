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
				System.out.print("���� �Է�? : ");
				num = sc.nextInt();
				if(num!=rdnum) {
					System.out.println("Ʋ�Ⱦ��!");
				}
				else {
					System.out.println("�¾Ҿ��!");
					break;
				}
			}

			System.out.println("������ " + rdnum + "�Դϴ�.");
			System.out.println("��� �Ͻðڽ��ϱ�? [Y/N]");
			yn=(char)System.in.read();

			if(yn!='y'&&yn!='Y') {	//����(!=) or ����(!=) �� ��� or(||)�� �ƴ� and(&&)�� ����. ���α׷��� ���.
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}

			System.in.skip(2); //���� (�ƽ�Ű 10,13) ����

		}
	}

}
