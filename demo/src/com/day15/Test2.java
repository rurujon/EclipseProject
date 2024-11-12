package com.day15;

import java.util.Hashtable;
import java.util.Iterator;

//Collection Framwork(�����)

//List(I) - ArrayList(C) - ����ȭ ���� �� ��.
//List(I) - Vector(C) - ����ȭ ������.
//�Ϲ������� ArrayList(C)�� ���� ����Ѵ�.


//Map(key,value)
//Map(I) - hashMap(C) - ArrayList�� ����.
//Map(I) - treeMap(C) - Vector�� ����.

//1. Key�� �ߺ����� ���� �� ����.(Set : �������̽�)
//2. Key�� �ߺ����� ������ ������ ���� ����ȴ�.(������ �ȴ�.)
//3. Map�� Iterator�� ����. ������ Set��  Iterator�� ������ �ֱ⿡ �װ� ����Ѵ�.

public class Test2 {
	
	public static final String tel[] = {"111-111","222-222","333-333","111-111","555-555"};//primery key
	public static final String name[] = {"�����","���γ�","�ڽ���","�ڹο�","������"};//primery key

	public static void main(String[] args) {
		
		Hashtable<String, String> h = new Hashtable<String, String>();//key�� �Ϲ������� 8���� �ڷ��� �� �ϳ��� ����Ѵ�.
		
		for(int i=0; i<name.length; i++) {
			h.put(tel[i], name[i]);
		}
		System.out.println(h);//���� ����� �� �ڱ⸸�� ����� �ִ�. �� �� ���� ���� ����� ä�õǾ� ���´�.
		
		String str = "";
		str=h.get("111-111");//key�� �ָ� value�� ���´�.
		if(str==null) {
			System.out.println("�ڷ� ����!");
		}else {
			System.out.println(str);
		}
		
		if(h.containsKey("222-222")){
			System.out.println("222-222 ����.");
			
		}
		if(h.contains("�ڹο�")) {//containsValue
			System.out.println("����.");
		}
		
		h.remove("222-222");
		if(h.containsKey("222-222")) {
			System.out.println("222-222 ����.");
		}else {
			System.out.println("222-222 ����.");
		}
		
		Iterator<String> it = h.keySet().iterator();
		
		while(it.hasNext()) {
			String Key = it.next();
			String value = h.get(Key);
			
			System.out.println(Key + ":" + value);
		}
	}

}
