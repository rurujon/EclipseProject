package com.day18;

import java.io.File;
import java.io.IOException;
import java.sql.Date;


//File 클래스
//file 및 folder를 관리할 수 있도록 기능을 제공하는 클래스
//파일의 복사, 또는 이름 변경 등의 조작을 할 경우에만 사용되고
//파일의 내용을 입출력하기 위한 메소드기능은 없다.

public class Test11 {

	public static void main(String[] args) throws IOException{
		
		File f = new File("c:\\doc\\test.txt");
		
		if(!f.exists()) {
			System.out.println("파일이 없습니다.");
			return;
		}
		
		System.out.println("파일명 : " + f.getName());
		System.out.println("파일 길이 : " + f.length());		//한글 한 자당 2byte, 공백 1byte, 엔터 2byte 세번.
		System.out.println("파일 경로 : " + f.getAbsolutePath());
		System.out.println("표준 경로 : " + f.getCanonicalPath());
		System.out.println("파일 생성일 : " + new Date(f.lastModified()));
		System.out.println("폴더 경로 : " + f.getParent());
		System.out.println("읽기 속성 : " + f.canRead());
		System.out.println("쓰기 속성 : " + f.canWrite());
		
		//현재 프로그램 경로
		String path = System.getProperty("user.dir");
		System.out.println("현재 프로그램 경로 : " + path);
		
		
	}

}
