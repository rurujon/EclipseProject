package com.day7;

class SubClass{
	
	int a,b;
	
	public void print() {
		System.out.println(a+b);
	}
	
	
}

public class Test2 {

	public static void main(String[] args) {
		
		SubClass ob1 = new SubClass();
		SubClass ob2 = new SubClass();
		
		System.out.println(ob1.a);
		System.out.println(ob1.b);
		
		System.out.println(ob2.a);
		System.out.println(ob2.b);
		
		ob1.a = 10;
		ob1.b = 20;
		
		System.out.println(ob1.a);
		System.out.println(ob1.b);
		
		System.out.println(ob2.a);
		System.out.println(ob2.b);
		
		ob2.a = 100;
		ob2.b = 200;
		
		System.out.println(ob1.a);
		System.out.println(ob1.b);
		
		System.out.println(ob2.a);
		System.out.println(ob2.b);
		
		System.out.println(ob1.a + ob1.b);
		ob1.print();

	}

}
