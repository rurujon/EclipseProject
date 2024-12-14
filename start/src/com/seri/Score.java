package com.seri;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.seri.ScoreVO;

public class Score implements Serializable{
	
	Scanner sc = new Scanner(System.in);
	List<ScoreVO> lists = new ArrayList<ScoreVO>();
	
	public void input() {
		
		ScoreVO vo = new ScoreVO();
		
		System.out.println("이름? ");
		vo.setName(sc.next());
		
		System.out.println("생일?[yy-mm-dd] ");
		vo.setBirth(sc.next());
		
		System.out.println("점수?");
		vo.setScore(sc.nextInt());
		
		lists.add(vo);
		
	}
	public void print() {
		
		Iterator<ScoreVO> it = lists.iterator();
		
		while(it.hasNext())	{
			
			ScoreVO vo = it.next();
			System.out.println(vo);
		
		}
		
	}
	public void save() {
		
		try {
			
			FileOutputStream fos = new FileOutputStream("c:\\doc\\scorevo.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(lists);
			
			oos.close();
			fos.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	public void end() {
		
		try {
			save();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
		System.out.println("---------------- 종료");
		System.exit(0);
	}
	
	public void load() {
		
		try {
			
			FileInputStream fis = new FileInputStream("c:\\doc\\scorevo.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			lists = (ArrayList<ScoreVO>)ois.readObject();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
