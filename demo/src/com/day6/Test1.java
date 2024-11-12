package com.day6;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		//10명 이내의 이름과 점수를 입력받아
		//점수가 높은 사람에서 낮은 사람으로 정렬(내림차순)
		
		Scanner sc = new Scanner(System.in);
		
		String[] name;
		int[] score;
		int[] rank;
		
		int inwon, i, j, t1;
		String t2;
		
		do {
			System.out.println("인원수[1~10]");
			inwon = sc.nextInt();
		}
		while(inwon<1||inwon>10);
		
		//인원 수만큼 배열 생성(메모리 할당, 배열 객체 생성)
		
		name = new String[inwon];
		score = new int[inwon];
		rank = new int[inwon];
		
		for(i=0; i<inwon; i++) {
			
			System.out.println("이름?");
			name[i] = sc.next();
			System.out.println("점수?");
			score[i]  = sc.nextInt();
		}
		
		//연산
		
		//석차 초기화
		for(i=0; i<rank.length; i++) {
			rank[i] = 1;
		}
		
		//석차 계산
		
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
		
		//연산
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
		
		//출력
		System.out.printf("%6s %4s %4s\n", "이름","점수", "석차");
		System.out.println("--------------");
		for(i=0; i<inwon; i++) {
			System.out.printf("%6s %4d %4d\n", name[i], score[i], rank[i]);
		}
		sc.close();

	}

}
