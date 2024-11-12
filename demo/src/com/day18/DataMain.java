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
			//����ȭ
			FileOutputStream fos = new FileOutputStream("c:\\doc\\datavo.txt");
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(new DataVO("�����", 100));
			oos.writeObject(new DataVO("���γ�", 80));
			oos.writeObject(new DataVO("�ڹο�", 70));
			oos.writeObject(new DataVO("������", 90));
			
			oos.close();
			fos.close();
			
			System.out.println("������ ���� �Ϸ�!");
			*/
			
			//�� ����ȭ
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
