package com.day20;

//class Ŭ����
//Ư�� Ŭ������ �������̽��� ���� ������ �˻��� �� �ִ� �޼ҵ带 �����ϰ� �ִ�.

class Test{
	
	public void write() {
		System.out.println("�׽�Ʈ...");
	}
}

public class Test2 {

	public static void main(String[] args) throws Exception {
		
		//Test ob = new Test();
		//ob.write();
		
		Class c = Class.forName("com.day20.Test");	//Web�� DB������ �� ����Ѵ�.
		
		Object ob = c.newInstance();
		
		Test t = (Test)ob;
		
		t.write();

	}

}
