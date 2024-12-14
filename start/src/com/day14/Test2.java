package com.day14;

import java.util.Iterator;
import java.util.Vector;

public class Test2 {
	
	private static final String city[] = {"서울","부산","대구","인천","광주","대전","울산"};

	
	public static void main(String[] args) {
		
		Vector<String> v = new Vector<String>();
		
		for(String c : city) {
			v.add(c);
		}
		
		System.out.println(v);
		
		String str;
		str = v.firstElement();
		System.out.println(str);
		
		str = v.lastElement();
		System.out.println(str);
		
		str = v.get(3);
		System.out.println(str);
		
		for(int i=0; i<v.size(); i++) {
			System.out.print(v.get(i) + " ");
		}
		System.out.println();
		//------------- 
		for(String c : v) {
			System.out.print(c+" ");
		}
		
		System.out.println();
		//----------------
		//반복자
		Iterator<String> it = v.iterator();
		
		while(it.hasNext()) {
			
			str = it.next();
			System.out.print(str + " ");
		}	//한 번 찍고나면 it에는 데이터가 없다.
		//고로 재실행하려면 새로 it2를 만들어서 데이터를 얻어야 한다..
		System.out.println();
		
		while(it.hasNext()) {
			
			str = it.next();
			System.out.print(str + " ");
		}
		System.out.println();
		
		
	}

}
