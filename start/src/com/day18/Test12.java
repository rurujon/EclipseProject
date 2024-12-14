package com.day18;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream.GetField;

public class Test12 {

	public static void main(String[] args) {
		
		String str = "c:\\doc\\temp\\java\\test.txt";
		
		File f = new File(str);
		
		if(!f.getParentFile().exists()) {
			f.getParentFile().mkdirs();
			
		}
		
		try {
			
			FileOutputStream fos = new FileOutputStream(f);
			
			System.out.println("문자열 입력");
			
			int data;
			
			while((data=System.in.read())!=-1) {
				fos.write(data);
				fos.flush();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
