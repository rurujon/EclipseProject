package com.day18;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Test10 {

	public static void main(String[] args) {
		
		try {
			
			FileOutputStream fos = new FileOutputStream("c:\\doc\\test2.txt");
			
			PrintStream ps = new PrintStream(fos);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//문자열 입력으로 넣은 값을 읽어낸다.
			
			String str;
			
			System.out.println("문자열 입력");	//abcd
			
			while((str = br.readLine())!=null) {
				ps.println(str);
			}
			
			ps.close();
			fos.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}

	}

}
