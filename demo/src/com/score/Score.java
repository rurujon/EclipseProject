package com.score;

import java.util.Scanner;

public class Score {
	
	private int inwon; //stack����
	Record[] rec; //stack����
	
	public void set() {
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("�ο���?[1~10]");
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		
		//�迭 ��ü ����
		rec= new Record[inwon];
		
		
	}
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		String[] title = {"����?", "����?", "����?"};
		
		for(int i=0; i<inwon; i++) {
			rec[i] = new Record();

			System.out.println("�̸�?");//����
			rec[i].name = sc.next();
			
			for(int j = 0; j<3; j++) {
				
				System.out.println(title[j]);
				rec[i].score[j] = sc.nextInt();
				
				rec[i].tot += rec[i].score[j];
				
			}
			rec[i].ave = rec[i].tot/3;
			

			/*System.out.println("����?");//30
			rec[i].score[0] = sc.nextInt();

			System.out.println("����?");//40
			rec[i].score[1] = sc.nextInt();

			System.out.println("����?");//50
			rec[i].score[2] = sc.nextInt();

			rec[i].tot = rec[i].score[0] + rec[i].score[1] + rec[i].score[2];
			rec[i].ave = rec[i].tot/3;*/
		}
	}

		//------
		
		//����
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
				
				System.out.printf("%6s",rec[i].name);//�̸�\

				
				for(int j=0; j<3; j++) {
					System.out.printf("%4d",rec[i].score[j]);
				}
				
				System.out.printf("%4d", rec[i].tot);
				System.out.printf("%4d", rec[i].ave);
				System.out.printf("%4d\n", rec[i].rank);
			}
		
	}

}
