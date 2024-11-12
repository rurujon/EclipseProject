package com.day10;

//Object Class
//자바에 있는 모든 클래스와 앞으로 만들어질 모든 클래스의 부모클래스.

//자바에서 가장 큰 자료형이다.

class SuperTest{
	
	private int a = 10;
	public void write() {
		System.out.println("a : " + a);
	}
}

public class Test6 {

	public static void main(String[] args) {
				
		SuperTest ob1 = new SuperTest();
		SuperTest ob2 = new SuperTest();
		
		
		System.out.println("ob1==ob2: " + (ob1==ob2));
		System.out.println("ob1.equals(ob2): " + ob1.equals(ob2));
		
		System.out.println("ob1 : " + ob1);//com.day10.SuperTest@15db9742 : @~ 해시태그
		System.out.println("ob1 : " + ob1.toString());
		System.out.println("ob2 : " + ob2.toString());
	}

}
