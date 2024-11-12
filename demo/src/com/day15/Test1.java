package com.day15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test1 {

	public static void main(String[] args) {
		
		ArrayList<String> lists = new ArrayList<String>();
		
		lists.add("서울");
		lists.add("부산");
		lists.add("대구");
		
		ListIterator<String> it = lists.listIterator();//iterator와 달리 내용물을 꺼내도 내용물이 남아있다.
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
		lists1.add("인천");
		
		for(String s : lists1) {
			System.out.print(s + " ");
		}
		System.out.println();
		Iterator<String> it2 = lists1.iterator();
		while(it.hasNext()) {
			String str = it.next();
			if(str.startsWith("서")) {
				System.out.println(str);
			}
		}
	}

}
