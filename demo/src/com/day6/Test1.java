package com.day6;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		//10�� �̳��� �̸��� ������ �Է¹޾�
		//������ ���� ������� ���� ������� ����(��������)
		
		Scanner sc = new Scanner(System.in);
		
		String[] name;
		int[] score;
		int[] rank;
		
		int inwon, i, j, t1;
		String t2;
		
		do {
			System.out.println("�ο���[1~10]");
			inwon = sc.nextInt();
		}
		while(inwon<1||inwon>10);
		
		//�ο� ����ŭ �迭 ����(�޸� �Ҵ�, �迭 ��ü ����)
		
		name = new String[inwon];
		score = new int[inwon];
		rank = new int[inwon];
		
		for(i=0; i<inwon; i++) {
			
			System.out.println("�̸�?");
			name[i] = sc.next();
			System.out.println("����?");
			score[i]  = sc.nextInt();
		}
		
		//����
		
		//���� �ʱ�ȭ
		for(i=0; i<rank.length; i++) {
			rank[i] = 1;
		}
		
		//���� ���
		
		for(i=0;i<score.length-1; i++) {
			for(j=i+1;j<score.length; j++) {
				
				if(score[i]>score[j]) {
					rank[j]++;
				}
				else if(score[i]<score[j]) {
					rank[i]++;
				}
			}
		}
		
		//����
		for(i=0;i<score.length-1; i++) {
			for(j=i+1;j<score.length; j++) {
				//System.out.println(i + ":" + j);
				if(score[i]<score[j]) {
					t1 =score[i];
					t2 =name[i];
					score[i]=score[j];
					name[i]=name[j];
					score[j]=t1;
					name[j]=t2;
					
					t1=rank[i];
					rank[i] = rank[j];
					rank[j] = t1;
				}
			}
		}
		
		//���
		System.out.printf("%6s %4s %4s\n", "�̸�","����", "����");
		System.out.println("--------------");
		for(i=0; i<inwon; i++) {
			System.out.printf("%6s %4d %4d\n", name[i], score[i], rank[i]);
		}
		sc.close();

	}

}
