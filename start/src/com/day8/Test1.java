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
		
		System.out.println("������ : " + this.r);
		System.out.println("���� : " + area);
	}
}

public class Test1 {

	public static void main(String[] args) {
		
		Circle ob = new Circle();	//Ŭ������ �ڷ����̴�.
		//ob.r = 30
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������?");
		int r = sc.nextInt();
		
		
		ob.set(r); 				//ob.set(r,ob)
		double a = ob.area();	//ob.area(ob)
		ob.write(a);			//write(a,ob)

	}


}
