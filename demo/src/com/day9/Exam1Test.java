package com.day9;

import java.util.Scanner;

public class Exam1Test {
	
	private int inwon;//�ʵ�
	Record[] rec;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ο���?");
		inwon = sc.nextInt();
		rec = new Record[inwon];
	}
	
	public void score() {
		Scanner sc = new Scanner(System.in);
		String[] str = {"����? ","����? ","����? "};
		for(int i=0; i<inwon; i++) {
			rec[i] = new Record();
			System.out.print("�̸�? ");
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
					rec[i].grade[j] = "��";
				}
				else if(rec[i].score[j]>60) {
					rec[i].grade[j] = "��";
				}
				else if(rec[i].score[j]>40) {
					rec[i].grade[j] = "��";
				}
				else if(rec[i].score[j]>20) {
					rec[i].grade[j] = "��";
				}
				else if(rec[i].score[j]>0) {
					rec[i].grade[j] = "��";
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
