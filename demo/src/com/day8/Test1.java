package com.day8;

import java.util.Scanner;

//this : Me, Class, Circle
class Circle{
	
	private int r=10;
	
	public void set(int r) {//set(int r, Circle this)
		this.r = r;
	}
	public double area() {//area(Circle this)
		
		return this.r*this.r*3.14;
	}
	public void write(double area) {//write(double area, Circle this)
		
		System.out.println("반지름 : " + this.r);
		System.out.println("넓이 : " + area);
	}
}

public class Test1 {

	public static void main(String[] args) {
		
		Circle ob = new Circle();	//클래스는 자료형이다.
		//ob.r = 30
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("반지름?");
		int r = sc.nextInt();
		
		
		ob.set(r); 				//ob.set(r,ob)
		double a = ob.area();	//ob.area(ob)
		ob.write(a);			//write(a,ob)

	}


}
