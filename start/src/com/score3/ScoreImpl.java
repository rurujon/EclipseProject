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
		
		System.out.println("�й�?");
		hak = sc.next();
		
		if(searchHak(hak)) {
			System.out.println("�й��� �̹� �ֽ��ϴ�.");
			return;
		}
		ScoreVO vo = new ScoreVO();
		
		System.out.print("�̸�? ");
		vo.setName(sc.next());
		
		System.out.print("����?");
		vo.setKor(sc.nextInt());
		System.out.print("����?");
		vo.setEng(sc.nextInt());
		System.out.print("����?");
		vo.setMat(sc.nextInt());
		
		hMap.put(hak, vo);
		
		System.out.println("�߰� ���� \n");
		
	}

	@Override
	public boolean searchHak(String Hak) {
		
		if(hMap.containsKey(hak)) {
			return true;//�й��� �̹� �ִٸ� �ڸ� �������� �ʰ� ����
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
		
		System.out.println("������ �й�?");
		hak = sc.next();
		
		if(hMap.containsKey(hak)) {
		
			ScoreVO vo = hMap.get(hak);

			System.out.println("������ ���� ����, 1:����, 2:�й���.");
			int choose = sc.nextInt();

			switch (choose) {
			case 1 : 
				hMap.remove(hak);
				input();

				System.out.println("�����Ǿ����ϴ�.");
				break;

			case 2 : System.out.println("������ �й� �Է�.");
			String newhak = sc.next();

			hMap.remove(hak);
			hMap.put(newhak, vo);

			System.out.println("�����Ǿ����ϴ�.");
			break;

			default:
				break;
			}
		}
		else {
			System.out.println("�й��� �˻����� �ʽ��ϴ�.");
		}
		/*if(hMap.containsKey(hak)) {
			hMap.remove(hak);
			input();
			
		}
		else {
			System.out.println("������ �й��� �������� �ʽ��ϴ�.");
		}
		*/
		
		
	}

	@Override
	public void delete() {
		
		System.out.println("������ �й�?");
		hak = sc.next();
		if(hMap.containsKey(hak)) {
			hMap.remove(hak);
			
		}
		else {
			System.out.println("������ �й��� �������� �ʽ��ϴ�.");
		}
	}

	@Override
	public void findHak() {
		
		System.out.println("�˻��� �й�?");
		hak = sc.next();
		
		if(searchHak(hak)) {
			ScoreVO vo = hMap.get(hak);
			
			System.out.println(hak + " " + vo.toString());
		}
		else {
			System.out.println("�й��� �������� �ʽ��ϴ�.");
		}
	}

	@Override
	public void findName() {
		
		System.out.println("�˻��� �̸�?");
		String name = sc.next();
		Iterator<String> it = hMap.keySet().iterator();
		
		boolean detect = false;
		while(it.hasNext()) {
			String hak = it.next();
			ScoreVO vo = hMap.get(hak);
			
			if(vo.getName().equals(name)) {
				System.out.println(hak + " " +vo.toString());
				detect = true;
			}
			if(detect !=true) {
				System.out.println("�̸��� �˻����� �ʽ��ϴ�.");
			}
			
		}
		
		
		/*
		boolean valueFound = false;
		
		for(Map.Entry<String, ScoreVO> entry : hMap.entrySet()) {
			if(entry.getValue().getName().equals(name)) {
				
				String key = entry.getKey();
				System.out.println(hMap.get(key));
				valueFound = true;
			}
		}
		 if (!valueFound) {
	            System.out.println("�̸� " + name + "��(��) ã�� �� �����ϴ�.");
		 }*/
	}

	

}
