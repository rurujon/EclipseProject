package com.day14;

import java.util.ArrayList;

class Test{
	String name;
	int age;
}


public class Test4 {

	public static void main(String[] args) {
		
		ArrayList<Test> lists = new ArrayList<Test>();
		//Test[] list = new Test[3];
		
		Test ob = new Test();
		ob.name = "�ڹο�";
		ob.age = 38;
		lists.add(ob);
		
		ob=new Test();
		ob.name = "���ҹ�";
		ob.age = 35;
		lists.add(ob);
		
		for(Test t : lists) {
			System.out.println(t.name + " : " + t.age);
		}
		
		
		

	}

}
