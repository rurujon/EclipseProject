package com.day14;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class Test3 {
	
	private static final String city[] = {"서울","부산","대구","인천","광주","대전","울산"};

	public static void main(String[] args) {
		
		Vector<String> lists = new Vector<String>();
		
		System.out.println("초기 용량 : " + lists.capacity());
		
		for(String c : city) {
			lists.add(c);
		}
		
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		System.out.println("데이터의 갯수 : " + lists.size() + "개");
		
		//수정
		lists.set(0, "Seoul");
		lists.set(1, "Pusan");
		
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//삽입
		lists.insertElementAt("대한민국", 0);
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//검색
		int index = lists.indexOf("대구");	//indexOf 검색값이 없으면 -1을 반환.
		if(index!=-1) {
			System.out.println("검색 성공 : " + index);
		}
		else {
			System.out.println("검색 실패 : " + index);
		}
		
		//오름차순
		Collections.sort(lists);	
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//내림차순
		Collections.sort(lists, Collections.reverseOrder());
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//삭제
		lists.remove("Pusan"); //lists.remove(7);
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		
		//용량 증가
		for(int i = 1; i<=20; i++) {
			lists.add(Integer.toString(i));
		}
		System.out.println("현재 용량 : " + lists.capacity());
		System.out.println("데이터의 갯수 : " + lists.size() + "개");
		
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//특정 범위 삭제
		for(int i =1; i<=10; i++) {
			lists.remove(5);
		}
		System.out.println("현재 용량 : " + lists.capacity());
		System.out.println("데이터의 갯수 : " + lists.size() + "개");
		
		for(String c : lists) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//공간 삭제
		lists.trimToSize();
		System.out.println("현재 용량 : " + lists.capacity());
		System.out.println("데이터의 갯수 : " + lists.size() + "개");
		
		//데이터 삭제
		lists.clear();
		System.out.println("현재 용량 : " + lists.capacity());
		System.out.println("데이터의 갯수 : " + lists.size() + "개");

	}

}
