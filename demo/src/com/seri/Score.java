package com.seri;

import java.io.File;
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
	//List<ScoreVO> lists = new ArrayList<ScoreVO>();
	
	private List<ScoreVO> lists;
	private String path = System.getProperty("user.dir");
	File f = new File(path,"\\data\\score.txt");
	public Score() {
		
		try {
			
			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			
			if(f.exists()) {
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				lists = (List<ScoreVO>)ois.readObject();
				fis.close();
				ois.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void input() {
		
		try {
			
			ScoreVO vo = new ScoreVO();
			
			System.out.println("이름? ");
			vo.setName(sc.next());
			
			System.out.println("생일?[yy-mm-dd] ");
			vo.setBirth(sc.next());
			
			System.out.println("점수?");
			vo.setScore(sc.nextInt());
			
			if(lists == null) {
				lists = new ArrayList<ScoreVO>();
			}
			
			lists.add(vo);
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		
		
	}
	public void print() {
		
		if(lists!=null) {
		
			Iterator<ScoreVO> it = lists.iterator();

			while(it.hasNext())	{

				ScoreVO vo = it.next();
				System.out.println(vo);

			}
		}
		
	}
	public void save() {
		
		try {
			
			if(lists!=null) {
			
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(lists);

				oos.close();
				fos.close();
				
				System.out.println("파일 저장 성공");
			}
			
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
	
	/*public void load() {
		
		try {
			
			FileInputStream fis = new FileInputStream("c:\\doc\\scorevo.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			lists = (ArrayList<ScoreVO>)ois.readObject();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}*/

}
