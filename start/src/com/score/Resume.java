package com.score;

import java.util.Scanner;

public class Resume {
	
	private int inwon;
	
	Trecord[] tre;
	
	public void set() {
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("인원 수?");
			inwon = sc.nextInt();
		}while(inwon<1);
		
		tre = new Trecord[inwon];
	}
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<inwon; i++) {
			
			tre[i] = new Trecord();
			
			System.out.print("\n이름? ");
			tre[i].name = sc.next();
			System.out.print("나이? ");
			tre[i].age = sc.nextInt();
			System.out.print("면허?(o,x) ");
			tre[i].license=sc.next();
			System.out.print("토익? ");
			tre[i].score=sc.nextInt();
			System.out.print("학점?(A~F) ");
			tre[i].cre=sc.next();
			
			
		}
	}
	
	public void total() {
		
		int a,b;
		for(int i=0; i<inwon; i++) {
			
			a= (int)(tre[i].score/10);
			
			switch(tre[i].cre) {
			
			case "A" :
				b = 100;
				break;
			case "B" :
				b = 90;
				break;
			case "C" :
				b = 80;
				break;
			case "D" :
				b = 60;
				break;
			case "E" :
				b = 50;
				break;
			case "F" :
				b = 40;
				break;
			default :
				b = 0;
			}
			
			tre[i].hsc = (a+b)/2;
			if(tre[i].license.equals("o")||tre[i].license.equals("O")) {
				tre[i].hsc= tre[i].hsc + 10;
			}
			
			if (tre[i].hsc>=70) {
				tre[i].yn = "합격";
			}
			else {
				tre[i].yn = "불합격";
			}
		}
		
	}
	
	public void output() {
		for(int i=0; i<inwon; i++) {
			
			System.out.printf("%6S",tre[i].name);
			System.out.printf("%4d",tre[i].age);
			System.out.printf("%4S",tre[i].license);
			System.out.printf("%4d",tre[i].score);
			System.out.printf("%4S",tre[i].cre);
			System.out.printf("%4S",tre[i].hsc);
			System.out.printf("%6S\n",tre[i].yn);
		}
	}

}
