package com.day7;

import java.util.Scanner;

public class Rect {
	
	int w, h;//��������(instance����) , instance ������ �⺻������ 0���� �ʱ�ȭ�ȴ�
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("����?");
		w=sc.nextInt();
		
		System.out.println("����?");
		h=sc.nextInt();
		
		//return;
	}
	
	public int area() {
		
		int result;//��������
		result = w*h;
		return result;
	}
	
	public int length() {
		return (w+h)*2;
	}
	
	public void print(int a, int l) {
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
		System.out.println("���� : " + a);
		System.out.println("�ѷ� : " + l);
	}

}
