package com.day6;

public class Test3 {

	public static void main(String[] args) {
		
		int[] num = {28,65,7,4,10};
		
		int i,j,temp;
		
		System.out.print("Source Data : ");
		for(i=0;i<num.length;i++) {
			System.out.printf("%4d",num[i]);
		}
		System.out.println();
		
		
		//Bubble Sort
		for(i=1;i<num.length; i++) {
			for(j=0;j<num.length-i; j++) {
				System.out.println(i+" : "+j);
				
				if(num[j]>num[j+1]) {
					
					temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
		}
		
		
		//Ãâ·Â
		System.out.print("Sorted Data : ");
		for(int su : num) {
			System.out.printf("%4d", su);
		}

	}

}
