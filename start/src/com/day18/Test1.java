package com.day18;

import java.io.IOException;

//stream (== ������?)
//������ ����½� ��� �����͸� ���¿� ���� ����
//�Ϸõ� �帧���� �����ϴ� Ŭ�������̴�.
//inputStream, outputStream

//����Ʈ ��Ʈ��(ByteStream) : 1byte�� �����͸� ������ �� �ִ� stream
//System.in
//System.out

public class Test1 {

	public static void main(String[] args) throws IOException{
		
		int data;
		System.out.println("���ڿ� �Է�");	//abcdef
		while((data=System.in.read())!=-1) {	//data �ȿ� �ִ� �����Ͱ� ������������.
			
			char ch = (char)data;
			System.out.print(ch);
			
		}
		

	}

}
