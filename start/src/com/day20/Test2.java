package com.day20;

//class 클래스
//특정 클래스나 인터페이스에 관한 정보를 검색할 수 있는 메소드를 포함하고 있다.

class Test{
	
	public void write() {
		System.out.println("테스트...");
	}
}

public class Test2 {

	public static void main(String[] args) throws Exception {
		
		//Test ob = new Test();
		//ob.write();
		
		Class c = Class.forName("com.day20.Test");	//Web의 DB연결할 때 사용한다.
		
		Object ob = c.newInstance();
		
		Test t = (Test)ob;
		
		t.write();

	}

}
