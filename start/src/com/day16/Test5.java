package com.day16;

import java.util.Scanner;

//5~10�� �̳��� �����ڸ� �Է¹޾� ����ϴ� ���α׷�

//���ڿ�? abcde
//abcde

class MyAuthenticator{
	
	public void inputFormat(String str) throws Exception{
		//length, �ƽ�Ű�� Ȱ��
		
		
		if(!(str.length()>4 && str.length()<11)) {
			throw new Exception("���ڿ� ���� ����");
		}
		
		for(int i=0; i<str.length(); i++) {
			char s = str.charAt(i);		// String�� �޼���. �� ���� ���ڸ� �̾Ƴ���.
			if (!((s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z'))) {	//((ch<'a'||ch>'z')&&(ch<'A'||ch>'Z'))
				throw new Exception("�����ڿ��� �ƴմϴ�.");
			}
		}
		
		
		
	}
}

public class Test5 {
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str;
		
		MyAuthenticator auth = new MyAuthenticator();
		
		
		
		try {
			
			System.out.println("���ڿ�");//abcde,abcd
			
			str = sc.next();
			
			auth.inputFormat(str);
			
			System.out.println(str);
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			// TODO: handle exception
		}

	}

}
