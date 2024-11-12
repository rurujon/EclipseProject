package com.day12;

import java.util.Scanner;

abstract class SortInt{
	
	private int[] value;
	
	protected abstract void sorting();// 추상 메서드
	
	public void sort(int[] value) {
		this.value=value;
		
		sorting();
	}
	
	public int length() {
		if (value==null) {
			
			return 0;
		}
		return value.length;//5
	}
	
	protected final int compare(int i, int j) {
		
		if(value[i]==value[j]) {
			return 0;
		}
		else if(value[i]>value[j]) {
			return 1;
			
		}
		else {
			return -1;
		}
		
	}
	
	protected final void swap(int i, int j) {
		
		int temp;
		temp = value[i];
		value[i] = value[j];
		value[j] = temp;
		
	}
	
	public void print() {
		
		if(value==null) {
			
			if(value == null) {
				return;
			}
		}
		
		for(int n : value) {
			System.out.printf("%4d",n);
		}
		System.out.println();
	}
	
}

class SortTest extends SortInt{

	@Override
	protected void sorting() {
		
		//Selection Sort
		for(int i=0; i<length()-1; i++) {
			
			for(int j=i+1; j<length(); j++) {
				
				if(compare(i, j)>0) {
					swap(i,j);
					
				}	
			}	
		}	
	}	
}

public class Test9 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] data = new int[5];
		
		System.out.println("다섯 개의 정수?");
		for(int i=0; i<data.length; i++) {
			data[i] = sc.nextInt();
		}
		
		SortTest ob = new SortTest();
		
		ob.sort(data);
		ob.print();

	}

}
