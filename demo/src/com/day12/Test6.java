package com.day12;

//Singleton
//객체를 여러번 생성하는 것이 아니라 하나의 객체만 생성하고 공유해서 사용하는 방법
//만들어서 쓸 일은 없고 가져다 쓴다.
//ex : Calendar now = new Calendar.getInstance();
//static과 call by reference

class Sing{
	
	private static Sing ob; 
	
	static Sing getInstance() {
		if(ob==null) {
			
			ob=new Sing();
		}
		
		return ob;
	}
}

public class Test6 {

	public static void main(String[] args) {
		
		Sing ob1 = Sing.getInstance();
		Sing ob2 = Sing.getInstance();
		
		if(ob1==ob2) {
			System.out.println("동일한 객체");
		}
		else {
			System.out.println("동일하지 않은 객체");
		}

	}

}
