package com.score4;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Score {
	
	Scanner sc = new Scanner(System.in);
	
	ScoreDAO dao = new ScoreDAO();
	
	public void insert() {
		
		try {
			
			ScoreDTO dto = new ScoreDTO();
			
			System.out.print("�й�? : ");
			dto.setHak(sc.next());
			
			System.out.print("�̸�? : ");
			dto.setName(sc.next());
			
			System.out.print("����? : ");
			dto.setKor(sc.nextInt());
			
			System.out.print("����? : ");
			dto.setEng(sc.nextInt());
			
			System.out.print("����? : ");
			dto.setMat(sc.nextInt());
			
			int result = dao.insertData(dto);
			
			if(result!=0) {
				System.out.println("�߰� ����!");
			}
			else {
				System.out.println("�߰� ����");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	public void update() {
		
		try {
			
			ScoreDTO dto = new ScoreDTO();
			
			System.out.println("������ �й�? ");
			dto.setHak(sc.next());
			
			System.out.println("����? ");
			dto.setKor(sc.nextInt());
			
			System.out.println("����? ");
			dto.setEng(sc.nextInt());
			
			System.out.println("����? ");
			dto.setMat(sc.nextInt());
			
			int result = dao.updateData(dto);
			
			if(result!=0) {
				System.out.println("���� ����!");
			}
			else {
				System.out.println("���� ����!");
			}
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
	}
	
	public void delete() {
		
		try {			
			
			System.out.println("������ �й�?");
			String delhak=sc.next();
			
			int result = dao.deleteData(delhak);
			
			if(result!=0) {
				System.out.println("���� ����!");
			}
			else {
				System.out.println("���� ����!");
			}
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
	}
	
	public void selectAll() {
		
		List<ScoreDTO> lists = dao.getList();
		
		Iterator<ScoreDTO> it = lists.iterator();
		
		while(it.hasNext()) {
			
			ScoreDTO dto = it.next();
			System.out.println(dto.toString());
		}
	}
	
	public void searchHak() {
		
		try {
			
			System.out.println("�˻��� �й�? ");
			String hak = sc.next();
			
			ScoreDTO dto = dao.getSearchHak(hak);
			
			if(dto!=null) {
				
				System.out.println(dto.toString());
			}
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
		}
		
	}
	
	public void searchName() {

		try {

			System.out.println("�˻��� �̸�? ");
			String name = sc.next();

			List<ScoreDTO> lists = dao.getSearchName(name);

			Iterator<ScoreDTO> it = lists.iterator();

			while(it.hasNext()) {

				ScoreDTO dto = it.next();
				System.out.println(dto.toString());
			}



		} catch (Exception e) {
			
			System.out.println(e.toString());
			// TODO: handle exception
		}

	}



}
