package com.day2;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//float , double
		float f=0; //0.0
		double d=0;  //0.0
		
		System.out.println(f);
		System.out.println(d);
		
		
		for(int i=1; i<=1000; i=i+1){
			//i++ = i=i+1
			
			System.out.println("¼öÁö");
			
			f = f + 100000;
			d = d + 100000;
			
		}
		
		System.out.println("float :  " + (f/10000));
		System.out.println("double : " + (d/10000));
		
	}

}
