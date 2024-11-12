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
			
			System.out.print("학번? : ");
			dto.setHak(sc.next());
			
			System.out.print("이름? : ");
			dto.setName(sc.next());
			
			System.out.print("국어? : ");
			dto.setKor(sc.nextInt());
			
			System.out.print("영어? : ");
			dto.setEng(sc.nextInt());
			
			System.out.print("수학? : ");
			dto.setMat(sc.nextInt());
			
			int result = dao.insertData(dto);
			
			if(result!=0) {
				System.out.println("추가 성공!");
			}
			else {
				System.out.println("추가 실패");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	public void update() {
		
		try {
			
			ScoreDTO dto = new ScoreDTO();
			
			System.out.println("수정할 학번? ");
			dto.setHak(sc.next());
			
			System.out.println("국어? ");
			dto.setKor(sc.nextInt());
			
			System.out.println("영어? ");
			dto.setEng(sc.nextInt());
			
			System.out.println("수학? ");
			dto.setMat(sc.nextInt());
			
			int result = dao.updateData(dto);
			
			if(result!=0) {
				System.out.println("수정 성공!");
			}
			else {
				System.out.println("수정 실패!");
			}
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
	}
	
	public void delete() {
		
		try {			
			
			System.out.println("삭제할 학번?");
			String delhak=sc.next();
			
			int result = dao.deleteData(delhak);
			
			if(result!=0) {
				System.out.println("삭제 성공!");
			}
			else {
				System.out.println("삭제 실패!");
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
			
			System.out.println("검색할 학번? ");
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

			System.out.println("검색할 이름? ");
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
