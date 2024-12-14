package com.day4;

public class Exam4 {

	public static void main(String[] args) {
		
		int i ,j, k;
		
		
		for(k=2; k<=9; k=k+4) {
			for(j=1; j<=9; j++) {
			
				for(i=k; i<=k+3; i++) {
				
					int sum = i*j;
				
					System.out.print(i + "*" + j + "=" + sum + "\t");
				
				}
			
				System.out.println();
			
			
			}
			
			System.out.println();
		
		}
		
		System.out.println();
		
		

	}

}
