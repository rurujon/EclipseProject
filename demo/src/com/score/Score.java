package com.score;

import java.util.Scanner;

public class Score {
	
	private int inwon; //stack영역
	Record[] rec; //stack영역
	
	public void set() {
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("인원수?[1~10]");
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		
		//배열 객체 생성
		rec= new Record[inwon];
		
		
	}
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		String[] title = {"국어?", "영어?", "수학?"};
		
		for(int i=0; i<inwon; i++) {
			rec[i] = new Record();

			System.out.println("이름?");//수지
			rec[i].name = sc.next();
			
			for(int j = 0; j<3; j++) {
				
				System.out.println(title[j]);
				rec[i].score[j] = sc.nextInt();
				
				rec[i].tot += rec[i].score[j];
				
			}
			rec[i].ave = rec[i].tot/3;
			

			/*System.out.println("국어?");//30
			rec[i].score[0] = sc.nextInt();

			System.out.println("영어?");//40
			rec[i].score[1] = sc.nextInt();

			System.out.println("수학?");//50
			rec[i].score[2] = sc.nextInt();

			rec[i].tot = rec[i].score[0] + rec[i].score[1] + rec[i].score[2];
			rec[i].ave = rec[i].tot/3;*/
		}
	}

		//------
		
		//석차
		private void ranking() {
			
			int i,j;
			
			for(i=0; i<inwon; i++) {
				rec[i].rank = 1;
				
			}
			
			for(i=0; i<inwon-1; i++) {
				for(j=i+1; j<inwon; j++) {
					
					if(rec[i].tot>rec[j].tot) {
						rec[j].rank++;
					}
					else if(rec[i].tot<rec[j].tot) {
						rec[i].rank++;
					}
				}
			}
		}
		
		public void print() {
			
			ranking();
			for(int i=0; i<inwon; i++) {
				
				System.out.printf("%6s",rec[i].name);//이름\

				
				for(int j=0; j<3; j++) {
					System.out.printf("%4d",rec[i].score[j]);
				}
				
				System.out.printf("%4d", rec[i].tot);
				System.out.printf("%4d", rec[i].ave);
				System.out.printf("%4d\n", rec[i].rank);
			}
		
	}

}
