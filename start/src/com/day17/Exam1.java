package com.day17;

import java.util.Random;
import java.util.Scanner;


class MyThreadEx extends Thread{
	
	@Override
	public void run() {
		
		System.out.print("고민중");
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
			{"정윤재","정준우","엄기표","이주현","이윤용",
			"문승은","조준영","황대웅","임경륜","배주용",
			"허강현","윤선호","정우준","김지영","최소영"};
		
		
		int num = 0;
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("발표자 인원 수[최대 15명] ");
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
		System.out.println("축하합니다. 발표자입니다.");
		
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
			System.out.println((i+1) + "번 발표자 : " + name[renum[i]]);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		

	
	}

}
