package com.score3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ScoreImpl implements Score{
	
	//private Map<String, ScoreVO> hMap = new HashMap<String, ScoreVO>();
	private Map<String, ScoreVO> hMap = new TreeMap<String, ScoreVO>();
	
	Scanner sc = new Scanner(System.in);
	String hak;

	@Override
	public void input() {
		
		System.out.println("학번?");
		hak = sc.next();
		
		if(searchHak(hak)) {
			System.out.println("학번이 이미 있습니다.");
			return;
		}
		ScoreVO vo = new ScoreVO();
		
		System.out.print("이름? ");
		vo.setName(sc.next());
		
		System.out.print("국어?");
		vo.setKor(sc.nextInt());
		System.out.print("영어?");
		vo.setEng(sc.nextInt());
		System.out.print("수학?");
		vo.setMat(sc.nextInt());
		
		hMap.put(hak, vo);
		
		System.out.println("추가 성공 \n");
		
	}

	@Override
	public boolean searchHak(String Hak) {
		
		if(hMap.containsKey(hak)) {
			return true;//학번이 이미 있다면 뒤를 실행하지 않고 종료
		}
		else {
		return false;
		}
	}

	@Override
	public void print() {
		
		Iterator<String> it = hMap.keySet().iterator();
		while(it.hasNext()) {
			String hak = it.next();
			ScoreVO vo = hMap.get(hak);
			
			System.out.println(hak + " " + vo.toString());
		}
	}
	
	@Override
	public void update() {
		
		System.out.println("수정할 학번?");
		hak = sc.next();
		
		if(hMap.containsKey(hak)) {
		
			ScoreVO vo = hMap.get(hak);

			System.out.println("수정할 범위 선택, 1:전부, 2:학번만. 3.점수만.");
			int choose = sc.nextInt();

			switch (choose) {
			case 1 : 
				hMap.remove(hak);
				input();

				System.out.println("수정되었습니다.");
				break;

			case 2 : System.out.println("수정할 학번 입력.");
				String newhak = sc.next();

				hMap.remove(hak);
				hMap.put(newhak, vo);

				System.out.println("수정되었습니다.");
				break;
			
			case 3 : 
				System.out.print("국어?");
				vo.setKor(sc.nextInt());
				System.out.print("영어?");
				vo.setEng(sc.nextInt());
				System.out.print("수학?");
				vo.setMat(sc.nextInt());
				System.out.println("수정되었습니다.");
				break;

			default:
				break;
			}
		}
		else {
			System.out.println("학번이 검색되지 않습니다.");
		}
		 //----------------------------
		/*if(hMap.containsKey(hak)) {
			hMap.remove(hak);
			input();
			
		}
		else {
			System.out.println("수정할 학번이 존재하지 않습니다.");
		}
		*/
		
		//선생님 예시.
		/*System.out.println("수정할 학번?");
		hak = sc.next();
		
		if(!searchHak(hak)) {
			System.out.println("수정할 학번이 없습니다.");
			return;
		}
		/*-------------------------------------
		//방법 1
		ScoreVO preVO = hMap.get(hak);
		ScoreVO vo = new ScoreVO();
		
		vo.setName(preVO.getName());
		System.out.print("국어?");
		vo.setKor(sc.nextInt());
		System.out.print("영어?");
		vo.setEng(sc.nextInt());
		System.out.print("수학?");
		vo.setMat(sc.nextInt());
		
		hMap.put(hak, vo);
		--------------------------------------------------
		//방법2
		ScoreVO vo = hMap.get(hak);
		System.out.print("국어?");
		vo.setKor(sc.nextInt());
		System.out.print("영어?");
		vo.setEng(sc.nextInt());
		System.out.print("수학?");
		vo.setMat(sc.nextInt());
		
		System.out.println("수정 성공.");
		*/
		
	}

	@Override
	public void delete() {
		
		System.out.println("삭제할 학번?");
		hak = sc.next();
		/* 내가 한 거
		if(hMap.containsKey(hak)) {
			hMap.remove(hak);
			
		}
		else {
			System.out.println("삭제할 학번이 존재하지 않습니다.");
		}
		*/
		
		//선생님.
		if(searchHak(hak)) {
			hMap.remove(hak);
		}
		else {
			System.out.println("삭제 실패");
		}
	}

	@Override
	public void findHak() {
		
		System.out.println("검색할 학번?");
		hak = sc.next();
		
		//방법1
		/*ScoreVO vo = hMap.get(hak);
		if(vo==null) {
			System.out.println("학번 X");
			return;
		}
		System.out.println(hak + " " + vo.toString());
		*/
		
		//방법2
		if(!searchHak(hak)) {
			System.out.println("학번이 존재하지 않습니다.");
			return;
			
		}
		ScoreVO vo = hMap.get(hak);
		
		System.out.println(hak + " " + vo.toString());
	}

	@Override
	public void findName() {
		
		// 내가 한거
		
		System.out.println("검색할 이름?");
		String name = sc.next();
		Iterator<String> it = hMap.keySet().iterator();
		
		boolean flag = false;
		while(it.hasNext()) {
			String hak = it.next();
			ScoreVO vo = hMap.get(hak);
			
			if(vo.getName().equals(name)) {
				System.out.println(hak + " " +vo.toString());
				flag = true;
			}
			if(flag !=true) {
				System.out.println("이름이 검색되지 않습니다.");
			}
			
		}
		
		
		/*--------------------- CGPT
		boolean valueFound = false;
		
		for(Map.Entry<String, ScoreVO> entry : hMap.entrySet()) {
			if(entry.getValue().getName().equals(name)) {
				
				String key = entry.getKey();
				System.out.println(hMap.get(key));
				valueFound = true;
			}
		}
		 if (!valueFound) {
	            System.out.println("이름 " + name + "을(를) 찾을 수 없습니다.");
		 }*/
		
		
	}

	

}
