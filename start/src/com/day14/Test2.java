package com.day14;

import java.util.Iterator;
import java.util.Vector;

public class Test2 {
	
	private static final String city[] = {"����","�λ�","�뱸","��õ","����","����","���"};

	
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
		//�ݺ���
		Iterator<String> it = v.iterator();
		
		while(it.hasNext()) {
			
			str = it.next();
			System.out.print(str + " ");
		}	//�� �� ����� it���� �����Ͱ� ����.
		//��� ������Ϸ��� ���� it2�� ���� �����͸� ���� �Ѵ�..
		System.out.println();
		
		while(it.hasNext()) {
			
			str = it.next();
			System.out.print(str + " ");
		}
		System.out.println();
		
		
	}

}
