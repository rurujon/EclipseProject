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
		
		//Set : �ߺ����� ������� ����.
		Set<String> s = new HashSet<String>();
		s.add("����");
		s.add("�λ�");
		s.add("�뱸");
		
		System.out.println(s);//[����, �λ�, �뱸]
		
		s.add("����");
		
		System.out.println(s);//[����, �λ�, �뱸] : �ߺ����� ������� �ʰ� ������ ������.
		
		System.out.println("------------");
		
		Stack<String> st = new Stack<String>();
		st.push("����");
		st.add("�λ�");
		st.push("�뱸");
		
		while(!st.empty()) {//�����Ͱ� ���� �ʴٸ�, �� ���� ������ �ݺ��϶�.
			System.out.println(st.pop()+" ");
			
		}
		System.out.println();
		
		Queue<String> q = new LinkedList<String>();
		q.offer("����");
		q.offer("�λ�");
		q.add("�뱸");
		
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
		lists2.add("����");
		lists2.add("�λ�");
		lists2.add("�뱸");
		
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
		
		lists2.subList(2,5).clear();//����.
		System.out.println();
		System.out.println("lists2....");
		for(String ss : lists2) {
			System.out.print(ss + " ");
		}
		System.out.println();
		String[] str= {"��","��","��","��","��","��"};
		for(String ss : str) {
			System.out.print(ss + " ");
		}
		System.out.println();
		
		Arrays.sort(str);//����
		for(String ss : str) {
			System.out.print(ss + " ");
		}
		System.out.println();

	}

}
