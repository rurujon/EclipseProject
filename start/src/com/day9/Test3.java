package com.day9;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.sql.Connection;
import java.util.Scanner;

//생성자
//메모리 할당을 받을 때 사용
//클래스의 이름과 동일하다
//리턴값이 없기 때문에 property가 없다.
//중복정의가 가능하다.
//생성자 안에서 생성자를 호출 가능하다
//단 맨 선두에서 한 번만 호출 가능하다.


public class Test3 {

	private int x;
	
	public Test3() {
		
		this(40);//this는 코딩 맨 선두에만 생성가능, 중복 불가.
		System.out.println("기본 생성자");
		//x=10;
		System.out.println("x: " + x);
		
	}
	
	public void set(int x) {
		this.x = x;
	}
	
	public void print() {
		System.out.println("x: " + x);
	}
	
	public Test3(int x) {
		
		
		System.out.println("오버로딩된 생성자");
		this.x = x;
		//System.out.println("x : " + this.x);
		//System.out.println("x : " + x);
	}
	
	public static void main(String[] args) {
		
		Test3 ob1 = new Test3();
		ob1.set(10);
		ob1.print();
		

		Test3 ob2 = new Test3(20);
		ob2.print();

	}
	
	

}
