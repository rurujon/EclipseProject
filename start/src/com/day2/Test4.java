package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		//System.in : Ű���带 ���� �Էµ� 1byte ���ڸ� �о��.
		//InputStreamReeader : System.in���� ���� 1byte�� 2 byte ���ڷ� ��ȯ
		//BufferReader : ���۷� �Է¹޾� ó���ӵ��� ����
		
		int r;
		double area, length;
		
		System.out.print("������?");
		
		r = Integer.parseInt(br.readLine());
		
		//readLine : ���۷� �޾ƿ� br�� �о���� ���
		
		
		area = r*r*3.14;
		length = r*2*3.14;
		
		System.out.println("���� : " + area );
		System.out.println("�ѷ� : " + length);

	}

}
