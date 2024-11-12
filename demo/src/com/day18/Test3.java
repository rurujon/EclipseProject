package com.day18;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

//InputStreamReader
//OutputStreamReader
//1byte stream을 2byte stream으로 변환해주는 Stream
//다시 말해, 문자로(String) 변환해 준다.

public class Test3 {

	public static void main(String[] args) throws IOException{
		
		int data;
		System.out.println("문자열 입력?");
		Reader rd = new InputStreamReader(System.in);	//BufferedReader가 고급형 보관소라면 Reader는 보급형
		
		//브릿지 클래스 : 데이터를 받아서 처리를 해주고 무조건 어딘가로 보내야하는 클래스
		while((data=rd.read())!=-1) {
			
			char ch = (char)data;
			System.out.print(ch);
			
			
		}

	}

}
