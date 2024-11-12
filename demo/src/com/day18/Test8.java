package com.day18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test8 {
	
	public boolean fileCopy(String file1, String file2) {
		File f = new File(file1);	//File 클래스는 불러온 파일을 그저 관리할 뿐, 만들거나 영향력을 끼치진 못한다.
		
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
			}//외워라! 자주 쓴다!
			
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
		
		System.out.println("원본 주소");
		str1 = sc.next();
		
		System.out.println("복사본 주소");
		str2 = sc.next();
		
		if(ob.fileCopy(str1, str2)) {
			System.out.println("파일 복사 성공");
		}
		else {
			System.out.println("파일 복사 실패");
		}

	}

}
