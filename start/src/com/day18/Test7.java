package com.day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		
		//원본파일 : c:\\doc\\test.txt
		//대상파일 : c:\\doc\\out1.txt
		//복사 완료
		
		Scanner sc = new Scanner(System.in);
		String str1, str2;
		int data;
		
		
		
		try {
			
			System.out.println("원본 주소");
			str1 = sc.next();
			
			System.out.println("복사본 주소");
			str2 = sc.next();
			
			FileInputStream fis = new FileInputStream(str1);
			FileOutputStream fos = new FileOutputStream(str2);
			
			while((data=fis.read())!=-1) {
				
				System.out.write(data);
				System.out.flush();
				fos.write(data);
				fos.flush();
				
			}
			
			System.out.println();
			System.out.println();
			System.out.println("복사 완료.");
			fis.close();
			fos.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
