package com.day17;

import java.util.Random;
import java.util.Scanner;


class MyThreadEx extends Thread{
	
	@Override
	public void run() {
		
		System.out.print("�����");
		Random rd = new Random();
		int rdCom = rd.nextInt(15);
		
		for(int i=0; i<rdCom; i++) {
			System.out.print(".");
			try {
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}

public class Exam1 {

	public static void main(String[] args) {
		
		String[] name = 
			{"������","���ؿ�","����ǥ","������","������",
			"������","���ؿ�","Ȳ���","�Ӱ��","���ֿ�",
			"�㰭��","����ȣ","������","������","�ּҿ�"};
		
		
		int num = 0;
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("��ǥ�� �ο� ��[�ִ� 15��] ");
			num = sc.nextInt();
		}
		while(num>15||num<1);
	
		
		
		MyThreadEx ob = new MyThreadEx();
		
		ob.start();
		
		int renum[] = new int[num];
		
		try {
			ob.join();
		} catch (Exception e) {
			
		}
		
		System.out.println();
		System.out.println("�����մϴ�. ��ǥ���Դϴ�.");
		
		int i = 0,j;
		
		while(i<num) {
			renum[i] = rd.nextInt(name.length);
			for(j=0; j<i; j++) {
				if(renum[j]==renum[i]) {
					i--;
					break;
				}
			}
			
			i++;
			
		}
		for(i=0; i<num; i++) {
			System.out.println((i+1) + "�� ��ǥ�� : " + name[renum[i]]);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		

	
	}

}
