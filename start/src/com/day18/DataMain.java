package com.day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataMain implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		

		
		try {
			/*
			//직렬화
			FileOutputStream fos = new FileOutputStream("c:\\doc\\datavo.txt");
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(new DataVO("배수지", 100));
			oos.writeObject(new DataVO("유인나", 80));
			oos.writeObject(new DataVO("박민영", 70));
			oos.writeObject(new DataVO("서예지", 90));
			
			oos.close();
			fos.close();
			
			System.out.println("데이터 저장 완료!");
			*/
			
			//역 직렬화
			FileInputStream fis = new FileInputStream("c:\\doc\\datavo.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			DataVO vo;
			
			try {
				
				while(true) {
					
					vo = (DataVO)ois.readObject(); 
					if(vo==null) {
						break;
					}
					
					System.out.println(vo.toString());
				}
				
			} catch (Exception e) {
				System.out.println(e.toString());
				// TODO: handle exception
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
