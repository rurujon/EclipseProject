package com.day16;

import java.util.Scanner;

//5~10�� �̳��� ���� ���ڸ� �Է¹޾� ����ϴ� ���α׷�

class Myauthen{
	
	public void inputForm(String str) throws Exception{
		
		if(str.length()<5||str.length()>10) {
			throw new Exception("���ڿ��� ���̴� 5~10�� �Դϴ�.");
		}
		int eng = 0;
		int num = 0;
		
		for(int i=0; i<str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')) {
				eng++;
			}
			else if(ch>='0'&&ch<='9') {
				num++;
			}
		}
		
		if(eng==0||num==0) {
			
			throw new Exception("������ ������ ȥ���� �����ּ���.");
		}
		
		
	}
}

public class Test6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		
		Myauthen auth = new Myauthen();
		
		try {
			
			System.out.println("���ڿ�?");
			str = sc.next();
			
			auth.inputForm(str);
			
			System.out.println(str);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}

	}

}
