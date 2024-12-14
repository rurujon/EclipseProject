package com.day18;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Test4 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.println("문자열?");
		
		Reader rd = new InputStreamReader(System.in);
		Writer wr = new OutputStreamWriter(System.out);
		
		while((data=rd.read())!=-1) {
			wr.write(data);
			wr.flush();	//출력의 마지막을 지정
						//반드시 이걸 써 줘야 한다.
						//입력받은 데이터 크기가 작아 트럭을 채우지 못해 반드시 써줘야함.
						//크기가 Buffer로 정해져 있다.
		}

	}

}
