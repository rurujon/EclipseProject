package com.day14;

import java.util.Iterator;
import java.util.Vector;

//Collection Framwork(�����)
//List(I) - ArrayList(C) - ����ȭ ���� �� ��.
//List(I) - Vector(C) - ����ȭ ������.
//�Ϲ������� ArrayList(C)�� ���� ����Ѵ�.


//Map(I) - hashMap(C) - ArrayList�� ����.
//Map(I) - treeMap(C) - Vector�� ����.

//�迭�� ���� : �� �� ����� ����� �ø����� �������� ���Ѵ�.
//�� �迭�� ������ Ŀ���� �� Collection�̴�.
//Collection�� �⺻ ����Ʈ�� Object��.

public class Test1 {

	public static void main(String[] args) {
		
		//<> Generic
		Vector v = new Vector();
		
		v.add("����");//upcast
		v.add("�λ�");
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
			
			if(ob instanceof String) {//instanceof �ڷ����� �´°� ���ϴ� ��ɾ�
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
