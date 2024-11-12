package com.day18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test8 {
	
	public boolean fileCopy(String file1, String file2) {
		File f = new File(file1);	//File Ŭ������ �ҷ��� ������ ���� ������ ��, ����ų� ������� ��ġ�� ���Ѵ�.
		
		if(!f.exists()) {
			return false;
		}
		try {
			FileInputStream fis = new FileInputStream(f);
			FileOutputStream fos = new FileOutputStream(file2);
			
			int data = 0;
			
			byte[] buffer = new byte[1024];
			
			while((data=fis.read(buffer, 0, 1024))!=-1) {
				
				fos.write(buffer, 0, data);
			}//�ܿ���! ���� ����!
			
			fis.close();
			fos.close();
			
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		Test8 ob = new Test8();
		
		Scanner sc = new Scanner(System.in);
		
		String str1, str2;
		
		System.out.println("���� �ּ�");
		str1 = sc.next();
		
		System.out.println("���纻 �ּ�");
		str2 = sc.next();
		
		if(ob.fileCopy(str1, str2)) {
			System.out.println("���� ���� ����");
		}
		else {
			System.out.println("���� ���� ����");
		}

	}

}
