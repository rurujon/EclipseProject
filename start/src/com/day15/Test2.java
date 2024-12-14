package com.day15;

import java.util.Hashtable;
import java.util.Iterator;

//Collection Framwork(방법론)

//List(I) - ArrayList(C) - 동기화 지원 안 함.
//List(I) - Vector(C) - 동기화 지원함.
//일반적으로 ArrayList(C)를 많이 사용한다.


//Map(key,value)
//Map(I) - hashMap(C) - ArrayList와 동일.
//Map(I) - treeMap(C) - Vector와 동일.

//1. Key는 중복값을 가질 수 없다.(Set : 인터페이스)
//2. Key가 중복값을 가지면 마지막 값이 저장된다.(수정이 된다.)
//3. Map은 Iterator가 없다. 하지만 Set이  Iterator를 가지고 있기에 그걸 사용한다.

public class Test2 {
	
	public static final String tel[] = {"111-111","222-222","333-333","111-111","555-555"};//primery key
	public static final String name[] = {"배수지","유인나","박신혜","박민영","서예지"};//primery key

	public static void main(String[] args) {
		
		Hashtable<String, String> h = new Hashtable<String, String>();//key는 일반적으로 8개의 자료형 중 하나를 사용한다.
		
		for(int i=0; i<name.length; i++) {
			h.put(tel[i], name[i]);
		}
		System.out.println(h);//맵은 출력할 때 자기만의 방식이 있다. 그 중 가장 빠른 방식이 채택되어 나온다.
		
		String str = "";
		str=h.get("111-111");//key를 주면 value가 나온다.
		if(str==null) {
			System.out.println("자료 없음!");
		}else {
			System.out.println(str);
		}
		
		if(h.containsKey("222-222")){
			System.out.println("222-222 있음.");
			
		}
		if(h.contains("박민영")) {//containsValue
			System.out.println("있음.");
		}
		
		h.remove("222-222");
		if(h.containsKey("222-222")) {
			System.out.println("222-222 있음.");
		}else {
			System.out.println("222-222 없음.");
		}
		
		Iterator<String> it = h.keySet().iterator();
		
		while(it.hasNext()) {
			String Key = it.next();
			String value = h.get(Key);
			
			System.out.println(Key + ":" + value);
		}
	}

}
