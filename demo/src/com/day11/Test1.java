package com.day11;

//String은 class이다.(자료형이 아니다.)
//사용빈도는 높고 저장되는 데이터의 양은 크기 때문에
//자료형처럼 사용하는 것이다.
//String의 데이터는 불변의 원칙을 가지고 있다.
//String 데이터는 equals로 비교한다.

public class Test1 {

	public static void main(String[] args) {
		
		String ob1 = "Seoul";
		String ob2 = "Seoul";
		String ob3 = new String("Seoul");
		
		System.out.println("ob1==ob2 : " + (ob1==ob2));//true : (Call By Reference) heap 영역의 데이터가 동일하기에 주소가 복사된다
		System.out.println("ob1==ob3 : " + (ob1==ob3));//false : new로 복사가 되기 때문에 주소 또한 다르다.
		System.out.println("ob1.equals(ob3): " + ob1.equals(ob3));//true : 주소가 아닌 데이터를 비교.
		
		ob2 = "korea";
		System.out.println("ob1==on2 : " + (ob1==ob2));//false : 주소번지가 새로 만들어진다.
		System.out.println(ob2);
		System.out.println(ob1.equals(ob2));
		
		ob2 = "japan";
		System.out.println("ob1==on2 : " + (ob1==ob2));//false :
		System.out.println(ob2);
		System.out.println(ob1.equals(ob2));
		
		ob2 = "Seoul";
		System.out.println("ob1==on2 : " + (ob1==ob2));//true :
		System.out.println(ob2);
		System.out.println(ob1.equals(ob2));
		
		System.out.println(ob2);
		System.out.println(ob2.toString());
		System.out.println(ob3);

	}

}
