package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		String name; //String�� �ڷ����� �ƴ϶� Ŭ����.
		int kor, eng, tot;
		
		System.out.print("�̸�?");//Suzi
		name = br.readLine();
		
		System.out.print("����?");//50
		kor = Integer.parseInt(br.readLine());
		
		System.out.print("����?");//70
		eng = Integer.parseInt(br.readLine());
		
		tot = kor + eng;
		
		System.out.print("�̸� : " + name);
		System.out.println(" , ���� : " + tot);

	}

}
