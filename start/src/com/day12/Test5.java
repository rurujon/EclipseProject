package com.day12;

class Test{
	protected int a=10, b=20;
	
	public void write() {
		
		System.out.println("부모클래스 write()...");;
		
		System.out.println("a :" + a +",b:" + b);
	}
}

class Demo extends Test{
	
	protected int b=30, c=40;
	
	@Override
	public void write() {
		
		System.out.println("자식 클래스 write()...");
		System.out.println("a: "+ a +", b:" + b + ", c:" + c);
		
		
	}
	
	public void print1() {
		System.out.println("자식 클래스 print1()...");
		write();
		
	}
	
	public void print2() {
		System.out.println("자식 클래스 print2()...");
		super.write();//부모꺼를 반드시 쓰고 싶을땐 super.을 쓴다.
	}
	
	
}

public class Test5 {

	public static void main(String[] args) {
		
Demo ob = new Demo();
		
		ob.write();
		ob.print1();
		ob.print2();
		
		System.out.println(ob.b);
		System.out.println("((Test)ob).b: " + ((Test)ob).b); //자식을 부모로 형변환(UPCAST)
		
		((Test)ob).write();//upcast 하지만 메소드는 반드시 본인 것을 사용한다.

	}

}
