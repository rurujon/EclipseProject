package com.day12;

import java.util.Calendar;

public class Test3 {

	//Calendar�� ����� ����޷� �����

	public static void main(String[] args) {

		Calendar now = Calendar.getInstance();

		int y = now.get(Calendar.YEAR);//��
		int m = now.get(Calendar.MONTH)+1;//��(0~11)
		int d = now.get(Calendar.DATE);//��
		int w = now.get(Calendar.DAY_OF_WEEK);//����(1~7 : �Ͽ��� 1)

		System.out.println(y + "-" + m + "-" + d);
		System.out.println(w);

		String[] yoil = {"��", "��", "ȭ", "��", "��", "��", "��"};
		System.out.println(yoil[w-1] + "����");

		int months[] = {31,28,31,30,31,30,31,31,30,31,30,31};

		int nalsu,i,week;

		int startDay = now.getActualMinimum(Calendar.DATE);//1

		//���⿡ ���� 2���� ���� ����
		if(y%4==0 && y%100!=0 ||y%400==0) {
			months[1] = 29;
		}

		//11�� 1������ ����� y ����(m-1)������ ����		
		nalsu = ((y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400);

		//int yy = (y-1)/4 - (y-1)/100 + (y-1)/400;
		//System.out.println(nalsu + ":" + yy);


		//m-1 �������� ���� �ջ�
		//�ε��� : 0  1  2  3  4  5  6  7  8  9 10 11
		//���� : {31,28,31,30,31,30,31,31,30,31,30,31}
		//�� : 	   1  2  3  4  5  6  7  8  9 10 11 12
		for(i=0; i<m-1; i++) {

			nalsu = nalsu + months[i];  //nalsu = nalsu+months[i]
		}

		nalsu +=1;  //y�� m�� 1���� ����

		//���� �� ���ϱ�
		week = nalsu %7;

		System.out.println(week);

		//���
		System.out.println("\n  ��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("------------------------------");

		//��������
		for (i=0; i<week; i++) {
			System.out.print("    ");
		}

		//m���� ��¥ ���
		for(i=1; i<=months[m-1]; i++) {
			System.out.printf("%4d",i);

			//�� ���� ���� ��µǸ� �ٹٲ�
			week++;

			if(week%7==0) {
				System.out.println();
			}
		}

		if(week%7!=0) {
			System.out.println();
		}

		System.out.println("------------------------------");
		

	}

}
