package com.day15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test1 {

	public static void main(String[] args) {
		
		ArrayList<String> lists = new ArrayList<String>();
		
		lists.add("����");
		lists.add("�λ�");
		lists.add("�뱸");
		
		ListIterator<String> it = lists.listIterator();//iterator�� �޸� ���빰�� ������ ���빰�� �����ִ�.
		while(it.hasNext()) {
			String str = it.next();
			System.out.print(str + " ");
		}
		System.out.println();
		while(it.hasPrevious()) {
			String str = it.previous();
			System.out.print(str + " ");
		}
		
		System.out.println();
		
		List<String> lists1 = new ArrayList<String>();
		lists1.addAll(lists);
		lists1.add("��õ");
		
		for(String s : lists1) {
			System.out.print(s + " ");
		}
		System.out.println();
		Iterator<String> it2 = lists1.iterator();
		while(it.hasNext()) {
			String str = it.next();
			if(str.startsWith("��")) {
				System.out.println(str);
			}
		}
	}

}
