package com.day6;

import java.util.Random;

public class Test2 {

	public static void main(String[] args) {

		//1~45까지의 수 중 6개의 난수를 발생시켜 크기순으로 정렬

		Random rd = new Random();

		int num[] = new int[6];
		int i,n;

		n=0;

		while(n<6) {
			num[n] = rd.nextInt(45)+1;
			for(i=0;i<n;i++){

				if(num[i]==num[n]) {
					n--;
					break;
				}

			}
			n++;
		}
		for(int su : num) {

			System.out.printf("%4d", su);
		}

	}

}
