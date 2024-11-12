package com.day13;

//내부 클래스(static)

class Outer3{
	
	static int a = 10;
	int b = 20;
	
	public static class Inner3{	//static으로 먼저 객체생성이 되어 올라가 있다.
		
		int c = 30;
		
		public void write() {
			
			System.out.println(a);
			//System.out.println(b);
			System.out.println(c);
			
			Outer3 o = new Outer3();
			System.out.println("o.b : " + o.b);	//내부에서 외부를 객체생성이 가능하다.
		}
		
	}
}

public class Test6 {

	public static void main(String[] args) {
		
		Outer3 ob = new Outer3();
		Outer3.Inner3 in = new Outer3.Inner3();
		in.write();
		

	}

}
