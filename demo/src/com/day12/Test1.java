package com.day12;

//wrapper 클래스
//자료형의 종류
//boolean, byte, char, short, int, long, float, double
//위의 자료형과 똑같은 형태의 클래스
//래퍼런스 자료형
//Boolean, Byte, Character, Short, Integer, Long, Float, Double

//Auto-Boxing : stack ㅡ> heap
//Auto-unboxing : heap ㅡ> stack
//같은 데이터 영역 사이에서의 움직임.

public class Test1 {

	public static void main(String[] args) {
		
		int n1 = 10;
		int n2;
		
		Integer num1;
		Integer num2 = new Integer(20);
		
		//Auto-Boxing
		num1 = n1;
		//Auto-Unboxing
		n2 = num2;
		
		System.out.println(n1 + ":" + num1);
		System.out.println(n2 + ":" + num2);

	}

}

/* 형변환(casting)

int a = 10;
float b;

b=a;  O : 암시적 형변환(굳이 변환하지 않아도 작은 건 큰 거 안에 잘 들어간다)
b=(float)a;  O : 명시적 형변환(자료형 변환하면 당연히 들어간다.)

a=b;  X : 암시적 형변환 불가능
a=(int)b  O : 명시적 형변환

-----------------------

상속
부모(b) - 자식(a)

부모(b) = 자식(a) UPCAST(0) : 자식을 부모화 시키는 작업
부모(b) = (부모)자식(a) UPCAST(0)

자식(a) = 부모(b)  (X)
자식(a) = (자식)부모(b) DOWNCAST(0) 

*/