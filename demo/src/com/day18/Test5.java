package com.day18;

//FileInputStream : ���� ���� ��
//FileOutputStream : ���� ���� ��

//file Ŭ������ file�� ���� �� ����.

import java.io.FileInputStream;

public class Test5 {

	public static void main(String[] args) {
		
		try {
			
			FileInputStream fis = new FileInputStream("c:\\doc\\test.txt");
			int data;
			while((data=fis.read())!=-1) {
				
				//System.out.print((char)data);
				//System.out.print(data);
				System.out.write(data);
				System.out.flush();
			}
			
			fis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
