package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test7 {

	public static void main(String[] args) throws IOException{


		//�غ��� ���̸� �Է¹޾� �ﰢ���� ���� ���ϱ�
		//�غ�? 10
		//����? 20
		//���� = ?

		//����
		//�Է�
		//����
		//���


		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		double a,h;

		double s;

		System.out.println("�غ�?");
		a = Double.parseDouble(br.readLine());

		System.out.println("����?");
		h = Double.parseDouble(br.readLine());

		s=((a*h)/2.0);
		System.out.println("�ﰢ���� ���� : " +  s);
		System.out.printf("���� : %g",s); //%g : �Ҽ��� �� �ڸ�����.
	}

}