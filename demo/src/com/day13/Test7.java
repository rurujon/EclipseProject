package com.day13;

//내부 클래스(익명의,Annonymus,무명의 클래스)

public class Test7 {
	
	public Object getTitle() {
		
		//return "무명의";
		
		return new Object() {	//이름이 없다. 주로 추상클래스, 혹은 인터페이스다.
			
			@Override
			public String toString() {
				return "무명의 클래스";
			}
		};
	}

	public static void main(String[] args) {
		
		Test7 ob = new Test7();
		
		Object o = ob.getTitle();
		System.out.println(o);

	}

}
