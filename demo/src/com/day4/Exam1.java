package com.day4;

public class Exam1 {

	public static void main(String[] args) {
		
		int i;
		int asum=0, bsum=0, total=0;
		
		for(i=1; i<=50; i++) {
			asum = asum + (2*i-1);
		}
		
		for(i=1; i<=50; i++) {
			bsum = bsum + 2*i;
		}
		
		total = asum + bsum;
		
		System.out.printf("È¦¼ö ÇÕ %d, Â¦¼ö ÇÕ %d, ÃÑÇÕ %d", asum, bsum, total);

	}

}
