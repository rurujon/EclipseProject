package com.day9;

import java.util.Scanner;

public class Exam1Test {
	
	private int inwon;//필드
	Record[] rec;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("인원수?");
		inwon = sc.nextInt();
		rec = new Record[inwon];
	}
	
	public void score() {
		Scanner sc = new Scanner(System.in);
		String[] str = {"국어? ","영어? ","수학? "};
		for(int i=0; i<inwon; i++) {
			rec[i] = new Record();
			System.out.print("이름? ");
			rec[i].name = sc.next();
			for(int j=0; j<3; j++) {
				System.out.printf("%s",str[j]);
				rec[i].score[j] = sc.nextInt();
			}
			
		}
	}
	
	private void panjung() {
		for(int i=0; i<inwon; i++) {
			for(int j=0; j<3; j++) {
				if(rec[i].score[j]>80) {
					rec[i].grade[j] = "수";
				}
				else if(rec[i].score[j]>60) {
					rec[i].grade[j] = "우";
				}
				else if(rec[i].score[j]>40) {
					rec[i].grade[j] = "미";
				}
				else if(rec[i].score[j]>20) {
					rec[i].grade[j] = "양";
				}
				else if(rec[i].score[j]>0) {
					rec[i].grade[j] = "가";
				}
			}
		}
		
	}
	
	public void output() {
		
		panjung();
		for(int i=0; i<inwon; i++) {
			System.out.print(rec[i].name + "\t");
			for(int j=0; j<3; j++) {
				System.out.print(rec[i].score[j] + "(" +  rec[i].grade[j] + ")" + "\t");
			}
			System.out.println();
		}
	}

}
