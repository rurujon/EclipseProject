package com.score2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score{
	
	Scanner sc = new Scanner(System.in);

	List<ScoreVO> lists = new ArrayList<ScoreVO>();
	
	@Override
	public void input() {
		
		ScoreVO vo = new ScoreVO();
		
		System.out.println("�й�?");//111
		vo.setHak(sc.next());
		
		System.out.println("�̸�?");//�ο�
		vo.setName(sc.next());
		
		System.out.println("����?");//50
		vo.setKor(sc.nextInt());
		
		System.out.println("����?");//60
		vo.setEng(sc.nextInt());
		
		System.out.println("����?");//70
		vo.setMat(sc.nextInt());
		
		lists.add(vo);
	}

	@Override
	public void print() {
		
		Iterator<ScoreVO> it = lists.iterator();
		
		while(it.hasNext())	{
			
			ScoreVO vo = it.next();
			
			System.out.println(vo);
			
			/*System.out.printf("%s %s %4d %4d %4d %4d %4d\n",vo.getHak(), vo.getName(), vo.getKor(), vo.getEng(), vo.getMat(),
					 (vo.getKor()+vo.getEng()+vo.getMat()),(vo.getKor()+vo.getEng()+vo.getMat())/3);*/
		}
	}

	@Override
	public void searchHak() {
		
		System.out.println("�й�?");
		String hak = sc.next();
		
		Iterator<ScoreVO> it = lists.iterator();
		while(it.hasNext()) {
			
			ScoreVO vo = it.next();
			if(vo.getHak().equals(hak)) {
				System.out.println(vo);
				break;
			}
			
		}
				
	}

	@Override
	public void searchName() {
		
		System.out.println("�̸�?");
		String name = sc.next();
		
		Iterator<ScoreVO> it = lists.iterator();
		while(it.hasNext()) {
			
			ScoreVO vo = it.next();
			if(vo.getName().equals(name)) {
				System.out.println(vo);
				
			}
			
		}
	}

	@Override
	public void descSortTot() {
		
		//���� ���
		//������ Ŭ����
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				return vo1.getTot()<vo2.getTot()?1:-1;	//��������, �ε�ȣ�� �ٲٸ� ��������.
			}
		};
		
		Collections.sort(lists, comp);
		print();
	}

	@Override
	public void ascSortHot() {
		
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				//return Integer.parseInt(vo1.getHak())>Integer.parseInt(vo2.getHak())?1:-1;
				return vo1.getHak().compareTo(vo2.getHak());
			}
		};
		
		Collections.sort(lists, comp);
		print();
		
		
		
	}
	
	

}
