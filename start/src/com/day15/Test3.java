package com.day15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Test3 {

	public static void main(String[] args) {
		
		//Set : 중복값을 허용하지 않음.
		Set<String> s = new HashSet<String>();
		s.add("서울");
		s.add("부산");
		s.add("대구");
		
		System.out.println(s);//[서울, 부산, 대구]
		
		s.add("서울");
		
		System.out.println(s);//[서울, 부산, 대구] : 중복값을 허용하지 않고 기존에 덮어씌운다.
		
		System.out.println("------------");
		
		Stack<String> st = new Stack<String>();
		st.push("서울");
		st.add("부산");
		st.push("대구");
		
		while(!st.empty()) {//데이터가 없지 않다면, 즉 있을 때까지 반복하라.
			System.out.println(st.pop()+" ");
			
		}
		System.out.println();
		
		Queue<String> q = new LinkedList<String>();
		q.offer("서울");
		q.offer("부산");
		q.add("대구");
		
		while(q.peek()!=null) {
			System.out.println(q.poll()+" ");
		}
		System.out.println();
		
		List<String> lists1 = new LinkedList<String>();
		lists1.add("A");
		lists1.add("B");
		lists1.add("C");
		lists1.add("D");
		lists1.add("E");
		lists1.add("F");
		lists1.add("G");
		lists1.add("H");
		lists1.add("I");
		
		List<String> lists2 = new LinkedList<String>();
		lists2.add("서울");
		lists2.add("부산");
		lists2.add("대구");
		
		lists2.addAll(lists1);
		
		System.out.println("lists1....");
		for(String ss : lists1) {
			System.out.print(ss + " ");
		}
		System.out.println();
		System.out.println("lists2....");
		for(String ss : lists2) {
			System.out.print(ss + " ");
		}
		
		lists2.subList(2,5).clear();//삭제.
		System.out.println();
		System.out.println("lists2....");
		for(String ss : lists2) {
			System.out.print(ss + " ");
		}
		System.out.println();
		String[] str= {"가","나","다","라","마","바"};
		for(String ss : str) {
			System.out.print(ss + " ");
		}
		System.out.println();
		
		Arrays.sort(str);//정렬
		for(String ss : str) {
			System.out.print(ss + " ");
		}
		System.out.println();

	}

}
