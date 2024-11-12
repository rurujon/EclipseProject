package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		//System.in : 키보드를 통해 입력된 1byte 문자를 읽어낸다.
		//InputStreamReeader : System.in으로 읽은 1byte를 2 byte 문자로 변환
		//BufferReader : 버퍼로 입력받아 처리속도를 높임
		
		int r;
		double area, length;
		
		System.out.print("반지름?");
		
		r = Integer.parseInt(br.readLine());
		
		//readLine : 버퍼로 받아온 br을 읽어오는 기능
		
		
		area = r*r*3.14;
		length = r*2*3.14;
		
		System.out.println("넓이 : " + area );
		System.out.println("둘레 : " + length);

	}

}
