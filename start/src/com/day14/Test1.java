package com.day14;

import java.util.Iterator;
import java.util.Vector;

//Collection Framwork(방법론)
//List(I) - ArrayList(C) - 동기화 지원 안 함.
//List(I) - Vector(C) - 동기화 지원함.
//일반적으로 ArrayList(C)를 많이 사용한다.


//Map(I) - hashMap(C) - ArrayList와 동일.
//Map(I) - treeMap(C) - Vector와 동일.

//배열의 단점 : 한 번 만들면 사이즈를 늘리지도 줄이지도 못한다.
//그 배열의 단점을 커버한 게 Collection이다.
//Collection의 기본 디폴트는 Object다.

public class Test1 {

	public static void main(String[] args) {
		
		//<> Generic
		Vector v = new Vector();
		
		v.add("서울");//upcast
		v.add("부산");
		v.add(30);
		v.add('A');
		
		
		String str;
		str = (String)v.get(0);
		System.out.println(str);
		
		Integer i;
		i=(Integer)v.get(2);
		System.out.println(i.toString());
		
		char c;
		c= (char)v.get(3);
		System.out.println(c);
		
		Iterator it = v.iterator();
		while(it.hasNext()) {
			Object ob = it.next();
			
			if(ob instanceof String) {//instanceof 자료형이 맞는가 비교하는 명령어
				str = (String)ob;
				System.out.println(str);
			}
			else if(ob instanceof Integer) {
				i=(Integer)ob;
				System.out.println(i.toString());
			}
			else if(ob instanceof Character) {
				c = (char)ob;
				System.out.println(c);
			}
		}

	}

}
