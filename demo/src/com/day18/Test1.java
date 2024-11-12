package com.day18;

import java.io.IOException;

//stream (== 파이프?)
//데이터 입출력시 모드 데이터를 형태와 관련 없이
//일련된 흐름으로 전송하는 클래스들이다.
//inputStream, outputStream

//바이트 스트림(ByteStream) : 1byte의 데이터를 내보낼 수 있는 stream
//System.in
//System.out

public class Test1 {

	public static void main(String[] args) throws IOException{
		
		int data;
		System.out.println("문자열 입력");	//abcdef
		while((data=System.in.read())!=-1) {	//data 안에 있는 데이터가 없어질때까지.
			
			char ch = (char)data;
			System.out.print(ch);
			
		}
		

	}

}
