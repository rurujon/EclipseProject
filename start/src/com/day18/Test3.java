package com.day18;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

//InputStreamReader
//OutputStreamReader
//1byte stream�� 2byte stream���� ��ȯ���ִ� Stream
//�ٽ� ����, ���ڷ�(String) ��ȯ�� �ش�.

public class Test3 {

	public static void main(String[] args) throws IOException{
		
		int data;
		System.out.println("���ڿ� �Է�?");
		Reader rd = new InputStreamReader(System.in);	//BufferedReader�� ����� �����Ҷ�� Reader�� ������
		
		//�긴�� Ŭ���� : �����͸� �޾Ƽ� ó���� ���ְ� ������ ��򰡷� �������ϴ� Ŭ����
		while((data=rd.read())!=-1) {
			
			char ch = (char)data;
			System.out.print(ch);
			
			
		}

	}

}
