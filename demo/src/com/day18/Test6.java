package com.day18;

import java.io.FileOutputStream;

//FileOutputStream : ������ ����� Ŭ����. ������ ��ۿ� ����.

public class Test6 {

	public static void main(String[] args) {
		
		try {
			
			FileOutputStream fos = new FileOutputStream("c:\\doc\\out.txt");
			
			int data;
			System.out.print("���ڿ� �Է�");
			
			while((data=System.in.read())!=-1) {
				fos.write(data);
				fos.flush();
			}
			
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

	}

}
