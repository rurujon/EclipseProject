package com.day3;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor;
		
		System.out.println("�̸�?"); //suzi
		name = sc.next();
		
		System.out.println("����?"); //60
		kor = sc.nextInt();
		
		String pan;
		
		if(kor>=90) {
			pan = "��";
		}
		else if (kor>=80)	{
			pan = "��";
		}
		else if (kor >=70)	{
			pan = "��";
		}
		else if (kor >=60) {
			pan = "��";
		}
		else	{
			pan = "��";
		}
		
		System.out.println(name + ":" + pan);
		
		sc.close();

	}

}
