package com.day18;

import java.io.File;
import java.io.IOException;
import java.sql.Date;


//File Ŭ����
//file �� folder�� ������ �� �ֵ��� ����� �����ϴ� Ŭ����
//������ ����, �Ǵ� �̸� ���� ���� ������ �� ��쿡�� ���ǰ�
//������ ������ ������ϱ� ���� �޼ҵ����� ����.

public class Test11 {

	public static void main(String[] args) throws IOException{
		
		File f = new File("c:\\doc\\test.txt");
		
		if(!f.exists()) {
			System.out.println("������ �����ϴ�.");
			return;
		}
		
		System.out.println("���ϸ� : " + f.getName());
		System.out.println("���� ���� : " + f.length());		//�ѱ� �� �ڴ� 2byte, ���� 1byte, ���� 2byte ����.
		System.out.println("���� ��� : " + f.getAbsolutePath());
		System.out.println("ǥ�� ��� : " + f.getCanonicalPath());
		System.out.println("���� ������ : " + new Date(f.lastModified()));
		System.out.println("���� ��� : " + f.getParent());
		System.out.println("�б� �Ӽ� : " + f.canRead());
		System.out.println("���� �Ӽ� : " + f.canWrite());
		
		//���� ���α׷� ���
		String path = System.getProperty("user.dir");
		System.out.println("���� ���α׷� ��� : " + path);
		
		
	}

}
